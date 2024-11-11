package com.example.lab1a2.repository;

import com.example.lab1a2.bootstrap.DataHolder;
import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.Location;
import com.example.lab1a2.service.EventService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationService {
    private final EventService eventService;

    public LocationService(EventService eventService) {
        this.eventService = eventService;
    }


    public List<Location> findAll() {
        return DataHolder.locations;
    }

    public Location findById(Long id) {
        return DataHolder.locations.stream().filter(l -> l.getId().equals(id)).findFirst().get();
    }

    public List<Event> findEventsForLocation(Long id) {
        List<Event> events = eventService.listAll().stream()
                .filter(loc -> loc.getLocation().getId().equals(id))
                .toList();

        return events;
    }

}
