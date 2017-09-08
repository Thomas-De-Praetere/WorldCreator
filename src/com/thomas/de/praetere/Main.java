package com.thomas.de.praetere;

import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.mountain.Mountain;
import com.thomas.de.praetere.worldcreator.map.printer.ToImagePrinter;
import com.thomas.de.praetere.worldcreator.map.transformer.Operations;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(1024, 1024);
        ToImagePrinter printer = new ToImagePrinter("C:\\Test", "test.jpg");
        Transformer transformer = new Mountain(512, 512, 200);
        transformer.transform(map, Operations.MAX);
        transformer = new Mountain(512, 300, 200);
        transformer.transform(map, Operations.MAX);
        transformer = new Mountain(512, 100, 200);
        transformer.transform(map, Operations.MAX);
        printer.transform(map);
    }
}
