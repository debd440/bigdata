package com.codebasket.SpringJdbcDemo.tnx;

public interface ITxnManager {

	public void beginTransaction();

	public void commitTransaction();

	public void rollbackTransaction();
}
