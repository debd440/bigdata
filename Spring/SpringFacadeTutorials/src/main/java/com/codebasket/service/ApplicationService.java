package com.codebasket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebasket.facade.ApplicationFacade;
import com.codebasket.facade.CBFacade;
import com.codebasket.model.EmployeeTo;

@Component
public class ApplicationService {

	@Autowired
	private ApplicationFacade applicationFacade;

	@Autowired
	private CBFacade cbFacade;

	public void getData() {

		// Get A Single Data
		// getEmployee();
		// Get All Data
		// getAllEmployee();

		// Post Data
		// postEmployee();

		// Delete
		// deleteEmployee();

		cbFacade.executeFallBack("12");
	}

	private void getEmployee() {
		EmployeeTo employee = applicationFacade.getEmployee();
		System.out.println("The Result is: ");
		System.out.println("Employee: " + employee);
	}

	private void getAllEmployee() {
		List<EmployeeTo> list = applicationFacade.getAllEmployee();
		System.out.println("The Result is: ");
		list.forEach(System.out::println);
	}

	private void postEmployee() {
		EmployeeTo employee = applicationFacade.postEmployee();
		System.out.println("The Result is: ");
		System.out.println("Employee: " + employee);
	}

	private void deleteEmployee() {
		applicationFacade.deleteEmployee();
	}

	public void healthcheck() {
		cbFacade.healthcheck("12");
	}

}
