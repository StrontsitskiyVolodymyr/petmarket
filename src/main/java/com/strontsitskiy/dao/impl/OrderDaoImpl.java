package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.models.Order;
import com.strontsitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    public void addOrder(Order order) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public void deleteOrder(Order order) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public Order getOrder(int id) throws SQLException {
        Order result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Order) session.load(Order.class,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }
}
