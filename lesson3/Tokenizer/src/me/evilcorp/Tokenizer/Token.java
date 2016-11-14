package me.evilcorp.Tokenizer;

/**
 * Created by ekzotech on 13.11.16.
 */
public abstract class Token { //создаём абстрактный класс Token
    protected int begin; //задаём переменные видимые только этому классу и его потомкам
    protected int end;
    protected String text;

    public Token(int begin, char[] chars) {
        this.begin = begin;
        this.end = findEnd(begin, chars);
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public String getText() {
        return text;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setText(String text) {
        this.text = text;
    }

    protected abstract int findEnd(int begin, char[] chars);

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" {" +
                "begin=" + begin +
                ", end=" + end +
                ", text='" + text + '\'' +
                '}';
    }
}
