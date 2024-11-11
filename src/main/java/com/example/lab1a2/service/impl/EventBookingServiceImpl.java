package com.example.lab1a2.service.impl;

import com.example.lab1a2.model.EventBooking;
import com.example.lab1a2.repository.EventBookingRepository;
import com.example.lab1a2.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    private final EventBookingRepository eventBookingRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }


    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        return eventBookingRepository.placeBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }
}
