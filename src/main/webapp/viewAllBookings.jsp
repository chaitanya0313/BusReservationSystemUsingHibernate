<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bus.entity.Booking" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Bookings - Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">&#x1F68C; Bus System - Admin</span>
    <div>
        <a href="viewBuses" class="btn btn-outline-light btn-sm me-2">View Buses</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <h5 class="mb-3">All Bookings</h5>

    <table class="table table-bordered table-hover bg-white">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>User Name</th>
                <th>Bus Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Passenger</th>
                <th>Seat No</th>
                <th>Booking Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Booking> allBookings = (List<Booking>) request.getAttribute("allBookings");
                if (allBookings != null && !allBookings.isEmpty()) {
                    int i = 1;
                    for (Booking b : allBookings) {
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= b.getUser().getName() %></td>
                <td><%= b.getBus().getBusName() %></td>
                <td><%= b.getBus().getSource() %></td>
                <td><%= b.getBus().getDestination() %></td>
                <td><%= b.getPassengerName() %></td>
                <td><%= b.getSeatNo() %></td>
                <td><%= b.getBookingDate() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="8" class="text-center">No bookings found.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
