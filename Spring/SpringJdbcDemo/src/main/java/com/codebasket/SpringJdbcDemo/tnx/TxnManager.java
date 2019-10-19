package com.codebasket.SpringJdbcDemo.tnx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TxnManager implements ITxnManager {

	@Autowired
	private PlatformTransactionManager transactionManager;

	TransactionStatus status;

	@Override
	public void beginTransaction() {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		status = transactionManager.getTransaction(definition);

	}

	@Override
	public void commitTransaction() {
		transactionManager.commit(status);
	}

	@Override
	public void rollbackTransaction() {
		transactionManager.rollback(status);
	}

}
