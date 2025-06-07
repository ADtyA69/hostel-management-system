package com.springboot.HostelManagmentSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.HostelManagmentSystem.Entity.Room;
import com.springboot.HostelManagmentSystem.Repo.RoomRepo;


@Service
public class Roomdao {

	@Autowired
	private RoomRepo roomrepo;
	
	 public List<Room> getAllRooms() {
	        return roomrepo.findAll();
	    }

	    public void saveRoom(Room room) {
	    	updateRoomStatus(room);
	        roomrepo.save(room);
	    }

	    public Room getRoomById(int id) {
	        return roomrepo.findById(id).orElse(null);
	    }

	    public void deleteRoom(int roomId) {
	    	  Room room = getRoomById(roomId);
	    	    if (room != null && room.getStudents() != null && !room.getStudents().isEmpty()) {
	    	        throw new RuntimeException("Cannot delete room. Students are assigned to this room.");
	    	    }	
	    	roomrepo.deleteById(roomId);
	    }
	    
	    public void updateRoomStatus(Room room) {
	        int occupied = room.getOccupied();
	        int capacity = room.getCapacity();

	        if (occupied == 0) {
	            room.setStatus("Available");
	        } else if (occupied < capacity) {
	            room.setStatus("Partially Occupied");
	        } else if (occupied == capacity) {
	            room.setStatus("Occupied");
	        } else {
	            room.setStatus("Overbooked"); // Just in case
	        }

	        roomrepo.save(room);
	    }
	    
		public int getAvailableRooms() {
			// TODO Auto-generated method stub
			 return roomrepo.countAvailableRooms();
		}
}
