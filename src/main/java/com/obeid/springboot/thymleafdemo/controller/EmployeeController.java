package com.obeid.springboot.thymleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obeid.springboot.thymleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		Employee emp1 = new Employee(1,"Yaser","Obeid","yaser@mail.com");
		Employee emp2 = new Employee(2,"Modi","Maad","modi@mail.com");
		Employee emp3 = new Employee(3,"Sana","Saan","sana@mail.com");
		Employee emp4 = new Employee(4,"Nana","Naan","nan@mail.com");
		
		employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
	}
	
	// mapping for /list
	
	@GetMapping("/list")
	public String findAll(Model model) {
		model.addAttribute("employees", employees);
		return "employee-list";
	}
	
	
}
