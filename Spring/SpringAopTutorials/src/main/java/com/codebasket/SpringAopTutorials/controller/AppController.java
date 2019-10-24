package com.codebasket.SpringAopTutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.SpringAopTutorials.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping(value = "invoke", method = RequestMethod.GET)
	public ResponseEntity<String> check() {

		System.out.println("Request Has been rceived");
		appService.createEmployee("Ram", "E1234");
		return new ResponseEntity<>("Aspect is working", HttpStatus.OK);
	}
}
