package me.evilcorp.figureArea;

/**
 * class to calc rectangle area
 * Created by ekzotech on 12.11.16.
 */
public class RectangleFigure extends Figure implements Areable {

    private double rectangleFirstSide = 0.0;
    private double rectangleSecondSide = 0.0;

    public RectangleFigure(int x, int y, double firstSide, double secondSide) {
        super(x, y);
        this.rectangleFirstSide = firstSide;
        this.rectangleSecondSide = secondSide;
    }

    @Override
    public double getArea() {
        double result = rectangleFirstSide * rectangleSecondSide;
        return result;
    }
}
