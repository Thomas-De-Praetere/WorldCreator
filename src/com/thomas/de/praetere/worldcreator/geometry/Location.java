package com.thomas.de.praetere.worldcreator.geometry;

/**
 * This class represents a 2D, integer location on a map.
 */
public class Location {
    /**
     * The x location.
     */
    protected final int x;
    /**
     * The y location.
     */
    protected final int y;

    /**
     * Create an integer location at the given x and y.
     *
     * @param x The x location.
     * @param y The y location.
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a location at (0,0)
     */
    public Location() {
        this(0, 0);
    }

    /**
     * @return The x location.
     */
    public int getX() {
        return x;
    }

    /**
     * @return The y location.
     */
    public int getY() {
        return y;
    }

    public double getDistance(Location loc) {
        return Math.sqrt((x - loc.x) * (x - loc.x) + (y - loc.y) * (y - loc.y));
    }

    public double getDistance(int x, int y) {
        return getDistance(new Location(x, y));
    }
}
