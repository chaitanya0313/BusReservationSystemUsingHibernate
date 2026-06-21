<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Bus</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">&#x1F68C; Bus System - Admin</span>
    <div>
        <a href="viewBuses" class="btn btn-outline-light btn-sm me-2">View Buses</a>
        <a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width:500px;">
        <h5 class="mb-3">Add New Bus</h5>

        <form action="addBus" method="post">
            <div class="mb-3">
                <label class="form-label">Bus Name</label>
                <input type="text" name="busName" class="form-control" placeholder="e.g. Express 101" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Source</label>
                <input type="text" name="source" class="form-control" placeholder="e.g. Mumbai" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Destination</label>
                <input type="text" name="destination" class="form-control" placeholder="e.g. Pune" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Departure Time</label>
                <input type="text" name="departureTime" class="form-control" placeholder="e.g. 08:00 AM" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Total Seats</label>
                <input type="number" name="totalSeats" class="form-control" min="1" placeholder="e.g. 40" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Add Bus</button>
        </form>
    </div>
</div>

</body>
</html>
