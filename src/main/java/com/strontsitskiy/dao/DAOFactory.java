package com.strontsitskiy.dao;

import com.strontsitskiy.dao.impl.*;
import com.strontsitskiy.models.*;

public class DAOFactory {
    public static DAOFactory instance = new DAOFactory();
    private UserDao userDao;
    private PetDao petDao;
    private OrderDao orderDao;
    private TypeDao typeDao;
    private SpeciesDao speciesDao;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        if (userDao == null) userDao = new UserDaoImpl(User.class);
        return userDao;
    }

    public PetDao getPetDao() {
        if (petDao == null) petDao = new PetDaoImpl(Pet.class);
        return petDao;
    }

    public OrderDao getOrderDao() {
        if (orderDao == null) orderDao = new OrderDaoImpl(PetOrder.class);
        return orderDao;
    }

    public TypeDao getTypeDao() {
        if (typeDao == null) typeDao = new TypeDaoImpl(PetType.class);
        return typeDao;
    }

    public SpeciesDao getSpeciesDao() {
        if (speciesDao == null) speciesDao = new SpeciesDaoImpl(Species.class);
        return speciesDao;
    }
}
