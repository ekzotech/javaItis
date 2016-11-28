package me.evilcorp.tokens;

/**
 * Created by ekzotech on 28.11.16.
 */
public class Separator extends Token {
    private String value;

    public Separator(){

    }

    public Separator(String value) {
        this.value = value;
    }

    public Separator(int begin, int end, String text, String value) {
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
