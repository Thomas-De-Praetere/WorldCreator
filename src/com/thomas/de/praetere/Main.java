package com.thomas.de.praetere;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.elevation.RandomElevationCreatorCreator;
import com.thomas.de.praetere.worldcreator.map.printer.ToImagePrinter;
import com.thomas.de.praetere.worldcreator.map.transformer.Operations;

public class Main {

    public static void main(String[] args) {
        System.out.println("Application Start");
        Map map = new Map(2000, 2000);
        System.out.println("Map Created");

        RandomElevationCreatorCreator creator = new RandomElevationCreatorCreator(10, 500.0);
        creator.create(map).forEach(a -> map.register(a, Operations.MAX));

        creator = new RandomElevationCreatorCreator(50, 300);
        creator.create(map).forEach(a -> map.register(a, Operations.MAX));

        map.calculate();

        ToImagePrinter printer = new ToImagePrinter("C:\\Test", "test.png");
        printer.create(map);
    }
}
