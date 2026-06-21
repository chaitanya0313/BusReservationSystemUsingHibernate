<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-primary px-3">
    <span class="navbar-brand">&#x1F68C; Bus Registration System</span>
    <div>
        <span class="text-white me-3">Welcome, <%= session.getAttribute("name") %></span>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-5">
    <h4 class="mb-4">User Dashboard</h4>
    <div class="row g-4">

        <div class="col-md-6">
            <div class="card text-center p-4 shadow-sm">
                <h5>Browse Buses</h5>
                <p class="text-muted">Search and book available buses</p>
                <a href="viewBuses" class="btn btn-primary">View Buses</a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card text-center p-4 shadow-sm">
                <h5>My Tickets</h5>
                <p class="text-muted">View or cancel your bookings</p>
                <a href="myTickets" class="btn btn-success">My Tickets</a>
            </div>
        </div>

    </div>
</div>

</body>
</html>
