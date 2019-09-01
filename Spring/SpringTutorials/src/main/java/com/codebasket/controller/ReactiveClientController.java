package com.codebasket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.codebasket.model.StudentTo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/react/client")
public class ReactiveClientController {

	WebClient client = WebClient.create("http://localhost:8080");

	// Mono Example
	// URL: http://localhost:8080/api/v1/react/client/student/5
	@RequestMapping(value = "student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentTo> monoExample(@PathVariable String id) {

		Mono<StudentTo> studentMono = client.get().uri("/api/v1/react/student/" + id, "1").retrieve()
				.bodyToMono(StudentTo.class);

		StudentTo result=studentMono.block();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// Flux Example
	// URL: http://localhost:8080/api/v1/react/client/student
	@RequestMapping(value = "student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fluxExample() {

		Flux<StudentTo> studentFlux = client.get().uri("/api/v1/react/student", "1").retrieve()
				.bodyToFlux(StudentTo.class);

		studentFlux.subscribe(System.out::println);
		return new ResponseEntity<>("Flux Example is working for Id: ", HttpStatus.OK);
	}
}
