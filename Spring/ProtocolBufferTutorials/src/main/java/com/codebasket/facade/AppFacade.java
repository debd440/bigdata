package com.codebasket.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.codebasket.proto.Employee.EmployeeTo;
import com.codebasket.proto.StudentProto.StudentTo;

@Component
public class AppFacade {

	@Autowired
	private RestTemplate restTemplate;

	public StudentTo getStudent() {

		String url = "http://localhost:8080/healthCheck";
		HttpHeaders headers = new HttpHeaders();
		headers.add("X_USER_ID", "11221");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<StudentTo> result = restTemplate.exchange(url, HttpMethod.GET, entity, StudentTo.class);
		System.out.println("Respnse Received");
		StudentTo student = result.getBody();
		System.out.println("Name: " + student.getName());
		System.out.println("Email: " + student.getEmail());
		System.out.println("ID: " + student.getId());
		System.out.println("Subjects");
		student.getSubjectsList().forEach(System.out::println);
		return result.getBody();
	}
	
	public EmployeeTo getEmployee() {

		String url = "http://localhost:8080/consume";
		HttpHeaders headers = new HttpHeaders();
		headers.add("X_USER_ID", "11221");
		

		EmployeeTo employee = EmployeeTo.newBuilder().setId(12).setEmail("Ram@test.com").setName("Ram").build();
		HttpEntity<EmployeeTo> entity = new HttpEntity<>(employee, headers);
		
		ResponseEntity<EmployeeTo> result = restTemplate.exchange(url, HttpMethod.POST, entity, EmployeeTo.class);
		System.out.println("Respnse Received");
		EmployeeTo student = result.getBody();
		System.out.println("Name: " + student.getName());
		System.out.println("Email: " + student.getEmail());
		System.out.println("ID: " + student.getId());
		return result.getBody();
	}
}
