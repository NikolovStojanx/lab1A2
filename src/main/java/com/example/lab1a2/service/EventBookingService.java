package com.example.lab1a2.service;

import com.example.lab1a2.model.EventBooking;

public interface EventBookingService {

    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets);
}
