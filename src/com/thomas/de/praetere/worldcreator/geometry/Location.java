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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != location.x) return false;
        return y == location.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
