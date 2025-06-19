package com.springboot.HostelManagmentSystem.Controller;

import java.util.UUID;

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

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	
	@Autowired
	private Roomdao roomdao;
	
	   @Autowired
	   private Studentdao studentdao;
	   
	
	
	   @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";  // login.jsp
	    }
	
	   @GetMapping("/logout")
	   public String logout(HttpSession session) {
	       session.invalidate();  
	       return "redirect:/login";  
	   }
	   
	   @PostMapping("/login")
	    public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
	     
	        if (email.equals("admin@gmail.com") && password.equals("admin123")) {
	        	session.setAttribute("role", "admin");
	            session.setAttribute("userId", 0); 
	            return "redirect:/admin/dashboard";
	        } else {
	            model.addAttribute("errorMessage", "Invalid email or password");
	            return "login";
	        }
	    }

	    @GetMapping("/admin/dashboard")
	    public String showDashboard(Model model) {
	    	 int totalRooms = roomdao.getAllRooms().size();
	    	 int totalStudents = studentdao.getTotalStudents();
	    	
	    	  model.addAttribute("totalRooms", totalRooms);
	    	  model.addAttribute("totalStudents", totalStudents);
	    	    
	    	    int availableRooms = roomdao.getAvailableRooms(); // Optional, if implemented
	    	    model.addAttribute("availableRooms", availableRooms);
	        return "AdminDashboard"; 
	    }
	    
	    
	    @GetMapping("/admin/rooms")
	    public String getAllRooms(Model model) {
	        model.addAttribute("rooms", roomdao.getAllRooms());
	        return "rooms";  // rooms.jsp
	    }

	 
	    @GetMapping("/admin/rooms/add")
	    public String showAddRoomForm(Model model) {
	        model.addAttribute("room", new Room());
	        return "add_room";  // add-room.jsp
	    }

	    @PostMapping("/admin/rooms/save")
	    public String saveRoom(@ModelAttribute("room") Room room) {
	        roomdao.saveRoom(room);
	        return "redirect:/admin/rooms";
	    }

	    @PostMapping("/admin/rooms/edit")
	    public String editRoom(@RequestParam("id") UUID id, Model model) {
	        Room room = roomdao.getRoomById(id);
	        model.addAttribute("room", room);
	        return "add_room";  // returns to edit form with data filled
	    }

	    @PostMapping("/admin/rooms/delete")
	    public String deleteRoom(@RequestParam("id") UUID id) {
	        roomdao.deleteRoom(id);
	        return "redirect:/admin/rooms";
	    }
}
