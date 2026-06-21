package com.bus.servlet;

import java.io.IOException;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.entity.Booking;
import com.bus.entity.Bus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelBooking")
public class CancelBookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BookingDAO bookingDAO = new BookingDAO();
    private final BusDAO busDAO = new BusDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(request.getParameter("bookingId"));

        Booking booking = bookingDAO.getBookingById(bookingId);

        if (booking != null) {
            int busId = booking.getBus().getId();

            bookingDAO.cancelBooking(bookingId);

            Bus bus = busDAO.getBusById(busId);
            int newAvailableSeats = bus.getAvailableSeats() + 1;
            busDAO.updateAvailableSeats(busId, newAvailableSeats);
        }

        response.sendRedirect("myTickets");
    }
}