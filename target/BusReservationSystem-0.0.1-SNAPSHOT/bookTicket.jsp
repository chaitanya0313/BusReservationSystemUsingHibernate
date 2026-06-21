<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Ticket</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-3">
    <span class="navbar-brand">&#x1F68C; Bus Registration System</span>
    <div>
        <a href="viewBuses" class="btn btn-outline-light btn-sm me-2">Back to Buses</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-5">
    <%
        com.bus.entity.Bus bus = (com.bus.entity.Bus) request.getAttribute("bus");
        List<Integer> availableSeatNumbers = (List<Integer>) request.getAttribute("availableSeatNumbers");
    %>
    <div class="card shadow p-4 mx-auto" style="max-width:500px;">
        <h5 class="mb-1">Book Ticket</h5>
        <p class="text-muted mb-3">
            <strong><%= bus.getBusName() %></strong> &nbsp;|&nbsp;
            <%= bus.getSource() %> &rarr; <%= bus.getDestination() %> &nbsp;|&nbsp;
            <%= bus.getDepartureTime() %>
        </p>

        <form action="bookTicket" method="post">
            <input type="hidden" name="busId" value="<%= bus.getId() %>">

            <div class="mb-3">
                <label class="form-label">Passenger Name</label>
                <input type="text" name="passengerName" class="form-control" placeholder="Enter passenger name" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Select Seat</label>
                <select name="seatNo" class="form-select" required>
                    <option value="">-- Choose a seat --</option>
                    <% for (Integer seat : availableSeatNumbers) { %>
                        <option value="<%= seat %>">Seat <%= seat %></option>
                    <% } %>
                </select>
            </div>

            <button type="submit" class="btn btn-success w-100">Confirm Booking</button>
        </form>
    </div>
</div>

</body>
</html>
