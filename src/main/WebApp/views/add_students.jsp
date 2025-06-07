<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Add/Edit Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	<meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">${student.id == 0 ? 'Add Student' : 'Edit Student'}</h2>

    <form action="/students/save" method="post">
        <input type="hidden" name="id" value="${student.id}"/>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" value="${student.name}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" value="${student.email}" required>
        </div>

       <div class="mb-3">
    <label class="form-label">Room</label>
   <select name="roomId">
        <c:forEach var="room" items="${rooms}">
            <option value="${room.id}" ${student.room != null && student.room.id == room.id ? 'selected' : ''}>
    Room ${room.roomNumber} - ${room.status} (${room.occupied}/${room.capacity})
</option>
        </c:forEach>
    </select><br/>

</div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="/students" class="btn btn-secondary">Cancel</a>
    </form>
    
    <c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
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