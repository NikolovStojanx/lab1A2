package com.example.lab1a2.repository;

import com.example.lab1a2.bootstrap.DataHolder;
import com.example.lab1a2.model.Event;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    private final LocationService locationRepository;

    public EventRepository(@Lazy LocationService locationService) {
        this.locationRepository = locationService;
    }


    // findAll()

    public List<Event> findAll() {
        return DataHolder.events;
    }


    // searchEvents(String text)
    // ime ili opis sodrzi tekstot text

    public List<Event> searchEvents(String text) {
        return findAll().stream().filter(event -> event.getName().contains(text) || event.getDescription().contains(text)).collect(Collectors.toList());
    }

    public Optional<Event> findById(Long id) {
        return findAll().stream().filter(event -> event.getId().equals(id)).findFirst();
    }

    public Event save(long id, String name, String description, double score, long locationId) {
        Optional<Event> event = DataHolder.events.stream().filter(e -> e.getId().equals(id)).findFirst();

        if (event.isPresent()) {
            Event event1 = event.get();
            event1.setName(name);
            event1.setDescription(description);
            event1.setPopularityScore(score);
            event1.setLocation(locationRepository.findById(locationId));
            return event1;
        }

        Event event1 = new Event(id, name, description, score, locationRepository.findById(locationId));
        DataHolder.events.add(event1);
        return event1;
    }

    public Event delete(long id) {
        Event event = findById(id).get();

        DataHolder.events.remove(event);
        return event;
    }
}
