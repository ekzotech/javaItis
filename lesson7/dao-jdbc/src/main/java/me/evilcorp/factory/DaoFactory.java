package me.evilcorp.factory;

import me.evilcorp.dao.CarDao;
import me.evilcorp.dao.UserDao;
import me.evilcorp.factory.loader.PropertyLoader;
import me.evilcorp.model.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

/**
 * Created by ekzotech on 29.11.16.
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE;

    private UserDao userDao;
    private CarDao carDao;

    static {
        INSTANCE = new DaoFactory();
    }

    private DaoFactory() {
        PropertyLoader.loadIocConfig();
        try {
            String userDaoName = PropertyLoader.getProperty("dao.user.class");
            String carDaoName = PropertyLoader.getProperty("dao.car.class");
            String type = PropertyLoader.getProperty("dao.type");
            if ("db".equals(type)) {
                Connection connection = ConnectionFactory.getInstance().getConnection();
                Constructor<?> userDaoConstructor = Class.forName(userDaoName).getConstructor(Connection.class);
                userDao = (UserDao) userDaoConstructor.newInstance(connection);

                Constructor<?> carDaoConstructor = Class.forName(carDaoName).getConstructor(Connection.class);
                carDao = (CarDao) carDaoConstructor.newInstance(connection);
            }
            else if ("file".equals(type)) {
                Constructor userDaoConst = (Constructor)Class.forName(userDaoName).getConstructor(String.class);
                userDao = (UserDao) userDaoConst.newInstance(PropertyLoader.getProperty("file.users.path"));
                Constructor carDaoConst = (Constructor)Class.forName(carDaoName).getConstructor(String.class);
                carDao = (CarDao) carDaoConst.newInstance(PropertyLoader.getProperty("file.cars.path"));
            }
        } catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public static DaoFactory getInstance() { return INSTANCE; }

    public UserDao getUserDao() { return userDao; }

    public CarDao getCarDao() { return carDao; }

}
