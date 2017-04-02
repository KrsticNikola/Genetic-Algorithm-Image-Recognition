/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.ga;

/**
 *
 * @author Nick
 */
public class Fitness {

    private int sumOfFeatures;
    private int numberOfPostitives;
    private int numberOfFailedPositives;

    private int sizeOfFeatures;
    private int sizeOfPostitives;
    private int sizeOfFailedPositives;

    private static double MINIMUM_POSITIVES = 0.8;
    private static double MAXIMUM_FALSE_POSITIVES = 0.3;

    public Fitness() {
    }

    public Fitness(int sumOfFeatures, int numberOfPostitives, int numberOfFailedPositives, int sizeOfFeatures, int sizeOfPostitives, int sizeOfFailedPositives) {
        this.sumOfFeatures = sumOfFeatures;
        this.numberOfPostitives = numberOfPostitives;
        this.numberOfFailedPositives = numberOfFailedPositives;
        this.sizeOfFeatures = sizeOfFeatures;
        this.sizeOfPostitives = sizeOfPostitives;
        this.sizeOfFailedPositives = sizeOfFailedPositives;
    }

    //number of numberOfPostitives + average feature number per window*0.2
    public float getFitnessValue() {
        if (sizeOfPostitives == 0 || sizeOfFailedPositives == 0) {
            throw new RuntimeException("Size of positives and size of failed positives can not be 0");
        }
        //FIXME handling of sum of features is missing? sumOfFeatures/sizeOfFeatures * 0.1
        //acc = (TP+TN)/(TP+FP+FN+TN)
        long TP = numberOfPostitives;
        long TN = sizeOfFailedPositives - numberOfFailedPositives;
        long FN = numberOfFailedPositives;
        long FP = sizeOfPostitives - numberOfPostitives;
//        float accuracy = (float)((TP+TN)/(TP+FP+FN+TN));
        float mcc = (float) ((TP * TN - FP * FN) / Math.sqrt((TP + FP) * (TP + FN) * (TN + FP) * (TN + FN)));
        return mcc;
    }

    public double getAccuracy() {
        long TP = numberOfPostitives;
        long TN = sizeOfFailedPositives - numberOfFailedPositives;
        long FN = numberOfFailedPositives;
        long FP = sizeOfPostitives - numberOfPostitives;
        double accuracy = (float) ((double)(TP + TN) / (TP + FP + FN + TN));
        return accuracy;
    }

    public int getSumOfFeatures() {
        return sumOfFeatures;
    }

    public void setSumOfFeatures(int sumOfFeatures) {
        this.sumOfFeatures = sumOfFeatures;
    }

    public int getNumberOfPostitives() {
        return numberOfPostitives;
    }

    public void setNumberOfPostitives(int numberOfPostitives) {
        this.numberOfPostitives = numberOfPostitives;
    }

    public int getNumberOfFailedPositives() {
        return numberOfFailedPositives;
    }

    public void setNumberOfFailedPositives(int numberOfFailedPositives) {
        this.numberOfFailedPositives = numberOfFailedPositives;
    }

    //FIXME there is no numberOfFailedPositives
    @Override
    public String toString() {
        return "Percentage of positives: " + ((float) numberOfPostitives / sizeOfPostitives) * 100 + "; Percentage of failed: " + ((float) numberOfFailedPositives / sizeOfFailedPositives) * 100 + "; Sum of features " + sumOfFeatures + "; Fitness value: " + getFitnessValue();
    }

    public int getSizeOfFeatures() {
        return sizeOfFeatures;
    }

    public void setSizeOfFeatures(int sizeOfFeatures) {
        this.sizeOfFeatures = sizeOfFeatures;
    }

    public int getSizeOfPostitives() {
        return sizeOfPostitives;
    }

    public void setSizeOfPostitives(int sizeOfPostitives) {
        this.sizeOfPostitives = sizeOfPostitives;
    }

    public int getSizeOfFailedPositives() {
        return sizeOfFailedPositives;
    }

    public void setSizeOfFailedPositives(int sizeOfFailedPositives) {
        this.sizeOfFailedPositives = sizeOfFailedPositives;
    }

}
