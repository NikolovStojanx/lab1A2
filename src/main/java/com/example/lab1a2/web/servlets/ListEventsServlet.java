//package com.example.lab1a2.web.servlets;
//
//import com.example.lab1a2.model.User;
//import com.example.lab1a2.service.EventBookingService;
//import com.example.lab1a2.service.EventService;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.Enumeration;
//
//@WebServlet(name = "EventsServlet", urlPatterns = "/servlet/events")
//public class ListEventsServlet extends HttpServlet {
//    private final EventService eventService;
//    private final EventBookingService eventBookingService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ListEventsServlet(EventService eventService, EventBookingService eventBookingService, SpringTemplateEngine springTemplateEngine) {
//        this.eventService = eventService;
//        this.eventBookingService = eventBookingService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String ipAddress = req.getRemoteAddr();
//        session.setAttribute("ipAddress", ipAddress);
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//
//        String text = req.getParameter("text");
//        String rating = req.getParameter("rating");
//
//
//       // context.setVariable("events", eventService.listAll());
//
//        context.setVariable("events", eventService.filterEvents(text, rating));
//
//
//
//        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        HttpSession session = req.getSession();
//        String atendeeAddress = (String) session.getAttribute("ipAddress");
//
//        String eventName = req.getParameter("selectedEvent");
//        int numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));
//        User user = (User) req.getSession().getAttribute("user");
//        String attendeeName = user.getName();
//
//        req.getSession().setAttribute("event", eventName);
//        req.getSession().setAttribute("numTickets", numberOfTickets);
//        req.getSession().setAttribute("ipAddress", atendeeAddress);
//        eventBookingService.placeBooking(eventName, attendeeName, atendeeAddress, numberOfTickets);
//
//        resp.sendRedirect("/eventBooking");
//    }
//}
