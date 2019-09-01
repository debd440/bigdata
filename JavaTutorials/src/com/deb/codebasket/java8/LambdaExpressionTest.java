package com.deb.codebasket.java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionTest {

	public static void main(String[] args) {
		
		List<String> students = new ArrayList<>();
		students.add("Ajay");
		students.add("Sunil");
		students.forEach(item->{
			System.out.println("Available Values: "+item);
		});
		
		List<Integer> numberList= new ArrayList<Integer>();
		numberList.add(12);
		numberList.add(15);
		numberList.add(25);
		numberList.forEach(item->{
			Integer result = item*10;
			System.out.println("Result: "+result);
		});
		
		for(int i=0;i<students.size();i++) {
			String name= students.get(i);
			System.out.println("Name: "+name);
		}
	}
}
