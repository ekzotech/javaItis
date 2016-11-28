package me.evilcorp.tokens;

/**
 * Created by ekzotech on 28.11.16.
 */
public class Number extends Token {
    private int value;

    public Number() {
        super();
    }

    public Number(int begin, int end, String text, int value) {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
