package me.evilcorp.figureArea;

/**
 * main class for all project
 * Created by ekzotech on 12.11.16.
 */
class MainProgram {
    public static void main(String[] args) {

        CircleFigure circle1 = new CircleFigure(1, 1, 3.0);
        CircleFigure circle2 = new CircleFigure(2, 2, 5.0);
        RectangleFigure rectangle1 = new RectangleFigure(1, 1, 3.0, 2.5);
        RectangleFigure rectangle2 = new RectangleFigure(2, 2, 6.0, 3.0);
        SquareFigure square1 = new SquareFigure(1, 1, 2.0);
        SquareFigure square2 = new SquareFigure(2, 2, 3);

        System.out.println(circle1.getArea());
        System.out.println(circle2.getArea());
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle2.getArea());
        System.out.println(square1.getArea());
        System.out.println(square2.getArea());
    }
}
