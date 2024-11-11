package com.example.lab1a2.model;

import lombok.Data;

@Data
public class Location {
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;

    public Location(String name, String address, String capacity, String description) {
        this.id = (long) (Math.random() * 10000);
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }
}