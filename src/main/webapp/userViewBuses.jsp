<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bus.entity.Bus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Available Buses</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-primary px-3">
    <span class="navbar-brand">&#x1F68C; Bus Registration System</span>
    <div>
        <a href="myTickets" class="btn btn-outline-light btn-sm me-2">My Tickets</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <h5 class="mb-3">Available Buses</h5>

    <table class="table table-bordered table-hover bg-white">
        <thead class="table-primary">
            <tr>
                <th>#</th>
                <th>Bus Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Departure</th>
                <th>Available Seats</th>
                <th>Action</th>
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
                <td><%= bus.getAvailableSeats() %></td>
                <td>
                    <% if (bus.getAvailableSeats() > 0) { %>
                        <a href="bookTicket?busId=<%= bus.getId() %>" class="btn btn-success btn-sm">Book</a>
                    <% } else { %>
                        <span class="badge bg-danger">Full</span>
                    <% } %>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="7" class="text-center">No buses available.</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
