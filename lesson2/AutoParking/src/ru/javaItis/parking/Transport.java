package ru.javaItis.parking;

/**
 * Abstract class Transport
 * Created by ekzotech on 09.11.16.
 */
public abstract class Transport {
    protected String name;

    public Transport(String name) {
        this.name = name;
    }
    public abstract void drive();
    public abstract void breakDown();
}
