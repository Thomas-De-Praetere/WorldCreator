package com.thomas.de.praetere.worldcreator.map.transformer;

public enum Operations implements Operation {
    SUM((o, n) -> o + n),
    SUBTRACT((o, n) -> o - n),
    MAX(Math::max),
    MIN(Math::min),
    NULL((o, n) -> o),
    REPLACE((o, n) -> n);
    private final Operation function;

    Operations(Operation function) {
        this.function = function;
    }

    @Override
    public double apply(double originalValue, double newValue) {
        return function.apply(originalValue, newValue);
    }
}
