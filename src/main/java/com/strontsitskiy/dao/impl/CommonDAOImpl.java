package com.strontsitskiy.dao.impl;


import com.strontsitskiy.dao.CommonDAO;
import com.strontsitskiy.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class CommonDAOImpl<O> implements CommonDAO<O> {

    private Class<O> clazz;

    public CommonDAOImpl(Class<O> clazz) {
        this.clazz = clazz;
    }

    public O add(O item) {
        Session session = null;
        O result = null;
        try {
            session = acquireSession();
            session.beginTransaction();
            result = (O) session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }

    public boolean update(O item) {
        Session session = null;
        boolean isUpdated = true;
        try {
            session = acquireSession();
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            isUpdated = false;
        } finally {
            closeSession(session);
        }
        return isUpdated;
    }

    public boolean remove(O item) {
        Session session = null;
        boolean isDeleted = true;
        try {
            session = acquireSession();
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            isDeleted = false;
        } finally {
            closeSession(session);
        }
        return isDeleted;
    }

    public List<O> getAll() {
        List<O> result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<O>) session.createQuery("from " + clazz.getSimpleName()).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }

    public O getById(Long key) {
        O result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (O) session.load(clazz, key);
            Hibernate.initialize(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }

    protected Session acquireSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    protected void closeSession(Session session) {
        if ((session != null) && (session.isOpen())) session.close();
    }
}
