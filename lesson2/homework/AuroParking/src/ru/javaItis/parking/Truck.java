package ru.javaItis.parking;

/**
 * Transport class for truck
 * Created by ekzotech on 09.11.16.
 */
public class Truck extends Transport {

    public Truck(String name) {
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
