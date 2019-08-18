package com.cg.pp.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transaction4")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txnid")
	@SequenceGenerator(name = "txnid", sequenceName = "txnid_seq", allocationSize = 20)
	@Column(length = 20)
	private int txnId;
	@Column
	private Date txndate;
	@Column(length = 20)
	private double amount;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accno")
	private Customer customer;
	@Column(length = 20)
	private String txn_type;
	@Column(length = 20)
	private int tgtAcc;

	public int getTgtAcc() {
		return tgtAcc;
	}

	public void setTgtAcc(int tgtAcc) {
		this.tgtAcc = tgtAcc;
	}

	public Transaction() {

	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public int getTxnId() {
		return txnId;
	}

	public double getAmount() {
		return amount;
	}

//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", txndate=" + txndate + ", amount=" + amount + ", customer=" + customer
				+ ", txn_type=" + txn_type + ", tgtAcc=" + tgtAcc + "]";
	}

	public final Date getTxndate() {
		return txndate;
	}

	public final void setTxndate(Date txndate) {
		this.txndate = txndate;
	}

	public String getTxn_type() {
		return txn_type;
	}

	public void setTxn_type(String txn_type) {
		this.txn_type = txn_type;
	}

}
