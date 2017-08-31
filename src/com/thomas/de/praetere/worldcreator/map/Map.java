package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.math.Math;

public class Map {
    private final MapPoint[][] map;

    private final int maxX;
    private final int maxY;

    public Map(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        map = new MapPoint[maxX][maxY];
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                map[x][y] = new MapPoint(x, y);
                setNeighbours(map[x][y]);
            }
        }
    }

    private void setNeighbours(MapPoint mapPoint) {
        for (Direction direction : Direction.values()) {
            Location neighbourLocation = direction.getLocation(mapPoint);
            MapPoint neighbour = null;
            if (Math.between(0, maxY - 1, neighbourLocation.getY())) {
                neighbour = map[neighbourLocation.getX() % maxX][neighbourLocation.getY()];
            }
            mapPoint.setNeighbour(neighbour, direction);
            if (neighbour != null) {
                neighbour.setNeighbour(mapPoint, direction.getOpposite());
            }
        }
    }


}
