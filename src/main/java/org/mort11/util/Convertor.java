package org.mort11.util;

public class Convertor {
    private static double ticksPer100Mil;

    public static double convertFPSToEncoderTicksPer100Milliseconds(double fps) {
        ticksPer100Mil = (fps / (10 * Constants.ONE_TICK));
        System.out.println(ticksPer100Mil);
        return ticksPer100Mil;

    }

}
