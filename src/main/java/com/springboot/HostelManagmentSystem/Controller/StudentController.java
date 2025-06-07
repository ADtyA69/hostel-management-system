package com.springboot.HostelManagmentSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.HostelManagmentSystem.Dao.Roomdao;
import com.springboot.HostelManagmentSystem.Dao.Studentdao;
import com.springboot.HostelManagmentSystem.Entity.Room;
import com.springboot.HostelManagmentSystem.Entity.Student;


@Controller
public class StudentController {

	   @Autowired
	   private Studentdao studentdao;
	   
		@Autowired
		private Roomdao roomdao;
		

	    // Show all students
	    @GetMapping("/students")
	    public String getAllStudents(Model model) {
	    	List<Student> students = studentdao.getAllStudents(); 
	    	System.out.println("Students fetched: " + students.size());// ya jo bhi method hai dao mein
	        model.addAttribute("students", students);
	        return "students";  // students.jsp
	    }

	    // Show add student form
	    @GetMapping("/students/add")
	    public String showAddStudentForm(Model model) {
	        model.addAttribute("student", new Student());
	        model.addAttribute("rooms", roomdao.getAllRooms());
	        return "add_students";  // add_student.jsp
	    }

	    // Save student
	    @PostMapping("/students/save")
	    public String saveStudent(@ModelAttribute Student student,@RequestParam int roomId, Model model) {
	    	 
	    	try {
	            studentdao.assignStudentToRoom(student, roomId);
	        } catch (RuntimeException e) {
	            model.addAttribute("errorMessage", e.getMessage());
	            model.addAttribute("rooms", roomdao.getAllRooms());
	            model.addAttribute("student", student);
	            return "add_students"; // Show the form again with error
	        }
	        return "redirect:/students";
	    }

	    // Edit student
	    @GetMapping("/students/edit/{id}")
	    public String editStudent(@PathVariable int id, Model model) {
	    	Student student = studentdao.getStudentById(id);
	        model.addAttribute("student", student);
	        model.addAttribute("rooms", roomdao.getAllRooms());
	        return "add_students";  // reuse form
	    }

	    // Delete student
	    @GetMapping("/students/delete/{id}")
	    public String deleteStudent(@PathVariable int id) {
	        studentdao.deleteStudent(id);
	        return "redirect:/students";
	    }
}
