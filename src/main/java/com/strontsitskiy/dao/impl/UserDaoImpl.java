package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;
import org.hibernate.Session;


public class UserDaoImpl extends CommonDAOImpl<User> implements UserDao {


    public UserDaoImpl(Class<User> clazz) {
        super(clazz);
    }

    public User getByEmail(String email) {
        User result  = null;
        Session session = null;
        try {
            session = acquireSession();
            result = (User) session.createQuery("from  User where email = :email ").setParameter("email",email).uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeSession(session);
        }
        return result;
    }
}
