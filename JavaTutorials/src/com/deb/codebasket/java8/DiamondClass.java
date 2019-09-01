package com.deb.codebasket.java8;

public class DiamondClass implements IStudent,IDepartment{

	@Override
	public void show() {
		System.out.println("calling Diamond Class Show");
	}

	@Override
	public void add() {
		IDepartment.super.add();
	}

}
