package me.evilcorp;

import me.evilcorp.observer.TokenizerObservable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ekzotech on 28.11.16.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();

        TokenizerObservable tokenizerObservable = new Tokenizer();
        tokenizerObservable.addTokenHandler(new TokenHandlerLettersImpl());
        tokenizerObservable.addTokenHandler(new TokenHandlerNumbersImpl());
        tokenizerObservable.addTokenHandler(new TokenHandlerSeparatorImpl());

        tokenizerObservable.tokenize(text);
    }
}
