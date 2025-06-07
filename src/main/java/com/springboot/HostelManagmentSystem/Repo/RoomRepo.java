package com.springboot.HostelManagmentSystem.Repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.springboot.HostelManagmentSystem.Entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>  
{

	
	 Room findByRoomNumber(String roomNumber);
	 
	  List<Room> findByStatus(String status);

	    @Query("SELECT COUNT(r) FROM Room r WHERE r.status = 'available'")
	    int countAvailableRooms();
}
