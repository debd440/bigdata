package com.deb.bigdatatutorials;

import java.util.Random;

public class Project {

	
	public static void main(String[] args) {
		
		 String[] name ={"Pankaj","Kumar","Priya","Chad","Stephen","Rahul","Shreya","Sudip","Sunil",
				 "Sasi","Raj","Ajay","Gaurav","Sandip","Meera","Mohan","Manu","Narendra","Chandra","Leela","Koel","Paul","Maria"};
		 String[] product={"Milk","Wheat","Rice","Chocolate","Biscuit","Salt","Soyabin","Dal","Soap","Masala"};
		 String fruits[]={"Mango","Apple","Dates","Banana","Coconuts","Grapes"};
		 Random r = new Random();
		 for (int i = 0; i < 1000; i++) {
			 int randomName =r.nextInt(((name.length-1)- 0) + 1) + 0;
			 int productName1 =r.nextInt(((product.length-1)- 0) + 1) + 0;
			 int productName3 =r.nextInt(((fruits.length-1)- 0) + 1) + 0;
			 int price =r.nextInt((200- 50) + 1) + 50;
			 int date =r.nextInt((30- 1) + 1) + 1;
			 System.out.println(name[randomName]+","+date+"/1/2018,"+product[productName1]+","+fruits[productName3]+","+price);
		}
		 
	}
}
