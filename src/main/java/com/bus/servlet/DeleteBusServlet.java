package com.bus.servlet;

import java.io.IOException;

import com.bus.dao.BusDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteBus")
public class DeleteBusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
        busDAO.deleteBus(busId);
        response.sendRedirect("viewBuses");
    }
}