package com.codebasket.facade;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.codebasket.model.EmployeeTo;

@Component
public class ApplicationFacade {

	public EmployeeTo getEmployee() {

		String url = "http://localhost:8080/api/v2/react/student/2";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X_USER_ID", "11221");
		headers.add("Authorization", "Basic dXNlcjp1c2VyUGFzcw==");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

		// Approach 1
		ResponseEntity<EmployeeTo> result = restTemplate.exchange(url, HttpMethod.GET, entity, EmployeeTo.class);

		// Approach 2
//		ResponseEntity<EmployeeTo> result = restTemplate.exchange(url, HttpMethod.GET, entity,
//				new ParameterizedTypeReference<EmployeeTo>() {
//				});

		// Approach 3- It does not support headers- HttpEntity<?> requestEntity is
		// missing in param
		// https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
//		ResponseEntity<EmployeeTo> result = restTemplate.getForEntity(url, EmployeeTo.class, entity);

		// Approach 4
		// EmployeeTo employee = restTemplate.getForObject(url, EmployeeTo.class,
		// entity);

		System.out.println("Status: " + result.getStatusCode());
		EmployeeTo employee = result.getBody();
		return employee;
	}

	public List<EmployeeTo> getAllEmployee() {

		String url = "http://localhost:8080/api/v2/react/student/";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X_USER_ID", "11221");
		headers.add("Authorization", "Basic dXNlcjp1c2VyUGFzcw==");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<EmployeeTo>> result = restTemplate.exchange(url, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<EmployeeTo>>() {
				});

		return result.getBody();
	}

	public EmployeeTo postEmployee() {

		String url = "http://localhost:8080/api/v2/react/student";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X_USER_ID", "11221");
		headers.add("Authorization", "Basic dXNlcjp1c2VyUGFzcw==");
		EmployeeTo employee = new EmployeeTo("Ram", "BLR");
		HttpEntity<EmployeeTo> entity = new HttpEntity<>(employee, headers);
		RestTemplate restTemplate = new RestTemplate();

		// Approach 1
		ResponseEntity<EmployeeTo> result = restTemplate.exchange(url, HttpMethod.POST, entity, EmployeeTo.class);

		// Approach 2
		// ResponseEntity<EmployeeTo> result = restTemplate.postForEntity(url, entity,
		// EmployeeTo.class);

		System.out.println("Status: " + result.getStatusCode());
		EmployeeTo item = result.getBody();
		return item;
	}

	public void deleteEmployee() {
		String url = "http://localhost:8080/api/v2/react/delete";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X_USER_ID", "11221");
		headers.add("Authorization", "Basic dXNlcjp1c2VyUGFzcw==");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		// Way 1
		restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
		// Way 2
		// restTemplate.delete(url, entity);

	}

	// Override timeouts in request factory
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		// Connect timeout
		clientHttpRequestFactory.setConnectTimeout(10_000);

		// Read timeout
		clientHttpRequestFactory.setReadTimeout(10_000);
		return clientHttpRequestFactory;
	}
}
