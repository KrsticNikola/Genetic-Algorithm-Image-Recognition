/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureTopBottom;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.util.ConstValues;

import java.util.Random;

/**
 *
 * @author Nick
 */
//FIXME videti sta si zabrljao sa izmenama!
public class IndividualTopBottom extends Individual {

//    private List<Feature> featureList;
    public IndividualTopBottom(int MIN_TRASHHOLD, int MAX_TRASHHOLD, int MAX_NUMBER_OF_FEATURES, float TRASHHOLD_MEDIAN_PERCENTAGE, float MIN_FEATURE_PERCENTAGE, int PIC_WIDTH, int PIC_HEIGHT) {
        super(IndividualType.TOP_BOTTOM_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT);
    }

    public IndividualTopBottom() {
        super();
    }

    //FIXME this needs to be shure there are no duplicate features
    // Create a random individual
    @Override
    protected Feature generateFeature() {
        Random rand = new Random();

        //FIXME hardoced values!
        int commonSideSize = 2 + rand.nextInt(5);
//        int randomWidth = 4 + rand.nextInt(10);

        //fixed values
//        int featureLeftSideWidth = commonSideSize;
//        int featureRightSideWidth = commonSideSize;
        int featureTopSideHeight = commonSideSize;
        int featureBottomSideHeight = commonSideSize;

        // For each place in the tournament get a random individual
//        int randomInt = rand.nextInt(PIC_WIDTH - featureWidth);
//        rand.nextInt();
        int featureWidth = commonSideSize * 2;
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
        FeatureTopBottom featureTopBottom = new FeatureTopBottom(maxAllowedThreshhold, minAllowedThreshhold, weight, featureTopSideHeight, featureBottomSideHeight, featureWidth);
        featureTopBottom.setPositionInPicture(new Rect(x, y, featureWidth, featureHeight));
        return featureTopBottom;
//            super.featureList.add(featureFourSide);
//        }
    }

    @Override
    public Feature mutate(Feature feature) {
        return generateFeature();
    }

    @Override
    public boolean equals(Object obj) {
        IndividualTopBottom ind = (IndividualTopBottom) obj;
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
