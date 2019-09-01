package com.deb.codebasket.java8;

import java.util.Optional;

public class OptionTest {

	public static void main(String[] args) {

		System.out.println("Example 1: Normal Values");
		Optional<Integer> item = Optional.of(5);
		System.out.println(item.isPresent());
		System.out.println(item.get());

		System.out.println("Example 2: Handling Null Values");
		Optional<Integer> data = Optional.ofNullable(null);
		if (data.isPresent()) {
			System.out.println(data.get());
		} else {
			System.out.println("Value not Available");
		}

		System.out.println("Example 3: Assigning Default Value");
		Optional<String> companyOptional = Optional.empty();
		String result = companyOptional.orElse("Hello");
		System.out.println("Result is: " + result);
	}
}
