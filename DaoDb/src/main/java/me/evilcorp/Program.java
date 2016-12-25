package me.evilcorp;

import me.evilcorp.factories.ServiceFactory;
import me.evilcorp.model.User;
import me.evilcorp.service.UserService;

/**
 * Created by ekzotech on 09.12.16.
 */
public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007",0);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008",1);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009",2);

        UserService userService = ServiceFactory.getInstance().getUserService();

        userService.addUser(marsel);
        userService.addUser(nastya);
        userService.addUser(ilya);

        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is Registered");
        } else {
            System.out.println("not registered");
        }
    }
}
