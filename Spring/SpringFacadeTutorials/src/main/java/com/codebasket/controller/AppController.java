package com.codebasket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.service.ApplicationService;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

	@Autowired
	private ApplicationService applicationService;

	// localhost:8080/api/v1/invoke
	// http://dummy.restapiexample.com/
	@RequestMapping(value = "invoke", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> check() {

		System.out.println("Request Has been rceived");
		applicationService.getData();
		return new ResponseEntity<>("Facade is working", HttpStatus.OK);
	}

	@RequestMapping(value = "healthcheck", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck() {

		System.out.println("Request Has been rceived");
		applicationService.healthcheck();
		return new ResponseEntity<>("Facade is working", HttpStatus.OK);
	}
}
