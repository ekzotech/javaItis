package ru.javaItis.parking;

/**
 * Transport class for car
 * Created by ekzotech on 09.11.16.
 */
public class Car extends Transport{

    public Car(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(name + " едет");
    }

    @Override
    public void breakDown() {
        System.out.println(name + " сломалась");
    }
}
