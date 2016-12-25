package me.evilcorp.service;

import me.evilcorp.dao.UsersDao;
import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 09.12.16.
 */
public class UsersService implements UserService {

    private UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if (currentUser.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
