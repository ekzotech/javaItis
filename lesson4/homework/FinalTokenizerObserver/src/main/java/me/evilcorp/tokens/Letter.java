package me.evilcorp.tokens;

/**
 * Created by ekzotech on 28.11.16.
 */
public class Letter extends Token {
    private String value;

    public Letter(){

    }

    public Letter(String value) {
        this.value = value;
    }

    public Letter(int begin, int end, String text, String value) {
        super(begin, end, text);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
