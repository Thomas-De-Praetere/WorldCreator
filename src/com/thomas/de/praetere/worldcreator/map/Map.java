package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.util.MathUtil;

import java.util.Iterator;
import java.util.Optional;

public class Map implements Iterable<MapPoint> {
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

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Optional<MapPoint> getPoint(int x, int y) {
        if (MathUtil.between(0, maxX - 1, x) && MathUtil.between(0, maxY, y)) {
            return Optional.of(map[x][y]);
        } else {
            return Optional.empty();
        }
    }

    private void setNeighbours(MapPoint mapPoint) {
        for (Direction direction : Direction.values()) {
            Location neighbourLocation = direction.getLocation(mapPoint);
            MapPoint neighbour = null;
            if (MathUtil.between(0, maxY - 1, neighbourLocation.getY())) {
                neighbour = map[Math.floorMod(neighbourLocation.getX(), maxX)][neighbourLocation.getY()];
            }
            mapPoint.setNeighbour(neighbour, direction);
            if (neighbour != null) {
                neighbour.setNeighbour(mapPoint, direction.getOpposite());
            }
        }
    }


    @Override
    public Iterator<MapPoint> iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator<MapPoint> {

        private int i;
        private int j;

        public MapIterator() {
            i = 0;
            j = 0;
        }

        @Override
        public boolean hasNext() {
            return j < maxY;
        }

        @Override
        public MapPoint next() {
            MapPoint mapPoint = map[i][j];
            i++;
            if (i >= maxX) {
                i = 0;
                j++;
            }
            return mapPoint;
        }
    }
}
