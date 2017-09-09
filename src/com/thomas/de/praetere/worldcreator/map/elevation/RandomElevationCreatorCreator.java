package com.thomas.de.praetere.worldcreator.map.elevation;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.transformer.Creator;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomElevationCreatorCreator implements Creator<List<Transformer>> {
    private final Random random;
    private final double maxHeight;
    private final int amount;

    public RandomElevationCreatorCreator(int amount, double maxHeight) {
        random = new Random();
        this.maxHeight = maxHeight;
        this.amount = amount;
    }

    @Override
    public List<Transformer> create(Map map) {
        System.out.println("Generating elevations.");
        List<Transformer> elevations = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            elevations.add(
                    new ElevationCreator(
                            random.nextInt(map.getMaxX()),
                            random.nextInt(map.getMaxY()),
                            random.nextDouble() * maxHeight
                    )
            );
        }
        System.out.println(String.format("Generated %d elevations.", elevations.size()));
        return elevations;
    }
}
