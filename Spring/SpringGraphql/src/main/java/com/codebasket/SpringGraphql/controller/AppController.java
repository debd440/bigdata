package com.codebasket.SpringGraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebasket.SpringGraphql.service.AppService;

import graphql.ExecutionResult;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	//http://localhost:8080/books
	@PostMapping("books")
    public ResponseEntity<Object> getAllBooks(@RequestBody String query){
		
        ExecutionResult execute = appService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
	/*
	Request1
	---------------
	{ 
		allBooks { 
			isn
			title
			author 
			publisher 
		} 
	}
	
	Request2
	---------------
	book(id: "1001")
	{ 
		isn
		title
		publisher 
	}
	
	Request3- Combination of Both Request
	---------------
	{ 
	book(id: "1001")
	{ 
		isn
		title
		publisher 
	}
	
	allBooks
	{
	title
	}
}
	*/
}
