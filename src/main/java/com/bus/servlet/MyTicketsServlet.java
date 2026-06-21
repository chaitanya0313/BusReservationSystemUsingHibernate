package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BookingDAO;
import com.bus.entity.Booking;
import com.bus.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/myTickets")
public class MyTicketsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Booking> myTickets = bookingDAO.getBookingsByUserId(user.getId());
        request.setAttribute("myTickets", myTickets);

        RequestDispatcher dispatcher = request.getRequestDispatcher("myTickets.jsp");
        dispatcher.forward(request, response);
    }
}