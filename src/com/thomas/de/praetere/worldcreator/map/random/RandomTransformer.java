package com.thomas.de.praetere.worldcreator.map.random;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Operations;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;

import java.util.Random;

public class RandomTransformer implements Transformer {
    private final Random random;
    private final double maxHeight;

    public RandomTransformer(double maxHeight) {
        random = new Random();
        this.maxHeight = maxHeight;
    }

    public RandomTransformer(double maxHeight, int seed) {
        random = new Random(seed);
        this.maxHeight = maxHeight;
    }

    @Override
    public void transform(Map map, Operations operation) {
        for (MapPoint mapPoint : map) {
            mapPoint.operateOnHeight(random.nextDouble() * maxHeight, operation);
        }
    }
}
