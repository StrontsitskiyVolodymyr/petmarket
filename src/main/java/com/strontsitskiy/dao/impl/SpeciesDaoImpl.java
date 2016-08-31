package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import org.hibernate.Session;

import java.util.List;

public class SpeciesDaoImpl extends CommonDAOImpl<Species> implements SpeciesDao {

    public SpeciesDaoImpl(Class<Species> clazz) {
        super(clazz);
    }

    public Species getSpeciesByName(String speciesName) {
        Species result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (Species) session.createQuery("from  Species where speciesName = :speciesName").setParameter("speciesName",speciesName).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }

    public List<Species> getSpeciesByType(PetType petType) {
        List<Species> result = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<Species>) session.createQuery("from Species where parentType=:pettype" ).setParameter("pettype",petType).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
        return result;
    }


}
