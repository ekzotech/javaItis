package me.evilcorp.hibernate;

import me.evilcorp.models.Child;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ekzotech on 05.12.16.
 */
public class HibernateConnector {
    private static HibernateConnector connector;
    private Configuration configuration;
    private SessionFactory sessionFactory;

    private HibernateConnector() {
        configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/javaitis");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "YtabuYfabu1");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addResource("User.hbm.xml");
        configuration.addResource("Auto.hbm.xml");
        configuration.addAnnotatedClass(Child.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    static {
        connector = new HibernateConnector();
    }

    public static HibernateConnector getConnector() {
        return connector;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = configuration.buildSessionFactory();
    }
}
