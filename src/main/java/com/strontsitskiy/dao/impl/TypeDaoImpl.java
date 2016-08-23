package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.TypeDao;
import com.strontsitskiy.models.Type;
import com.strontsitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class TypeDaoImpl implements TypeDao {
    public void addType(Type type) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(type);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public void deleteType(Type type) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(type);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public Type getType(String type) throws SQLException {
        Type result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Type) session.load(Type.class, type);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }
}
