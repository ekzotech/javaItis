package me.evilcorp.figureArea;

/**
 * class to calc circle area
 * Created by ekzotech on 12.11.16.
 */
public class CircleFigure extends Figure implements Areable {
    private double circleRadius = 0.0;

    public CircleFigure(int x, int y, double radius) {
        super(x, y);
        this.circleRadius = radius;
    }

    @Override
    public double getArea() {
        double result;
        result = 2 * 3.14 * (circleRadius * circleRadius);
        return result;
    }
}
