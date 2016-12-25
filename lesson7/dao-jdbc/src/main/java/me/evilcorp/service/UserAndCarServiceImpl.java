package me.evilcorp.service;

import me.evilcorp.dao.CarDao;
import me.evilcorp.dao.UserDao;
import me.evilcorp.model.Car;
import me.evilcorp.model.User;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public class UserAndCarServiceImpl implements UserService {
    private UserDao userDao;
    private CarDao carDao;

    public UserAndCarServiceImpl(UserDao userDao, CarDao carDao) {
        this.userDao = userDao;
        this.carDao = carDao;
    }



    @Override
    public boolean isRegistered(String name) {
        return userDao.isExist(name);
    }

    @Override
    public void addUser(User user) {
        List<Car> cars = user.getCars();
        userDao.save(user);
        if (cars != null) {
            for (Car car : cars) {
                carDao.save(car, user.getId());
            }
        }
    }

    @Override
    public User getUser(int id) {
        User user = userDao.find(id);
        user.setCars(carDao.findAllUserCars(id));
        return user;
    }

    @Override
    public void update(User user) {
        List<Car> cars = user.getCars();
        userDao.update(user);
        for (Car car : cars) {
            carDao.update(car);
        }
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        List<User> usersByCity = userDao.getUsersByCity(cityName);
        for (User user : usersByCity) {
            user.setCars(carDao.findAllUserCars(user.getId()));
        }
        return usersByCity;
    }

    @Override
    public List<User> getAll() {
        List<User> all = userDao.findAll();
        for (User u : all) {
            u.setCars(carDao.findAllUserCars(u.getId()));
        }
        return all;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        List<Car> cars = user.getCars();
        userDao.save(user);
        for (Car c : cars) {
            carDao.save(c,user.getId());
        }
    }
}
