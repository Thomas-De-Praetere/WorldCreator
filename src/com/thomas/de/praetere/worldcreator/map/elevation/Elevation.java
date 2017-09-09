package com.thomas.de.praetere.worldcreator.map.elevation;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.function.Function;

public class Elevation implements Function {
    private final Location location;
    private final double height;
    private Function elevationFunction;

    public Elevation(Location location, double height) {
        this.location = location;
        this.height = height;
        Hill hill = new Hill(location, height);
        Mountain mountain = new Mountain(location, height);
        elevationFunction = (height <= Hill.HILL_CUT_OFF) ? hill : mountain.max(new Hill(location, Hill.HILL_CUT_OFF));
    }

    public Location getLocation() {
        return location;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double apply(double distance) {
        return elevationFunction.apply(distance);
    }
}
