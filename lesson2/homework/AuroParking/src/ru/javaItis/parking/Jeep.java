package ru.javaItis.parking;

/**
 * Transport class for jeep
 * Created by ekzotech on 09.11.16.
 */
public class Jeep extends Transport {

    public Jeep(String name) {
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
