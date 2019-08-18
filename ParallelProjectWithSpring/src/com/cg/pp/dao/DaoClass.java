package com.cg.pp.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.pp.bean.Customer;
import com.cg.pp.bean.Transaction;

@Repository
@Transactional
public class DaoClass implements DaoInterface {
	@PersistenceContext
	EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public int addCustomer(Customer customer) {
		manager.persist(customer);
		return customer.getAccno();
	}

	@Override
	public Customer getCustomer(int accno) {
		Customer customer = manager.find(Customer.class, accno);
		return customer;
	}

	@Override
	public int addTransaction(int accno, Transaction txn) {
		Customer customer = manager.find(Customer.class, accno);
		txn.setCustomer(customer);
		txn.setTxndate(Date.valueOf(LocalDate.now()));
		manager.persist(txn);
		txn = manager.find(Transaction.class, txn.getTxnId());
		return txn.getTxnId();
	}

	@Override
	public List<Transaction> printTransactions(int accno) {
		List<Transaction> list = new ArrayList<>();
		String sql = "SELECT a FROM Transaction a where accno=(:accno)";
		TypedQuery<Transaction> query = manager.createQuery(sql, Transaction.class);
		query.setParameter("accno", accno);
		list = query.getResultList();
		return list;
	}

	@Override
	public void updateCustomer(Customer customer) {
		manager.merge(customer);
	}

}
