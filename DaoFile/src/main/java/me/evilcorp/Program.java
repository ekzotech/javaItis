package me.evilcorp;

import me.evilcorp.dao.UsersDao;
import me.evilcorp.dao.UsersDaoFileImpl;
import me.evilcorp.model.User;
import me.evilcorp.service.UserService;
import me.evilcorp.service.UsersService;

/**
 * Created by ekzotech on 09.12.16.
 */
public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007");
        User nastya = new User("Nastya", "nastyaLogin", "qwerty007");
        User ilya = new User("Ilya", "ilyaLogin", "qwerty007");

        UsersDao usersDao = new UsersDaoFileImpl("/home/ekzotech/Projects/javaItis/DaoFile/src/main/resources/users.txt");

        usersDao.save(marsel);
        usersDao.save(nastya);
        usersDao.save(ilya);

        UserService userService = new UsersService(usersDao);

        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is registered");
        } else {
            System.out.println("Not registered");
        }
    }
}
