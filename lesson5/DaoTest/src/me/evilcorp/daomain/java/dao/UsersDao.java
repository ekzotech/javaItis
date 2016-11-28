package me.evilcorp.daomain.java.dao;

import me.evilcorp.daomain.java.model.User;

import java.util.List;

/**
 * Created by ekzotech on 19.11.16.
 */
public interface UsersDao {
    List<User> findAll();
    void update(User user);
    void save(User user);
    User find(int id);
    void delete(int id);
    void clean();

    boolean contains(int id);
}
