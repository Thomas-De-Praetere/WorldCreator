package com.thomas.de.praetere.worldcreator.map.elevation;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.function.Function;
import com.thomas.de.praetere.worldcreator.map.function.Functions;

public class Hill implements Function {

    public static double HILL_CUT_OFF = 300;

    private final Function hillFunction;
    private final double height;
    private final Location location;

    public Hill(Location location, double height) {
        this.height = height;
        this.location = location;
        hillFunction = Functions.getHill(height, height);
    }

    public double getHeight() {
        return height;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public double apply(double distance) {
        return hillFunction.apply(distance);
    }
}
