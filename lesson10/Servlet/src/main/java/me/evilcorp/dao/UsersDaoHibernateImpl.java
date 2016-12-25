package me.evilcorp.dao;

import me.evilcorp.hibernate.HibernateConnector;
import me.evilcorp.models.Child;
import me.evilcorp.models.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ekzotech on 05.12.16.
 */
public class UsersDaoHibernateImpl {
    Session session;

    public UsersDaoHibernateImpl() {

    }

    public List<User> findByName(String name) {
        // открыл сессию
        this.session = HibernateConnector.getConnector().getSession();
        // начал транзакция
        session.beginTransaction();

        List<User> result =  session.createQuery("from User user where name = :userName", User.class)
                .setParameter("userName", name).list();
        session.getTransaction().commit();

        return result;
    }

    public Integer saveChild(Child child) {
        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();

        Integer resultId = (Integer) session.save(child);

        session.getTransaction().commit();

        return resultId;
    }
}
