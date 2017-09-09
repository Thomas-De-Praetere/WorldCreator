package com.thomas.de.praetere.worldcreator.map.function;

public interface Function {
    double apply(double x);

    default Function max(Function e) {
        return d -> Math.max(this.apply(d), e.apply(d));
    }

    default Function min(Function e) {
        return d -> Math.min(this.apply(d), e.apply(d));
    }
}
