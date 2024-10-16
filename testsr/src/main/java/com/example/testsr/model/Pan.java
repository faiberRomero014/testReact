package com.example.testsr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pan {
    @Id
    private int id;
    private String name;
    private int price;

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
