package ru.javaItis.parking;

/**
 * Transport class for motorcycle
 * Created by ekzotech on 09.11.16.
 */
public class Motorcycle extends Transport {

    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(name + " едет");
    }

    @Override
    public void breakDown() {
        System.out.println(name + " сломался");
    }
}
