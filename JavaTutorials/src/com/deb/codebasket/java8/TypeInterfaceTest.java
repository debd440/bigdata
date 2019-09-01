package com.deb.codebasket.java8;

import java.util.ArrayList;
import java.util.List;

public class TypeInterfaceTest {

	public static void main(String[] args) {
		// Java 7 Declaration
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(11);
		showList(list1);
		// Java 8 Declaration
		List<Integer> list2 = new ArrayList<>();
		list2.add(12);
		showList(list2);
	}

	public static void showList(List<Integer> list) {
		if (!list.isEmpty()) {
			list.forEach(System.out::println);
		} else
			System.out.println("list is empty");
	}
}
