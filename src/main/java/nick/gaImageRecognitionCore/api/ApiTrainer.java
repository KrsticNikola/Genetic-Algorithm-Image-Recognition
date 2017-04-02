/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.api;

import nick.gaImageRecognitionCore.ga.Population;
import nick.gaImageRecognitionCore.trainer.Trainer;
import nick.gaImageRecognitionCore.util.TrainingRules;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Nick
 */
public class ApiTrainer implements IApiTrainer {

    private final Trainer trainer;

    public ApiTrainer(int POPULATION_SIZE, int MAX_NUMBER_OF_ITERATIONS,
            List<BufferedImage> trainingImages, List<BufferedImage> falseTrainingImages, TrainingRules trainingRules) {
        trainer = new Trainer(POPULATION_SIZE, MAX_NUMBER_OF_ITERATIONS, trainingImages, falseTrainingImages, trainingRules);
    }

    @Override
    public void startTraining() {
        new Thread(trainer).start();
    }

    @Override
    public void stopTraining() {
        trainer.stopTraining();
    }

    @Override
    public Population getPopulation() {
        return trainer.getPopulation();
    }

    @Override
    public int getGenerationCount() {
        return trainer.getGenerationCount();
    }

    @Override
    public TrainingRules getTrainingRules() {
        return trainer.getTrainingRules();
    }

    @Override
    public int getPOPULATION_SIZE() {
        return trainer.getPOPULATION_SIZE();
    }

}
