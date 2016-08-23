package com.strontsitskiy.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type {
    @Id
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
