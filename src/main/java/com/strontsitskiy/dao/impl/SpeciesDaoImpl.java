package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class SpeciesDaoImpl implements SpeciesDao {
    public void addSpecies(Species species) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(species);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public void deleteSpecies(Species species) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(species);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    public Species getSpecies(String species) throws SQLException {
        Species result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Species) session.load(Species.class, species);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }
}
