package com.strontsitskiy.dao;

import com.strontsitskiy.models.Species;

import java.sql.SQLException;

public interface SpeciesDao {
    public void addSpecies(Species species)throws SQLException;
    public void deleteSpecies(Species species)throws SQLException;
    public Species getSpecies(String species)throws SQLException;
}
