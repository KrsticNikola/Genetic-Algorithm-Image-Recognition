/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureMiddleLeftRight;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.util.ConstValues;

import java.util.Random;

/**
 *
 * @author Nick
 */
public class IndividualMiddleLeftRight extends Individual {

    public IndividualMiddleLeftRight() {
    }

    public IndividualMiddleLeftRight(int MIN_TRASHHOLD, int MAX_TRASHHOLD, int MAX_NUMBER_OF_FEATURES, float TRASHHOLD_MEDIAN_PERCENTAGE, float MIN_FEATURE_PERCENTAGE, int PIC_WIDTH, int PIC_HEIGHT) {
        super(IndividualType.MIDDLE_LEFT_RIGHT_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT);
    }

    @Override
    public Feature mutate(Feature feature) {
        return generateFeature();
    }

    @Override
    protected Feature generateFeature() {
        Random rand = new Random();

        int commonSideSize = 2 + rand.nextInt(3);
//        int randomHeight = 2 + rand.nextInt(12);
//        int randomHeight = 4 + rand.nextInt(10);

        //fixed values
        int featureLeftSideWidth = commonSideSize;
        int featureRightSideWidth = commonSideSize;
        int centerSideWidth = commonSideSize;
//        int featureTopSideHeight = commonSideSize;
//        int featureBottomSideHeight = commonSideSize;

        // For each place in the tournament get a random individual
//        int randomInt = rand.nextInt(PIC_WIDTH - featureWidth);
        int featureWidth = featureLeftSideWidth + centerSideWidth + featureRightSideWidth;
        int featureHeight = commonSideSize * 2;

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

//        float weight = (float) ((trashholdMax - trashholdMin) * rand.nextDouble() + trashholdMin);
//        float weight = (float) ((getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble() + getMinThrashhold());
//        float thresholdMedian = (float) (weight * getMedianPercentageThrashhold());
//        float maxAllowedThreshhold = weight + thresholdMedian;
//        float minAllowedThreshhold = weight - thresholdMedian;
        FeatureMiddleLeftRight featureMiddleLeftRight = new FeatureMiddleLeftRight(maxAllowedThreshhold, minAllowedThreshhold, weight, featureLeftSideWidth, featureRightSideWidth, centerSideWidth, featureHeight);
        featureMiddleLeftRight.setPositionInPicture(new Rect(x, y, featureWidth, featureHeight));
        return featureMiddleLeftRight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
