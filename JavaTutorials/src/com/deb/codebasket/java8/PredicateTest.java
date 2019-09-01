package com.deb.codebasket.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

	public static void main(String[] args) {

		 // Creating predicate 
        Predicate<Integer> lesserthan = i -> (i < 18);  
        // Calling Predicate method 
        System.out.println(lesserthan.test(10));  

        
        Predicate<Integer> greaterThanTen = (i) -> i > 10; 
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;  
        boolean value = greaterThanTen.and(lowerThanTwenty).test(15); 
        System.out.println(value); 
  
        
        List<String> students = new ArrayList<>();
		students.add("Ajay");
		students.add("Sunil");
		students.add("Ashish");
		students.add("Ramesh");
		List<String> result = students.stream().filter(item -> item.startsWith("R")).collect(Collectors.toList());
		result.forEach(System.out::println);
	}
}
