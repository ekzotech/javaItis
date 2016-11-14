package me.evilcorp.Tokenizer;

/**
 * Created by ekzotech on 13.11.16.
 */
public class Number extends Token {
    public Number(int begin, char[] chars) {
        super(begin, chars);
    }

    @Override
    public int findEnd(int begin, char[] chars) {
        int end = 0;
        for (int i = begin; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 48 && aChar <= 57) { //коды символов 0-9
                end = i;
            }
            else break;
        }
        return end;
    }
}