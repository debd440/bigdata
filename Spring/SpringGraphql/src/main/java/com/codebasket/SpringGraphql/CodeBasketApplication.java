package com.codebasket.SpringGraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.codebasket.SpringGraphql.config.AppConfiguration;

@SpringBootApplication
@Import({ AppConfiguration.class })
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}
}
