package com.codebasket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication // Triggers EnableAutoConfiguration,ComponentScan & Configuration
@EnableAutoConfiguration // Load configurations automatically
@ComponentScan({ "com.codebasket.controller", "com.codebasket.proto" }) // Scan all folders
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}

	@Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
	// Install Protobuf
	// sudo apt-get install autoconf automake libtool curl make g++ unzip
	// Download - https://github.com/protocolbuffers/protobuf/releases/tag/v3.6.1
	// Extract the contents and change in the directory
	// ./configure
	// make
	// make check
	// sudo make install
	// sudo ldconfig # refresh shared library cache.
	// To Compile- Go Inside Src/Main and
	// run protoc --java_out=java resources/Student.proto
	// Check Version - protoc --version

}
