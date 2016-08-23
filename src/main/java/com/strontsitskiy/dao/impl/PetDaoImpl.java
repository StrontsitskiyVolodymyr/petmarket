package com.strontsitskiy.dao.impl;


import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;

import com.strontsitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class PetDaoImpl implements PetDao {
    public void addPet(Pet pet) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pet);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public void deletePet(Pet pet) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pet);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public Pet getPet(int id) throws SQLException {
        Pet result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Pet) session.load(Pet.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }
}
