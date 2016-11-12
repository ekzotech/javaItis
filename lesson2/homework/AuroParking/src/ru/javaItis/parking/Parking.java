package ru.javaItis.parking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


interface TransportFactory {
    Transport[] create(int quantity);
}

class BicycleFactory implements TransportFactory {
    @Override
    public Bicycle[] create(int quantity) {
        return new Bicycle[quantity];
    }
}

class BusFactory implements TransportFactory {
    @Override
    public Bus[] create(int quantity) {
        return new Bus[quantity];
    }
}

class CarFactory implements TransportFactory {
    @Override
    public Car[] create(int quantity) {
        return new Car[quantity];
    }
}

class JeepFactory implements TransportFactory {
    @Override
    public Jeep[] create(int quantity) {
        return new Jeep[quantity];
    }
}

class MotorcycleFactory implements TransportFactory {
    @Override
    public Motorcycle[] create(int quantity) {
        return new Motorcycle[quantity];
    }
}

class TruckFactory implements TransportFactory {
    @Override
    public Truck[] create(int quantity) {
        return new Truck[quantity];
    }
}
/**
 * Main class for all project
 * Created by ekzotech on 09.11.16.
 */
public class Parking {
    private static final Map<String, TransportFactory> FACTORIES = new HashMap<>(6);

    static {
        FACTORIES.put("Bicycle", new BicycleFactory());
        FACTORIES.put("Bus", new BusFactory());
        FACTORIES.put("Car", new CarFactory());
        FACTORIES.put("Jeep", new JeepFactory());
        FACTORIES.put("Motorcycle", new MotorcycleFactory());
        FACTORIES.put("Truck", new TruckFactory());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Добро пожаловать на автопарковку, написанную на Java!");
        System.out.println("Пожалуйста, введите размер парковки:");
        String sParkingLots = bufferedReader.readLine();
        int parkingLots = Integer.parseInt(sParkingLots);
        int parkingLotsSizeNotSet = 1;
        while (parkingLotsSizeNotSet == 1) {
            if (parkingLots == 0) {
                System.out.println("Размер парковки не может быть равен нулю");
            } else if (parkingLots < 0) {
                System.out.println("Размер парковки не может быть меньше нуля");
            } else if (parkingLots >= 64) {
                System.out.println("Это что, парковка МЕГИ???");
                parkingLotsSizeNotSet = 0;
            } else {
                System.out.println("Количество мест на парковке: " + parkingLots);
                parkingLotsSizeNotSet = 0;
            }
        }

        int transportTypeSetFirstTime = 0; //здесь планировалось организовать проверку выполняется ли следующий блок первый раз или нет
        //если не первый раз - то добавить System.out.println() с текстом "0 для выхода"
        //а ещё добавить в switch case 0: для выхода
        //но я пока не знаю, как это сделать

        System.out.println("Выберите тип транспортного средства, которое вы хотите припарковать:");
        System.out.println("Нажмите 1 для велосипеда");
        System.out.println("Нажмите 2 для автобуса");
        System.out.println("Нажмите 3 для легкового автомобиля");
        System.out.println("Нажмите 4 для внедорожника");
        System.out.println("Нажмите 5 для мотоцикла");
        System.out.println("Нажмите 6 для грузовика");
        String sTransportType = bufferedReader.readLine();
        int transportType = Integer.parseInt(sTransportType);
        String setTransportType = "";
        String lcTransportType = "";
        int transportTypeNotSet = 1;
        while (transportTypeNotSet == 1) {
            switch (transportType) {
                case 1:
                    setTransportType = "Bicycle";
                    lcTransportType = "bicycle";
                    transportTypeNotSet = 0;
                    break;
                case 2:
                    setTransportType = "Bus";
                    lcTransportType = "bus";
                    transportTypeNotSet = 0;
                    break;
                case 3:
                    setTransportType = "Car";
                    lcTransportType = "car";
                    transportTypeNotSet = 0;
                    break;
                case 4:
                    setTransportType = "Jeep";
                    lcTransportType = "jeep";
                    transportTypeNotSet = 0;
                    break;
                case 5:
                    setTransportType = "Motorcycle";
                    lcTransportType = "motorcycle";
                    transportTypeNotSet = 0;
                    break;
                case 6:
                    setTransportType = "Truck";
                    lcTransportType = "truck";
                    transportTypeNotSet = 0;
                    break;
                case 0:

                default:
                    System.out.println("Введите число от 1 до 6");
                    break;
            }
        }

        int qtyInput = 0; //
        int setTransportQuantity = 0;
        while (qtyInput == 0) {
            System.out.println("Введите сколько единиц выбранного транспорта вы хотите припарковать:");
            String sTransportQuantity = bufferedReader.readLine();
            int transportQuantity = Integer.parseInt(sTransportQuantity);
            if (transportQuantity == 0) {
                System.out.println("Количество не может быть равно нулю");
            } else if (transportQuantity > parkingLots) {
                System.out.println("Количество не может быть больше количества мест на парковке");
            } else {
                setTransportQuantity = transportQuantity;
                qtyInput = 1;
            }
        }

        AutoParking autoParking = new AutoParking(new Transport[parkingLots]);

        Transport[] transport = FACTORIES.get(setTransportType).create(setTransportQuantity);
        //здесь надо реализовать создание имени для новосозданного объекта

        System.out.println("Парковка транспорта завершена");

        //здесь надо реализовать выезд с парковки для отдельных машин
//        autoParking.parkOutTransport("bus1");
//        autoParking.parkOutTransport("car3");
//        autoParking.parkOutTransport("bicycle1");

//        System.out.println("Часть машин уехала с парковки");

        autoParking.parkOutAllTransport();

    }
}
