package com.cg.pp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "address4")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accno")
	@SequenceGenerator(name = "accno", sequenceName = "accno_seq", allocationSize = 20)
	private int addressid;
	@Column(length = 20)
	@Pattern(regexp = "[A-Za-z0-9\\s]{4,25}", message = "flatno should contain only letters and numbers")
	private String flatno;
	@Column(length = 20)
	@Pattern(regexp = "[A-Za-z\\s]{4,25}", message = "Street should contain only letters")
	private String street;
	@Column(length = 20)
	@Pattern(regexp = "[A-Za-z\\s]{4,25}", message = "City should contain only letters")
	private String city;
	@Column(length = 20)
	@Pattern(regexp = "[0-9]{4,6}", message = "Pincode should contain only 4 to 6 numbers")
	private String pincode;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getFlatno() {
		return flatno;
	}

	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", flatno=" + flatno + ", street=" + street + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

}
