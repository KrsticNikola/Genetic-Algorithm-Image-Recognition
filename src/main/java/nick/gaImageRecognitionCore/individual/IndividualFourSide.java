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
public class IndividualFourSide extends Individual {

    public IndividualFourSide(int MIN_TRASHHOLD, int MAX_TRASHHOLD, int MAX_NUMBER_OF_FEATURES, float TRASHHOLD_MEDIAN_PERCENTAGE, float MIN_FEATURE_PERCENTAGE, int PIC_WIDTH, int PIC_HEIGHT) {
        super(IndividualType.FOUR_SIDE_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT);
    }

    public IndividualFourSide() {
        super();
    }

    //FIXME this needs to be shure there are no duplicate features
//    @Override
//    public void generateIndividualAction() {
//        for (int i = 0; i < getMaxNumberOfFeatures(); i++) {
//            getFeatureList().add(generateIndividual());
//        }
//    }
    //FIXME this needs to be shure there are no duplicate features
    // Create a random individual
    @Override
    protected Feature generateFeature() {
        Random rand = new Random();

        //FIXME hardoced values!
        int commonSideSizeWidth = 2 + rand.nextInt(5);
        int commonSideSizeHeight = 2 + rand.nextInt(5);

        //fixed values
        int featureLeftSideWidth = commonSideSizeWidth;
        int featureRightSideWidth = commonSideSizeWidth;
        int featureTopSideHeight = commonSideSizeHeight;
        int featureBottomSideHeight = commonSideSizeHeight;

        // For each place in the tournament get a random individual
//        int randomInt = rand.nextInt(PIC_WIDTH - featureWidth);
//        rand.nextInt();
        int featureWidth = featureLeftSideWidth + featureRightSideWidth;
        int featureHeight = featureTopSideHeight + featureBottomSideHeight;

        int x = rand.nextInt(getWindowWidth() - featureWidth);
        int y = rand.nextInt(getWindowHeight() - featureHeight);

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

//        float weight = (float) ((getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble() + getMinThrashhold());
////        System.out.println(weight);
//        float thresholdMedian = (float) (weight * getMedianPercentageThrashhold());
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
        IndividualFourSide ind = (IndividualFourSide) obj;
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
