package com.thomas.de.praetere.worldcreator.map;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.transformer.Operation;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;
import com.thomas.de.praetere.worldcreator.map.util.MathUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Map implements Iterable<MapPoint> {
    private final MapPoint[][] map;

    private final int maxX;
    private final int maxY;

    private final List<TransformerOperation> transformers;

    public Map(int maxX, int maxY) {
        this.transformers = new ArrayList<>();
        this.maxX = maxX;
        this.maxY = maxY;
        map = new MapPoint[maxX][maxY];
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                map[x][y] = new MapPoint(x, y, this);
            }
        }
    }

    public void register(Transformer transformer, Operation operation) {
        transformers.add(new TransformerOperation(transformer, operation));
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Optional<MapPoint> getPoint(Location location) {
        return getPoint(location.getX(), location.getY());
    }

    public Optional<MapPoint> getPoint(int x, int y) {
        if (MathUtil.between(0, maxY - 1, y)) {
            return Optional.of(map[Math.floorMod(x, maxX)][y]);
        } else {
            return Optional.empty();
        }
    }

    public Optional<MapPoint> getNeighbour(MapPoint point, Direction direction) {
        return getPoint(direction.getLocation(point));
    }

    public void calculate() {
        int i = 0;
        int k = 1;
        int max = maxX * maxY;
        for (MapPoint mapPoint : this) {
            for (TransformerOperation transformer : transformers) {
                double newHeight = transformer.transformer.transform(mapPoint, transformer.operation);
                mapPoint.setHeight(newHeight);
            }
            i++;
            if (i == k) {
                k += maxX;
                System.out.println(String.format("Calculation %f%%.", 100*(double) i / (double) max));
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

    private static class TransformerOperation {
        private final Transformer transformer;
        private final Operation operation;

        public Transformer getTransformer() {
            return transformer;
        }

        public Operation getOperation() {
            return operation;
        }

        public TransformerOperation(Transformer transformer, Operation operation) {

            this.transformer = transformer;
            this.operation = operation;
        }
    }
}
