package com.strontsitskiy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String speciesName;

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String species) {
        this.speciesName = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
