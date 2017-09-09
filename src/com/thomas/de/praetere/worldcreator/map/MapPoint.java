package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.geometry.Point;

import java.util.Optional;

/**
 * A {@link MapPoint} is a point with neighbours and other data that can be used in a map.
 */
public class MapPoint extends Point {
    private final Map map;

    /**
     * Creates a MapPoint with a given height and location.
     *
     * @param x      The x location.
     * @param y      The y location.
     * @param height The height.
     */
    public MapPoint(int x, int y, double height, Map map) {
        super(x, y, height);
        this.map = map;
    }

    /**
     * Creates a MapPoint with height 0.0 and location.
     *
     * @param x The x location.
     * @param y The y location.
     */
    public MapPoint(int x, int y, Map map) {
        this(x, y, 0.0, map);
    }

    /**
     * Returns a neighbour in a given direction.
     *
     * @param direction The direction.
     * @return A {@link MapPoint} if it exists.
     */
    public Optional<MapPoint> getNeighbour(Direction direction) {
        return map.getNeighbour(this, direction);
    }


    /**
     * Changes the height of the {@link MapPoint}.
     *
     * @param value The value with which it changes.
     */
    public void changeHeight(double value) {
        height += value;
    }

    @Override
    public double getDistance(Location loc) {
        double normalDist = super.getDistance(loc);
        Location largestX = (this.x > loc.getX()) ? this : loc;
        Location smallestX = (this.x > loc.getX()) ? loc : this;
        Location transposed = new Location(largestX.getX() - map.getMaxX(), largestX.getY());
        double otherDist = transposed.getDistance(smallestX);
        return Math.min(normalDist, otherDist);
    }

    @Override
    public double getDistance(int x, int y) {
        return getDistance(new Location(x, y));
    }
}
