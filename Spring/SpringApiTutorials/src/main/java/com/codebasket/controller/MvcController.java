package com.codebasket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String welcome() {
		return "login";
	}
}
