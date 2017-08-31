package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Point;

import java.util.EnumMap;
import java.util.Optional;

/**
 * A {@link MapPoint} is a point with neighbours and other data that can be used in a map.
 */
public class MapPoint extends Point {
    /**
     * The neighbours of a MapPoint.
     */
    private final EnumMap<Direction, MapPoint> neighbours;

    /**
     * Creates a MapPoint with a given height and location.
     *
     * @param x      The x location.
     * @param y      The y location.
     * @param height The height.
     */
    public MapPoint(int x, int y, double height) {
        super(x, y, height);
        neighbours = new EnumMap<>(Direction.class);
    }

    /**
     * Creates a MapPoint with height 0.0 and location.
     *
     * @param x The x location.
     * @param y The y location.
     */
    public MapPoint(int x, int y) {
        this(x, y, 0.0);
    }

    /**
     * Returns a neighbour in a given direction.
     *
     * @param direction The direction.
     * @return A {@link MapPoint} if it exists.
     */
    public Optional<MapPoint> getNeighbour(Direction direction) {
        return Optional.ofNullable(neighbours.get(direction));
    }

    /**
     * Sets a neighbour in a given direction.
     *
     * @param mapPoint  The new neighbour.
     * @param direction The direction in which it is.
     */
    public void setNeighbour(MapPoint mapPoint, Direction direction) {
        neighbours.put(direction, mapPoint);
    }

    /**
     * Changes the height of the {@link MapPoint}.
     *
     * @param value The value with which it changes.
     */
    public void changeHeight(double value) {
        height += value;
    }
}
