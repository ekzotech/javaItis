package me.evilcorp.DAOMain.java;

import me.evilcorp.DAOMain.java.Factories.ServiceFactory;
import me.evilcorp.DAOMain.java.Model.User;
import me.evilcorp.DAOMain.java.Service.UserService;

/**
 * Created by ekzotech on 19.11.16.
 */
public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007", 0);
        User vasya = new User("Vasya", "vasyaLogin", "vasyaparol007", 1);
        User maxx = new User("Maxx", "maxxLogin", "maxxparol007", 2);

        UserService userService = ServiceFactory.getInstance().getUserService();

        userService.addUser(marsel);
        userService.addUser(vasya);
        userService.addUser(maxx);

        if (userService.isRegistered("Marsel")){
            System.out.println("Марсель зарегистрирован");
        } else {
            System.out.println("Марсель незарегистрирован");
        }
    }
}
