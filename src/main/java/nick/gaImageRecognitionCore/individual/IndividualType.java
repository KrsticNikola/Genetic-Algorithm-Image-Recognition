/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nick.gaImageRecognitionCore.individual;

/**
 *
 * @author Nick
 */
public enum IndividualType {
    LEFT_RIGHT_INDIVIDUAL, TOP_BOTTOM_INDIVIDUAL, FOUR_SIDE_INDIVIDUAL, MIDDLE_LEFT_RIGHT_INDIVIDUAL;

    public static int typeAsInt(IndividualType individualType) {
        switch (individualType) {
            case LEFT_RIGHT_INDIVIDUAL:
                return 0;
            case TOP_BOTTOM_INDIVIDUAL:
                return 1;
            case FOUR_SIDE_INDIVIDUAL:
                return 2;
            case MIDDLE_LEFT_RIGHT_INDIVIDUAL:
                return 3;
        }
        return -1;
    }

    public static IndividualType typeAsEnum(int individualType) {
        switch (individualType) {
            case 0:
                return IndividualType.LEFT_RIGHT_INDIVIDUAL;
            case 1:
                return IndividualType.TOP_BOTTOM_INDIVIDUAL;
            case 2:
                return IndividualType.FOUR_SIDE_INDIVIDUAL;
            case 3:
                return IndividualType.MIDDLE_LEFT_RIGHT_INDIVIDUAL;
        }
        return null;
    }
}
