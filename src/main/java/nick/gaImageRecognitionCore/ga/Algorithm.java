/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.ga;

import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.IndividualUtil;
import nick.gaImageRecognitionCore.util.TrainingRules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class Algorithm {

    private static final Logger LOGGER = Logger.getLogger(Algorithm.class.getName());
    
    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.8;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    private static final int ELITISM_OFFSET = 1;

    /* Public methods */
    // Evolve a population
    public static Population evolvePopulation(final Population pop, TrainingRules trainingRules) {
        Population newPopulation = new Population(pop.size(), false, trainingRules);

//        Individual[] chromosomes = new Individual[pop.getIndividuals().length];
//        ArrayList<Population> tournamentPopulation = new ArrayList<>();
//        System.arraycopy(pop.getIndividuals(), 0, chromosomes, 0, pop.getIndividuals().length);
        // Keep our best individual
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = ELITISM_OFFSET;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover

        //we will use threading for performance gain and faster evaluation proces
//        ExecutorService executor = Executors.newFixedThreadPool(pop.size());
//
//        for (int i = elitismOffset; i < pop.size(); i++) {
//            ArrayList<Individual> chromosomes = new ArrayList<>(Arrays.asList(pop.getIndividuals()));
//
//            ThreadGAEvolution thread = new ThreadGAEvolution(chromosomes, newPopulation, i);
//            executor.execute(thread);
//
//        }
//
//        try {
//            executor.shutdown();
//            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//            while (!executor.isTerminated()) {
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException("Thread pool is interrupted!");
//        }

        for (int i = elitismOffset; i < pop.size(); i++) {
            ArrayList<Individual> chromosomes = new ArrayList<>(Arrays.asList(pop.getIndividuals()));
            
            Individual indiv1 = tournamentSelection(chromosomes, trainingRules);
            
            Individual indiv2 = tournamentSelection(chromosomes, trainingRules);
//            while (indiv1.getFeatureList() == indiv2.getFeatureList()) {
//                LOGGER.log(Level.INFO, "Chromosomes size {0}", chromosomes.size());
//                try {
//                    indiv2 = tournamentSelection(chromosomes, trainingRules);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }

            Individual newIndiv = crossover(indiv1, indiv2, trainingRules);
            newPopulation.saveIndividual(i, newIndiv);
        }
        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    public static Individual crossover(Individual indiv1, Individual indiv2, TrainingRules trainingRules) {
        Individual newSol = IndividualUtil.createIndividual(trainingRules);
        
//        IndividualFourSide newSol = new IndividualFourSide();

        // Loop through genes
        for (int i = 0; i < indiv1.getFeatureList().size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.getFeatureList().add(indiv1.getFeatureList().get(i));
            } else {
                newSol.getFeatureList().add(indiv2.getFeatureList().get(i));
            }
        }

        return newSol;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.getFeatureList().size(); i++) {
            if (Math.random() <= mutationRate) {
                indiv.getFeatureList().set(i, indiv.mutate(indiv.getFeatureList().get(i)));

            }
        }
    }

    // Select individuals for crossover
    //original version 
//    private static Individual tournamentSelection(final Population pop) {
//        // Create a tournament population
//        Population tournament = new Population(tournamentSize, false);
//        // For each place in the tournament get a random individual
//        for (int i = 0; i < tournamentSize; i++) {
//            int randomId = (int) (Math.random() * pop.size());
//            tournament.saveIndividual(i, pop.getIndividual(randomId));
//        }
//        // Get the fittest
//        Individual fittest = tournament.getFittest();
//        return fittest;
//    }
    // Select individuals for crossover
    // modified version
    public static Individual tournamentSelection(final ArrayList<Individual> chromosomes, TrainingRules trainingRules) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false, trainingRules);
        Random rand = new Random();
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            if (chromosomes.isEmpty()) {
                LOGGER.log(Level.SEVERE, "Training rules: {0}", trainingRules);
                throw new RuntimeException("Chromozomes are empty!");
            }
            int randomId = rand.nextInt(chromosomes.size());
//            int randomId = (int) (Math.random() * chromosomes.size());
//            try {
            Individual selected = chromosomes.get(randomId);
            tournament.saveIndividual(i, selected);
//            } catch (Exception e) {
//                System.out.println("Fail;");
//                return null;
//            }

            chromosomes.remove(selected);
        }
        // Get the fittest
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}
