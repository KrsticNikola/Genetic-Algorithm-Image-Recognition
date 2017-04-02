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
public class TrainingRules {

    private float TRASHHOLD_MEDIAN_PERCENTAGE;

    private int autoIncrementDefaultValue;
    private boolean autoIncrement;
    private int autoIncrementGenerationCounter; //after how much generations autoincrement will occure

    private int MIN_TRASHHOLD;
    private int MAX_TRASHHOLD;

    private int MAX_NUMBER_OF_FEATURES;

    private int PIC_WIDTH;
    private int PIC_HEIGHT;

    private float MIN_FEATURE_PERCENTAGE;

    private IndividualType IndividualType;

    public TrainingRules(int autoIncrementGenerationCounter, boolean autoIncrement, float TRASHHOLD_MEDIAN_PERCENTAGE, int autoIncrementDefaultValue, int MIN_TRASHHOLD, int MAX_TRASHHOLD, int MAX_NUMBER_OF_FEATURES, int PIC_WIDTH, int PIC_HEIGHT, float MIN_FEATURE_PERCENTAGE, IndividualType IndividualType) {
        this.autoIncrementGenerationCounter = autoIncrementGenerationCounter;
        this.autoIncrement = autoIncrement;
        this.TRASHHOLD_MEDIAN_PERCENTAGE = TRASHHOLD_MEDIAN_PERCENTAGE;
        this.autoIncrementDefaultValue = autoIncrementDefaultValue;
        this.MIN_TRASHHOLD = MIN_TRASHHOLD;
        this.MAX_TRASHHOLD = MAX_TRASHHOLD;
        this.MAX_NUMBER_OF_FEATURES = MAX_NUMBER_OF_FEATURES;
        this.PIC_WIDTH = PIC_WIDTH;
        this.PIC_HEIGHT = PIC_HEIGHT;
        this.MIN_FEATURE_PERCENTAGE = MIN_FEATURE_PERCENTAGE;
        this.IndividualType = IndividualType;
    }

    @Override
    public String toString() {
        return "TrainingRules{" + "TRASHHOLD_MEDIAN_PERCENTAGE=" + TRASHHOLD_MEDIAN_PERCENTAGE + ", autoIncrementDefaultValue=" + autoIncrementDefaultValue + ", autoIncrement=" + autoIncrement + ", autoIncrementGenerationCounter=" + autoIncrementGenerationCounter + ", MIN_TRASHHOLD=" + MIN_TRASHHOLD + ", MAX_TRASHHOLD=" + MAX_TRASHHOLD + ", MAX_NUMBER_OF_FEATURES=" + MAX_NUMBER_OF_FEATURES + ", PIC_WIDTH=" + PIC_WIDTH + ", PIC_HEIGHT=" + PIC_HEIGHT + ", MIN_FEATURE_PERCENTAGE=" + MIN_FEATURE_PERCENTAGE + ", IndividualType=" + IndividualType + '}';
    }

    
    public void autoIncrement() {
        MIN_TRASHHOLD += autoIncrementDefaultValue;
        MAX_TRASHHOLD += autoIncrementDefaultValue;
    }

    public void setAutoIncrementDefaultValue(int autoIncrementDefaultValue) {
        this.autoIncrementDefaultValue = autoIncrementDefaultValue;
    }

    public float getTRASHHOLD_MEDIAN_PERCENTAGE() {
        return TRASHHOLD_MEDIAN_PERCENTAGE;
    }

    public void setTRASHHOLD_MEDIAN_PERCENTAGE(float TRASHHOLD_MEDIAN_PERCENTAGE) {
        this.TRASHHOLD_MEDIAN_PERCENTAGE = TRASHHOLD_MEDIAN_PERCENTAGE;
    }

    public int getMIN_TRASHHOLD() {
        return MIN_TRASHHOLD;
    }

    public void setMIN_TRASHHOLD(int MIN_TRASHHOLD) {
        this.MIN_TRASHHOLD = MIN_TRASHHOLD;
    }

    public int getMAX_TRASHHOLD() {
        return MAX_TRASHHOLD;
    }

    public void setMAX_TRASHHOLD(int MAX_TRASHHOLD) {
        this.MAX_TRASHHOLD = MAX_TRASHHOLD;
    }

    public int getMAX_NUMBER_OF_FEATURES() {
        return MAX_NUMBER_OF_FEATURES;
    }

    public void setMAX_NUMBER_OF_FEATURES(int MAX_NUMBER_OF_FEATURES) {
        this.MAX_NUMBER_OF_FEATURES = MAX_NUMBER_OF_FEATURES;
    }

    public int getPIC_WIDTH() {
        return PIC_WIDTH;
    }

    public void setPIC_WIDTH(int PIC_WIDTH) {
        this.PIC_WIDTH = PIC_WIDTH;
    }

    public int getPIC_HEIGHT() {
        return PIC_HEIGHT;
    }

    public void setPIC_HEIGHT(int PIC_HEIGHT) {
        this.PIC_HEIGHT = PIC_HEIGHT;
    }

    public float getMIN_FEATURE_PERCENTAGE() {
        return MIN_FEATURE_PERCENTAGE;
    }

    public void setMIN_FEATURE_PERCENTAGE(float MIN_FEATURE_PERCENTAGE) {
        this.MIN_FEATURE_PERCENTAGE = MIN_FEATURE_PERCENTAGE;
    }

    public IndividualType getIndividualType() {
        return IndividualType;
    }

    public void setIndividualType(IndividualType IndividualType) {
        this.IndividualType = IndividualType;
    }

    public int getAutoIncrementDefaultValue() {
        return autoIncrementDefaultValue;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public int getAutoIncrementGenerationCounter() {
        return autoIncrementGenerationCounter;
    }

    public void setAutoIncrementGenerationCounter(int autoIncrementGenerationCounter) {
        this.autoIncrementGenerationCounter = autoIncrementGenerationCounter;
    }

}
