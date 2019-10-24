package com.codebasket.SpringJwtDemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan({ "com.codebasket.SpringJwtDemo.controller", "com.codebasket.SpringJwtDemo.security",
		"com.codebasket.SpringJwtDemo.model", "com.codebasket.SpringJwtDemo.service" })
@Import({ AppConfig.class })
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecurityApplication.class);
	}

	// Generate Password from https://bcrypt-generator.com/ set in userdetails
	// service
	// To generate token call -http://localhost:8080/authenticate
	// http://localhost:8080/authenticate to get token
//	{
//		"username":"codebasket",
//		"password":"password"
//	}
	// http://localhost:8080/healthcheck- pass token in header
}
