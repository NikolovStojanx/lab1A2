package com.example.lab1a2.service;

import com.example.lab1a2.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> listAll();
    List<Event> searchEvents(String text);

    List<Event> filterEvents(String text, String rating);
    List<Event> searchEventsRating(List<Event> events, int rating);
    Optional<Event> findById(Long id);
    Event save(Long id, String name, String description, double popularityScore, long locationId);
    Event delete(Long id);
}
