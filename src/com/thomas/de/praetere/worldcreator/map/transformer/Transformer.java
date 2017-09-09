package com.thomas.de.praetere.worldcreator.map.transformer;

import com.thomas.de.praetere.worldcreator.map.MapPoint;

public interface Transformer {

    double transform(MapPoint point, Operation operation);
}
