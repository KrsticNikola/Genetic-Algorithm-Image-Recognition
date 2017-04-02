/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.feature;

/**
 *
 * @author Nick
 */
public enum FeatureType {

    LEFT_RIGHT, TOP_BOTTOM, FOUR_SIDE, MIDDLE_LEFT_RIGHT;

    public static int typeAsInt(FeatureType featureType) {
        switch (featureType) {
            case LEFT_RIGHT:
                return 0;
            case TOP_BOTTOM:
                return 1;
            case FOUR_SIDE:
                return 2;
            case MIDDLE_LEFT_RIGHT:
                return 3;
        }
        return -1;
    }

    public static FeatureType typeAsEnum(int featureType) {
        switch (featureType) {
            case 0:
                return FeatureType.LEFT_RIGHT;
            case 1:
                return FeatureType.TOP_BOTTOM;
            case 2:
                return FeatureType.FOUR_SIDE;
            case 3:
                return FeatureType.MIDDLE_LEFT_RIGHT;
        }
        return null;
    }

}
