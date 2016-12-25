package me.evilcorp.dao;

import me.evilcorp.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekzotech on 09.12.16.
 */
public class UsersDaoFileImpl implements UsersDao {

    private File path;

    public UsersDaoFileImpl(String path) {
        this(new File(path));
    }

    public UsersDaoFileImpl(File path) {
        this.path = path;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.path))) {
            while (stream.available() > 0) {
                try {
                    User user = (User) stream.readObject();
                    arrayList.add(user);
                } catch (ClassNotFoundException e) {
                    System.out.println("User not found");
                }
            }
        } catch (IOException e) {
            System.out.println("Invalid path");
        }

        return arrayList;
    }

    @Override
    public void save(User user) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(user);
        } catch (IOException e) {
            System.out.println("Invalid path");
        }

    }
}
