package me.evilcorp.service;

import me.evilcorp.model.User;

/**
 * Created by ekzotech on 09.12.16.
 */
public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
}
