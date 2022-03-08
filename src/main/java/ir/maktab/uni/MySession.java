package ir.maktab.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
