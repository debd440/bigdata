package com.deb.codebasket.java8;

@FunctionalInterface
public interface IStudent {

	public void show();

	// public void display(); //Error Only 1 Abstract Method Allowed

	public static void display() {
		System.out.println("Hello, New Static Method Here");
	}

	// Can not have static method with default
	default void substract() {
		System.out.println("Student Interface- Substract Method");
	}

	default void add() {
		System.out.println("Student Interface- Add Method");
	}
}
