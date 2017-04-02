package nick.gaImageRecognitionCore.image;

import nick.gaImageRecognitionCore.feature.*;

import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class IntegralImage {

    private boolean debug = false;
    private boolean debugFeatureTypes = false;
    private static final Logger LOGGER = Logger.getLogger(IntegralImage.class.getName());

//    double[][] values = {
//                            {0.00,0.00,0.00,0.00,0.00,0.00,3.95,4.35,1.92,12.07,14.16,134.88},
//                            {0.00,0.00,0.00,0.00,0.00,0.00,0.00,4.74,1.13,12.23,5.70,89.01},
//                            {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,2.10,13.72,1.49,71.94},
//                            {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,7.58,7.79,55.21},
//                            {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,7.79,33.01},
//                            {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,3.92},
//                            {5.39,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,22.09},
//                            {9.34,0.39,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,37.28},
//                            {5.79,4.35,3.23,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,47.29},
//                            {5.67,3.82,0.97,6.30,0.00,0.00,0.00,0.00,0.00,0.00,0.00,47.29},
//                            {24.11,6.31,6.45,13.88,0.00,0.00,0.00,0.00,0.00,0.00,0.00,47.29},
//                            {46.09,69.39,55.13,46.03,41.76,7.00,31.91,43.70,58.39,98.75,132.71,0.00}
//                            };
    private BufferedImage sourceImage;

    private int[][] integral_image_matrix;

    private int width;
    private int height;

    private IntegralImage() {
    }

    public IntegralImage(BufferedImage sourceImage) {
        this.sourceImage = sourceImage;
        setNormalizedGrayImage(sourceImage);
    }

    /**
     *
     * @param image
     * @return normalized matrix of pixels
     */
    private void setNormalizedGrayImage(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        int[][] grayImage = new int[width][height];
        int[][] img = new int[width][height];
        for (int i = 0; i < width; i++) {
            int cumulatedValue = 0;
            for (int j = 0; j < height; j++) {
                int c = image.getRGB(i, j);
                int red = (c & 0x00ff0000) >> 16;
                int green = (c & 0x0000ff00) >> 8;
                int blue = c & 0x000000ff;
                int value = (30 * red + 59 * green + 11 * blue) / 100;
                img[i][j] = value;
                grayImage[i][j] = (i > 0 ? grayImage[i - 1][j] : 0) + cumulatedValue + value;
                cumulatedValue += value;
            }
        }
        integral_image_matrix = grayImage;
    }

    int counterError = 0;

    /**
     *
     * @param minx
     * @param miny
     * @param maxx
     * @param maxy
     * @return summed pixel area
     */
    public double getSum(int minx, int miny, int maxx, int maxy) {
//        minx--;
//        miny--;
//        maxx--;
//        maxy--;
        if (integral_image_matrix == null) {
            setNormalizedGrayImage(sourceImage);
        }
        try {
            double a = (minx > 0 && miny > 0) ? integral_image_matrix[minx - 1][miny - 1] : 0;
            double b = (miny > 0) ? integral_image_matrix[maxx][miny - 1] : 0;
            double c = (minx > 0) ? integral_image_matrix[minx - 1][maxy] : 0;
            double d = integral_image_matrix[maxx][maxy];
            double sum = a - b - c + d;
            return sum;
        } catch (Exception e) {
//            counterError++;
//            System.out.println("Error counter: " + counterError);
            System.out.println("minx: " + minx + " miny:" + miny + " maxx:" + maxx + " maxy:" + maxy);
            throw new RuntimeException("test");
//            e.printStackTrace();
//            return 0;
        }

    }

    public double getSumFeatureWithPadding(Feature feature, int paddingX, int paddingY, float scale) {
//        feature.getPositionInPicture().scaleCoordinates(scale);
        if (debugFeatureTypes && Math.random() < 0.005) {
            LOGGER.log(Level.INFO, "{0}",feature);
        }
        switch (feature.getFeatureType()) {
            case FOUR_SIDE:
                return sumFourSide(feature, paddingX, paddingY, scale);
            case LEFT_RIGHT:
                return sumLeftRigth(feature, paddingX, paddingY, scale);
            case TOP_BOTTOM:
                return sumTopBottom(feature, paddingX, paddingY, scale);
            case MIDDLE_LEFT_RIGHT:
                return sumMiddleLeftRight(feature, paddingX, paddingY, scale);
            default:
                throw new Error("No feature type defined!");

        }

    }

    private double sumLeftRigth(Feature featureLeftRigth, int paddingX, int paddingY, float scale) {

        FeatureLeftRigth feature = (FeatureLeftRigth) featureLeftRigth;
        //left rectangle
        int minX = (int) (feature.getPositionInPicture().getMinX() * scale) + paddingX;
        int minY = (int) (feature.getPositionInPicture().getMinY() * scale) + paddingY;
        int maxX = minX + (int) (feature.getLeftSideWidth() * scale);
        int maxY = minY + (int) (feature.getPositionInPicture().getHeight() * scale);

        //right rectangle
        int minXRight = maxX;
        int minYRight = minY;
        int maxXRight = (int) (minXRight + feature.getRightSideWidth() * scale);
        int maxYRight = maxY;

        double weightLeft = 0;
        double weightRight = 0;
        try {
            weightLeft = getSum(minX, minY, maxX, maxY);
            weightRight = getSum(minXRight, minYRight, maxXRight, maxYRight);
//            if (Math.random()<0.005) {
//                System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
//            System.out.println("minX:" + minX + " minY:" + minY + "minX:" + maxXRight + " maxYRight:" + maxYRight);
//            System.out.println("----------------------------------------------");
//            }

//            weightLeft = getSum((int) (minX * scale), (int) (minY * scale), (int) (maxX * scale), (int) (maxY * scale));
//            weightRight = getSum((int) (minXRight * scale), (int) (minYRight * scale), (int) (maxXRight * scale), (int) (maxYRight * scale));
            if (debug && Math.random() < 0.005) {
                LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightLeft - weightRight));
            }
        } catch (Exception e) {
            System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
            System.out.println("postion minX:" + feature.getPositionInPicture().getMinX() + " postition minY:" + feature.getPositionInPicture().getMinY());
            throw new RuntimeException("stop");
        }

//        double weightLeft = getSum((int) (minX * scale), (int) (minY * scale), (int) (maxX * scale), (int) (maxY * scale));
//        double weightRight = getSum((int) (minXRight * scale), (int) (minYRight * scale), (int) (maxXRight * scale), (int) (maxYRight * scale));
        return Math.abs(weightLeft - weightRight);
    }

    private double sumTopBottom(Feature feature, int paddingX, int paddingY, float scale) {

        FeatureTopBottom featureTopBottom = (FeatureTopBottom) feature;

        //top rectangle
        int minX = (int) (featureTopBottom.getPositionInPicture().getMinX() * scale) + paddingX;
        int minY = (int) (featureTopBottom.getPositionInPicture().getMinY() * scale) + paddingY;
        int maxX = minX + (int) (featureTopBottom.getPositionInPicture().getWidth() * scale);
        int maxY = minY + (int) (featureTopBottom.getTopSideHeight() * scale);

        //down rectangle
        int minXBottom = minX;
        int minYBottom = maxY;
        int maxXBottom = maxX;
        int maxYBottom = maxY + (int) (featureTopBottom.getBottomSideHeight() * scale);

        double weightTop = getSum(minX, minY, maxX, maxY);
        double weightBottom = getSum(minXBottom, minYBottom, maxXBottom, maxYBottom);

        if (debug && Math.random() < 0.005) {
            LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightTop - weightBottom));
        }
        return Math.abs(weightTop - weightBottom);

    }

    private double sumMiddleLeftRight(Feature feature, int paddingX, int paddingY, float scale) {
        FeatureMiddleLeftRight featureMiddleLeftRight = (FeatureMiddleLeftRight) feature;

        int featureHeight = featureMiddleLeftRight.getPositionInPicture().getHeight();
        //left rectangle
        int minX = (int) (featureMiddleLeftRight.getPositionInPicture().getMinX() * scale) + paddingX;
        int minY = (int) (featureMiddleLeftRight.getPositionInPicture().getMinY() * scale) + paddingY;
        int maxX = minX + (int) (featureMiddleLeftRight.getLeftSideWidth() * scale);
        int maxY = minY + (int) (featureHeight * scale);

        //center rectangle
        int minXCenter = (int) maxX;
        int minYCenter = (int) minY;
        int maxXCenter = minXCenter + (int) (featureMiddleLeftRight.getCenterSideWidth() * scale);
        int maxYCenter = maxY;

        //right rectangle
        int minXRight = maxXCenter;
        int minYRight = minY;
        int maxXRight = minXRight + (int) (featureMiddleLeftRight.getRightSideWidth() * scale);
        int maxYRight = maxY;

        double weightLeft = 0;
        double weightCenter = 0;
        double weightRight = 0;

        try {
            weightLeft = getSum(minX, minY, maxX, maxY);
            weightCenter = getSum(minXCenter, minYCenter, maxXCenter, maxYCenter);
            weightRight = getSum(minXRight, minYRight, maxXRight, maxYRight);
//            if (Math.random() < 0.005) {

//                System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
//            System.out.println("minX:" + minX + " minY:" + minY + "minX:" + maxXRight + " maxYRight:" + maxYRight);
//                System.out.println("weightCenter: " + weightCenter);
//            System.out.println("----------------------------------------------");
//                 LOGGER.log(Level.INFO, "weightLeft: {0},", weightLeft);
//                LOGGER.log(Level.INFO, "weightCenter: {0} ", weightCenter);
//                LOGGER.log(Level.INFO, "weightRight: {0} ", weightRight);
//                LOGGER.log(Level.INFO, "----------------------- ");
//                System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
//                LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightLeft - weightRight + weightCenter));
//            }
//            weightLeft = getSum((int) (minX * scale), (int) (minY * scale), (int) (maxX * scale), (int) (maxY * scale));
//            weightRight = getSum((int) (minXRight * scale), (int) (minYRight * scale), (int) (maxXRight * scale), (int) (maxYRight * scale));
            if (debug && Math.random() < 0.005) {
                LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightLeft - weightRight + weightCenter));
            }
        } catch (Exception e) {
            System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
            System.out.println("postion minX:" + feature.getPositionInPicture().getMinX() + " postition minY:" + feature.getPositionInPicture().getMinY());
            throw new RuntimeException("stop");
        }

//        double weightLeft = getSum((int) (minX * scale), (int) (minY * scale), (int) (maxX * scale), (int) (maxY * scale));
//        double weightRight = getSum((int) (minXRight * scale), (int) (minYRight * scale), (int) (maxXRight * scale), (int) (maxYRight * scale));
        return Math.abs(weightLeft - weightRight + weightCenter);
    }

    private double sumFourSide(Feature feature, int paddingX, int paddingY, float scale) {

        try {

            FeatureFourSide featureFourSide = (FeatureFourSide) feature;
            //top left rectangle
            int minX = feature.getPositionInPicture().getMinX() + paddingX;
            int minY = feature.getPositionInPicture().getMinY() + paddingY;
            int maxX = minX + (int) (featureFourSide.getLeftSideWidth() * scale);
            int maxY = minY + (int) (featureFourSide.getTopSideHeight() * scale);

            //top right rectangle
            int minXTopRigth = maxX;
            int minYTopRigth = minY;
            int maxXTopRigth = minXTopRigth + (int) (featureFourSide.getRightSideWidth() * scale);
            int maxYTopRigth = maxY;

            //down left rectangle
            int minXBottomLeft = minX;
            int minYBottomLeft = maxY;
            int maxXBottomLeft = maxX;
            int maxYBottomLeft = maxY + (int) (featureFourSide.getBottomSideHeight() * scale);

            //down rigth rectangle
            int minXBottomRigth = minXTopRigth;
            int minYBottomRigth = minYBottomLeft;
            int maxXBottomRigth = maxXTopRigth;//
            int maxYBottomRigth = maxYBottomLeft;

            if (minX == maxX || minY == maxY) {
                throw new IllegalStateException(" Min and max values are same, feature is not initialized properly!");
            }

            double weightTopLeft = getSum(minX, minY, maxX, maxY);
            double weightTopRigth = getSum(minXTopRigth, minYTopRigth, maxXTopRigth, maxYTopRigth);
            double weightBottomLeft = getSum(minXBottomLeft, minYBottomLeft, maxXBottomLeft, maxYBottomLeft);
            double weightBottomRigth = getSum(minXBottomRigth, minYBottomRigth, maxXBottomRigth, maxYBottomRigth);

//            if (Math.random() < 0.005) {
//                LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightTopLeft + weightBottomRigth - weightTopRigth - weightBottomLeft));
//                LOGGER.log(Level.INFO, "wight topLeft: {0},", weightTopLeft);
//                LOGGER.log(Level.INFO, "wightBottomLeft: {0} ", weightBottomLeft);
//                LOGGER.log(Level.INFO, "----------------------- ");
//                System.out.println("paddingX:" + paddingX + " paddingY:" + paddingY + " scale:" + scale);
//            System.out.println("minX:" + minX + " minY:" + minY + "minX:" + maxXRight + " maxYRight:" + maxYRight);
//                System.out.println("weightCenter: " + weightCenter);
//            System.out.println("----------------------------------------------");
//            }
            if (debug && Math.random() < 0.005) {
                LOGGER.log(Level.INFO, "formula threshhold: {0},", Math.abs(weightTopLeft + weightBottomRigth - weightTopRigth - weightBottomLeft));
            }

            return Math.abs(weightTopLeft + weightBottomRigth - weightTopRigth - weightBottomLeft);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
