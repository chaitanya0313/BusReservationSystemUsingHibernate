package com.bus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bus.dao.BookingDAO;
import com.bus.dao.BusDAO;
import com.bus.entity.Booking;
import com.bus.entity.Bus;
import com.bus.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookTicket")
public class BookTicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BusDAO busDAO = new BusDAO();
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int busId = Integer.parseInt(request.getParameter("busId"));
        Bus bus = busDAO.getBusById(busId);

        List<Booking> existingBookings = bookingDAO.getBookingsByBusId(busId);
        List<Integer> takenSeats = new ArrayList<>();
        for (Booking b : existingBookings) {
            takenSeats.add(b.getSeatNo());
        }

        List<Integer> availableSeatNumbers = new ArrayList<>();
        for (int seat = 1; seat <= bus.getTotalSeats(); seat++) {
            if (!takenSeats.contains(seat)) {
                availableSeatNumbers.add(seat);
            }
        }

        request.setAttribute("bus", bus);
        request.setAttribute("availableSeatNumbers", availableSeatNumbers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bookTicket.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int busId = Integer.parseInt(request.getParameter("busId"));
        String passengerName = request.getParameter("passengerName");
        int seatNo = Integer.parseInt(request.getParameter("seatNo"));

        Bus bus = busDAO.getBusById(busId);

        Booking booking = new Booking(user, bus, passengerName, seatNo, new Date());
        bookingDAO.addBooking(booking);

        int newAvailableSeats = bus.getAvailableSeats() - 1;
        busDAO.updateAvailableSeats(busId, newAvailableSeats);

        response.sendRedirect("myTickets");
    }
}