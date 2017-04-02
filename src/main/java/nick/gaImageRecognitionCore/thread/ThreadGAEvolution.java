/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.thread;

import nick.gaImageRecognitionCore.ga.Population;
import nick.gaImageRecognitionCore.individual.Individual;

import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class ThreadGAEvolution implements Runnable {

    final ArrayList<Individual> chromosomes;
    final Population newPopulation;
    final int position;

    public ThreadGAEvolution(ArrayList<Individual> chromosomes, Population newPopulation, int position) {
        this.chromosomes = chromosomes;
        this.newPopulation = newPopulation;
        this.position = position;
    }

    @Override
    public void run() {
//        Individual indiv1 = ALGORITHM.TOURNAMENTSELECTION(CHROMOSOMES);
//        INDIVIDUAL INDIV2 = ALGORITHM.TOURNAMENTSELECTION(CHROMOSOMES);
//        WHILE (INDIV1.GETFEATURELIST() == INDIV2.GETFEATURELIST()) {
//            TRY {
//                INDIV2 = ALGORITHM.TOURNAMENTSELECTION(CHROMOSOMES);
//            } CATCH (EXCEPTION E) {
//                SYSTEM.OUT.PRINTLN("TOURNAMENT SELECTED VALUES ARE SAME!!");
//            }
//
//        }
//
//        INDIVIDUAL NEWINDIV = ALGORITHM.CROSSOVER(INDIV1, INDIV2);
//        NEWPOPULATION.SAVEINDIVIDUAL(POSITION, NEWINDIV);
    }

}
