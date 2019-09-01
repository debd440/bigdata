package com.deb.codebasket.java9;

import java.util.List;

public class CollectionChangesTest {

	public static void main(String[] args) {
		// Empty List
		List immutableList = List.of();
		// With Elements
		List list = List.of("one", "two", "three");
		System.out.println("Immutable List: " + immutableList);
		System.out.println("List: " + list);
	}
}
