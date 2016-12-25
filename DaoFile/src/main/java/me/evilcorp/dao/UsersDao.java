package me.evilcorp.dao;

import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 09.12.16.
 */
public interface UsersDao {
    List<User> findAll();
    void save(User user);
}
