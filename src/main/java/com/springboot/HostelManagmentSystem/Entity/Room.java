package com.springboot.HostelManagmentSystem.Entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
	    private UUID id;

	    private String roomNumber;
	    private String type; // Single / Double
	    private int capacity;
	    private int occupied;
	    private String status;
	    
	    @OneToMany(mappedBy = "room")
	    private List<Student> students;
	    
	    
	    
		public List<Student> getStudents() {
			return students;
		}
		public void setStudents(List<Student> students) {
			this.students = students;
		}
		public UUID getId() {
			return id;
		}
		public void setId(UUID id) {
			this.id = id;
		}
		public String getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public int getOccupied() {
			return occupied;
		}
		public void setOccupied(int occupied) {
			this.occupied = occupied;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", capacity=" + capacity
					+ ", occupied=" + occupied + ", status=" + status + "]";
		}
		public Room(UUID id, String roomNumber, String type, int capacity, int occupied, String status) {
			super();
			this.id = id;
			this.roomNumber = roomNumber;
			this.type = type;
			this.capacity = capacity;
			this.occupied = occupied;
			this.status = status;
		}
		public Room() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    

}
