/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.api;

import nick.gaImageRecognitionCore.ga.Population;
import nick.gaImageRecognitionCore.util.TrainingRules;

/**
 *
 * @author Nick
 */
public interface IApiTrainer {
    
    /**
     * Start training tread of @Trainer
     */
    public void startTraining();
    
    public void stopTraining();
    
    public Population getPopulation();
    
    public int getGenerationCount();
    
    public TrainingRules getTrainingRules();

    public int getPOPULATION_SIZE();
}
