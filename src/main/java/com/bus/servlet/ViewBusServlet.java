package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import com.bus.dao.BusDAO;
import com.bus.entity.Bus;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewBuses")
public class ViewBusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final BusDAO busDAO = new BusDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        List<Bus> buses = busDAO.getAllBuses();
        request.setAttribute("buses", buses);

        RequestDispatcher dispatcher;
        if ("ADMIN".equals(role)) {
            dispatcher = request.getRequestDispatcher("adminViewBuses.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("userViewBuses.jsp");
        }
        dispatcher.forward(request, response);
    }
}