package com.codebasket.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.model.StudentTo;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

	// Can Handle Any type of request like GET,POST,PUT,DELETE,PATCH
	// GetMapping,PostMapping,PutMapping,PutMapping,PatchMapping are internally
	// using RequestMapping as alias
	// URL: http://localhost:8080/api/v1/healthcheck
	// @RequestMapping("healthcheck")
	// @RequestMapping(value = "healthcheck")
	@RequestMapping(path = "healthcheck")
	public String healthcheck() {
		return "Healthcheck is working";
	}

	// Get Mapping Handles Get Request Only
	// URL: http://localhost:8080/api/v1/healthcheck/get
	@GetMapping(value = "healthcheck/get")
	public String getHealthcheck() {
		return "Get Healthcheck is working";
	}

	// Real time Declaration
	// URL: http://localhost:8080/api/v1/check
	@RequestMapping(value = "check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> check() {
		return new ResponseEntity<>("Check Method is working", HttpStatus.OK);
	}

	// Get Request - Path param
	// URL: http://localhost:8080/api/v1/path-param/12
	@RequestMapping(value = "path-param/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> pathParam(@PathVariable String id) {
		return new ResponseEntity<>("Path Param Method is working for Id: " + id, HttpStatus.OK);
	}

	// Get Request - Query param
	// URL: http://localhost:8080/api/v1/query-param?name=Rahul&city=Bangalor
	@RequestMapping(value = "query-param", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> queryParam(@RequestParam("name") String nameData,
			@RequestParam("city") String cityData) {
		return new ResponseEntity<>("Query Param Method is working for Name: " + nameData + " City: " + cityData,
				HttpStatus.OK);
	}

	// Delete Request
	// URL: http://localhost:8080/api/v1/delete/12
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity<>("Delete Method is working for Id: " + id, HttpStatus.OK);
	}

	// Post Request
	// URL: http://localhost:8080/api/v1/student
	// Request: {"name":"Rahul","city":"BLR"}
	@RequestMapping(value = "student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insert(@RequestBody StudentTo request) {
		return new ResponseEntity<>(
				"Post Method is working for Name: " + request.getName() + " City: " + request.getCity(), HttpStatus.OK);
	}

	// Put Request
	// URL: http://localhost:8080/api/v1/student/11
	// Request: {"name":"Rahul","city":"BLR"}
	@RequestMapping(value = "student/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody StudentTo request) {
		return new ResponseEntity<>(
				"Put Method is working for Id: " + id + " Name: " + request.getName() + " City: " + request.getCity(),
				HttpStatus.OK);
	}

	// Patch Request
	// URL: http://localhost:8080/api/v1/student/11
	// Request: {"name":"Rahul","city":"BLR"}
	@RequestMapping(value = "student/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> partialUpdate(@PathVariable String id, @RequestBody StudentTo request) {
		return new ResponseEntity<>(
				"Patch Method is working for Id: " + id + " Name: " + request.getName() + " City: " + request.getCity(),
				HttpStatus.OK);
	}

	// Send Json Response
	// Post Request
	// URL: http://localhost:8080/api/v1/student
	// Request: {"name":"Rahul","city":"BLR"}
	@RequestMapping(value = "student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentTo> retrieve(@PathVariable String id) {
		StudentTo student = new StudentTo("Rahul", "Mumbai");
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	// Request Header
	// URL: http://localhost:8080/api/v1/header/12
	@RequestMapping(value = "header/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> header(@RequestHeader("X-USER_ID") String userId, @PathVariable String id) {
		return new ResponseEntity<>("Header Method is working for Id: " + id + " & X-USER_ID: " + userId,
				HttpStatus.OK);
	}

	// Post Request With JSON Array
	// URL: http://localhost:8080/api/v1/student/array
	// Request: [{"name":"Rahul","city":"BLR"},{"name":"Sachin","city":"MUM"}]
	@RequestMapping(value = "student/array", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertArray(@RequestBody List<StudentTo> request) {
		
		request.stream().forEach(System.out::println);
		return new ResponseEntity<>("Multi Param Value Received", HttpStatus.OK);
	}
}
