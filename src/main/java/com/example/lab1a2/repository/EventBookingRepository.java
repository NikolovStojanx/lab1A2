package com.example.lab1a2.repository;

import com.example.lab1a2.bootstrap.DataHolder;
import com.example.lab1a2.model.EventBooking;
import org.springframework.stereotype.Repository;

@Repository
public class EventBookingRepository {


    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        EventBooking eventBooking = new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);

        DataHolder.eventBookings.add(eventBooking);
        return eventBooking;

    }
}
