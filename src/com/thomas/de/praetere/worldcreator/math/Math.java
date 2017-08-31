package com.thomas.de.praetere.worldcreator.math;

public class Math {
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
}
