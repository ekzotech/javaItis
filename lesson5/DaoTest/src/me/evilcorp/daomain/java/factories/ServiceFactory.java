package me.evilcorp.daomain.java.factories;

import me.evilcorp.daomain.java.dao.UsersDao;
import me.evilcorp.daomain.java.factories.loaders.PropertyLoader;
import me.evilcorp.daomain.java.service.UserService;
import me.evilcorp.daomain.java.verify.Verifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ekzotech on 19.11.16.
 */
public class ServiceFactory {
    private static final ServiceFactory INSTANCE;

    private UserService service;

    static {
        INSTANCE = new ServiceFactory();
    }

    private ServiceFactory(){
        try {
            UsersDao dao = DaoFactory.getInstance().getDao();
            Verifier verifier = (Verifier) Class.forName(PropertyLoader.getProperty("verifier.class")).newInstance();
            Constructor<?> constructor = Class.forName(PropertyLoader.getProperty("service.class")).getConstructor(UsersDao.class,Verifier.class);
            service = (UserService)constructor.newInstance(dao,verifier);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
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
