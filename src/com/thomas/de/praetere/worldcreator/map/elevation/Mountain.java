package com.thomas.de.praetere.worldcreator.map.elevation;

import com.thomas.de.praetere.worldcreator.geometry.Location;
import com.thomas.de.praetere.worldcreator.map.function.Function;
import com.thomas.de.praetere.worldcreator.map.function.Functions;

public class Mountain implements Function {
    private final Function mountainFunction;
    private final double height;
    private final Location location;

    public Mountain(Location location, double height) {
        this.height = height;
        this.location = location;
        mountainFunction = Functions.getMountain(height, height);
    }

    public double getHeight() {
        return height;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public double apply(double distance) {
        return mountainFunction.apply(distance);
    }
}
