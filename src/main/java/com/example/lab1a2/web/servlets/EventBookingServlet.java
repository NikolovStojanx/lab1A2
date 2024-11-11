//package com.example.lab1a2.web.servlets;
//
//import com.example.lab1a2.model.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = "/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventBookingServlet(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//
//        User user = (User) req.getSession().getAttribute("user");
//
//        context.setVariable("name", user.getName());
//        context.setVariable("event", (String)req.getSession().getAttribute("event"));
//        context.setVariable("numTickets", (Integer) req.getSession().getAttribute("numTickets"));
//        context.setVariable("ipAddress", req.getSession().getAttribute("ipAddress"));
//
//        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//
//
//    }
//}
