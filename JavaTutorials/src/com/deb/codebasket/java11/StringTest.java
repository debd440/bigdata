package com.deb.codebasket.java11;

import java.util.stream.Collectors;

public class StringTest {

	public static void main(String[] args) {

		System.out.println("Introuction of IsBlank Method");
		String item = "";
		System.out.println(item.isBlank());

		System.out.println("Convert line into List");
		String str = "Java\nScala\nHBase";
		System.out.println(str.lines().collect(Collectors.toList()));
		
		System.out.println("Repeat operation");
		String word = "CodeBasket"; 
        System.out.println(word.repeat(3)); 
        
        System.out.println("Remove the white-space which is in-front of the string ");
        String word1 = " CodeBasket "; 
        System.out.println(word1.strip()); 
	}
}
