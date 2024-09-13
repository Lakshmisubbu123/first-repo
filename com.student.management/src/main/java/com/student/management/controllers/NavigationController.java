package com.student.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	@GetMapping("/openAddStudentPage")
	public String openAddStudentPage() {
		return "addStudent";
	}
	@GetMapping("/openDeleteStudentPage")
	public String openDeleteStudentPage() {
		return "deleteStudent";
	}
	@GetMapping("/searchStudents")
	public String searchStudents() {
		return "searchStudent";
	}
	@GetMapping("/fetchAllStudent")
	public String fetchAllStudent() {
		return "fetchStudent";
	}
	@GetMapping("/openUpdateStudentPage")
	public String openUpdateStudentPage() {
		return "updateStudent";
	}
	
}
