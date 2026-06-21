package com.bus.servlet;

import java.io.IOException;

import com.bus.dao.BusDAO;
import com.bus.entity.Bus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addBus")
public class AddBusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BusDAO busDAO = new BusDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addBus.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String busName = request.getParameter("busName");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String departureTime = request.getParameter("departureTime");
        int totalSeats = Integer.parseInt(request.getParameter("totalSeats"));

        Bus bus = new Bus(busName, source, destination, departureTime, totalSeats, totalSeats);

        busDAO.addBus(bus);

        response.sendRedirect("viewBuses");
    }
}