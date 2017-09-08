package com.thomas.de.praetere.worldcreator.map.mountain;

import com.thomas.de.praetere.worldcreator.map.Direction;
import com.thomas.de.praetere.worldcreator.map.Map;
import com.thomas.de.praetere.worldcreator.map.MapPoint;
import com.thomas.de.praetere.worldcreator.map.transformer.Operations;
import com.thomas.de.praetere.worldcreator.map.transformer.Transformer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Stack;

public class Mountain implements Transformer {
    private int x;
    private int y;
    private double height;

    public Mountain(int x, int y, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public void transform(Map map, Operations operation) {
        HashSet<MapPoint> passedPoints = new HashSet<>();
        Stack<MapPoint> stack = new Stack<>();
        Optional<MapPoint> top = map.getPoint(x, y);
        top.ifPresent(stack::push);
        while (!stack.isEmpty()) {
            MapPoint currentNode = stack.pop();
            passedPoints.add(currentNode);
            double newH = height - currentNode.getDistance(x, y);
            if (newH > 0.0) {
                for (Direction dir : Direction.values()) {
                    currentNode.getNeighbour(dir).ifPresent(n -> {
                        if (!passedPoints.contains(n)) {
                            stack.push(n);
                        }
                    });
                }
                currentNode.operateOnHeight(
                        newH,
                        operation
                );
            }
        }
    }
}
