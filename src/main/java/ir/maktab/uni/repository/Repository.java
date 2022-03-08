package ir.maktab.uni.repository;

import ir.maktab.uni.MySession;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface Repository<T>{

    default T save(T t){
        Session session = MySession.getSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        return t;
    }

    default T findById(Class<T> clazz, int id) {
        Session session = MySession.getSession();
        return session.find(clazz, id);
    }

    default void delete(Class<T> clazz){
        Session session = MySession.getSession();
        session.delete(clazz);
    }

    default List<T> findAll(Class<T> clazz){
        Session session = MySession.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> query=criteriaBuilder.createQuery(clazz);
        Root<T> root= query.from(clazz);
        return session.createQuery(query.select(root)).getResultList();
    }

    default void update(T t){
        Session session = MySession.getSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
    }

}
