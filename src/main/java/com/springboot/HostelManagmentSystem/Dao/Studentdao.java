package com.springboot.HostelManagmentSystem.Dao;
import java.util.List;
import java.util.UUID;

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

	public Student getStudentById(UUID id) {
		return studentrepo.findById(id).orElse(null);
	}

	public void saveStudent(Student student) {
		studentrepo.save(student);
	}

	public void deleteStudent(UUID id) {
		studentrepo.deleteById(id);
	}

	public int getTotalStudents() {
		return (int) studentrepo.count();
	}

	public void assignStudentToRoom(Student student, UUID newRoomId) {
		Room newRoom = roomdao.getRoomById(newRoomId);
		if (newRoom == null) {
			throw new RuntimeException("Room not found");
		}
		if (newRoom.getOccupied() >= newRoom.getCapacity()) {
			throw new RuntimeException("Room is already full");
		}

		Room oldRoom = null;

		if (student.getId() != null) {
			Student existingStudent = studentrepo.findById(student.getId()).orElse(null);
			if (existingStudent != null && existingStudent.getRoom() != null) {
				oldRoom = existingStudent.getRoom();

				if (!oldRoom.getId().equals(newRoomId)) {
					oldRoom.setOccupied(oldRoom.getOccupied() - 1);
					roomdao.updateRoomStatus(oldRoom);
				} else {
					student.setRoom(oldRoom);
					studentrepo.save(student);
					return;
				}
			}
		}

		newRoom.setOccupied(newRoom.getOccupied() + 1);
		roomdao.updateRoomStatus(newRoom);
		student.setRoom(newRoom);
		studentrepo.save(student);
	}
}
