package com.thomas.de.praetere.worldcreator.map.util;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Calculator;

public class Heighest implements Calculator<MapPoint> {
    private final Map map;

    public Heighest(Map map) {
        this.map = map;
    }

    @Override
    public MapPoint calculate() {
        double maxHeight = Double.NEGATIVE_INFINITY;
        MapPoint highest = null;
        for (MapPoint mapPoint : map) {
            if (mapPoint.getHeight() > maxHeight) {
                highest = mapPoint;
                maxHeight = mapPoint.getHeight();
            }
        }
        return highest;
    }
}




