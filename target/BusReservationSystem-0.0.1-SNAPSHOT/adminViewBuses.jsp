<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bus.entity.Bus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Buses - Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">&#x1F68C; Bus System - Admin</span>
    <div>
        <a href="viewAllBookings" class="btn btn-outline-light btn-sm me-2">All Bookings</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h5>All Buses</h5>
        <a href="addBus" class="btn btn-primary btn-sm">Add Bus</a>
    </div>

    <table class="table table-bordered table-hover bg-white">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Bus Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Departure</th>
                <th>Total Seats</th>
                <th>Available</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Bus> buses = (List<Bus>) request.getAttribute("buses");
                if (buses != null && !buses.isEmpty()) {
                    int i = 1;
                    for (Bus bus : buses) {
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= bus.getBusName() %></td>
                <td><%= bus.getSource() %></td>
                <td><%= bus.getDestination() %></td>
                <td><%= bus.getDepartureTime() %></td>
                <td><%= bus.getTotalSeats() %></td>
                <td><%= bus.getAvailableSeats() %></td>
                <td>
                    <a href="viewPassengers?busId=<%= bus.getId() %>" class="btn btn-info btn-sm text-white">Passengers</a>
                    <a href="deleteBus?busId=<%= bus.getId() %>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Delete this bus and all its bookings?')">Delete</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="8" class="text-center">No buses found.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
