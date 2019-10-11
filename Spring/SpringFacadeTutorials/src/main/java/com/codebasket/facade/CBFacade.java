package com.codebasket.facade;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.codebasket.model.EmployeeTo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class CBFacade {

	@HystrixCommand(fallbackMethod = "fallBack")
	public EmployeeTo executeFallBack(String id) {

		System.out.println("We are in Facade.Executing External Call");
		String url = "http://localhost:9912/api/v2/react/student/2";
		RestTemplate restTemplate = new RestTemplate();
		// Approach 1
		ResponseEntity<EmployeeTo> result = restTemplate.exchange(url, HttpMethod.GET, null, EmployeeTo.class);
		System.out.println("Status: " + result.getStatusCode());
		EmployeeTo employee = result.getBody();
		return employee;
	}

	public EmployeeTo fallBack(String id, Throwable ex) {
		System.out.println("FallBack Executed. " + ex.getMessage());
		return null;
	}

	@HystrixCommand(fallbackMethod = "healthcheckFB")
	public EmployeeTo healthcheck(String id) {

		System.out.println("We are in Facade.Executing External Call");
		String url = "http://dummy.restapiexample.com/api/v1/employee/1";
		RestTemplate restTemplate = new RestTemplate();
		// Approach 1
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println("Status: " + result.getStatusCode());
		return null;
	}

	public EmployeeTo healthcheckFB(String id, Throwable ex) {
		System.out.println("FallBack Executed. " + ex.getMessage());
		return null;
	}
}
