package com.strontsitskiy.dao.impl;


import com.strontsitskiy.dao.PetDao;
import com.strontsitskiy.models.Pet;

public class PetDaoImpl  extends  CommonDAOImpl<Pet> implements PetDao {

    public PetDaoImpl(Class<Pet> clazz) {
        super(clazz);
    }
}
