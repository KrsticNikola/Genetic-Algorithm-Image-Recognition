/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureFourSide;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.util.ConstValues;

import java.util.Random;

/**
 *
 * @author Nick
 */
//FIXME videti sta si zabrljao sa izmenama!
//FIXME Not implemented!
public class IndividualMixed extends Individual {

    public static final float TRASHHOLD_MEDIAN_PERCENTAGE = 0.15f;

    public static final int MIN_TRASHHOLD = 100;
    public static final int MAX_TRASHHOLD = 1500;
//    private static final int DEFAULT_MIN_TRASHHOLD = 25;
//    private static final int DEFAULT_MAX_TRASHHOLD = 200;

    public static final int MAX_NUMBER_OF_FEATURES = 70;

//    private static final int DEFAULT_VALUES = 4;
//
//    private static final int FEATURE_LEFT_SIDE_WIDTH = DEFAULT_VALUES;
//    private static final int FEATURE_RIGHT_SIDE_WIDTH = DEFAULT_VALUES;
//    private static final int FEATURE_TOP_SIDE_HEIGHT = DEFAULT_VALUES;
//    private static final int FEATURE_BOTTOM_SIDE_HEIGHT = DEFAULT_VALUES;
    private static final int PIC_WIDTH = 19;
    private static final int PIC_HEIGHT = 19;
    //these values are randomed now
//    private static final float MIN_ALLOWED_THRESHHOLD = 75;
//    private static final float MAX_ALLOWED_THRESHHOLD = 100;

    public static float MIN_FEATURE_PERCENTAGE = 0.7f;

//    private List<Feature> featureList;
    public IndividualMixed() {
        super(IndividualType.FOUR_SIDE_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT);
        throw new RuntimeException("Not implemented~!!");
    }

//    public IndividualFourSide(float threshholdMedianPercentage, float minFeaturePercentage) {
//        super(IndividualType.FOUR_SIDE_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, threshholdMedianPercentage, minFeaturePercentage, PIC_WIDTH, PIC_HEIGHT);
//    }
    //FIXME this needs to be shure there are no duplicate features
//    @Override
//    public void generateIndividualAction() {
//        for (int i = 0; i < MAX_NUMBER_OF_FEATURES; i++) {
//            getFeatureList().add(generateIndividual());
//        }
//    }
    //FIXME this needs to be shure there are no duplicate features
    // Create a random individual
    @Override
    protected Feature generateFeature() {
        Random rand = new Random();

        int commonSideSize = 2 + rand.nextInt(4);

        //fixed values
        int featureLeftSideWidth = commonSideSize;
        int featureRightSideWidth = commonSideSize;
        int featureTopSideHeight = commonSideSize;
        int featureBottomSideHeight = commonSideSize;

        // For each place in the tournament get a random individual
//        int randomInt = rand.nextInt(PIC_WIDTH - featureWidth);
//        rand.nextInt();
        int featureWidth = featureLeftSideWidth + featureRightSideWidth;
        int featureHeight = featureTopSideHeight + featureBottomSideHeight;

        int x = rand.nextInt(PIC_WIDTH - featureWidth);
        int y = rand.nextInt(PIC_HEIGHT - featureHeight);

//        float trashholdMax = (float) (getMaxThrashhold() - (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
//        float trashholdMin = (float) (getMinThrashhold() + (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
//        if (trashholdMin > trashholdMax) {
//            trashholdMax += trashholdMin;
//            trashholdMin = trashholdMax - trashholdMin;
//            trashholdMax = trashholdMax - trashholdMin;
////            trashholdMax =
//
//        }
        float weight = ConstValues.FIXED_WEIGHT;
        float maxAllowedThreshhold = getMaxThrashhold();
        float minAllowedThreshhold = getMinThrashhold();
//        float weight = (float) ((trashholdMax-trashholdMin) * rand.nextDouble() + trashholdMin);
////        System.out.println(weight);
////        float thresholdMedian = (float) (weight * getMedianPercentageThrashhold());
//        float maxAllowedThreshhold = weight + thresholdMedian;
//        float minAllowedThreshhold = weight - thresholdMedian;

        FeatureFourSide featureFourSide = new FeatureFourSide(maxAllowedThreshhold, minAllowedThreshhold, weight, featureTopSideHeight, featureBottomSideHeight, featureLeftSideWidth, featureRightSideWidth);
        featureFourSide.setPositionInPicture(new Rect(x, y, featureWidth, featureHeight));
//        FeatureFourSide featureFourSide = new FeatureFourSide(maxAllowedThreshhold, minAllowedThreshhold, weight, new Rect(x, y, featureWidth, featureHeight));
//            System.out.println("Feature four side; " + featureFourSide);
        return featureFourSide;
//            super.featureList.add(featureFourSide);
//        }
    }

    @Override
    public Feature mutate(Feature feature) {
        return generateFeature();
//        System.out.println("test");
    }

    @Override
    public boolean equals(Object obj) {
        IndividualMixed ind = (IndividualMixed) obj;
        if (this.getFeatureList().get(1).getWeight() == ind.getFeatureList().get(1).getWeight() && this.getFeatureList().get(1).getPositionInPicture().equals(ind.getFeatureList().get(1).getPositionInPicture())) {
            return true;
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
