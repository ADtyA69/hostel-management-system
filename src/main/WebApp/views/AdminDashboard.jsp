<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 10px;
            transition: transform 0.2s ease-in-out;
        }
        .card:hover {
            transform: scale(1.05);
        }
        .dashboard-header {
            margin: 30px 0 40px 0;
            text-align: center;
            color: #343a40;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">Hostel Admin Panel</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="/admin/rooms">Manage Rooms</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/students">Manage Students</a></li>
                <li class="nav-item"><a class="nav-link" href="/login">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <h1 class="dashboard-header">Welcome, Admin!</h1>

    <div class="row g-4">

        <div class="col-md-4">
            <div class="card text-white bg-success">
                <div class="card-body">
                    <h5 class="card-title">Total Rooms</h5>
                    <p class="card-text display-4">${totalRooms}</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-white bg-info">
                <div class="card-body">
                    <h5 class="card-title">Total Students</h5>
                    <p class="card-text display-4">${totalStudents}</p> <!-- Add dynamic later -->
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-white bg-warning">
                <div class="card-body">
                    <h5 class="card-title">Available Rooms</h5>
                    <p class="card-text display-4">${availableRooms}</p> <!-- Add dynamic later -->
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Bootstrap 5 JS bundle CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>