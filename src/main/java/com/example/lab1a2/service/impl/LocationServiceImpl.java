package com.example.lab1a2.service.impl;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.Location;
import com.example.lab1a2.repository.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements com.example.lab1a2.service.LocationService {
    private final LocationService locationRepository;

    public LocationServiceImpl(LocationService locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Event> findEventsForLocation(long locationId) {
        return locationRepository.findEventsForLocation(locationId);
    }
}
