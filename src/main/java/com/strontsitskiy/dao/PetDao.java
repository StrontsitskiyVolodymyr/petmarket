package com.strontsitskiy.dao;


import com.strontsitskiy.models.Pet;

import java.sql.SQLException;

public interface PetDao {
    public void addPet(Pet pet)throws SQLException;
    public void deletePet(Pet pet)throws SQLException;
    public Pet getPet(int id)throws SQLException;
}
