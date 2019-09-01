package com.deb.codebasket.java8;

@FunctionalInterface
public interface IDepartment {

	default void add() {
		System.out.println("Department Interface- Add Method");
	}
	public void show();

}
