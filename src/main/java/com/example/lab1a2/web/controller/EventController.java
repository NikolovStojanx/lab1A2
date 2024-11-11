package com.example.lab1a2.web.controller;

import com.example.lab1a2.model.Event;
import com.example.lab1a2.model.Location;
import com.example.lab1a2.model.User;
import com.example.lab1a2.service.EventService;
import com.example.lab1a2.service.LocationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) String text,
                                @RequestParam(required = false) String rating,
                                Model model) {

        List<Event> events = eventService.filterEvents(text, rating);
        model.addAttribute("events", events);
        return "listEvents";
    }

    @GetMapping("/booking")
    public String showBookingConfirmation(HttpServletRequest request,
                                          Model model) {
        model.addAttribute("eventName", request.getSession().getAttribute("eventName"));
        model.addAttribute("numTickets", request.getSession().getAttribute("numTickets"));
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user.getName());
        model.addAttribute("ipAddress", request.getRemoteAddr());
        return "bookingConfirmation";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditEventPage(@PathVariable Long id, Model model) {
        if (eventService.findById(id).isPresent()) {
            Event event = eventService.findById(id).get();
            List<Location> locations = locationService.findAll();
            model.addAttribute("event", event);
            model.addAttribute("locations", locations);

            return "add-form";
        }


        return "redirect:/events?error=EventNotFound";
    }

    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());

        return "add-form";
    }

    @PostMapping("/add")
    public String addEvent(@RequestParam Long id,
                           @RequestParam String name,
                           @RequestParam String description,
                           @RequestParam double score,
                           @RequestParam Long locationId) {


        eventService.save(id, name, description, score, locationId);
        return "redirect:/events";

    }

    @PostMapping("/booking")
    public String booking(HttpServletRequest request,
                          @RequestParam String eventName,
                          @RequestParam int numTickets) {

        request.getSession().setAttribute("eventName", eventName);
        request.getSession().setAttribute("numTickets", numTickets);
        return "redirect:/events/booking";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long eventId) {
        eventService.delete(eventId);

        return "redirect:/events";
    }


}
