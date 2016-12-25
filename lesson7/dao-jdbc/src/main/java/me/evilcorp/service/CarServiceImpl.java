package me.evilcorp.service;

import me.evilcorp.dao.CarDao;
import me.evilcorp.model.Car;

import java.util.List;

/**
 * Created by ekzotech on 29.11.16.
 */
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) { this.carDao = carDao; }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car find(int id) {
        return carDao.find(id);
    }

    @Override
    public void save(Car car, int userId) {
        carDao.save(car, userId);
    }

    @Override
    public void delete(int id) {
        carDao.delete(id);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public List<Car> getCarsByCity(String userCity) {
        return carDao.getCarsByCity(userCity);
    }
}
