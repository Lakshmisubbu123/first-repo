package com.student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.services.StudentService;

//@RestController //--->change 28/8/24
@Controller
public class StudentController {
	/*
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello From Spring Boot";
	}
	@GetMapping("/bye")
	public String sayBye()
	{
		return "Bye from spring boot";
	}
	@GetMapping("/data")
	public String acceptData(@PathVariable String data)
	{
		return "Data received:"+data;
	}
	@GetMapping("/data2")
	public String acceptValues(@RequestParam String d1,@RequestParam String d2)
	{
		return "Data received:"+d1+","+d2;
	}
	@GetMapping("/acceptStudent")
	public String acceptStudent(
			@RequestParam int roll,
			@RequestParam String name,
			@RequestParam String branch,
			@RequestParam int yop,
			@RequestParam double cgpa
			)
	{
		Student st=new Student(roll,name,branch,yop,cgpa);
		System.out.println(st);
		return "student data received";
	}
	@PostMapping("/acceptStudentObject")
	public String acceptStudentObject(@RequestBody Student st)
	{
		System.out.println(st);
		return "student data received";
	}
	*/
	@Autowired
	StudentService service;
	
	/*@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student st)
	{
		service.addStudent(st);
		return "student added successfully";
	} ------>27/8/24  */
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student st,Model model)
	{
		service.addStudent(st);
		model.addAttribute("student_added","student added succussfully");
		return "index";
	}/*
	@GetMapping("/searchStudent")
	public Student searchStudent(@RequestParam int roll) {
		return service.searchStudent(roll);
	} ---> 28/8/24*/
	// org.springframework.ui.Model;
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll,Model model) {
		Student st=service.searchStudent(roll);
		model.addAttribute("student",st);
		return "displayStudent";
	}
	/*
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student st)
	{
		service.updateStudent(st);
		return "student updated successfully";
	}
	*/
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st,Model model)
	{
		service.updateStudent(st);
		model.addAttribute("student_updated","student updated succussfully");
		return "index";
	}
	/*
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll) {
		service.deleteStudent(roll);
		return "student deleted successfully";
	}*/
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll,Model model) {
		service.deleteStudent(roll);
		model.addAttribute("student_deleted","student deleted succussfully");
		return "index";
	}
	/*
	@GetMapping("/fetchAllStudent")
	public List<Student> fetchAllStudents()
	{
		return service.fetchAllStudents();
	}-->28/8/24
	*/
	@GetMapping("/fetchAllStudents")
	public String fetchAllStudents(Model model)
	{
		List<Student>stList=service.fetchAllStudents();
		model.addAttribute("studentList",stList);
		return "displayAllStudents";
	}
	@GetMapping("/deleteAllStudents")
	public String deleteAllStudents(Model model)
	{
		service.deleteAllStudents();
		model.addAttribute("student_deleted","student deleted succussfully");
		return "index";
	}
}
