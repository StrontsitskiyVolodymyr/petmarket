package com.strontsitskiy.models;

import javax.persistence.*;

@Entity
public class PetOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User oldOwner;
    @OneToOne
    private  User newOwner;
    @OneToOne
    private  Pet targetPet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(User newOwner) {
        this.newOwner = newOwner;
    }

    public User getOldOwner() {
        return oldOwner;
    }

    public void setOldOwner(User oldOwner) {
        this.oldOwner = oldOwner;
    }

    public Pet getTargetPet() {
        return targetPet;
    }

    public void setTargetPet(Pet targetPet) {
        this.targetPet = targetPet;
    }
}
