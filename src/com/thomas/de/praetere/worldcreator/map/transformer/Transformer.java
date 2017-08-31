package com.thomas.de.praetere.worldcreator.map.transformer;

import com.thomas.de.praetere.worldcreator.map.Map;

public interface Transformer {
    /**
     * Transforms a map and uses the operation to determine how the values will be changed.
     *
     * @param map       The map to change.
     * @param operation The way to apply the changes.
     */
    void transform(Map map, Operations operation);
}
