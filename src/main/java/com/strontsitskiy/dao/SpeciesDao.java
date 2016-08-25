package com.strontsitskiy.dao;

import com.strontsitskiy.models.Species;

public interface SpeciesDao extends  CommonDAO<Species> {
    Species getSpicesByName( String speciesName);
}
