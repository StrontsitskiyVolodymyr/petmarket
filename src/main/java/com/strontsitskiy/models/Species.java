package com.strontsitskiy.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Species{
    @Id
    private  String species;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
