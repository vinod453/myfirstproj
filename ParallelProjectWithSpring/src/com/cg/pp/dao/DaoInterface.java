package com.cg.pp.dao;

import java.util.List;

import com.cg.pp.bean.Customer;
import com.cg.pp.bean.Transaction;

public interface DaoInterface {
	int addCustomer(Customer customer);

	Customer getCustomer(int accno) ;

	int addTransaction(int accno, Transaction txn) ;

	List<Transaction> printTransactions(int accno);

	void updateCustomer(Customer customer) ;

}
