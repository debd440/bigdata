package com.codebasket.SpringAopTutorials.service;

import org.springframework.stereotype.Component;

import com.codebasket.SpringAopTutorials.model.Employee;

@Component
public class AppService {

	public Employee createEmployee(String name, String empId) {

		Employee emp = new Employee(empId, name);
		return emp;
	}
}
