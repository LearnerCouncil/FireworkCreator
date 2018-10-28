package de.simagdo.fireworkcreator.utils;

public class Utils {

    /**
     * Check if the currentValue is between the minValue and the maxValue
     *
     * @param currentValue which will be checked if between
     * @param minValue     of the check
     * @param maxValue     of the check
     * @return if the position is between the points
     */
    public static boolean between(int currentValue, int minValue, int maxValue) {
        return (currentValue >= minValue && currentValue <= maxValue);
    }

}
