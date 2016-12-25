package me.evilcorp.dao;

import me.evilcorp.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekzotech on 09.12.16.
 */
public class UsersDaoArrayListImpl implements UsersDao {

    List<User> users;

    public UsersDaoArrayListImpl() {
        this.users = new ArrayList<User>();
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public void save(User user) {
        User userForSave = new User(user.getName(), user.getLogin(), user.getPassword());
        this.users.add(userForSave);
    }
}
