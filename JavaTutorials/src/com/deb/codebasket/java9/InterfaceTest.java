package com.deb.codebasket.java9;

public interface InterfaceTest {

	default void add() {
		show();
	}

	private void show() {
		System.out.println("Private method Implementation");
	}
}
