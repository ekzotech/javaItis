package me.evilcorp.Tokenizer;

/**
 * Created by ekzotech on 13.11.16.
 */
public class Word extends Token {
    public Word(int begin, char[] chars) {
        super(begin, chars);
    }

    @Override
    public int findEnd(int begin, char[] chars) {
        int end = 0;
        for (int i = begin; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 65 && aChar <= 90 || aChar >= 97 && aChar <= 122 || aChar >= 1040 && aChar <= 1103) { //коды символов A-Z,a-z,А-я
                end = i;
            }
            else break;
        }
        return end;
    }
}