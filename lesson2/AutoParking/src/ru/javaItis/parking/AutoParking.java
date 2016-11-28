package ru.javaItis.parking;

/**
 * Here is logic for parking
 * Created by ekzotech on 09.11.16.
 */
public class AutoParking {
    private Transport[] arrayOfTransport;

    public AutoParking(Transport[] arrayOfTransport) {
        this.arrayOfTransport = arrayOfTransport;
    }

    public void parkInTransport(Transport transport) {
        for (int i = 0; i < arrayOfTransport.length; i++) {
            if (arrayOfTransport[i] == null) {
                arrayOfTransport[i] = transport;
                System.out.println("Транспорт припаркован на место " + i);
                return;
            }
        }
        System.out.println("Нет мест.");
    }

    public Transport parkOutTransport(String name) {
        for (int i = 0; i < arrayOfTransport.length; i++) {
            if (arrayOfTransport[i]!=null && arrayOfTransport[i].name.equals(name)) {
                Transport transport = arrayOfTransport[i];
                arrayOfTransport[i] = null;
                System.out.println(transport.name + " уехал с парковки");
                return transport;
            }
        }
        System.out.println("Транспорт не найден.");
        return null;
    }

    public void parkOutAllTransport() {
        for (int i = 0; i < arrayOfTransport.length; i++) {
            if (arrayOfTransport[i] != null) {
                arrayOfTransport[i].drive();
                arrayOfTransport[i] = null;
            }
        }
        System.out.println("Весь транспорт уехал, парковка пуста");
    }
}
