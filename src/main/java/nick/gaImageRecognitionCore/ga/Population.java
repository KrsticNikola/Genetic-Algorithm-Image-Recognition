/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.ga;

import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.IndividualUtil;
import nick.gaImageRecognitionCore.util.TrainingRules;
import org.apache.commons.lang3.ObjectUtils;

/**
 *
 * @author Nick
 */
public final class Population {

    private final Individual[] individuals;

    private final int FITTEST_SIZE = 5;
    
    private TrainingRules trainingRules;

    /*
     * Constructors
     */
    // Create a population
//    public Population(Individual[] individuals) {
//        this.individuals = individuals;
//    }
    /*
     * Constructors
     */

    // Create a population

    public Population(int populationSize, boolean initialise, TrainingRules trainingRules) {
        individuals = new Individual[populationSize];
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = IndividualUtil.createIndividual(trainingRules);
                newIndividual.generateIndividualAction();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness().getFitnessValue() <= getIndividual(i).getFitness().getFitnessValue()) {
                fittest = getIndividual(i);
            }
        }
        return ObjectUtils.clone(fittest);
    }

    public Individual[] getTopFittest() {
//        Individual fittest = new IndividualFourSide();
//        Individual fittest = individuals[0];
//        fittest.setFitness(new Fitness(0, 0, 0));
        // Loop through individuals to find fittest
        Individual[] fittestArray = new Individual[FITTEST_SIZE];
        int counter = 0;
//        int[] selectedIntArray = new int[FITTEST_SIZE];

        while (counter < FITTEST_SIZE) {
            Individual fittest = individuals[0];
            // Loop through individuals to find fittest
            for (int i = 0; i < size(); i++) {
                if (fittest.getFitness().getFitnessValue() <= getIndividual(i).getFitness().getFitnessValue()) {

                    boolean elementExists = false;
                    for (int j = 0; j < counter; j++) {
                        if (fittestArray[j].equals(fittest)) {
                            elementExists = true;
                        }
                    }
                    if (!elementExists) {
                        fittest = getIndividual(i);
                    }

                }
            }
            fittestArray[counter] = fittest;
            counter++;
        }

        return fittestArray;
    }

    /* Public methods */
    // Get population size
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

}
