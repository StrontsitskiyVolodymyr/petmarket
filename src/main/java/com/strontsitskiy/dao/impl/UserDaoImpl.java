package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.UserDao;
import com.strontsitskiy.models.User;


public class UserDaoImpl extends CommonDAOImpl<User> implements UserDao {


    public UserDaoImpl(Class<User> clazz) {
        super(clazz);
    }
}
