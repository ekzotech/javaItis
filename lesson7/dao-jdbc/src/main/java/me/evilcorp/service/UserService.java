package me.evilcorp.service;

import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
    void update(User user);
    public List<User> getUsersByCity(String cityName);
    List<User> getAll();
    void delete(int id);
    void save(User user);

}
