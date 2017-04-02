package nick.gaImageRecognitionCore.trainer;

import nick.gaImageRecognitionCore.ga.Algorithm;
import nick.gaImageRecognitionCore.ga.Fitness;
import nick.gaImageRecognitionCore.ga.FitnessCalculation;
import nick.gaImageRecognitionCore.ga.Population;
import nick.gaImageRecognitionCore.image.IntegralImage;
import nick.gaImageRecognitionCore.util.TrainingRules;

import java.awt.image.BufferedImage;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trainer implements Runnable {
    
    private static final Logger LOGGER = Logger.getLogger(Trainer.class.getName());
    
    private Population population;
    
    int generationCount = 0;

    // initial population
    private final int POPULATION_SIZE;
    private final int MAX_NUMBER_OF_ITERATIONS;
    
    private final TrainingRules trainingRules;

    // we will set lowest minimal value for start
    private float fittestValue = -1000;
    private boolean stopTraining = false;

    /**
     * This is auto-configuration constructor, it will automatically ajust
     * minThrashold, maxThrashold and medianPercentagethresshold values
     *
     * @param POPULATION_SIZE
     * @param MAX_NUMBER_OF_ITERATIONS
     * @param trainingImages
     * @param falseTrainingImages
     * @param trainingRules
     */
    public Trainer(int POPULATION_SIZE, int MAX_NUMBER_OF_ITERATIONS,
            List<BufferedImage> trainingImages, List<BufferedImage> falseTrainingImages, TrainingRules trainingRules) {
        this.POPULATION_SIZE = POPULATION_SIZE;
        this.MAX_NUMBER_OF_ITERATIONS = MAX_NUMBER_OF_ITERATIONS;
        this.trainingRules = trainingRules;
        
        List<IntegralImage> trainingIntegralImages = new ArrayList<>();
        List<IntegralImage> falseIntegralImages = new ArrayList<>();
        
        for (BufferedImage image : trainingImages) {
            trainingIntegralImages.add(new IntegralImage(image));
        }
        for (BufferedImage image : falseTrainingImages) {
            falseIntegralImages.add(new IntegralImage(image));
        }

        //this needs to be set as it is singleton used in individuals during training
        FitnessCalculation.getInstance().setTrainingIntegralImages(trainingIntegralImages);
        FitnessCalculation.getInstance().setFalseIntegralImages(falseIntegralImages);
        
    }
    
    @Override
    public void run() {
        // Create an initial population
        population = new Population(POPULATION_SIZE, true, trainingRules);

        // Evolve our population counter
        generationCount = 0;
        
        System.out.println("Training started..");
        LOGGER.log(Level.INFO, "Training riles: {0}", trainingRules);
        while (!stopTraining) {
            generationCount++;
            // counter++;
            population = Algorithm.evolvePopulation(population, trainingRules);
            Fitness bestFitness = population.getFittest().getFitness();
            
            float fitnessValue = bestFitness.getFitnessValue();
            
            if (fittestValue < fitnessValue) {
                fittestValue = fitnessValue;
                
                String logMessage = MessageFormat.format("Generation: {0} Fittest: {1}", generationCount, bestFitness);
                LOGGER.log(Level.INFO, logMessage);
            }
            if (generationCount == MAX_NUMBER_OF_ITERATIONS) {
                break;
            }
//            if (generationCount % 50 == 0) {
//                List<Feature> featureList = population.getFittest().getFeatureList();
//                for (int i = 0; i < featureList.size(); i++) {
//                    LOGGER.log(Level.INFO, "Feature element: {0} ", featureList.get(i));
//                }
//            }
            
//            if (generationCount % 10 == 0) {
//                
//                String logMessage = MessageFormat.format("Generation count: {0} ", generationCount);
//                LOGGER.log(Level.INFO, logMessage);
//            }
//            if (generationCount % 10 == 0) {
//                String logMessage = MessageFormat.format("Generation: {0} Fittest: {1}", generationCount, bestFitness);
//                LOGGER.log(Level.INFO, logMessage);
//                LOGGER.log(Level.INFO, "Fittest value: " + fittestValue);
////                String logMessage = MessageFormat.format("Generation count: {0} ", generationCount);
////                LOGGER.log(Level.INFO, logMessage);
//            }
            
            if (trainingRules.isAutoIncrement() && generationCount % trainingRules.getAutoIncrementGenerationCounter() == 0) {
                trainingRules.autoIncrement();
                LOGGER.log(Level.INFO, "min thrashhold is now:{0}", trainingRules.getMIN_TRASHHOLD());
                LOGGER.log(Level.INFO, "Max thrashhold is now:{0}", trainingRules.getMAX_TRASHHOLD());
            }
            
        }
        LOGGER.log(Level.INFO, "Training stoped");
        stopTraining = false;
        
    }
    
    public void stopTraining() {
        stopTraining = true;
    }
    
    public Population getPopulation() {
        return population;
    }
    
    public int getGenerationCount() {
        return generationCount;
    }
    
    public TrainingRules getTrainingRules() {
        return trainingRules;
    }

    public int getPOPULATION_SIZE() {
        return POPULATION_SIZE;
    }
    
}
