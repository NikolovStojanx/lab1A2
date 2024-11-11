package com.example.lab1a2.service;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> findAll();
    Location findById(Long id);

    List<Event> findEventsForLocation(long locationId);
}
