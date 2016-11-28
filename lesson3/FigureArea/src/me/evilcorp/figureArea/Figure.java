package me.evilcorp.figureArea;

/**
 * abstract class for any figure type
 * Created by ekzotech on 12.11.16.
 */
@SuppressWarnings({"CanBeFinal", "unused"})
abstract class Figure {
    private int x;
    private int y;

    Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
