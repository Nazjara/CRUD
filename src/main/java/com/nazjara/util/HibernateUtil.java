package com.nazjara.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;

    public <T> Serializable create(final T entity) {
        Transaction transaction = null;
        Session session = null;
        Serializable savedEntity = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            savedEntity = session.save(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return savedEntity;
    }

    public <T> T update(final T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return entity;
    }

    public <T> void delete(final T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();

        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> fetchAll(Class<T> entityClass) {
        Transaction transaction = null;
        Session session = null;
        List list = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            list = session.createQuery(" FROM " + entityClass.getName()).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return list;
    }

    @SuppressWarnings("rawtypes")
    public <T> List fetchAll(String query) {
        Transaction transaction = null;
        Session session = null;
        List<T> list = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            list = session.createSQLQuery(query).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public <T> T fetchById(Serializable id, Class<T> entityClass) {
        Transaction transaction = null;
        Session session = null;
        T entity = null;
        try {
            session = sessionFactory.openSession();
            Assert.notNull(session, "Hibernate session cannot be null");
            transaction = session.beginTransaction();
            entity = (T) session.get(entityClass, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return entity;
    }


}
