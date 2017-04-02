/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.run;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.ga.Algorithm;
import nick.gaImageRecognitionCore.ga.Fitness;
import nick.gaImageRecognitionCore.ga.FitnessCalculation;
import nick.gaImageRecognitionCore.ga.Population;
import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.individual.IndividualType;
import nick.gaImageRecognitionCore.util.ConfigurationUtil;
import nick.gaImageRecognitionCore.util.IOUtil;
import nick.gaImageRecognitionCore.util.TrainingRules;
import nick.gaImageRecognitionCore.util.TrainingRulesDefault;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick
 */
public class GARun {

//    private static final float MIN_FEATURE_PERCENTAGE = IndividualFourSide.MIN_FEATURE_PERCENTAGE;
    private static final int ALLOWED_NUMBER_OF_ITERATIONS = 100;
    private static final int POPULATION_SIZE = 150;
//    private static final IndividualType INDIVIDUAL_TYPE = IndividualType.TOP_BOTTOM_INDIVIDUAL;
    private static final IndividualType INDIVIDUAL_TYPE = IndividualType.TOP_BOTTOM_INDIVIDUAL;

    public static void main(String[] args) {
        TrainingRules trainingRules = TrainingRulesDefault.getDefaultTrainingRules();
        trainingRules.setIndividualType(INDIVIDUAL_TYPE);

        // Create an initial population
        Population myPop = new Population(POPULATION_SIZE, true, trainingRules);

        System.out.println("Learning started with params: ");
        System.out.println(myPop.getIndividual(0).toString());
        System.out.println();

        String trainingFolder = "src/main/resources/ForTraining/face/";
        String falsePositivesFolder = "src/main/resources/ForTraining/non-face/";

//        String  falsePositivesFolder = "src/main/resources/ForTraining/face/";
//        String  trainingFolder = "src/main/resources/ForTraining/non-face/";
        String configLocation = "src/main/resources/config/config.txt";
//        String learningParamsPath = "src/resources/config/configParam2.txt";

        List<IntegralImage> positiveImages = new ArrayList<>();
        List<IntegralImage> falsePositiveImages = new ArrayList<>();

        List<BufferedImage> trainingImages = IOUtil.getImagesFromFolder(trainingFolder);
        for (BufferedImage image : trainingImages) {
            positiveImages.add(new IntegralImage(image));
        }
        List<BufferedImage> falseImages = IOUtil.getImagesFromFolder(falsePositivesFolder);
        for (BufferedImage image : falseImages) {
            falsePositiveImages.add(new IntegralImage(image));
        }

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;

        //we will break iteration if result is ame for 2000 generations
        int counter = 0;

        float fittestValue = -250;

//        int populationCounterBreak = 0;
        FitnessCalculation.getInstance().setTrainingIntegralImages(positiveImages);
        FitnessCalculation.getInstance().setFalseIntegralImages(falsePositiveImages);
        while (true) {
//        while (myPop.getFittest().getFitness().getNumberOfPostitives() < positiveImages.size() || myPop.getFittest().getFitness().getNumberOfFailedPositives() > 0) {
            generationCount++;
            counter++;
            myPop = Algorithm.evolvePopulation(myPop, trainingRules);
            Fitness bestFitness = myPop.getFittest().getFitness();
//            if (generationCount % 100 == 0) {

//                Individual fittestIndividual = myPop.getFittest();
            float fitnessValue = bestFitness.getFitnessValue();
            if (fittestValue < fitnessValue) {
                counter = 0;
                fittestValue = fitnessValue;
                System.out.println("Generation: " + generationCount + " Fittest: " + bestFitness);
            }
//            if (generationCount % 500 == 0) {
//                System.out.println("Test start!!!-----------------------");
//                for (Individual individuals : myPop.getIndividuals()) {
//                    System.out.println("Fittnes value : " +individuals.getFitness().getFitnessValue() + " Number of features: " + individuals.getFitness().getSumOfFeatures() + " Positives: " + individuals.getFitness().getNumberOfPostitives());
////                     System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness().getFitnessValue());
////                System.out.println("Generation: " + generationCount + " found : " + myPop.getFittest().getFitness().getNumberOfPostitives());
//                
//                }
//                System.out.println("Test end ===========================");
//                break;
//            }
//            if (bestFitness.getNumberOfPostitives() > positiveImages.size() * 0.8) {
//                break;
//            }
            if (counter == ALLOWED_NUMBER_OF_ITERATIONS) {
                break;
            }
//            if (myPop.getFittest().getFitness().getNumberOfPostitives() == positiveImages.size() && myPop.getFittest().getFitness().getNumberOfFailedPositives() == 0) {
//                break;
//            }
            if (generationCount % 10 == 0) {
                System.out.println("generation: " + generationCount);
            }
            if (generationCount == 20000) {
                System.out.println("Failed!!");
                break;
            }
//            if (myPop.getFittest().getFitness().getNumberOfFailedPositives() == 0 && myPop.getFittest().getFitness().getNumberOfPostitives() == positiveImages.size()) {
//                break;
//            }

        }
        Individual[] selectedIndividuals = new Individual[1];
        selectedIndividuals[0] = myPop.getFittest();

        String configPath = ConfigurationUtil.saveConfiguration(selectedIndividuals, configLocation);

//        int foundSamples = selectedIndividuals[0].getFitness().getNumberOfPostitives();
//        int falsePositivesSamples = selectedIndividuals[0].getFitness().getNumberOfFailedPositives();
        int numberOfSamples = positiveImages.size();
        int numberOfFalseSamples = falsePositiveImages.size();
        float minFeaturePercentage = trainingRules.getMIN_FEATURE_PERCENTAGE();
        float trashholdMedianPercentage = trainingRules.getTRASHHOLD_MEDIAN_PERCENTAGE();
        int minThreshold = trainingRules.getMIN_TRASHHOLD();
        int maxThreshold = trainingRules.getMAX_TRASHHOLD();
        int numberOfFeatures = trainingRules.getMAX_NUMBER_OF_FEATURES();

        ConfigurationUtil.saveTrainingParams(POPULATION_SIZE, INDIVIDUAL_TYPE, minFeaturePercentage, trashholdMedianPercentage, minThreshold, maxThreshold, numberOfFeatures, selectedIndividuals[0].getFitness(), configPath);
//        Individual[] test = ConfigurationUtil.readConfiguration(configLocation);
//        for (int i = 0; i < test.length; i++) {
//            System.out.println("Loaed individuals!!!-------------");
//            for (int j = 0; j < test[i].getFeatureList().size(); j++) {
//                System.out.println(test[i].getFeatureList().get(j));
//            }
////            System.out.println(test[i]);
//        }
//        System.out.println("Feature list------------------------------------------");
//        for (Feature feature : myPop.getFittest().getFeatureList()) {
//            System.out.println(feature);
//        }
//        System.out.println("------------------------------------------");
//        System.out.println(" Solution----- generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
//        for (int i = 0; i < myPop.getFittest().getFeatureList().size(); i++) {
//            System.out.println(myPop.getFittest().getFeatureList().get(i));
//        }
//        Individual[] topFittest = myPop.getTopFittest();
//        for (int i = 0; i < topFittest.length; i++) {
//            System.out.println(topFittest[i].getFitness());
//        }
        List<Feature> selectedFeatures = myPop.getFittest().getFeatureList();
        System.out.println("Selected features start -------------------");
        for (int i = 0; i < selectedFeatures.size(); i++) {
            System.out.println(selectedFeatures.get(i));
        }
        System.out.println(" --------------------------------");

        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
//        System.out.println("Genes:");
        System.out.println("Solution --- " + myPop.getFittest().getFitness());

//        PictureScanner pictureScannerSelectedRectangles = new PictureScanner(IOUtil.readImage(learningImage1), (ArrayList<Feature>) myPop.getFittest().getFeatureList());
//        ArrayList<FoundWindow> foundObjectsSelectedRectangles = pictureScannerSelectedRectangles.scannPicture(null, null, null, MIN_FEATURE_PERCENTAGE);
//        if (foundObjectsSelectedRectangles.isEmpty()) {
//            System.out.println("Failed test!");
////            throw new RuntimeException("Failed test!");
//        }
//        IOUtil.writeRectToImageWindows(IOUtil.readImage(learningImage1), foundObjectsSelectedRectangles, "selectedRectangles");
//
//        String testImageName = "0001_00000001.jpg";
////        String testImageName = "C2_011.jpg";
////        String testImageName = "eye_crop_1.jpg";
//        PictureScanner pictureScannerTestPicture = new PictureScanner(IOUtil.readImage(testImageName), (ArrayList<Feature>) myPop.getFittest().getFeatureList());
//        ArrayList<FoundWindow> foundObjectsTestPicture = pictureScannerTestPicture.scannPicture(null, null, null, MIN_FEATURE_PERCENTAGE);
//        System.out.println("Number of found objects " + foundObjectsTestPicture.size());
//
//        IOUtil.writeRectToImageWindows(IOUtil.readImage(testImageName), foundObjectsTestPicture, "testImageResults");
    }
}
