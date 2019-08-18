package com.cg.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pp.bean.Customer;
import com.cg.pp.bean.Transaction;
import com.cg.pp.dao.DaoInterface;
import com.cg.pp.exception.CustomerException;

@Service
public class ServiceClass implements ServiceInterface {
	@Autowired
	DaoInterface dao;
	Customer customer;

	public DaoInterface getDao() {
		return dao;
	}

	public void setDao(DaoInterface dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public int addCustomer(Customer customer) {
		int accno = dao.addCustomer(customer);
		return accno;
	}

	@Override
	public Customer getCustomer(int accno) {
		customer = dao.getCustomer(accno);
		return customer;
	}

	@Override
	public Transaction depositMoney(int accno, double amount) throws CustomerException {
		String txn_type = "Deposit";
		customer = dao.getCustomer(accno);
		Transaction txn = generateTxn(accno, amount, txn_type);
		if (customer.getBalance() >= amount) {
			customer.setBalance(customer.getBalance() - amount);
			customer.setAmount(customer.getAmount() + amount);
		} else {
			throw new CustomerException("Amount insufficient in your account");
		}
		dao.updateCustomer(customer);
		txn.setTgtAcc(accno);
		int txnId = dao.addTransaction(accno, txn);
		txn.setTxnId(txnId);
		return txn;
	}

	private Transaction generateTxn(int accno, double amount, String txn_type) {
		customer = getCustomer(accno);
		Transaction txn = new Transaction();
		txn.setAmount(amount);
		txn.setCustomer(customer);
		txn.setTxn_type(txn_type);
		return txn;
	}

	@Override
	public boolean verifyPassword(int accno, String password) throws CustomerException {
		customer = dao.getCustomer(accno);
		if (customer == null)
			throw new CustomerException("Customer does not exist");
		if (customer.getPassword().equals(password))
			return true;
		else
			return false;
	}

	@Override
	public Transaction withdrawMoney(int accno, double amount) throws CustomerException {
		String txn_type = "Withdraw";
		Transaction txn = generateTxn(accno, amount, txn_type);
		customer = dao.getCustomer(accno);
		if (customer.getAmount() >= amount) {
			customer.setBalance(customer.getBalance() + amount);
			customer.setAmount(customer.getAmount() - amount);
		} else {
			throw new CustomerException("Amount insufficient in your Wallet");
		}
		dao.updateCustomer(customer);
		txn.setTgtAcc(accno);
		int txnId = dao.addTransaction(accno, txn);
		txn.setTxnId(txnId);
		return txn;
	}

	@Override
	public Transaction fundTransfer(int accno, int trg_accno, double amount) throws CustomerException {
		String txn_type = "FundTransfer";
		Transaction txn = generateTxn(accno, amount, txn_type);
		Transaction txn2 = generateTxn(trg_accno, amount, txn_type);
		customer = dao.getCustomer(accno);
		Customer customer2 = dao.getCustomer(trg_accno);
		if (customer2 == null)
			throw new CustomerException("Target Account doesn't exits");
		if (customer.getAmount() >= amount) {
			customer.setAmount(customer.getAmount() - amount);
			customer2.setAmount(customer2.getAmount() + amount);
		} else {
			throw new CustomerException("Amount insufficient in your account");
		}
		dao.updateCustomer(customer);
		dao.updateCustomer(customer2);
		txn.setTgtAcc(trg_accno);
		int txnId = dao.addTransaction(accno, txn);
		txn.setTxnId(txnId);
		txn2.setTgtAcc(accno);
		int txnId1 = dao.addTransaction(trg_accno, txn2);
		txn2.setTxnId(txnId1);
		return txn;
	}

	@Override
	public List<Transaction> printTransactions(int accno) {
		List<Transaction> list = dao.printTransactions(accno);
		return list;
	}

}
