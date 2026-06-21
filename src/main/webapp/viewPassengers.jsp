<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bus.entity.Booking, com.bus.entity.Bus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Passengers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">&#x1F68C; Bus System - Admin</span>
    <div>
        <a href="viewBuses" class="btn btn-outline-light btn-sm me-2">Back to Buses</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <%
        Bus bus = (Bus) request.getAttribute("bus");
    %>
    <h5 class="mb-1">Passengers for: <strong><%= bus.getBusName() %></strong></h5>
    <p class="text-muted mb-3">
        <%= bus.getSource() %> &rarr; <%= bus.getDestination() %> &nbsp;|&nbsp;
        <%= bus.getDepartureTime() %>
    </p>

    <table class="table table-bordered table-hover bg-white">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>User Name</th>
                <th>Passenger Name</th>
                <th>Seat No</th>
                <th>Booking Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Booking> passengers = (List<Booking>) request.getAttribute("passengers");
                if (passengers != null && !passengers.isEmpty()) {
                    int i = 1;
                    for (Booking b : passengers) {
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= b.getUser().getName() %></td>
                <td><%= b.getPassengerName() %></td>
                <td><%= b.getSeatNo() %></td>
                <td><%= b.getBookingDate() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="5" class="text-center">No passengers booked for this bus.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
