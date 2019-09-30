package com.codebasket.swagger.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // Triggers EnableAutoConfiguration,ComponentScan & Configuration
@EnableAutoConfiguration // Load configurations automatically
@EnableSwagger2
@ComponentScan({ "com.codebasket.swagger.controller", "com.codebasket.swagger.model" }) // Scan all folders
@Import({ AppConfiguration.class, SwaggerConfig.class }) // Import Other Resources
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}
}
