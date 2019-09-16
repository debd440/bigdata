package com.codebasket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication // Triggers EnableAutoConfiguration,ComponentScan & Configuration
//@EnableAutoConfiguration // Load configurations automatically
@ComponentScan({ "com.codebasket.controller", "com.codebasket.filter", "com.codebasket.handler",
		"com.codebasket.router" }) // Scan all folders
@Import({ AppConfiguration.class }) // Import Other Resources
public class CodeBasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

}
