/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionGui.configuration;

/**
 *
 * @author Nick
 */
public class RuntimeConfiguration {

    private static RuntimeConfiguration RuntimeConfiguration;

    private String trainingFolderPath;
    private String trainingFalseImagesFolderPath;
    
    private String testImagesFolderLocation;
    private String testFalseImagesFolderLocation;
    private String testConfigurationsFolderLocation;

    private RuntimeConfiguration() {
    }

    public static RuntimeConfiguration getInstance() {
        if (RuntimeConfiguration == null) {
            RuntimeConfiguration = new RuntimeConfiguration();
        }
        return RuntimeConfiguration;
    }

    public String getTrainingFolderPath() {
        return trainingFolderPath;
    }

    public void setTrainingFolderPath(String trainingFolderPath) {
        this.trainingFolderPath = trainingFolderPath;
    }

    public String getTrainingFalseImagesFolderPath() {
        return trainingFalseImagesFolderPath;
    }

    public void setTrainingFalseImagesFolderPath(String trainingFalseImagesFolderPath) {
        this.trainingFalseImagesFolderPath = trainingFalseImagesFolderPath;
    }

    public String getTestImagesFolderLocation() {
        return testImagesFolderLocation;
    }

    public void setTestImagesFolderLocation(String testImagesFolderLocation) {
        this.testImagesFolderLocation = testImagesFolderLocation;
    }

    public String getTestFalseImagesFolderLocation() {
        return testFalseImagesFolderLocation;
    }

    public void setTestFalseImagesFolderLocation(String testFalseImagesFolderLocation) {
        this.testFalseImagesFolderLocation = testFalseImagesFolderLocation;
    }

    public String getTestConfigurationsFolderLocation() {
        return testConfigurationsFolderLocation;
    }

    public void setTestConfigurationsFolderLocation(String testConfigurationsFolderLocation) {
        this.testConfigurationsFolderLocation = testConfigurationsFolderLocation;
    }


}
