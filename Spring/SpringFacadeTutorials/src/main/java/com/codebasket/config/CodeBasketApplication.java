package com.codebasket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication // Triggers EnableAutoConfiguration,ComponentScan & Configuration
@EnableAutoConfiguration // Load configurations automatically
@ComponentScan({ "com.codebasket.controller", "com.codebasket.facade", "com.codebasket.model",
		"com.codebasket.service" }) // Scan all folders
@Import({ AppConfiguration.class }) // Import Other Resources
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableHystrix
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}
	//Dashboard URl- http://localhost:9091/hystrix
	//Acculator Stream-  http://localhost:9091/actuator/hystrix.stream
}
