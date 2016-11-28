package me.evilcorp.daomain.java.service;

import me.evilcorp.daomain.java.dao.UsersDao;
import me.evilcorp.daomain.java.model.User;
import me.evilcorp.daomain.java.verify.Verifier;

import java.util.List;

/**
 * Created by ekzotech on 19.11.16.
 */
public class UserServiceImpl implements UserService {
    private UsersDao usersDao;
    private Verifier verifier;

    public UserServiceImpl(UsersDao usersDao, Verifier verifier){
        this.usersDao = usersDao;
        this.verifier = verifier;
    }

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users){
            if (currentUser.getName().equals(name)){
                return true;
            }
        }

        return false;
    }

    public void addUser(User user){
        usersDao.save(user);
    }

    public User getUser(int id){
        verifier.userExist(id);
        return usersDao.find(id);
    }

    @Override
    public void update(User user){
        verifier.userExist(user.getId());
        usersDao.update(user);
    }
}
