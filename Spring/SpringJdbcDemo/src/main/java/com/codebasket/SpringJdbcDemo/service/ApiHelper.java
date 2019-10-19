package com.codebasket.SpringJdbcDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.codebasket.SpringJdbcDemo.model.StudentTo;
import com.codebasket.SpringJdbcDemo.persist.ApiDao;
import com.codebasket.SpringJdbcDemo.tnx.ITxnManager;

@Service
public class ApiHelper {

	@Autowired
	private ApiDao apiDao;

//	 @Autowired
//	 private ITxnManager iTxnManager;

	/*propagation — Optional setting for propagation. This is a very important attribute in setting the transactional behavior. I will cover a use case of it below.

    REQUIRED — support a current transaction, create a new one if none exist
    REQUIRES_NEW — create a new transaction and suspend the current transaction if none exist
    MANDATORY — support a current transaction, throw an exception if none exists
    NESTED — executes within a nested transaction if a current transaction exists
    SUPPORTS — supports currents transaction but execute non-transactionally if none exists*/
	
	/*readOnly — whether the transaction is read-only or read/write
	timeout — transaction timeout
	rollbackFor — arrays of exception class objects that must cause a rollback of the transaction
	rollbackForClassName — arrays of exception class names that must cause a rollback of the transaction
	noRollbackFor — arrays of exception class objects that must not cause a rollback of the transaction
	noRollbackForClassName — arrays of exception class names that must not cause a rollback of the transaction*/

	@Transactional(propagation =Propagation.REQUIRED, readOnly=false,timeout=100,rollbackFor= {Exception.class,RuntimeException.class})
	public void transExample() {
		try {
			// iTxnManager.beginTransaction();

			StudentTo student = new StudentTo();
			student.setName("Virat");
			student.setCity("BLR");
			int sid = apiDao.save(student);
			System.out.println("generated Sid" + sid);
			apiDao.saveCourse(sid, "Science");

			// iTxnManager.commitTransaction();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
