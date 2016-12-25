package me.evilcorp.service;

import me.evilcorp.dao.UserDao;
import me.evilcorp.model.User;
import me.evilcorp.verify.Verifier;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private Verifier verifier;

    public UserServiceImpl(UserDao userDao, Verifier verifier) {
        this.userDao = userDao;
        this.verifier = verifier;
    }


    @Override
    public boolean isRegistered(String name) {
        return userDao.isExist(name);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUser(int id) {
        verifier.userExist(id);
        return userDao.find(id);
    }

    @Override
    public void update(User user) {
        verifier.userExist(user.getId());
        userDao.update(user);
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        return userDao.getUsersByCity(cityName);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
