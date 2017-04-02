/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.feature;

import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.image.Rect;

import java.util.ArrayList;

/**
 * <p> This is maybe for delete?
 *
 * @author Nick
 */
public class FeatureExtracton {

    public static final long THRESHHOLD_DEBUG_SHARED_VALUE = 120;
    public static final long MIN_VALUE_THRESHHOLD = 80;

    private static final long THRESHHOLD_TOP_DOWN = THRESHHOLD_DEBUG_SHARED_VALUE;
    private static final long THRESHHOLD_LEFT_RIGHT = THRESHHOLD_DEBUG_SHARED_VALUE;
    private static final long THRESHHOLD_FOUR_SIDE = THRESHHOLD_DEBUG_SHARED_VALUE;

    /**
     * feature width must be dividable with 2
     *
     * @+++++|-----
     *
     * @param integerImage
     * @param leftSideWidth
     * @param rightSideWidth
     * @param featureHeight height feature
     * @return get features based on pattern
     */
    public static ArrayList<Feature> getFeaturesLeftRigth(IntegralImage integerImage, int featureHeight, int leftSideWidth, int rightSideWidth) {
        ArrayList<Feature> features = new ArrayList<>();

        int featureWidth = leftSideWidth + rightSideWidth;

        for (int i = 0; i < integerImage.getWidth() - featureWidth; i++) {
            for (int j = 0; j < integerImage.getHeight() - featureHeight; j++) {

                //left rectangle
                int minX = i;
                int minY = j;
                int maxX = minX + leftSideWidth;
                int maxY = minY + featureHeight;

                //right rectangle
                int minXRight = maxX;
                int minYRight = minY;
                int maxXRight = minXRight + rightSideWidth;
                int maxYRight = maxY;

                float weightLeft = (float) integerImage.getSum(minX, minY, maxX, maxY);
                float weightRight = (float) integerImage.getSum(minXRight, minYRight, maxXRight, maxYRight);

                float featureWeight = Math.abs(weightLeft - weightRight);
                FeatureLeftRigth feature = new FeatureLeftRigth(weightLeft, weightRight, THRESHHOLD_LEFT_RIGHT, MIN_VALUE_THRESHHOLD, featureWeight, leftSideWidth, rightSideWidth, featureHeight);
                feature.setPositionInPicture(new Rect(minX, minY, featureWidth, featureHeight));
                features.add(feature);
//                if (j + size.getHeight() + 1 == integerImage.getHeight()) {
//                    System.out.println("Break;");
//                }
            }
//            if (i + size.getWidth() + 1 == integerImage.getWidth()) {
//                System.out.println("Break;");
//            }

        }

        return features;
    }

    /**
     * feature height must be dividable with 2
     *
     * @+++++
     * @-----
     *
     * @param integerImage
     * @param featureWidth
     * @param topSideHeight
     * @param bottomSideHeight
     * @return
     *
     */
    public static ArrayList<Feature> getFeaturesTopBottom(IntegralImage integerImage, int featureWidth, int topSideHeight, int bottomSideHeight) {
        ArrayList<Feature> features = new ArrayList<>();

        int featureHeight = topSideHeight + bottomSideHeight;

        for (int i = 0; i < integerImage.getWidth() - featureWidth; i++) {
            for (int j = 0; j < integerImage.getHeight() - featureHeight; j++) {

                //top rectangle
                int minX = i;
                int minY = j;
                int maxX = minX + featureWidth;
                int maxY = minY + topSideHeight;

                //down rectangle
                int minXRight = minX;
                int minYRight = maxY;
                int maxXRight = maxX;
                int maxYRight = maxY + bottomSideHeight;

                float weightTop = (float) integerImage.getSum(minX, minY, maxX, maxY);
                float weightBottom = (float) integerImage.getSum(minXRight, minYRight, maxXRight, maxYRight);

                float featureWeight = Math.abs(weightTop - weightBottom);
                FeatureTopBottom feature = new FeatureTopBottom(weightTop, weightBottom, THRESHHOLD_TOP_DOWN, MIN_VALUE_THRESHHOLD, featureWeight, topSideHeight, bottomSideHeight, featureWidth);
                feature.setPositionInPicture(new Rect(minX, minY, featureWidth, featureHeight));
                features.add(feature);
            }
        }

        return features;
    }

    /**
     * feature width and height must be dividable with 2
     *
     * @+++++|-----
     * @-----|+++++
     * 
     * @param integerImage
     * @param leftSideWidth
     * @param rightSideWidth
     * @param topSideHeight
     * @return 
     *
     */
    public static ArrayList<Feature> getFeaturesFourSide(IntegralImage integerImage, int leftSideWidth, int rightSideWidth, int topSideHeight, int bottomSideHeight) {
        ArrayList<Feature> features = new ArrayList<>();
        int featureWidth = leftSideWidth + rightSideWidth;
        int featureHeight = topSideHeight + bottomSideHeight;

        for (int i = 0; i < integerImage.getWidth() - featureWidth; i++) {
            for (int j = 0; j < integerImage.getHeight() - featureHeight; j++) {

                //top left rectangle
                int minXLeftTop = i;
                int minYLeftTop = j;
                int maxXLeftTop = minXLeftTop + leftSideWidth;
                int maxYLeftTop = minYLeftTop + topSideHeight;
                //top right rectangle
                int minXRightTop = maxXLeftTop;
                int minYRightTop = minYLeftTop;
                int maxXRightTop = minXRightTop + rightSideWidth;
                int maxYRightTop = maxYLeftTop;

                //bottom left rectangle
                int minXLeftBottom = minXLeftTop;
                int minYLeftBottom = maxYLeftTop;
                int maxXLeftBottom = maxXLeftTop;
                int maxYLeftBottom = minYLeftBottom + bottomSideHeight;
                //bottom right rectangle
                int minXRightBottom = minXRightTop;
                int minYRightBottom = minYLeftBottom;
                int maxXRightBottom = maxXRightTop;
                int maxYRightBottom = maxYLeftBottom;

                float weightTopLeft = (float) integerImage.getSum(minXLeftTop, minYLeftTop, maxXLeftTop, maxYLeftTop);
                float weightTopRigth = (float) integerImage.getSum(minXRightTop, minYRightTop, maxXRightTop, maxYRightTop);
                float weightBottomLeft = (float) integerImage.getSum(minXLeftBottom, minYLeftBottom, maxXLeftBottom, maxYLeftBottom);
                float weightBottomRigth = (float) integerImage.getSum(minXRightBottom, minYRightBottom, maxXRightBottom, maxYRightBottom);

                float featureWeight = Math.abs(weightTopLeft + weightBottomRigth - weightTopRigth - weightBottomLeft);
                FeatureFourSide feature = new FeatureFourSide(weightTopLeft, weightTopRigth, weightBottomLeft, weightBottomRigth, THRESHHOLD_FOUR_SIDE, MIN_VALUE_THRESHHOLD, featureWeight, topSideHeight, bottomSideHeight, leftSideWidth, rightSideWidth);
                feature.setPositionInPicture(new Rect(minXLeftTop, minYLeftTop, featureWidth, featureHeight));
                features.add(feature);
            }
        }

        return features;
    }

}
