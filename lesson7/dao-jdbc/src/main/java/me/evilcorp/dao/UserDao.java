package me.evilcorp.dao;

import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public interface UserDao {
    List<User> findAll();
    void update(User user);
    void save(User user);
    User find(int id);
    void delete(int id);
    List<User> getUsersByCity(String cityName);
    boolean isExist(String name);
}
