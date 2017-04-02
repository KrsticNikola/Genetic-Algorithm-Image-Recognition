/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.run.delete;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureExtracton;
import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.util.IOUtil;

import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class TestPictureScanner {

    public static void main(String[] args) {

        float trashhold = 120;
        float minValueTrashhold = 80;

        float minFeaturePercentage = 0.4f;

        int sizesFixed = 5;
        int sizes = 4;

//        FeatureExtracton.THRESHHOLD_DEBUG_SHARED_VALUE = (long) trashhold;
//        FeatureExtracton.MIN_VALUE_THRESHHOLD = (long) minValueTrashhold;
//        String learningImage1 = "eye_crop_1.png";
//        String learningImage2 = "eye_crop_2.png";
//        String learningImage1 = "scaledeye_crop1.png";
//        String learningImage2 = "scaledeye_crop2.png";
        String learningImage1 = "scaledFacesPositives/C2_001_croped_scaled.png";
        String learningImage2 = "scaledFacesPositives/C2_002_croped_scaled.png";

//        String learningImage1 = "C2_001_croped.png";
//        String learningImage2 = "C2_002_croped.png";
//        String learningImage1 = "scaledblack_rec_1.png";
//        String learningImage2 = "scaledblack_rec_2.png";
        IntegralImage integralImage1 = new IntegralImage(IOUtil.readImage(learningImage1));
        IntegralImage integralImage2 = new IntegralImage(IOUtil.readImage(learningImage2));

//        ArrayList<Feature> features1 = FeatureExtracton.getFeaturesLeftRigth(integralImage1, sizesFixed, sizes, sizes);
//        ArrayList<Feature> features2 = FeatureExtracton.getFeaturesLeftRigth(integralImage2, sizesFixed, sizes, sizes);
//
//        ArrayList<Feature> features3 = FeatureExtracton.getFeaturesTopBottom(integralImage1, sizesFixed, sizes, sizes);
//        ArrayList<Feature> features4 = FeatureExtracton.getFeaturesTopBottom(integralImage2, sizesFixed, sizes, sizes);
        ArrayList<Feature> features5 = FeatureExtracton.getFeaturesFourSide(integralImage1, sizes, sizes, sizes, sizes);
        ArrayList<Feature> features6 = FeatureExtracton.getFeaturesFourSide(integralImage2, sizes, sizes, sizes, sizes);
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        ArrayList<Rect> rects = new ArrayList<>();
        ArrayList<Feature> selectedFeatures = new ArrayList<>();
//        for (int i = 0; i < features1.size(); i++) {
//            double result = Math.abs(features1.get(i).getWeight() - features2.get(i).getWeight());
//            System.out.println("Value group1: " + result);
//            if (result > minValueTrashhold && result < trashhold) {
////                System.out.println(features2.get(i).getPositionInPicture());
//                selectedFeatures.add(features1.get(i));
//                rects.add(features1.get(i).getPositionInPicture());
//                counter1++;
//            }
//        }
//        for (int i = 0; i < features3.size(); i++) {
//            double result = Math.abs(features3.get(i).getWeight() - features4.get(i).getWeight());
//            
//            if ( result > minValueTrashhold && result < trashhold) {
////                System.out.println(features3.get(i).getPositionInPicture());
////                System.out.println("Value group1: " + result);
//                selectedFeatures.add(features3.get(i));
//                rects.add(features3.get(i).getPositionInPicture());
//                counter2++;
//            }
//        }
        for (int i = 0; i < features5.size(); i++) {
            double result = Math.abs(features5.get(i).getWeight() - features6.get(i).getWeight());
            System.out.println("Value group1: " + result);
            if (result > minValueTrashhold && result < trashhold) {
//                System.out.println(features3.get(i).getPositionInPicture());
//                System.out.println("Value group1: " + result);
                selectedFeatures.add(features5.get(i));
                rects.add(features5.get(i).getPositionInPicture());
                counter3++;
            }
        }

        IOUtil.writeRectToImage(IOUtil.readImage(learningImage1), rects, "selectedRectangles1");
        IOUtil.writeRectToImage(IOUtil.readImage(learningImage2), rects, "selectedRectangles2");

        System.out.println("Number of selected features = " + selectedFeatures.size());
//        int minFeatureReq = (int) (0.3 * selectedFeatures.size());
        System.out.println("Min features1 req: " + counter1 * minFeaturePercentage);
        System.out.println("Min features2 req: " + counter2 * minFeaturePercentage);
        System.out.println("Min features3 req: " + counter3 * minFeaturePercentage);
//        int minFeatureReq = 10;
//        String testImageName = "C2_011.jpg";
//        String testImageName = "C2_001.jpg";
        String testImageName = "black_rectangles.jpg";
//        PictureScanner pictureScanner = new PictureScanner(IOUtil.readImage(testImageName), selectedFeatures);
//        ArrayList<FoundWindow> foundObjects = pictureScanner.scannPicture(null, null, null, minFeaturePercentage);

//        System.out.println("Number of found objects " + foundObjects.size());
//
//        IOUtil.writeRectToImageWindows(IOUtil.readImage(testImageName), foundObjects, "testImageResults");
    }

}
