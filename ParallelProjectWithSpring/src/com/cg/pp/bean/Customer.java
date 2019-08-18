package com.cg.pp.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer4")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accno")
	@SequenceGenerator(name = "accno", sequenceName = "accno_seq", allocationSize = 20)
	private int accno;
	@Column(length = 20)
	@Pattern(regexp = "[A-Za-z\\s]{4,15}", message = "Enter the name size between 4 and 15")
	private String name;
	@Column(length = 20)
	private double amount;
	@Column(length = 20)
	private double balance;
	@Column(length = 20)
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message = "Password should contain atleast 1 capital letter,1 small letter,1 number and 1 special character")
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@Column(length = 20)
	@Pattern(regexp = "[0-9]{12}", message = "AadharCard should contain 12 digits")
	private String aadharCard;
	@Column(length = 20)
	@Pattern(regexp = "[A-Z0-9]{8,10}", message = "PanCard should contains capital letters and numbers in between 8 to 10")
	private String panCard;
	@Column(length = 20)
	@Pattern(regexp = "[7-9]{1}[0-9]{9}", message = "Phone number should contain 10 digits")
	private String phoneNumber;

	@Override
	public String toString() {
		return "Customer [accno=" + accno + ", name=" + name + ", amount=" + amount + ", balance=" + balance
				+ ", password=" + password + ", address=" + address + ", aadharCard=" + aadharCard + ", panCard="
				+ panCard + ", phoneNumber=" + phoneNumber + "]";
	}

	public final int getAccno() {
		return accno;
	}

	public final void setAccno(int accno) {
		this.accno = accno;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final double getAmount() {
		return amount;
	}

	public final void setAmount(double amount) {
		this.amount = amount;
	}

	public final double getBalance() {
		return balance;
	}

	public final void setBalance(double balance) {
		this.balance = balance;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final Address getAddress() {
		return address;
	}

	public final void setAddress(Address address) {
		this.address = address;
	}

	public final String getAadharCard() {
		return aadharCard;
	}

	public final void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public final String getPanCard() {
		return panCard;
	}

	public final void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
