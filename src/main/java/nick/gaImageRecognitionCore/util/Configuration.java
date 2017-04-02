/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.util;

import nick.gaImageRecognitionCore.feature.*;
import nick.gaImageRecognitionCore.image.Rect;
import nick.gaImageRecognitionCore.individual.*;
import org.apache.commons.lang3.mutable.MutableInt;

/**
 *
 * @author Nick
 */
public class Configuration {

    private static final char SEPARATOR = ',';
    private static final String INDIVIDUAL_START = "000";
    private static final int windowWidth = 19;
    private static final int windowHeight = 19;

    private StringBuffer configurationBuffer = new StringBuffer();
    private String configurationString;

    private Individual[] individuals;
    private Individual[] parsedIndividuals;

    Configuration(Individual[] individuals) {
        this.individuals = individuals;
    }

    Configuration(String configurationString) {
        this.configurationString = configurationString;
    }

    public void parseConfigurationString() {
        if (configurationString == null) {
            throw new RuntimeException("Configuration string must be initialised before parsing configuration");
        }
        String[] strArr = configurationString.split(",");
        int numberOfIndividuals = Integer.parseInt(strArr[0]);
        //init parsed individuals
        parsedIndividuals = new Individual[numberOfIndividuals];

        //we are using mutable int so we could increment it in method getParsedValue()
        MutableInt dataRowCounter = new MutableInt(1);

        try {

            for (int i = 0; i < numberOfIndividuals; i++) {
                Individual parsedIndividual = null;
                //filling out individual
                String individualStart = getParsedValue(strArr, dataRowCounter);
                if (individualStart.equalsIgnoreCase(INDIVIDUAL_START)) {

                    //individual instatiation with type
                    parsedIndividual = initiateIndividual(Integer.parseInt(getParsedValue(strArr, dataRowCounter)));
                    parsedIndividual.setWindowWidth(Integer.parseInt(getParsedValue(strArr, dataRowCounter)));
                    parsedIndividual.setWindowHeight(Integer.parseInt(getParsedValue(strArr, dataRowCounter)));
                    parsedIndividual.setMinFeaturePercentage(Float.parseFloat(getParsedValue(strArr, dataRowCounter)));

                    int featureListSize = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                    for (int j = 0; j < featureListSize; j++) {

                        FeatureType featureType = FeatureType.typeAsEnum(Integer.parseInt(getParsedValue(strArr, dataRowCounter)));

                        int minX = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                        int minY = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                        int width = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                        int height = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                        Rect positionInPicture = new Rect(minX, minY, width, height);

                        float weight = Float.parseFloat(getParsedValue(strArr, dataRowCounter));
                        float minAllowedThreshhold = Float.parseFloat(getParsedValue(strArr, dataRowCounter));
                        float maxAllowedThreshhold = Float.parseFloat(getParsedValue(strArr, dataRowCounter));

                        Feature parsedFeature = initiateFeature(featureType, positionInPicture, minAllowedThreshhold, maxAllowedThreshhold, weight, strArr, dataRowCounter);
                        parsedIndividual.getFeatureList().add(parsedFeature);

                    }

                } else {
                    throw new RuntimeException("something is wrong with parsing at csv location + " + dataRowCounter.getValue());
                }
                parsedIndividuals[i] = parsedIndividual;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed parser at position: " + dataRowCounter);
        }

    }

    public void buildConfigurationString() {
        if (individuals == null) {
            throw new RuntimeException("Individuals must be initialised before building configuration");
        }
        //number of individuals
        append(individuals.length);

        for (Individual individual : individuals) {
            //individual specific part - separator is 000
            append(INDIVIDUAL_START);

            //individual type
            append(IndividualType.typeAsInt(individual.getIndividualType()));

            //window width
            append(windowWidth);

            //window height
            append(windowHeight);

            //min feature percentage
            append(individual.getMinFeaturePercentage());

            //feature list size
            append(individual.getFeatureList().size());

            for (Feature feature : individual.getFeatureList()) {
                addFeature(feature);
            }
        }

    }

    private void append(String append) {
        configurationBuffer.append(append);
        configurationBuffer.append(SEPARATOR);
    }

    private void append(int append) {
        configurationBuffer.append(append);
        configurationBuffer.append(SEPARATOR);
    }

    private void append(float append) {
        configurationBuffer.append(append);
        configurationBuffer.append(SEPARATOR);
    }

    private void addFeature(Feature feature) {
        //type of feature
        if (feature.getFeatureType() == null) {
            throw new RuntimeException("Feature type can not be null!");
        }
        configurationBuffer.append(FeatureType.typeAsInt(feature.getFeatureType()));
        configurationBuffer.append(SEPARATOR);

        //x postition
        if (feature.getPositionInPicture().getMinX() == null) {
            throw new RuntimeException("Feature x can not be null!");
        }
        configurationBuffer.append(feature.getPositionInPicture().getMinX());
        configurationBuffer.append(SEPARATOR);

        //y postition
        if (feature.getPositionInPicture().getMinY() == null) {
            throw new RuntimeException("Feature y can not be null!");
        }
        configurationBuffer.append(feature.getPositionInPicture().getMinY());
        configurationBuffer.append(SEPARATOR);

        //width postition
        if (feature.getPositionInPicture().getWidth() == null) {
            throw new RuntimeException("Feature width can not be null!");
        }
        configurationBuffer.append(feature.getPositionInPicture().getWidth());
        configurationBuffer.append(SEPARATOR);

        //height postition
        if (feature.getPositionInPicture().getHeight() == null) {
            throw new RuntimeException("Feature height can not be null!");
        }

        configurationBuffer.append(feature.getPositionInPicture().getHeight());
        configurationBuffer.append(SEPARATOR);
        //weight
        if (feature.getWeight() == null) {
            throw new RuntimeException("Feature weight can not be null!");
        }
        configurationBuffer.append(feature.getWeight());
        configurationBuffer.append(SEPARATOR);

        //min threshhold
        if (feature.getMinAllowedThreshold() == null) {
            throw new RuntimeException("Feature min allowed threshhold can not be null!");
        }
        configurationBuffer.append(feature.getMinAllowedThreshold());
        configurationBuffer.append(SEPARATOR);

        //max threshhold
        if (feature.getMaxAllowedthreshold() == null) {
            throw new RuntimeException("Feature max allowed threshhold can not be null!");
        }
        configurationBuffer.append(feature.getMaxAllowedthreshold());
        configurationBuffer.append(SEPARATOR);

        appendFeatureSpecific(feature);

    }

    public StringBuffer getConfigurationBuffer() {
        return configurationBuffer;
    }

    public Individual[] getParsedIndividuals() {
        return parsedIndividuals;
    }

    private String getParsedValue(String[] strArr, MutableInt dataRowCounter) {
        //get value and increment data row counter
        String value = strArr[dataRowCounter.getValue()];
        dataRowCounter.setValue(dataRowCounter.getValue() + 1);
        return value;
    }

    private Individual initiateIndividual(int parseInt) {
        IndividualType type = IndividualType.typeAsEnum(parseInt);
//        return IndividualUtil.getIndividualFromType(type);
        switch (type) {
            case FOUR_SIDE_INDIVIDUAL:
                return new IndividualFourSide();
            case LEFT_RIGHT_INDIVIDUAL:
                return new IndividualLeftRight();
            case TOP_BOTTOM_INDIVIDUAL:
                return new IndividualTopBottom();
            default:
                throw new RuntimeException("Unsupported individual type: " + type);
        }
    }


    private Feature initiateFeature(FeatureType featureType, Rect positionInPicture, float minAllowedThreshhold, float maxAllowedThreshhold, float weight, String[] strArr, MutableInt dataRowCounter) {
        switch (featureType) {
            case LEFT_RIGHT:
                //feature specific data 
                int leftSideWidth = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int rightSideWidth = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int height = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                
                return new FeatureLeftRigth(maxAllowedThreshhold, minAllowedThreshhold, weight, leftSideWidth, rightSideWidth, height, positionInPicture);
            case TOP_BOTTOM:
                int topSideHeight = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int bottomSideHeight = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int width = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                return new FeatureTopBottom(maxAllowedThreshhold, minAllowedThreshhold, weight, topSideHeight, bottomSideHeight, width, positionInPicture);
            case FOUR_SIDE:
                //feature specific data 
                int topSideHeightF = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int bottomSideHeightF = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int leftSideWidthF = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                int rightSideWidthF = Integer.parseInt(getParsedValue(strArr, dataRowCounter));
                return new FeatureFourSide(maxAllowedThreshhold, minAllowedThreshhold, weight, topSideHeightF, bottomSideHeightF, leftSideWidthF, rightSideWidthF, positionInPicture);
            default:
                throw new RuntimeException("Unsupported type of feature");
        }
    }

    private void appendFeatureSpecific(Feature feature) {
        switch (feature.getFeatureType()) {
            case LEFT_RIGHT:
                FeatureLeftRigth featureLeftRigth = (FeatureLeftRigth) feature;

                if (featureLeftRigth.getLeftSideWidth() == null || featureLeftRigth.getLeftSideWidth() == 0) {
                    throw new RuntimeException("Feature left width can not be null or 0!");
                }
                configurationBuffer.append(featureLeftRigth.getLeftSideWidth());
                configurationBuffer.append(SEPARATOR);

                if (featureLeftRigth.getRightSideWidth() == null || featureLeftRigth.getRightSideWidth() == 0) {
                    throw new RuntimeException("Feature right side width can not be null or 0!");
                }
                configurationBuffer.append(featureLeftRigth.getRightSideWidth());
                configurationBuffer.append(SEPARATOR);

                if (featureLeftRigth.getHeight() == null || featureLeftRigth.getHeight() == 0) {
                    throw new RuntimeException("Feature height can not be null or 0!");
                }
                configurationBuffer.append(featureLeftRigth.getHeight());
                configurationBuffer.append(SEPARATOR);
                break;
            case TOP_BOTTOM:
                FeatureTopBottom featureTopBottom = (FeatureTopBottom) feature;

                if (featureTopBottom.getTopSideHeight() == null || featureTopBottom.getTopSideHeight() == 0) {
                    throw new RuntimeException("Feature top side height can not be null or 0!");
                }
                configurationBuffer.append(featureTopBottom.getTopSideHeight());
                configurationBuffer.append(SEPARATOR);
                
                if (featureTopBottom.getBottomSideHeight() == null || featureTopBottom.getBottomSideHeight() == 0) {
                    throw new RuntimeException("Feature bottom side height can not be null or 0!");
                }
                configurationBuffer.append(featureTopBottom.getBottomSideHeight());
                configurationBuffer.append(SEPARATOR);
                
                if (featureTopBottom.getWidth()== null || featureTopBottom.getWidth() == 0) {
                    throw new RuntimeException("Feature width can not be null or 0!");
                }
                configurationBuffer.append(featureTopBottom.getWidth());
                configurationBuffer.append(SEPARATOR);
                break;
            case FOUR_SIDE:
                //top left
                FeatureFourSide featureFourSide = (FeatureFourSide) feature;
                if (featureFourSide.getTopSideHeight() == null || featureFourSide.getTopSideHeight() == 0) {
                    throw new RuntimeException("Feature top side height not be null or 0!");
                }
                configurationBuffer.append(featureFourSide.getTopSideHeight());
                configurationBuffer.append(SEPARATOR);

                if (featureFourSide.getBottomSideHeight() == null || featureFourSide.getBottomSideHeight() == 0) {
                    throw new RuntimeException("Feature bottom side height not be null or 0!");
                }
                configurationBuffer.append(featureFourSide.getBottomSideHeight());
                configurationBuffer.append(SEPARATOR);

                if (featureFourSide.getLeftSideWidth() == null || featureFourSide.getLeftSideWidth() == 0) {
                    throw new RuntimeException("Feature left side width not be null or 0!");
                }
                configurationBuffer.append(featureFourSide.getLeftSideWidth());
                configurationBuffer.append(SEPARATOR);

                if (featureFourSide.getRightSideWidth() == null || featureFourSide.getRightSideWidth() == 0) {
                    throw new RuntimeException("Feature right side width not be null or 0!");
                }
                configurationBuffer.append(featureFourSide.getRightSideWidth());
                configurationBuffer.append(SEPARATOR);
                break;
        default:
            throw new RuntimeException("Something is wrong! ");

        }
    }

}
