package com.strontsitskiy.dao;

import com.strontsitskiy.models.PetType;

public interface TypeDao  extends  CommonDAO<PetType>{
    PetType getTypeByName(String typeName);
}
