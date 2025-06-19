<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Add Room</title>
   <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">


    <div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
<h3 class="text-center">${room.id == null ? 'Add Room' : 'Edit Room'}</h3>
<input type="hidden" name="id" value="${room.id != null ? room.id : ''}"/>
        </div>
        <div class="card-body">
            <form action="/admin/rooms/save" method="post">
                <input type="hidden" name="id" value="${room.id}"/>

                <div class="form-group">
                    <label>Room Number</label>
                    <input type="text" name="roomNumber" class="form-control" value="${room.roomNumber}" required/>
                </div>

                <div class="form-group">
                    <label>Type</label>
                    <select name="type" class="form-control" required>
                        <option value="">--Select--</option>
                        <option value="Single" ${room.type == 'Single' ? 'selected' : ''}>Single</option>
                        <option value="Double" ${room.type == 'Double' ? 'selected' : ''}>Double</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Capacity</label>
                    <input type="number" name="capacity" class="form-control" value="${room.capacity}" min="1" required/>
                </div>

                <div class="form-group">
                    <label>Occupied</label>
                    <input type="number" name="occupied" class="form-control" value="${room.occupied}" min="0" required/>
                </div>

                <div class="form-group">
                    <label>Status</label>
                    <select name="status" class="form-control" required>
                        <option value="">--Select--</option>
                        <option value="Available" ${room.status == 'Available' ? 'selected' : ''}>Available</option>
                        <option value="Occupied" ${room.status == 'Occupied' ? 'selected' : ''}>Occupied</option>
                        <option value="Maintenance" ${room.status == 'Maintenance' ? 'selected' : ''}>Maintenance</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-success btn-block">Save</button>
                <a href="/rooms" class="btn btn-secondary btn-block">Cancel</a>
            </form>
        </div>
    </div>
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