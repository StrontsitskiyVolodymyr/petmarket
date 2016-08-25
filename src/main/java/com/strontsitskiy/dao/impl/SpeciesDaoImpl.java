package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.models.Species;
import org.hibernate.Session;

public class SpeciesDaoImpl extends CommonDAOImpl<Species> implements SpeciesDao {

    public SpeciesDaoImpl(Class<Species> clazz) {
        super(clazz);
    }

    public Species getSpicesByName(String speciesName) {
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
}
