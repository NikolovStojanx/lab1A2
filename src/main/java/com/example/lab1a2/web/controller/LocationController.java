package com.example.lab1a2.web.controller;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.Location;
import com.example.lab1a2.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String getLocationsPage(Model model) {
        model.addAttribute("locations", locationService.findAll());

        return "locations";
    }

    @GetMapping("/events/{id}")
    public String getEventsPage(@PathVariable Long id, Model model) {
        Location location = locationService.findById(id);
        List<Event> events = locationService.findEventsForLocation(id);

        model.addAttribute("events", events);

        return "listEvents";

    }
}
