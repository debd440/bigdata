package com.deb.codebasket.java8;

import java.util.Arrays;

public class ParallelArraySortingTest {

	public static void main(String[] args) {
		
		int[] arr = {5,8,1,0,6,9};  
		Arrays.parallelSort(arr);
        System.out.println("\nArray elements after sorting");  
        // Iterating array elements  
        for (int i : arr) {  
            System.out.print(i+" ");  
        }  
	}
}
