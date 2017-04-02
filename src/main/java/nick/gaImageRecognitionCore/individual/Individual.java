/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.ga.Fitness;
import nick.gaImageRecognitionCore.ga.FitnessCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nick
 */
public abstract class Individual implements Cloneable {

    protected boolean debug = true;
    private List<Feature> featureList = new ArrayList<>();

    private Fitness fitness;

    private IndividualType individualType;
    private Integer minThrashhold;
    private Integer maxThrashhold;
    private Integer maxNumberOfFeatures;
    
    //TODO Delete this is not needed as we are using fixed min/max thrashhold
    private Float medianPercentageThrashhold;

    private Float minFeaturePercentage;

    private Integer windowWidth;
    private Integer windowHeight;

    /**
     * Used only when loading data from saved configuration !
     */
    public Individual() {

    }

    public Individual(IndividualType individualType, Integer minThrashhold, Integer maxThrashhold, Integer maxNumberOfFeatures, Float medianPercentageThrashhold, Float minFeaturePercentage, Integer windowWidth, Integer windowHeight) {
        this.individualType = individualType;
        this.minThrashhold = minThrashhold;
        this.maxThrashhold = maxThrashhold;
        this.maxNumberOfFeatures = maxNumberOfFeatures;
        this.medianPercentageThrashhold = medianPercentageThrashhold;
        this.minFeaturePercentage = minFeaturePercentage;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    //Create a random individuals and add to list
    public void generateIndividualAction() {
        for (int i = 0; i < getMaxNumberOfFeatures(); i++) {
            getFeatureList().add(generateFeature());
        }
    }

    protected float calculateWeight() {
        Random rand = new Random();
        float trashholdMax = (float) (getMaxThrashhold() - (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
        float trashholdMin = (float) (getMinThrashhold() + (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
        if (trashholdMin > trashholdMax) {
            trashholdMax += trashholdMin;
            trashholdMin = trashholdMax - trashholdMin;
            trashholdMax = trashholdMax - trashholdMin;
//            trashholdMax =

        }
        return (float) ((trashholdMax - trashholdMin) * rand.nextDouble() + trashholdMin);
//        weight = new MutableFloat((float) ((trashholdMax - trashholdMin) * rand.nextDouble() + trashholdMin));
////        System.out.println(weight);
//        thresholdMedian = new MutableFloat((float) ((trashholdMax - trashholdMin) * getMedianPercentageThrashhold()));
////        float thresholdMedianPrivate = (float) (weightPrivate * getMedianPercentageThrashhold());
//        maxAllowedThreshhold = new MutableFloat((float) (weight + thresholdMedian));
//        minAllowedThreshhold = new MutableFloat((float) weight - thresholdMedian);
    }
    
//    protected void calculateThrashholds(MutableFloat weight, MutableFloat thresholdMedian, MutableFloat maxAllowedThreshhold, MutableFloat minAllowedThreshhold) {
//        Random rand = new Random();
//        float trashholdMax = (float) (getMaxThrashhold() - (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
//        float trashholdMin = (float) (getMinThrashhold() + (getMaxThrashhold() - getMinThrashhold()) * rand.nextDouble());
//        if (trashholdMin > trashholdMax) {
//            trashholdMax += trashholdMin;
//            trashholdMin = trashholdMax - trashholdMin;
//            trashholdMax = trashholdMax - trashholdMin;
////            trashholdMax =
//
//        }
//
//        weight = new MutableFloat((float) ((trashholdMax - trashholdMin) * rand.nextDouble() + trashholdMin));
////        System.out.println(weight);
//        thresholdMedian = new MutableFloat((float) ((trashholdMax - trashholdMin) * getMedianPercentageThrashhold()));
////        float thresholdMedianPrivate = (float) (weightPrivate * getMedianPercentageThrashhold());
//        maxAllowedThreshhold = new MutableFloat((float) (weight + thresholdMedian));
//        minAllowedThreshhold = new MutableFloat((float) weight - thresholdMedian);
//    }

    // Create a random individual
    protected abstract Feature generateFeature();

    //mutate individual
    public abstract Feature mutate(Feature feature);

    //used in apache lcone must have impl
//    @Override
//    public abstract Object clone() throws CloneNotSupportedException;
    public Fitness getFitness() {
        if (fitness == null) {
            fitness = FitnessCalculation.getInstance().generateFitness(this);
        }
        return fitness;
    }

    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }

//    public abstract void generateIndividualAction();
//    protected abstract Object clone();
    public IndividualType getIndividualType() {
        return individualType;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public Integer getMinThrashhold() {
        return minThrashhold;
    }

    public Integer getMaxThrashhold() {
        return maxThrashhold;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public Float getMedianPercentageThrashhold() {
        return medianPercentageThrashhold;
    }

    public void setMedianPercentageThrashhold(Float medianPercentageThrashhold) {
        this.medianPercentageThrashhold = medianPercentageThrashhold;
    }

    public Integer getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(Integer windowWidth) {
        this.windowWidth = windowWidth;
    }

    public Integer getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(Integer windowHeight) {
        this.windowHeight = windowHeight;
    }

    public Float getMinFeaturePercentage() {
        return minFeaturePercentage;
    }

    public void setMinFeaturePercentage(Float minFeaturePercentage) {
        this.minFeaturePercentage = minFeaturePercentage;
    }

    public Integer getMaxNumberOfFeatures() {
        return maxNumberOfFeatures;
    }

    public void setMaxNumberOfFeatures(Integer maxNumberOfFeatures) {
        this.maxNumberOfFeatures = maxNumberOfFeatures;
    }
}
