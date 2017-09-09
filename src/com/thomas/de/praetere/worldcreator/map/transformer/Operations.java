package com.thomas.de.praetere.worldcreator.map.transformer;

public class Operations {
    public static Operation SUM = (o, n) -> o + n;

    public static Operation SUBTRACT = (o, n) -> o - n;

    public static Operation MAX = Math::max;

    public static Operation MIN = Math::min;

    public static Operation NULL = (o, n) -> o;

    public static Operation REPLACE = (o, n) -> n;
    public static Operation MEAN = (o, n) -> (o + n) / 2.0;
}
