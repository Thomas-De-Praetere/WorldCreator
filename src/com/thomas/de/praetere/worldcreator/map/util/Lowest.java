package com.thomas.de.praetere.worldcreator.map.util;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Calculator;

public class Lowest implements Calculator<MapPoint> {
    private final Map map;

    public Lowest(Map map) {
        this.map = map;
    }

    @Override
    public MapPoint calculate() {
        double minHeight = Double.POSITIVE_INFINITY;
        MapPoint lowest = null;
        for (MapPoint mapPoint : map) {
            if (mapPoint.getHeight() < minHeight) {
                lowest = mapPoint;
                minHeight = mapPoint.getHeight();
            }
        }
        return lowest;
    }
}
