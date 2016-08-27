package com.strontsitskiy.models;

import javax.persistence.*;

@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String speciesName;
    @ManyToOne
    private PetType parentType;

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

    public PetType getParentType() {
        return parentType;
    }

    public void setParentType(PetType parentType) {
        this.parentType = parentType;
    }
}
