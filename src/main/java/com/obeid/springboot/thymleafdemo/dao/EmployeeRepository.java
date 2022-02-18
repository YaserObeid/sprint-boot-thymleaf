package com.obeid.springboot.thymleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obeid.springboot.thymleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// here will be add the methods if you need
	
	

}
