package me.evilcorp.figureArea;

/**
 * Created by ekzotech on 12.11.16.
 */
public class SquareFigure extends Figure implements Areable {
    double squareSide = 0.0;

    public SquareFigure(int x, int y, double squareSide) {
        super(x, y);
        this.squareSide = squareSide;
    }

    @Override
    public double getArea() {
        double result = 0.0;
        result = squareSide * squareSide;
        return result;
    }
}
