package com.obeid.springboot.thymleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obeid.springboot.thymleafdemo.dao.EmployeeRepository;
import com.obeid.springboot.thymleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; 

	@Override
	public List<Employee> findAll() {
		// 
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee employee = null;
		if(result.isPresent())
			employee = result.get();
		else
			// employee not found
			throw new RuntimeException("Employ not found: id=" + theId);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);

	}

}
