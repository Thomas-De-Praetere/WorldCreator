package com.thomas.de.praetere.worldcreator.map.function;

public class Functions {
    public static Function getHill(double width, double height) {
        return x -> height * Math.pow(Math.E, -((x * x) / (width * width)));
    }

    public static Function getMountain(double width, double height) {
        return x -> height - height * Math.abs(x) / width;
    }

    public static Function getLinear(double start, double decreasePerDistanceUnit) {
        return d -> start - d * decreasePerDistanceUnit;
    }

    public static Function getQuadratic(double start, double decreasePerDistanceUnit) {
        return d -> start - d * d * decreasePerDistanceUnit;
    }
}
