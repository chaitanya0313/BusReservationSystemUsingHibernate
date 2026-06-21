<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">&#x1F68C; Bus System - Admin</span>
    <div>
        <span class="text-white me-3">Welcome, <%= session.getAttribute("name") %></span>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-5">
    <h4 class="mb-4">Admin Dashboard</h4>
    <div class="row g-4">

        <div class="col-md-4">
            <div class="card text-center p-4 shadow-sm">
                <h5>Add Bus</h5>
                <p class="text-muted">Add a new bus to the system</p>
                <a href="addBus" class="btn btn-primary">Add Bus</a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-center p-4 shadow-sm">
                <h5>View All Buses</h5>
                <p class="text-muted">Manage buses and view passengers</p>
                <a href="viewBuses" class="btn btn-secondary">View Buses</a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-center p-4 shadow-sm">
                <h5>All Bookings</h5>
                <p class="text-muted">View all bookings in the system</p>
                <a href="viewAllBookings" class="btn btn-info text-white">View Bookings</a>
            </div>
        </div>

    </div>
</div>

</body>
</html>
