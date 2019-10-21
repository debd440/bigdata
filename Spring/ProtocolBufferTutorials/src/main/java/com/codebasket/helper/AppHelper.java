package com.codebasket.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebasket.facade.AppFacade;

@Component
public class AppHelper {
	
	@Autowired
	private AppFacade appFacade;
	
	public void getData() {
	//	appFacade.getStudent();
		appFacade.getEmployee();
	}

}
