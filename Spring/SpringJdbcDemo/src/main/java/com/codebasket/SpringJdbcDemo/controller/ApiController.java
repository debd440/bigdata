package com.codebasket.SpringJdbcDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.SpringJdbcDemo.service.ApiService;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@RequestMapping(value = "invoke", method = RequestMethod.GET)
	public ResponseEntity<String> insert() {

		apiService.execute();
		return new ResponseEntity<>("Dao Execution Success", HttpStatus.OK);
	}

}
