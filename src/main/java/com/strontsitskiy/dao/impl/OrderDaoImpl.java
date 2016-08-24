package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.models.PetOrder;
import org.hibernate.Session;

public class OrderDaoImpl extends CommonDAOImpl<PetOrder> implements OrderDao {

    public OrderDaoImpl(Class<PetOrder> clazz) {
        super(clazz);
    }

    public PetOrder getByCreatorId(Long creatorId) {
        PetOrder result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (PetOrder) session.createQuery("from  PetOrder where oldOwner = :oldOwner ").setParameter("oldOwner",creatorId).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }
}
