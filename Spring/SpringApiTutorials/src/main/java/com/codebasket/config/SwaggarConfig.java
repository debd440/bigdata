package com.codebasket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggarConfig {

	@Value("enable.swaggar")
	private String swaggarStatus;

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.codebasket.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).enable(Boolean.valueOf(swaggarStatus));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Demo API For B2C Training").description("Demo Api")
				.contact(new Contact("Deb", "www.b2c.com", "deb@jojodelivery.com")).version("1.0.0").build();
	}
}
