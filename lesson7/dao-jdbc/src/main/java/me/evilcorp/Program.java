package me.evilcorp;

import me.evilcorp.factory.ServiceFactory;
import me.evilcorp.service.UserService;

/**
 * Created by ekzotech on 29.11.16.
 */
public class Program {
    public static void main(String[] args) {
        UserService userService = ServiceFactory.getInstance().getUserService();
    }


}
