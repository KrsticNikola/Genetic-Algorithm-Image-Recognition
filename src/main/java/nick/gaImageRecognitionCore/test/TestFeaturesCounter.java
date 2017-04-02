/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.test;

import nick.gaImageRecognitionCore.feature.Feature;
import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.util.ConfigurationUtil;

import java.util.HashSet;

/**
 *
 * @author Nick
 */
public class TestFeaturesCounter {

    public static void main(String[] args) {
        String testFolder = "src/main/resources/ForTesting/face/";
        String testFalsePositivesFolder = "src/main/resources/ForTesting/non-face/";
//        String testFolder = "src/resources/ForTesting/non-face/";

//        String configLocation = "src/main/resources/config/config_old4.txt";
        String configLocation = "src/main/resources/config/config.txt";
        Individual[] individualsFromConfig = ConfigurationUtil.readConfiguration(configLocation);
        
        HashSet<Feature> featureSet = new HashSet<>();
        
        
        for (Individual ind : individualsFromConfig) {
            System.out.println("Feature size: " + ind.getFeatureList().size());
            for (Feature feature : ind.getFeatureList()) {
                featureSet.add(feature);
            }
            break;
        }
        
        System.out.println("HashSet size: " + featureSet.size());


    }
}
