package ru.javaItis.parking;


/**
 * Main class for all project
 * Created by ekzotech on 09.11.16.
 */
public class Parking {
    public static void main(String[] args) {
        AutoParking autoParking = new AutoParking(new Transport[15]);

        autoParking.parkInTransport(new Car("car1"));
        autoParking.parkInTransport(new Car("car2"));
        autoParking.parkInTransport(new Car("car3"));
        autoParking.parkInTransport(new Bicycle("bicycle1"));
        autoParking.parkInTransport(new Bus("bus1"));
        autoParking.parkInTransport(new Jeep("jeep1"));
        autoParking.parkInTransport(new Motorcycle("motorcycle1"));

        System.out.println("Парковка транспорта завершена");

        autoParking.parkOutTransport("bus1");
        autoParking.parkOutTransport("car3");
        autoParking.parkOutTransport("bicycle1");

        System.out.println("Часть машин уехала с парковки");

        autoParking.parkOutAllTransport();

    }
}
