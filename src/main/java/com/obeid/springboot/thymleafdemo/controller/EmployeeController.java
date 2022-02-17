package com.obeid.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obeid.springboot.thymleafdemo.entity.Employee;
import com.obeid.springboot.thymleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// Get: employees/list
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employees/employee-list";
	}
	
	// get : employees/ShowAddForm
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		
		return "employees/employee-form";
		
	}
	
	// post: /employees/save
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	
	
	
}
