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
public class Run {

    public static void main(String[] args) {
        
        float trashhold = 5;

        IntegralImage integralImage1 = new IntegralImage(IOUtil.readImage("scaledeye_crop2.png"));
        IntegralImage integralImage2 = new IntegralImage(IOUtil.readImage("scaledeye_crop1.png"));

//        ArrayList<Feature> features1 = FeatureExtracton.getFeaturesLeftRigth(integralImage1, 3, 3);
//        ArrayList<Feature> features2 = FeatureExtracton.getFeaturesLeftRigth(integralImage2, 3, 3);
//        ArrayList<Feature> features1 = FeatureExtracton.getFeaturesTopBottom(integralImage1, 3, 3);
//        ArrayList<Feature> features2 = FeatureExtracton.getFeaturesTopBottom(integralImage2, 3, 3);
        ArrayList<Feature> features1 = FeatureExtracton.getFeaturesFourSide(integralImage1, 3, 3, 3, 3);
        ArrayList<Feature> features2 = FeatureExtracton.getFeaturesFourSide(integralImage2, 3, 3, 3, 3);
        System.out.println("Number of features1 : " + features1.size());
        System.out.println("Number of features2 : " + features2.size());
//        int counter = 1;
//        int xRectanges = 0;
//        int yRectanges = 0;
        ArrayList<Feature> selectedFeatures = new ArrayList<>();
        ArrayList<Rect> rects = new ArrayList<>();
        for (int i = 0; i < features1.size(); i++) {
//            System.out.println("Feature 1 weight: " + features1.get(i).getWeight());
//            System.out.println("Feature 2 weight: " + features2.get(i).getWeight());
            if (Math.abs(features1.get(i).getWeight() - features2.get(i).getWeight()) < trashhold) {
                rects.add(features2.get(i).getPositionInPicture());
                selectedFeatures.add(features1.get(i));
            }
//            System.out.println("---------- ");
        }

        System.out.println("Number of rectangles: " + rects.size());
        for (int i = 0; i < rects.size(); i++) {
            System.out.println(rects.get(i));
        }

        System.out.println("Write rectangles..");
        IOUtil.writeRectToImage(IOUtil.readImage("scaledeye_crop2.png"), rects, "img1Rectangles");
        IOUtil.writeRectToImage(IOUtil.readImage("scaledeye_crop1.png"), rects, "img2Rectangles");

//        for (Feature feature : features1) {
//            if (feature.getPositionInPicture().getMinX() == 3) {
//                xRectanges++;
//            }
//            if (feature.getPositionInPicture().getMinY() == 3) {
//                yRectanges++;
//            }
////            System.out.println("Position: " + counter + " :" + feature.getPositionInPicture());
////            System.out.println("Feature weight: " + counter + " :" + feature.getWeight());
//            counter++;
//        }
//        System.out.println("Max x rectangles: " + xRectanges);
//        System.out.println("Max y rectangles: " + yRectanges);

    }

}
