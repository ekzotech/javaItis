package me.evilcorp.DAOMain.java.Service;

import me.evilcorp.DAOMain.java.Model.User;

/**
 * Created by ekzotech on 19.11.16.
 */
public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
    void update(User user);
}
