<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bus.entity.Booking" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Tickets</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-primary px-3">
    <span class="navbar-brand">&#x1F68C; Bus Registration System</span>
    <div>
        <a href="viewBuses" class="btn btn-outline-light btn-sm me-2">Browse Buses</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-4">
    <h5 class="mb-3">My Tickets</h5>

    <table class="table table-bordered table-hover bg-white">
        <thead class="table-primary">
            <tr>
                <th>#</th>
                <th>Bus Name</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Departure</th>
                <th>Passenger</th>
                <th>Seat No</th>
                <th>Booking Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Booking> myTickets = (List<Booking>) request.getAttribute("myTickets");
                if (myTickets != null && !myTickets.isEmpty()) {
                    int i = 1;
                    for (Booking b : myTickets) {
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= b.getBus().getBusName() %></td>
                <td><%= b.getBus().getSource() %></td>
                <td><%= b.getBus().getDestination() %></td>
                <td><%= b.getBus().getDepartureTime() %></td>
                <td><%= b.getPassengerName() %></td>
                <td><%= b.getSeatNo() %></td>
                <td><%= b.getBookingDate() %></td>
                <td>
                    <a href="cancelBooking?bookingId=<%= b.getId() %>"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('Cancel this ticket?')">Cancel</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="9" class="text-center">No tickets booked yet. <a href="viewBuses">Browse buses</a></td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
