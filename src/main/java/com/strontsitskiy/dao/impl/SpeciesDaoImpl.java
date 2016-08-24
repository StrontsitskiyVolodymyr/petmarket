package com.strontsitskiy.dao.impl;

import com.strontsitskiy.dao.SpeciesDao;
import com.strontsitskiy.models.Species;

public class SpeciesDaoImpl extends CommonDAOImpl<Species> implements SpeciesDao {

    public SpeciesDaoImpl(Class<Species> clazz) {
        super(clazz);
    }

}
