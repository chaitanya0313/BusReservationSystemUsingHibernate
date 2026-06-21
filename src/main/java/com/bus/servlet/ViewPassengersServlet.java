package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.entity.Booking;
import com.bus.entity.Bus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewPassengers")
public class ViewPassengersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BookingDAO bookingDAO = new BookingDAO();
    private final BusDAO busDAO = new BusDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        int busId = Integer.parseInt(request.getParameter("busId"));
        Bus bus = busDAO.getBusById(busId);
        List<Booking> passengers = bookingDAO.getBookingsByBusId(busId);

        request.setAttribute("bus", bus);
        request.setAttribute("passengers", passengers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPassengers.jsp");
        dispatcher.forward(request, response);
    }
}