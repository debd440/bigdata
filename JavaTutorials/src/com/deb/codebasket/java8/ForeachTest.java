package com.deb.codebasket.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ForeachTest {

	public static void main(String args[]) {

		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		// Example 1
		System.out.println("Example 1: Simple Examle for For Each using List");
		numberList.forEach(System.out::println);

		
		// Example 2
		System.out.println("Example 2: Define Action");
		Consumer<Integer> action = System.out::println;
		numberList.forEach(action);

		
		System.out.println("Example 3: Using Map");
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		// 1. Map entries
		System.out.println("Normal key & Values");
		map.entrySet().forEach(System.out::println);
		System.out.println("Map Keys");
		// 2. Map keys
		Consumer<String> actionOnKeys = System.out::println;
		map.keySet().forEach(actionOnKeys);
		System.out.println("Map Values");
		// 3. Map values
		Consumer<Integer> actionOnValues = System.out::println;
		map.values().forEach(actionOnValues);

		
		System.out.println("Example 4:Custom Action");
		Consumer<Map.Entry<String, Integer>> customAction = entry -> {
			System.out.println("Key is : " + entry.getKey());
			System.out.println("Value is : " + entry.getValue());
		};
		map.entrySet().forEach(customAction);

	}
}
