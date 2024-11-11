package com.example.lab1a2.service.impl;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.repository.EventRepository;
import com.example.lab1a2.service.EventService;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public List<Event> filterEvents(String text, String rating) {
        if (rating != null && rating.isEmpty()) rating = null;
        if(text != null && text.isEmpty()) text = null;

        if (text == null && rating == null) {
            return listAll();
        } else if(text != null && rating != null) {
            int ratingInt = Integer.parseInt(rating);
            List<Event> eventsText = searchEvents(text);
            return searchEventsRating(eventsText, ratingInt);
        }
        else if (text == null) {
            return searchEventsRating(listAll(), Integer.parseInt(rating));
        } else {
            return searchEvents(text);
        }
    }

    @Override
    public List<Event> searchEventsRating(List<Event> events, int rating) {
        return events.stream().filter(event -> event.getPopularityScore() >= rating).collect(Collectors.toList());
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event save(Long id, String name, String description, double popularityScore, long locationId) {
        return eventRepository.save(id, name, description, popularityScore, locationId);
    }

    @Override
    public Event delete(Long id) {
        return eventRepository.delete(id);
    }


}
