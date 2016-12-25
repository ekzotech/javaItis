package me.evilcorp.factories;

import me.evilcorp.dao.UsersDao;
import me.evilcorp.factories.loaders.PropertyLoader;
import me.evilcorp.service.UserService;
import org.junit.rules.Verifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ekzotech on 09.12.16.
 */
public class ServiceFactory {
    private static final ServiceFactory INSTANCE;

    private UserService service;

    static {
        INSTANCE = new ServiceFactory();
    }

    private ServiceFactory() {
        try {
            UsersDao dao = DaoFactory.getInstance().getDao();
            Verifier verifier = (Verifier) Class.forName(PropertyLoader.getProperty("verifier.class")).newInstance();
            Constructor<?> constructor = Class.forName(PropertyLoader.getProperty("service.class")).getConstructor(UsersDao.class, Verifier.class);
            service = (UserService)constructor.newInstance(dao,verifier);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }

    public UserService getUserService(){
        return service;
    }
}
