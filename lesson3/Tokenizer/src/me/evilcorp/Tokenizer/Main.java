package me.evilcorp.Tokenizer;

/**
 * Created by ekzotech on 13.11.16.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите строку для разбора:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String textToTokenize = bufferedReader.readLine();

        ArrayList tokenize = new NativeTokenizerImpl().tokenize(textToTokenize); //вызываем метод .tokenize(полученная строка)
        System.out.println("Результат обработки:");
        for (int i = 0; i < tokenize.size(); i++) {
            if (tokenize.get(i) != null) {
                System.out.println("Вывод элемента массива " + i);
                System.out.println(tokenize.get(i));
            }
        }
        System.out.println("Обработка завершена");
    }
}