package com.thomas.de.praetere.worldcreator.map.printer;

import com.sun.javafx.iio.ImageStorage;
import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Creator;
import com.thomas.de.praetere.worldcreator.map.util.Heighest;
import com.thomas.de.praetere.worldcreator.map.util.Lowest;
import com.thomas.de.praetere.worldcreator.map.util.MathUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ToImagePrinter implements Creator<Boolean> {
    private final String pathName;
    private final String fileName;

    public ToImagePrinter(String pathName, String fileName) {
        this.pathName = pathName;
        this.fileName = fileName;
    }

    @Override
    public Boolean create(Map map) {
        System.out.println("Started Printing");
        BufferedImage image = new BufferedImage(map.getMaxX(), map.getMaxY(), ImageStorage.ImageType.RGB.ordinal());
        double maxHeight = new Heighest(map).calculate().getHeight();
        double minHeight = new Lowest(map).calculate().getHeight();
        for (int i = 0; i < map.getMaxX(); i++) {
            for (int j = 0; j < map.getMaxY(); j++) {
                Optional<MapPoint> point = map.getPoint(i, j);
                if (point.isPresent()) {
                    image.setRGB(i, j, toRgb(point.get(), minHeight, maxHeight));
                }
            }
        }
        try {
            ImageIO.write(image, "png", new File(pathName, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished printing.");
        return true;
    }

    private int toRgb(MapPoint point, double lowest, double highest) {
        Color c;
        if (point.getHeight() < 0) {
            int col = MathUtil.makeBetween256((point.getHeight() - lowest) / (0 - lowest));
            c = new Color(col, col, 255);
        } else {
            int col = MathUtil.makeBetween256((point.getHeight()) / (highest));
            c = new Color(col, col, col);
        }
        return c.getRGB();
    }
}
