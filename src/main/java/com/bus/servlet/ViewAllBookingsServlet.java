package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BookingDAO;
import com.bus.entity.Booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewAllBookings")
public class ViewAllBookingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Booking> allBookings = bookingDAO.getAllBookings();
        request.setAttribute("allBookings", allBookings);

        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllBookings.jsp");
        dispatcher.forward(request, response);
    }
}