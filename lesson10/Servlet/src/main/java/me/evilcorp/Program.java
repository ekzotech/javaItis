package me.evilcorp;

import me.evilcorp.dao.UsersDaoHibernateImpl;
import me.evilcorp.models.Child;
import me.evilcorp.models.User;

import java.util.List;

/**
 * Created by ekzotech on 05.12.16.
 */
public class Program {
    public static void main(String[] args) {
        UsersDaoHibernateImpl hibernate = new UsersDaoHibernateImpl();
        List<User> users = hibernate.findByName("Toleg");

        User user = users.get(0);
        Child child = new Child("Vika", user);

        System.out.println(hibernate.saveChild(child));
    }
}
