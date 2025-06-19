<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Rooms</title>
<meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Rooms List</h2>
    <a href="/admin/rooms/add" class="btn btn-primary mb-3">Add New Room</a>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
            <!--    <th>ID</th> -->
            <th>Room Number</th>
            <th>Type</th>
            <th>Capacity</th>
            <th>Occupied</th>
            <th>Status</th>
            <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
               <%--  <td>${room.id}</td> --%>
                <td>${room.roomNumber}</td>
                <td>${room.type}</td>
                <td>${room.capacity}</td>
                <td>${room.occupied}</td>
                <td>${room.status}</td>
                    <td>
<form action="/admin/rooms/edit" method="post" style="display:inline;">
    <input type="hidden" name="id" value="${room.id}" />
    <button type="submit" class="btn btn-sm btn-warning">Edit</button>
</form>

<form action="/admin/rooms/delete" method="post" style="display:inline;" onsubmit="return confirm('Are you sure to delete this room?');">
    <input type="hidden" name="id" value="${room.id}" />
    <button type="submit" class="btn btn-sm btn-danger">Delete</button>
</form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
    window.addEventListener( "pageshow", function ( event ) {
        if (event.persisted || (window.performance && window.performance.navigation.type === 2)) {
            // Force reload when page is loaded from cache
            window.location.reload();
        }
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>