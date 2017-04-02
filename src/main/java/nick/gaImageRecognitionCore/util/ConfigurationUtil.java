/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.ga.Fitness;
import nick.gaImageRecognitionCore.individual.Individual;
import nick.gaImageRecognitionCore.individual.IndividualType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class ConfigurationUtil {

    static final FilenameFilter TXT_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".txt");
        }
    };

    static final FilenameFilter TCONF_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".tconf");
        }
    };

    public static String saveConfiguration(Individual[] individuals, String pathFolder) {
        Configuration conf = new Configuration(individuals);
        conf.buildConfigurationString();
        try {
//            File outputFile = new File(path);
            File outputFile = null;
//            int counter = 0;
//            String p = path;
            String fileNameAsTimestamp = "config" + new SimpleDateFormat("yyyyMMddhhmmSSS").format(new Date());
//            while (outputFile.exists() && !outputFile.isDirectory()) {

            String path = pathFolder + fileNameAsTimestamp + ".tconf";
            outputFile = new File(path);
//            counter++;

//            }
            FileUtils.writeStringToFile(outputFile, conf.getConfigurationBuffer().toString());
            System.out.println("Configuration successful saved at location: " + path);
            return path;
//            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
//            Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Individual[] readConfiguration(String path) {
        String configuration = null;
        try {
            configuration = FileUtils.readFileToString(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        Configuration conf = new Configuration(configuration);
        conf.parseConfigurationString();

        Individual[] individualsFromConfig = conf.getParsedIndividuals();
        if (StringUtils.isBlank(configuration) || individualsFromConfig == null) {
            throw new RuntimeException("Configuration file bad format;");
        }
        System.out.println("Configuration at location: " + path + " successful loaded");
        return individualsFromConfig;
    }

    /**
     * Read saved .tconf from folder
     *
     * @param path path to folder with .tconf files
     * @return
     */
    public static Individual[] readConfigurationsFromFolder(String path) {

        final File dir = new File(path);
        List<Individual[]> individuals = new ArrayList<>();
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(TCONF_FILTER)) {
                individuals.add(readConfiguration(f.getAbsolutePath()));
            }
        } else {
            throw new RuntimeException("Configuration folder not found for location: " + path);
        }

        if (individuals.isEmpty()) {
            throw new RuntimeException("Loaded individuals from configuration can not be empty..");
        }

        int numberOfIndividuals = 0;
        for (Individual[] individual : individuals) {
            numberOfIndividuals += individual.length;
        }

        Individual[] individualsJoined = null;
//        individualsJoined[0] = individuals.get(0);

        for (Individual[] individual : individuals) {
            individualsJoined = ArrayUtils.addAll(individualsJoined, individual);
        }

        return individualsJoined;
    }

    /**
     * This method will save traning params used in training proces
     *
     * @param populationSize
     * @param individualType
     * @param MIN_FEATURE_PERCENTAGE
     * @param THRASHHOLD_MEDIAN_PERCENTAGE
     * @param MIN_TRASHHOLD
     * @param MAX_TRASHHOLD
     * @param NUMBER_OF_FEATURES
     * @param fitness
     * @param samples
     * @param falseSamples
     * @param configPath
     */
    public static void saveTrainingParams(int populationSize, IndividualType individualType, float MIN_FEATURE_PERCENTAGE, float THRASHHOLD_MEDIAN_PERCENTAGE, int MIN_TRASHHOLD, int MAX_TRASHHOLD, int NUMBER_OF_FEATURES, Fitness fitness, String configPath) {
        String path = configPath.replace(".tconf", "-info.txt");
//        String path = configPath.replace("config/config", "config/configParam");
        File outputFile = new File(path);
        StringBuilder params = new StringBuilder().append("populationSize: ")
                .append(populationSize)
                .append(System.getProperty("line.separator"))
                .append("; IndividualType: ")
                .append(individualType)
                .append(System.getProperty("line.separator"))
                .append("; MIN_FEATURE_PERCENTAGE: ")
                .append(MIN_FEATURE_PERCENTAGE)
                .append(System.getProperty("line.separator"))
                .append("; THRASHHOLD_MEDIAN_PERCENTAGE: ")
                .append(THRASHHOLD_MEDIAN_PERCENTAGE)
                .append(System.getProperty("line.separator"))
                .append("; MIN_TRASHHOLD: ")
                .append(MIN_TRASHHOLD)
                .append(System.getProperty("line.separator"))
                .append("; MAX_TRASHHOLD: ")
                .append(MAX_TRASHHOLD)
                .append(System.getProperty("line.separator"))
                .append("; MAX_NUMBER_OF_FEATURES: ")
                .append(NUMBER_OF_FEATURES)
                .append(System.getProperty("line.separator"))
                .append(";  ")
                .append(fitness)
                .append(";  ")
                .append("; accuracy: ")
                .append(fitness.getAccuracy())
                .append(";  ")
                .append(System.getProperty("line.separator"))
                .append("; Size of positive samples: ")
                .append(fitness.getSizeOfPostitives())
                .append(System.getProperty("line.separator"))
                .append("; Size of non positive samples: ")
                .append(fitness.getSizeOfFailedPositives())
                .append(System.getProperty("line.separator"))
                .append("; Number of positives found: ")
                .append(fitness.getNumberOfPostitives())
                .append(System.getProperty("line.separator"))
                .append("; Number of false positives found: ")
                .append(fitness.getNumberOfFailedPositives());
        try {
            FileUtils.writeStringToFile(outputFile, params.toString());
            System.out.println("Config paramse saved at location: " + path);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(ConfigurationUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addSeparator(StringBuilder conf) {
        conf.append(",");
    }
}
