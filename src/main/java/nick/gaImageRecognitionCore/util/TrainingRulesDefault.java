/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.individual.IndividualType;

/**
 *
 * @author Nick
 */
public class TrainingRulesDefault {

//    public static float TRASHHOLD_MEDIAN_PERCENTAGE = 0;
//
//    public static int autoIncrementDefaultValue = 0;
//    
//    public static int MIN_TRASHHOLD = 0;
//    public static int MAX_TRASHHOLD = 0;
//
//    public static int MAX_NUMBER_OF_FEATURES = 0;
//
//    public static int PIC_WIDTH = 0;
//    public static int PIC_HEIGHT = 0;
//
//    public static float MIN_FEATURE_PERCENTAGE = 0;
    public static float TRASHHOLD_MEDIAN_PERCENTAGE = 0.5f;

    public static int autoIncrementDefaultValue = 200;
    public static int autoIncrementCounter = 150 ;
    public static boolean autoIncrement = false;

    public static int MIN_TRASHHOLD = 500;
    public static int MAX_TRASHHOLD = 3000;

    public static int MAX_NUMBER_OF_FEATURES = 80;

    public static int PIC_WIDTH = 19;
    public static int PIC_HEIGHT = 19;

    public static float MIN_FEATURE_PERCENTAGE = 0.75f;
    
    public static IndividualType individualType = IndividualType.FOUR_SIDE_INDIVIDUAL;

    public static TrainingRules getDefaultTrainingRules() {
        return new TrainingRules(autoIncrementCounter, autoIncrement, TRASHHOLD_MEDIAN_PERCENTAGE, autoIncrementDefaultValue, MIN_TRASHHOLD, MAX_TRASHHOLD, MAX_NUMBER_OF_FEATURES, PIC_WIDTH, PIC_HEIGHT, MIN_FEATURE_PERCENTAGE, individualType);
    }
}
