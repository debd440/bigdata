package com.deb.codebasket.java12;

public class SwitchTest {

	public static void main(String[] args) {

		System.out.println("Before Java 12");
		int day = 2;
		String dayString;
		switch (day) {
			case 1: {
				dayString = "Monday";
				break;
			}
			case 2: {
				dayString = "Tuesday";
				break;
			}
			default: {
				dayString = "Invalid day";
				break;
			}
		}
		System.out.println(dayString);

		
		System.out.println("From Java 12");
		System.out.println("Enhanced Switch Statement:");
		final int flag = 2;
		String numericString;
		switch (flag) {
		case 1 -> numericString = "one";
		case 2 -> numericString = "two";
		case 3 -> numericString = "three";
		default -> numericString = "N/A";
		}
		System.out.println("\t" + flag + " ==> " + numericString);

		System.out.println("Return Statement");
		int result = switch (flag) {
		case 1 -> 10;
		case 2 -> 20;
		case 3 -> 40;
		default -> 50;
		};
		System.out.println("Result: " + result);
	}
}
