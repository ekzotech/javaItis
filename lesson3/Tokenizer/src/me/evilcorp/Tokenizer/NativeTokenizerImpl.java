package me.evilcorp.Tokenizer;

import java.util.ArrayList;

/**
 * Created by ekzotech on 13.11.16.
 */
public class NativeTokenizerImpl implements Tokenizer {

    private String text;

    //private Token[] tokens;

    //private int index;

    private ArrayList<Token> tokens; //инициализация

    public NativeTokenizerImpl() {
        this.tokens = new ArrayList<Token>(); //arraylist с именем token, принадлежащий классу Token
        //this.index = 0;
    }

    public ArrayList tokenize(String text) {
        this.text = text; //формальный параметр text равняется text
        char[] chars = text.toCharArray(); //создаём массив chars, который является массивом чаров char[]
        for (int i = 0; i < chars.length; i++) { //сравнение с длиной массива чаров
            char aChar = chars[i]; //по счётчику i получаем элемент массива и приравниваем к aChar типа char
            Token token = null; //обнуляем текущий токен
            if (Separator.PATTERN.contains(String.valueOf(aChar))) { //используем паттерн сепаратов; получаем значение aChar, приводим в строку
                token = new Separator(i, chars);
            } else if (aChar >= '0' && aChar <= '9') {
                token = new Number(i, chars);
            } else if (aChar >= 'A' && aChar <= 'Z' || aChar >= 'a' && aChar <= 'z' || aChar >= 'А' && aChar <= 'я') {
                token = new Word(i, chars);
            }
            else continue;

            i = token.getEnd();
            token.setText(text.substring(token.begin, token.end+1)); //из полученной изначально строки вызываем метод substring с параметрами начального символа и конечного символа
            //например, text.substring(0, 2)
            //addToken(token);
            tokens.add(token); //добавляем в arraylist tokens (при помощи tokens.add) текущий токен
            tokens.size(); //выводим размер tokens
            //index++;
        }

        return this.tokens;
    }

/*
    private static final float RATE_CAPACITY = 1.5f;

    public NativeTokenizerImpl(int capacity) {
        this.tokens = new Token[capacity];
        this.index = 0;
    }

    public Token[] tokenize(String text) {
        this.text = text;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Token token = null;
            if (Separator.PATTERN.contains(String.valueOf(aChar))) {
                token = new Separator(i, chars);
            } else if (aChar >= '0' && aChar <= '9') {
                token = new Number(i, chars);
            } else if (aChar >= 'A' && aChar <= 'Z' || aChar >= 'a' && aChar <= 'z' || aChar >= 'А' && aChar <= 'я') {
                token = new Word(i, chars);
            }
            else continue;

            i = token.getEnd();
            token.setText(text.substring(token.begin, token.end+1));
            addToken(token);
            index++;
        }

        return this.tokens;
    }

    private void addToken(Token token){
        if (index < tokens.length)
            tokens[index] = token;
        else {
            extendArray();
            addToken(token);
        }
    }

    private void extendArray() {
        Token[] fullArray = this.tokens;
        Token[] newArrayToken = new Token[(int)(fullArray.length * RATE_CAPACITY)];
        for (int i = 0; i < fullArray.length; i++) {
            newArrayToken[i] = fullArray[i];
        }
        this.tokens = newArrayToken;
    }
    */
}