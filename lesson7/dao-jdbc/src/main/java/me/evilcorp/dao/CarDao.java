package me.evilcorp.dao;

import me.evilcorp.model.Car;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public interface CarDao {
    List<Car> findAllUserCars(int userId);
    List<Car> findAll();
    void update(Car car);
    void save(Car car, int userId);
    Car find(int id);
    void delete(int id);
    List<Car> getCarsByCity(String userCity);
}
