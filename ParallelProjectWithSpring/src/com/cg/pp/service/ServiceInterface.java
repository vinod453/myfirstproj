package com.cg.pp.service;

import java.util.List;

import com.cg.pp.bean.Customer;
import com.cg.pp.bean.Transaction;
import com.cg.pp.exception.CustomerException;

public interface ServiceInterface {

	int addCustomer(Customer customer);

	Customer getCustomer(int accno);

	Transaction depositMoney(int accno, double amount) throws CustomerException;

	Transaction withdrawMoney(int accno, double amount) throws CustomerException;

	boolean verifyPassword(int accno, String password) throws CustomerException;

	Transaction fundTransfer(int accno, int trg_accno, double amount) throws CustomerException;

	List<Transaction> printTransactions(int accno);

}
