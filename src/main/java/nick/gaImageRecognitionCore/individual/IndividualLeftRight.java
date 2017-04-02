/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.feature.FeatureLeftRigth;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.util.ConstValues;

import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
//FIXME videti sta si zabrljao sa izmenama!
public class IndividualLeftRight extends Individual {

    private static final Logger LOGGER = Logger.getLogger(IndividualLeftRight.class.getName());

    public IndividualLeftRight(int MIN_TRASHHOLD, int MAX_TRASHHOLD, int MAX_NUMBER_OF_FEATURES, float TRASHHOLD_MEDIAN_PERCENTAGE, float MIN_FEATURE_PERCENTAGE, int PIC_WIDTH, int PIC_HEIGHT) {
        super(IndividualType.LEFT_RIGHT_INDIVIDUAL, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT);
    }

    public IndividualLeftRight() {
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

        int commonSideSize = 2 + rand.nextInt(5);
//        int randomHeight = 2 + rand.nextInt(12);
//        int randomHeight = 4 + rand.nextInt(10);

        //fixed values
        int featureLeftSideWidth = commonSideSize;
        int featureRightSideWidth = commonSideSize;
//        int featureTopSideHeight = commonSideSize;
//        int featureBottomSideHeight = commonSideSize;

        // For each place in the tournament get a random individual
//        int randomInt = rand.nextInt(PIC_WIDTH - featureWidth);
        int featureWidth = featureLeftSideWidth + featureRightSideWidth;
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
////        System.out.println(weight);
//        float thresholdMedian = (float) (weight * getMedianPercentageThrashhold());
//        float maxAllowedThreshhold = weight + thresholdMedian;
//        float minAllowedThreshhold = weight - thresholdMedian;
        
        
//        if (debug && Math.random() < 0.005) {
//             LOGGER.log(Level.INFO, "-------------------", minAllowedThreshhold);
////            LOGGER.log(Level.INFO, "Max thrashhold: {0}", trashholdMax);
////            LOGGER.log(Level.INFO, "Min thrashhold: {0}", trashholdMin);
////            LOGGER.log(Level.INFO, "thresholdMedian: {0}", thresholdMedian);
//            LOGGER.log(Level.INFO, "Max allowed: {0}", maxAllowedThreshhold);
//            LOGGER.log(Level.INFO, "Min allowed: {0}", minAllowedThreshhold);
//            LOGGER.log(Level.INFO, "-------------------", minAllowedThreshhold);
//        }

        FeatureLeftRigth featureLeftRigth = new FeatureLeftRigth(maxAllowedThreshhold, minAllowedThreshhold, weight, featureHeight, featureLeftSideWidth, featureRightSideWidth);
        featureLeftRigth.setPositionInPicture(new Rect(x, y, featureWidth, featureHeight));
        return featureLeftRigth;
//        }
    }

    @Override
    public Feature mutate(Feature feature) {
        return generateFeature();
//        System.out.println("test");
    }

    @Override
    public boolean equals(Object obj) {
        IndividualLeftRight ind = (IndividualLeftRight) obj;
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
