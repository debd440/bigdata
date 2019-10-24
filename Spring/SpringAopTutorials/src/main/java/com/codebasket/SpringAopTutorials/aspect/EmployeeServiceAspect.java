package com.codebasket.SpringAopTutorials.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.codebasket.SpringAopTutorials.service..*(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {

		System.out.println("*********************************************");
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	@After(value = "execution(* com.codebasket.SpringAopTutorials.service..*(..)) and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {

		System.out.println("*********************************************");
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}

	//Around override before feature
	//@Around(value = "execution(* com.codebasket.SpringAopTutorials.service..*(..)) and args(name,empId)")
	public void aroundAdvice(JoinPoint joinPoint, String name, String empId) {

		System.out.println("*********************************************");
		System.out.println("Around method:" + joinPoint.getSignature());
		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}

	@AfterReturning(value = "execution(* com.codebasket.SpringAopTutorials.service..*(..)) and args(name,empId)")
	public void afterReturningAdvice(JoinPoint joinPoint, String name, String empId) {

		System.out.println("*********************************************");
		System.out.println("After Returning method:" + joinPoint.getSignature());
		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
}
