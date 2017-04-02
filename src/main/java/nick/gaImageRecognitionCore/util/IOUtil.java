package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FoundWindow;
import nick.gaImageRecognitionCore.image.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class IOUtil {

    private static final String RESOURCE_FOLDER = "src/main/resources/";
    private static final String IMAGE_TYPE_PNG = "png";
    private static final String IMAGE_DEFAULT_NAME = "default_name";
    private static final int IMAGE_SCALE_WIDTH = 19;
    private static final int IMAGE_SCALE_HEIGHT = 19;

    public static BufferedImage readImage(String fileName) {
        try {
            return ImageIO.read(new File(RESOURCE_FOLDER + fileName));
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static BufferedImage readImageAbsPath(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean writeImage(BufferedImage image, String imageName) {
        String name = (imageName == null ? IMAGE_DEFAULT_NAME : imageName);
        File outputFile = new File(RESOURCE_FOLDER + name);
        try {
            ImageIO.write(image, IMAGE_TYPE_PNG, outputFile);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void scaleImg(String imgName, String outputName) {
        try {
            File srcfile = new File(RESOURCE_FOLDER + imgName);
            if (!srcfile.exists()) {
                return;
            }
            Image src = javax.imageio.ImageIO.read(srcfile);

            BufferedImage tag = new BufferedImage((int) IMAGE_SCALE_WIDTH, (int) IMAGE_SCALE_HEIGHT,
                    BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(src.getScaledInstance(IMAGE_SCALE_WIDTH, IMAGE_SCALE_HEIGHT, Image.SCALE_SMOOTH), 0, 0, null);

            FileOutputStream out = new FileOutputStream(RESOURCE_FOLDER + outputName.concat(".").concat(IMAGE_TYPE_PNG));
            ImageIO.write(tag, IMAGE_TYPE_PNG, out);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static BufferedImage getScaledImg(String imgName) {
        BufferedImage tag = null;
        try {
            File srcfile = new File(RESOURCE_FOLDER + imgName);
//            if (!srcfile.exists()) {
//                return;
//            }
            Image src = javax.imageio.ImageIO.read(srcfile);

            tag = new BufferedImage((int) IMAGE_SCALE_WIDTH, (int) IMAGE_SCALE_HEIGHT,
                    BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(src.getScaledInstance(IMAGE_SCALE_WIDTH, IMAGE_SCALE_HEIGHT, Image.SCALE_SMOOTH), 0, 0, null);

//            FileOutputStream out = new FileOutputStream(RESOURCE_FOLDER + outputName.concat(".").concat(IMAGE_TYPE_PNG));
//            ImageIO.write(tag, IMAGE_TYPE_PNG, out);
//            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tag;
    }

    public static void writeRectToImage(BufferedImage image, ArrayList<Rect> rectangles, String newImageName) {
//        BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        bi = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
        Graphics2D g2 = image.createGraphics();
        float thickness = 0.01F;
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(Color.red);
        for (Rect rect : rectangles) {
            g2.drawRect(rect.getMinX(), rect.getMinY(), rect.getWidth(), rect.getHeight());
//            System.out.println("done");
//            break;
        }
        try {
            FileOutputStream out = new FileOutputStream(RESOURCE_FOLDER + newImageName.concat(".").concat(IMAGE_TYPE_PNG));
            ImageIO.write(image, IMAGE_TYPE_PNG, out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void writeFoundWindowToImage(BufferedImage image, ArrayList<FoundWindow> rectangles, String newImageName) {
//        BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        bi = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
        Graphics2D g2 = image.createGraphics();
        float thickness = 0.01F;
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(Color.red);
        for (Rect rect : rectangles) {
            g2.drawRect(rect.getMinX(), rect.getMinY(), rect.getWidth(), rect.getHeight());
//            System.out.println("done");
//            break;
        }
        try {
            FileOutputStream out = new FileOutputStream(RESOURCE_FOLDER + newImageName.concat(".").concat(IMAGE_TYPE_PNG));
            ImageIO.write(image, IMAGE_TYPE_PNG, out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeRectToImageWindows(BufferedImage image, ArrayList<FoundWindow> rectangles, String newImageName) {
//        BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        bi = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
        Graphics2D g2 = image.createGraphics();
        float thickness = 0.01F;
        g2.setStroke(new BasicStroke(thickness));
//        g2.setColor(Color.red);
        for (Rect rect : rectangles) {
            FoundWindow foundw = (FoundWindow) rect;
            g2.setColor(Color.red);
            g2.drawRect(rect.getMinX(), rect.getMinY(), rect.getWidth(), rect.getHeight());
            g2.setColor(Color.GREEN);
            for (Feature feature : foundw.getFeatures()) {
                float scale = foundw.getScale();
                int featureX = (int) (feature.getPositionInPicture().getMinX() * scale) + rect.getMinX();
                int featureY = (int) (feature.getPositionInPicture().getMinY() * scale) + rect.getMinY();
                int width = (int) (feature.getPositionInPicture().getWidth() * scale);
                int height = (int) (feature.getPositionInPicture().getHeight() * scale);
                g2.drawRect(featureX, featureY, width, height);

            }
//               System.out.println("Features in window: " + foundw.getFeatures());
//               System.out.println("Features in window: " + foundw.getFeatures().size());
//            break;
//            System.out.println("done");
//            break;
        }
        try {
            FileOutputStream out = new FileOutputStream(RESOURCE_FOLDER + newImageName.concat(".").concat(IMAGE_TYPE_PNG));
            ImageIO.write(image, IMAGE_TYPE_PNG, out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /////////////////multi folder read pictures
    // File representing the folder that you select using a FileChooser
//    static final File dir = new File("src/resurces/");
    // array of supported extensions (use a List if you prefer)
    private static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "pgm" // and other formats you need
    };
    // filter to identify images based on their extensions
    private static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public static List<BufferedImage> getImagesFromFolder(String src) {
        String systemSeparator = File.separator;
        if (!String.valueOf(src.charAt(src.length() - 1)).equals(systemSeparator)) {
            // when using folder location it needs to end with /
            src = src + systemSeparator;
        }
        final File dir = new File(src);
        List<BufferedImage> images = new ArrayList<>();
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                images.add(readImageAbsPath(f.getAbsolutePath()));
            }
        } else {
            throw new RuntimeException("Folder not found for location: " + src);
        }

        if (images.isEmpty()) {
            throw new RuntimeException("Loaded images can not be empty..");
        }
        return images;
    }

}
