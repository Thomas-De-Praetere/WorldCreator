package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Location;

/**
 * This class represents a location of a neighbour of a {@link MapPoint}.
 */
public enum Direction {
    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Direction getOpposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
        }
        return this;
    }

    public Location getLocation(Location location) {
        return new Location(location.getX() + x, location.getY() + y);
    }
}
