package me.evilcorp.dao.file;

import me.evilcorp.dao.UserDao;
import me.evilcorp.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ekzotech on 29.11.16.
 */
public class UserDaoFileImpl implements UserDao {
    private File path;
    private List<User> cache;

    public UserDaoFileImpl(String path) { this(new File(path)); }

    public UserDaoFileImpl(File path) {
        this.path = path;
        this.cache = readAllUsers();
    }


    @Override
    public List<User> findAll() { return cache; }

    @Override
    public void update(User user) {
        ListIterator<User> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()) {
            if (userListIterator.next().getId() == user.getId()) {
                userListIterator.remove();
                userListIterator.add(user);
            }
        }
        writeAllUsers(cache);
    }

    @Override
    public void save(User user) {
        if (!cache.contains(user)){
            cache.add(user);
        }
        writeAllUsers(cache);
    }

    @Override
    public User find(int id) {
        for (User user : cache) {
            if (user.getId() == id){
                return user;
            }
        }
        return new User(0, "null",0, "null");
    }

    @Override
    public void delete(int id) {
        ListIterator<User> userListIterator = cache.listIterator();
        while (userListIterator.hasNext()){
            if (userListIterator.next().getId() == id){
                userListIterator.remove();
                break;
            }
        }
        writeAllUsers(cache);
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        List<User> users = new ArrayList<>();
        for (User u : cache) {
            if (u.getCity().equals(cityName)){
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public boolean isExist(String name) {
        for (User u : cache){
            if (u.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private List<User> readAllUsers() {
        List<User> arrayList;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.path))) {
            try {
                arrayList = (ArrayList<User>) stream.readObject();
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("User not found");
            }
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
        return new ArrayList<>();
    }

    private void writeAllUsers(List<User> users) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))){
            stream.writeObject(users);
        } catch (IOException e) {
            System.out.println("Invalid path");
        }
    }
}
