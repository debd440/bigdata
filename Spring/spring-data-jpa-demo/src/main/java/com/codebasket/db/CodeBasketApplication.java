package com.codebasket.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.codebasket.db.config.AppConfiguration;

@SpringBootApplication // Triggers EnableAutoConfiguration,ComponentScan & Configuration
@Import({ AppConfiguration.class }) // Import Other Resources
@EnableTransactionManagement(proxyTargetClass = true)
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}
	
	//https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-one-mapping-example/
	//https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
	//https://www.callicoder.com/hibernate-spring-boot-jpa-many-to-many-mapping-example/
}
