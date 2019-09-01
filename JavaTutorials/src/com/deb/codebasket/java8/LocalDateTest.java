package com.deb.codebasket.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDateTest {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.isSet(6);
		System.out.println("Current Time: "+calendar.getTime());
		
		System.out.println("Local Date Example");
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());                
		System.out.println(localDate.getDayOfWeek().toString()); 

		System.out.println("Local Time Example");
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.toString());    
		System.out.println(localTime.getHour());     
		
		System.out.println("LocalDateTime Example");
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toString());      
		System.out.println(localDateTime.getDayOfMonth()); 
	}
}
