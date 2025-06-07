package com.springboot.HostelManagmentSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;
	    private String email;
	    private String phone;
	    private String address;
	 // FK to Room
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "room_id")  // foreign key column in student table
	    private Room room;
	    
	    
		public Room getRoom() {
			return room;
		}
		public void setRoom(Room room) {
			this.room = room;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
//		public int getRoomId() {
//			return roomId;
//		}
//		public void setRoomId(int roomId) {
//			this.roomId = roomId;
//		}
		
	    
	    
}
