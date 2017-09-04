package com.thomas.de.praetere;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.printer.ToImagePrinter;
import com.thomas.de.praetere.worldcreator.map.random.RandomTransformer;
import com.thomas.de.praetere.worldcreator.map.transformer.Operations;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(1024, 1024);
        ToImagePrinter printer = new ToImagePrinter("C:\\Test", "test.jpg");
        RandomTransformer randomTransformer = new RandomTransformer(1000);
        randomTransformer.transform(map, Operations.REPLACE);
        printer.transform(map, Operations.NULL);
    }
}
