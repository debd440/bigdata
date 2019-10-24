package com.codebasket.SpringAopTutorials.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({ "com.codebasket.SpringAopTutorials.controller", "com.codebasket.SpringAopTutorials.aspect",
		"com.codebasket.SpringAopTutorials.model", "com.codebasket.SpringAopTutorials.service" })
public class CodeBasketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodeBasketApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CodeBasketApplication.class);
	}

//	An important term in AOP is advice. It is the action taken by an aspect at a particular join-point.
//	Joinpoint is a point of execution of the program, such as the execution of a method or the handling of an exception. In Spring AOP, a joinpoint always represents a method execution.
//	Pointcut is a predicate or expression that matches join points.
//	Advice is associated with a pointcut expression and runs at any join point matched by the pointcut.

//    Before - the advice functionality takes place before the advised method is invoked.
//    After - the advice functionality takes place after the advised method completes, regardless of the outcome.
//    AfterReturning - returning the advice functionality takes place after the advised method successfully completes.
//    AfterThrowing - throwing the advice functionality takes place after the advised method throws an exception.
//    Around - the advice wraps the advised method, providing some functionality before and after the advised method is invoked.

}
