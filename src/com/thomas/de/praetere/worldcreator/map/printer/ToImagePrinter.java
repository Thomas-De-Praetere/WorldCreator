package com.thomas.de.praetere.worldcreator.map.printer;

import com.sun.javafx.iio.ImageStorage;
import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.ConstantTransformer;
import com.thomas.de.praetere.worldcreator.map.util.Heighest;
import com.thomas.de.praetere.worldcreator.map.util.Lowest;
import com.thomas.de.praetere.worldcreator.map.util.MathUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ToImagePrinter implements ConstantTransformer {
    private final String pathName;
    private final String fileName;

    public ToImagePrinter(String pathName, String fileName) {
        this.pathName = pathName;
        this.fileName = fileName;
    }

    @Override
    public void transform(Map map) {
        BufferedImage image = new BufferedImage(map.getMaxX(), map.getMaxY(), ImageStorage.ImageType.RGB.ordinal());
        double maxHeight = new Heighest(map).calculate().getHeight();
        double minHeight = new Lowest(map).calculate().getHeight();
        for (int i = 0; i < map.getMaxX(); i++) {
            for (int j = 0; j < map.getMaxY(); j++) {
                Optional<MapPoint> point = map.getPoint(i, j);
                if (point.isPresent()) {
                    System.out.println(toRgb(point.get(), minHeight, maxHeight));
                    image.setRGB(i, j, toRgb(point.get(), minHeight, maxHeight));
                }
            }
        }
        try {
            ImageIO.write(image, "jpg", new File(pathName, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int toRgb(MapPoint point, double lowest, double highest) {
        return MathUtil.makeBetween256((point.getHeight() - lowest) / (highest - lowest));
    }
}
