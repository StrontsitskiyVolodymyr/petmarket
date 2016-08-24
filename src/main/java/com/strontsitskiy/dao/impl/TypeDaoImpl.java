package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.TypeDao;
import com.strontsitskiy.models.PetType;

public class TypeDaoImpl extends CommonDAOImpl<PetType> implements TypeDao {

    public TypeDaoImpl(Class<PetType> clazz) {
        super(clazz);
    }
}
