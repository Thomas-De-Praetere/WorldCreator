package com.thomas.de.praetere.worldcreator.map.util;

import java.util.Optional;

public class Tuple<K, T> {
    private final K k;
    private final T t;

    public Tuple(K k, T t) {
        this.k = k;
        this.t = t;
    }

    public Optional<K> getK() {
        return Optional.ofNullable(k);
    }

    public Optional<T> getT() {
        return Optional.ofNullable(t);
    }
}
