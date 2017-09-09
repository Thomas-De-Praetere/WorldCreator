package com.thomas.de.praetere.worldcreator.map.transformer;

import com.thomas.de.praetere.worldcreator.map.Map;

/**
 * This is a transformer class that guarantees not to change the given network. This is useful for printers etc.
 */
public interface Creator<T> {
    /**
     * Uses the information in the map for something, but it does not change the map.
     *
     * @param map The given {@link Map}.
     */
    T create(Map map);
}
