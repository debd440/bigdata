package com.deb.codebasket.java8;

public class InterfaceTest {

	public static void main(String[] args) {

		IStudent student = new StudentImpl();
		student.show();
		IStudent.display();

		IDepartment department = new DepartmentImpl();
		department.show();
		System.out.println("Testing Diamond Problem");
		DiamondClass diamond = new DiamondClass();
		diamond.add();
	}
}
