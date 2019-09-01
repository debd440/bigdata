package com.deb.codebasket.java8;

public class JoinStringTest {

	public static void main(String[] args) {

		String a = "Hello";
		String b = "World";
		String c = "B2C";
		System.out.println(a + " " + b + " " + c);
		System.out.println("" + String.join(" ", a, b, c));
	}
}
