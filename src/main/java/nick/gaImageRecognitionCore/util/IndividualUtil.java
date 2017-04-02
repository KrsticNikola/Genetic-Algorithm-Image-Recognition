/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.individual.*;

/**
 *
 * @author Nick
 */
public class IndividualUtil {
//     public static float MIN_FEATURE_PERCENTAGE = 0.7f;

//    public static Individual getIndividualFromType(IndividualType individualType) {
//        return createIndividual(individualType, null);
//        switch (individualType) {
//            case FOUR_SIDE_INDIVIDUAL:
//                 return new IndividualFourSide();
//            case LEFT_RIGHT_INDIVIDUAL:
//                return new IndividualLeftRight();
//            case TOP_BOTTOM_INDIVIDUAL:
//                return new IndividualTopBottom();
//            default:
//                throw new RuntimeException("Individual type unkonwn, entered value is: " + individualType);
//        }
//    }

//    public static float getMinFeaturePerecntage(IndividualType individualType) {
//        switch (individualType) {
//            case FOUR_SIDE_INDIVIDUAL:
//                return IndividualFourSide.MIN_FEATURE_PERCENTAGE;
//            case LEFT_RIGHT_INDIVIDUAL:
//                return IndividualLeftRight.MIN_FEATURE_PERCENTAGE;
//            case TOP_BOTTOM_INDIVIDUAL:
//                return IndividualTopBottom.MIN_FEATURE_PERCENTAGE;
//            default:
//                throw new RuntimeException("Individual type unkonwn, entered value is: " + individualType);
//        }
//    }

    public static Individual createIndividual(TrainingRules trainingRules) {
        IndividualType individualType = trainingRules.getIndividualType();
//        if (trainingRules == null) {
//            trainingRules = TrainingRulesFactory.getInstance().getTrainingRules();
//        }
//        TrainingRules trainingRules = TrainingRulesFactory.getInstance().getTrainingRules();
        switch (individualType) {
            case FOUR_SIDE_INDIVIDUAL:
                return new IndividualFourSide(trainingRules.getMIN_TRASHHOLD(), trainingRules.getMAX_TRASHHOLD(), trainingRules.getMAX_NUMBER_OF_FEATURES(), trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE(), trainingRules.getMIN_FEATURE_PERCENTAGE(), trainingRules.getPIC_WIDTH(), trainingRules.getPIC_HEIGHT());
//                return new IndividualFourSide(MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, TRASHHOLD_MEDIAN_PERCENTAGE, MIN_FEATURE_PERCENTAGE, PIC_WIDTH, PIC_HEIGHT)
            case LEFT_RIGHT_INDIVIDUAL:
                return new IndividualLeftRight(trainingRules.getMIN_TRASHHOLD(), trainingRules.getMAX_TRASHHOLD(), trainingRules.getMAX_NUMBER_OF_FEATURES(), trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE(), trainingRules.getMIN_FEATURE_PERCENTAGE(), trainingRules.getPIC_WIDTH(), trainingRules.getPIC_HEIGHT());
            case TOP_BOTTOM_INDIVIDUAL:
                return new IndividualTopBottom(trainingRules.getMIN_TRASHHOLD(), trainingRules.getMAX_TRASHHOLD(), trainingRules.getMAX_NUMBER_OF_FEATURES(), trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE(), trainingRules.getMIN_FEATURE_PERCENTAGE(), trainingRules.getPIC_WIDTH(), trainingRules.getPIC_HEIGHT());
            case MIDDLE_LEFT_RIGHT_INDIVIDUAL:
                return new IndividualMiddleLeftRight(trainingRules.getMIN_TRASHHOLD(), trainingRules.getMAX_TRASHHOLD(), trainingRules.getMAX_NUMBER_OF_FEATURES(), trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE(), trainingRules.getMIN_FEATURE_PERCENTAGE(), trainingRules.getPIC_WIDTH(), trainingRules.getPIC_HEIGHT());
            default:
                throw new RuntimeException("Unsupported individual type");
        }
    }
}
