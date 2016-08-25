package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.TypeDao;
import com.strontsitskiy.models.PetType;
import org.hibernate.Session;

public class TypeDaoImpl extends CommonDAOImpl<PetType> implements TypeDao {

    public TypeDaoImpl(Class<PetType> clazz) {
        super(clazz);
    }

    public PetType getTypeByName(String typeName) {
        PetType result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (PetType) session.createQuery("from  PetType where typeName = :typeName").setParameter("typeName",typeName).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }
}
