package com.deb.codebasket.scenario;

import java.util.ArrayList;
import java.util.Collection;

public class ConcurrentModificationTest {

	public static void main(String[] args) {
		
		 Collection<Integer> l = new ArrayList<Integer>();

		    for (int i=0; i < 10; ++i) {
		        l.add(new Integer(4));
		        l.add(new Integer(5));
		        l.add(new Integer(6));
		    }

		    for (Integer i : l) {
		        if (i.intValue() == 5) {
		            l.remove(i);
		        }
		    }

		    System.out.println(l);
	}
}
