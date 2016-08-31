package com.strontsitskiy.dao;

import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;

import java.util.List;

public interface SpeciesDao extends CommonDAO<Species> {
    Species getSpeciesByName(String speciesName);

    List<Species> getSpeciesByType(PetType petType);
}

