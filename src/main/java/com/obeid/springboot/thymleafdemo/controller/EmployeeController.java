package com.obeid.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obeid.springboot.thymleafdemo.entity.Employee;
import com.obeid.springboot.thymleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// list all emoloyees
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employees/employee-list";
	}
	
	// open empty form
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		
		return "employees/employee-form";
		
	}
	
	// open filled form
	
		@PostMapping("/showUpdateForm")
		public String showUpdateForm(@RequestParam("id") int id, Model model) {
			
			Employee employee = employeeService.findById(id);
			model.addAttribute("employee", employee);
			
			return "employees/employee-form";
			
		}
	
	// save/ update employee
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	// delete by id
	
	@PostMapping("/delete")
	public String deleteById(@RequestParam("id") int id ) {
		
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
	
	
	
}
