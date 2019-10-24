package com.codebasket.SpringJwtDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Map<String, String>> healthcheck() {

		Map<String, String> healthCheck = new HashMap<>();
		healthCheck.put("methodName", "healthcheck");
		return new ResponseEntity<>(healthCheck, HttpStatus.OK);
	}
}
