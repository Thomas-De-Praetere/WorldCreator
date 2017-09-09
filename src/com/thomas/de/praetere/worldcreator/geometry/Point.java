package com.thomas.de.praetere.worldcreator.geometry;

/**
 * A point is an extension of a location with a double height.
 */
public class Point extends Location {
    /**
     * The height of a location.
     */
    protected double height;

    /**
     * Creates a Point with a given (x,y)-location and a given height.
     *
     * @param x      The x location.
     * @param y      The y location.
     * @param height The height.
     */
    public Point(int x, int y, double height) {
        super(x, y);
        this.height = height;
    }

    /**
     * Creates a point wat the (x,y)-location with height 0.
     *
     * @param x The x location.
     * @param y The y location.
     */
    public Point(int x, int y) {
        this(x, y, 0.0);
    }

    /**
     * Creates a point at (0,0) with height 0.0.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * @return The height of the Point.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the point.
     *
     * @param height The new height.
     */
    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Point{" +
                "height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
