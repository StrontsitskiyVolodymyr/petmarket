package com.strontsitskiy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
    private String oldOwner;
    private  String newOwner;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  int pet;

    public String getOldOwner() {
        return oldOwner;
    }

    public void setOldOwner(String oldOwner) {
        this.oldOwner = oldOwner;
    }

    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPet() {
        return pet;
    }

    public void setPet(int pet) {
        this.pet = pet;
    }
}
