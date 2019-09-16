package com.codebasket.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.model.StudentTo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/react/")
public class ReactiveController {

	static Map<String, StudentTo> studentList = new HashMap<>();
	static {

		studentList.put("1", new StudentTo("1", "StudentTo 1"));
		studentList.put("2", new StudentTo("2", "StudentTo 2"));
		studentList.put("3", new StudentTo("3", "StudentTo 3"));
		studentList.put("4", new StudentTo("4", "StudentTo 4"));
		studentList.put("5", new StudentTo("5", "StudentTo 5"));
		studentList.put("6", new StudentTo("6", "StudentTo 6"));
		studentList.put("7", new StudentTo("7", "StudentTo 7"));
		studentList.put("8", new StudentTo("8", "StudentTo 8"));
		studentList.put("9", new StudentTo("9", "StudentTo 9"));
		studentList.put("10", new StudentTo("10", "StudentTo 10"));
	}

	// Mono Example
	// URL: http://localhost:8080/api/v1/react/student/7
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<StudentTo> monoRequest(@PathVariable String id) {

		System.out.println("Mono Request Made for Id: " + id);
		return Mono.just(studentList.get(id));
	}

	// Flux Example
	// URL: http://localhost:8080/api/v1/react/student
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Flux<StudentTo> fluxRequest() {

		System.out.println("Flux Request Received ");
		return Flux.fromIterable(studentList.values());
	}
}
