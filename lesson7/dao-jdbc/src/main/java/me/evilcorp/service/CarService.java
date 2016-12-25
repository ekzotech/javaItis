package me.evilcorp.service;

import me.evilcorp.model.Car;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public interface CarService {
    List<Car> findAll();
    Car find(int id);
    void save(Car user, int userId);
    void delete(int id);
    void update(Car user);
    List<Car> getCarsByCity(String userCity);
}
