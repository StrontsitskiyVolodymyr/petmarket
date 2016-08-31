package com.strontsitskiy.dao.impl;


import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.models.User;
import org.hibernate.Session;

import java.util.List;

public class PetDaoImpl  extends  CommonDAOImpl<Pet> implements PetDao {

    public PetDaoImpl(Class<Pet> clazz) {
        super(clazz);
    }

    public List<Pet> getPetsByOwner(User owner) {
        List<Pet> result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<Pet>) session.createQuery("from Pet where owner=:owner" ).setParameter("owner",owner).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }

    public List<Pet> getPetsByType(PetType type) {
        List<Pet> result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<Pet>) session.createQuery("from Pet where petType=:type" ).setParameter("type",type).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }

    public List<Pet> getPetsBySpecies(Species species) {
        List<Pet> result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<Pet>) session.createQuery("from Pet where species=:species" ).setParameter("species",species).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }
}
