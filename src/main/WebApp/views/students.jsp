<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
    <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">All Students</h2>
    <a href="/students/add" class="btn btn-primary mb-3">Add New Student</a>
    
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
               <!--  <th>ID</th> -->
                <th>Name</th>
                <th>Email</th>
                <th>Room Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                  <%--   <td>${student.id}</td> --%>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.room.roomNumber}</td>
                    <td>
                        <a href="/students/edit/${student.id}" class="btn btn-sm btn-warning">Edit</a>
                        <a href="/students/delete/${student.id}" class="btn btn-sm btn-danger">Delete</a>
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
</body>
</html>