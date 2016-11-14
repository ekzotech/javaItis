package me.evilcorp.Tokenizer;

/**
 * Created by ekzotech on 13.11.16.
 */


public class Separator extends Token {

    public static final String PATTERN = ",.?!:;-_\n \t"; //константа PATTERN с содержащимися знаками препинания и пробельными символами

    public Separator(int begin, char[] chars) {
        super(begin, chars); //отсылка к классу-предку Token
    }

    @Override
    protected int findEnd(int begin, char[] chars) {
        return begin;
    }
}