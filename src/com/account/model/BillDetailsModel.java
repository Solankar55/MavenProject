package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BillDetails")

public class BillDetailsModel {

	@Id
	@GeneratedValue
	

	private int billdetailsId;
	private String address;
	private String date;
	private int billNumber;
	private String email;
	private int numberofseller;
	private String name;
	private int phonenumbers;

	/*Getter And Setter*/
	
	public int getBilldetailsId() {
		return billdetailsId;
	}
	public void setBilldetailsId(int billdetailsId) {
		this.billdetailsId = billdetailsId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumberofseller() {
		return numberofseller;
	}
	public void setNumberofseller(int numberofseller) {
		this.numberofseller = numberofseller;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhonenumbers() {
		return phonenumbers;
	}
	public void setPhonenumbers(int phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	
	
}
