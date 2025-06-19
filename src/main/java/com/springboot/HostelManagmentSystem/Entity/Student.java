package com.springboot.HostelManagmentSystem.Entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
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
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	    name = "UUID",
	    strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
	    private UUID id;

	    private String name;
	    private String email;
	    private String phone;
	    private String address;
	 // FK to Room
	    
	    @ManyToOne
	    @JoinColumn(name = "room_id", columnDefinition = "BINARY(16)")  // foreign key column in student table
	    private Room room;
	    
	    
		public Room getRoom() {
			return room;
		}
		public void setRoom(Room room) {
			this.room = room;
		}
		public UUID getId() {
			return id;
		}
		public void setId(UUID id) {
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
