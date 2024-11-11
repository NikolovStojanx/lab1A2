package com.example.lab1a2.bootstrap;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.EventBooking;
import com.example.lab1a2.model.Location;
import com.example.lab1a2.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DataHolder {

    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;
    public static List<User> users = null;
    public static List<Location> locations = null;

    @PostConstruct
    public void init() {
        // name, description, popularity score
        events = new ArrayList<>();
        eventBookings = new ArrayList<>();
        users = new ArrayList<>();
        users.add(new User("stojan.nikolov", "sn", "Stojan", "Nikolov"));
        locations = new ArrayList<>();

        IntStream.range(0, 5).forEach(i -> {
            String name = "name " + i;
            String description = "description " + i;
            String address = "address " + i;
            int capacity = (i + 15) * 3;
            Location location = new Location(name, description, address, String.valueOf(capacity));
            locations.add(location);
        });

        IntStream.range(0, 11).forEach(i -> {
            String name = "Name" + i;
            String description = "Description " + i;
            Event event = new Event(name, description, i);
            Random random = new Random();
            events.add(new Event(name, description, i));
        });



    }
}
