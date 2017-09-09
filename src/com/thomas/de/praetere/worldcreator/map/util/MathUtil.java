package com.thomas.de.praetere.worldcreator.map.util;

public class MathUtil {
    public static double EPSILON = 10E-2;

    /**
     * Calculates whether the value x is between the lower and the upper bound.
     *
     * @param l The lower bound.
     * @param u The upper bound.
     * @param x The value to check.
     * @return True if l < x < u.
     */
    public static boolean betweenStrict(int l, int u, int x) {
        return l < x && x < u;
    }

    /**
     * Calculates whether the value x is between the lower and upper bound including the bounds.
     *
     * @param l The lower bound.
     * @param u The upper bound.
     * @param x The value to check.
     * @return True if l <= x <= u.
     */
    public static boolean between(int l, int u, int x) {
        return betweenStrict(l, u, x) || x == l || x == u;
    }

    /**
     * Converts a double between 0.0 and 1.0 to an int between 0 and 256 (exclusive).
     *
     * @return An integer between 0 and 256 (exclusive).
     */
    public static int makeBetween256(double aDouble) {
        long round = Math.round(aDouble * 255);
        return (int) round;
    }

    public static boolean isZero(double d) {
        return d < EPSILON && d > -EPSILON;
    }
}
