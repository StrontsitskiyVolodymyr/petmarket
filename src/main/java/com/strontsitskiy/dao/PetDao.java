package com.strontsitskiy.dao;


import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetType;
import com.strontsitskiy.models.Species;
import com.strontsitskiy.models.User;

import java.util.List;

public interface PetDao extends CommonDAO<Pet> {
    List<Pet> getPetsByOwner(User owner);
    List<Pet> getPetsByType(PetType type);
    List<Pet> getPetsBySpecies(Species species);
    List<Pet> getLastAddedPets();
}
