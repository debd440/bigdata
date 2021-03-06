package com.codebasket.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.swagger.model.StudentTo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Demo API Documentation", description = "Demo B2C API Documentation")
@RestController
@RequestMapping("/api/v3/")
public class SwaggerController {

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "student", tags = "student", response = ResponseEntity.class)
	@RequestMapping(value = "student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> insert(@RequestBody StudentTo request) {
		return new ResponseEntity<>(
				"Post Method is working for Name: " + request.getName() + " City: " + request.getCity(), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "student", tags = "student", response = ResponseEntity.class)
	@RequestMapping(value = "student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<StudentTo> retrieve(@PathVariable String id) {
		StudentTo student = new StudentTo("Rahul", "Mumbai");
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "delete", tags = "delete", response = ResponseEntity.class)
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String id) {
		return new ResponseEntity<>("Delete Method is working for Id: " + id, HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@ApiOperation(value = "student", tags = "student", response = ResponseEntity.class)
	@RequestMapping(value = "student/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody StudentTo request) {
		return new ResponseEntity<>(
				"Put Method is working for Id: " + id + " Name: " + request.getName() + " City: " + request.getCity(),
				HttpStatus.OK);
	}
}
