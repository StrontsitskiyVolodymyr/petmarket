package com.strontsitskiy;

import com.strontsitskiy.dao.*;
import com.strontsitskiy.dao.impl.*;

public class Factory {
    public static Factory instance = new Factory();
    public UserDao userDao;
    public PetDao petDao;
    public OrderDao orderDao;
    public TypeDao typeDao;
    public SpeciesDao speciesDao;

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        if (userDao == null) userDao = new UserDaoImpl();
        return userDao;
    }

    public PetDao getPetDao() {
        if (petDao == null) petDao = new PetDaoImpl();
        return petDao;
    }

    public OrderDao getOrderDao() {
        if (orderDao == null) orderDao = new OrderDaoImpl();
        return orderDao;
    }

    public TypeDao getTypeDao() {
        if (typeDao == null) typeDao = new TypeDaoImpl();
        return typeDao;
    }

    public SpeciesDao getSpeciesDao() {
        if (speciesDao == null) speciesDao = new SpeciesDaoImpl();
        return speciesDao;
    }
}
