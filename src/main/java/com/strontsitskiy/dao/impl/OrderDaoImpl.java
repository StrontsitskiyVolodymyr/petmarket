package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.OrderDao;
import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.models.User;
import org.hibernate.Session;

import java.util.List;

public class OrderDaoImpl extends CommonDAOImpl<PetOrder> implements OrderDao {

    public OrderDaoImpl(Class<PetOrder> clazz) {
        super(clazz);
    }

    public List<PetOrder> getByCreatorId(Long creatorId) {
        List<PetOrder> result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (List<PetOrder>)session.createQuery("from  PetOrder where newOwner="+creatorId).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }

    public PetOrder getOrderByPetIdAndNewOwnerId(Long petid, Long userid) {
        PetOrder result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (PetOrder) session.createQuery("from  PetOrder where targetPet ="+petid+" and newOwner="+userid).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }
}
