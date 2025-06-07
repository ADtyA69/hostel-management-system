package com.springboot.HostelManagmentSystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.HostelManagmentSystem.Entity.Room;
import com.springboot.HostelManagmentSystem.Entity.Student;
import com.springboot.HostelManagmentSystem.Repo.StudentRepo;

@Service
public class Studentdao {
	
	@Autowired
	private StudentRepo studentrepo;
	
	@Autowired
	private Roomdao roomdao;
	
	public List<Student> getAllStudents() {
        return studentrepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentrepo.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
    	studentrepo.save(student);
    }

    public void deleteStudent(int id) {
    	studentrepo.deleteById(id);
    }

	public int getTotalStudents() {
		// TODO Auto-generated method stub
		 return (int) studentrepo.count();
		
	}

	public void assignStudentToRoom(Student student, int newRoomId) {
	    
	    
	    Room newRoom = roomdao.getRoomById(newRoomId);
	    if (newRoom == null) {
	        throw new RuntimeException("Room not found");
	    }
	    if (newRoom.getOccupied() >= newRoom.getCapacity()) {
	        throw new RuntimeException("Room is already full");
	    }
	    //Assign room to student
	    Room oldRoom = null;

	    // Editing student case
	    if (student.getId() != 0) {
	        Student existingStudent = studentrepo.findById(student.getId()).orElse(null);
	        if (existingStudent != null && existingStudent.getRoom() != null) {
	            oldRoom = existingStudent.getRoom();

	            if (oldRoom.getId() != newRoomId) {
	                // Decrease old room occupied count
	                oldRoom.setOccupied(oldRoom.getOccupied() - 1);
	                roomdao.updateRoomStatus(oldRoom);
	            } else {
	                // If same room, no need to update counts again
	                student.setRoom(oldRoom);
	                studentrepo.save(student);
	                return;
	            }
	        }
	    }
	    // Update room status
	 // Set new room and increment occupied
	    newRoom.setOccupied(newRoom.getOccupied() + 1);
	    roomdao.updateRoomStatus(newRoom);
	    student.setRoom(newRoom);

	    studentrepo.save(student);
	}
	
	
}
