package com.example.lab1a2.model;

import com.example.lab1a2.bootstrap.DataHolder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
public class Event {
    private Long id;
    String name;
    String description;
    double popularityScore;
    private Location location;

    public Event(String name, String description, double popularityScore) {
        this.id = (long) (Math.random() * 10000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        Random random = new Random();
        this.location = DataHolder.locations.get(random.nextInt(0, 4));
    }

    public Event(Long id, String name, String description, double score, Location location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.popularityScore = score;
        this.location = location;
    }

    public String getLocationName() {
        return location.getName();
    }
}
