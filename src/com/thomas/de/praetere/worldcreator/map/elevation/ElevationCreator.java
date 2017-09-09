package com.thomas.de.praetere.worldcreator.map.elevation;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Operation;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;

public class ElevationCreator implements Transformer {
    private final Elevation elevation;

    public ElevationCreator(int x, int y, double height) {
        elevation = new Elevation(new Location(x, y), height);
    }

    @Override
    public double transform(MapPoint map, Operation operation) {
        return operation.apply(map.getHeight(), elevation.apply(map.getDistance(elevation.getLocation())));
    }
}
