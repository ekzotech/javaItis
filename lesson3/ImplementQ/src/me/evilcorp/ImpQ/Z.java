package me.evilcorp.ImpQ;

/**
 * Created by ekzotech on 13.11.16.
 */
public class Z implements D {
    @Override
    public int calc() {
        return 4;//здесь из-за предыдущих приколов надо возвращать 4, иначе на выходе получим 1+2+3=6,
        //а получив 6 непонятно, это у тебя 1+2+3 или 1+2+1+2; зато получив 7 сразу всё прост и понятно 1+2+4.
    }
}
