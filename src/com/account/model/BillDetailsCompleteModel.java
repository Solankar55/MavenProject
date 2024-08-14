package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="billdetailscomplete")

public class BillDetailsCompleteModel {

	@Id
	@GeneratedValue
	

	private int billcompletedId;
	private String date;
	private String totalamount;
	private String totalpendingamount;

	@OneToMany(mappedBy="billdetailsId")
	List<BillDetailsModel> billDetailsModel = new ArrayList<BillDetailsModel>();

	
	
	
	/*Getter And Setter*/
	
	
	public int getBillcompletedId() {
		return billcompletedId;
	}
	public void setBillcompletedId(int billcompletedId) {
		this.billcompletedId = billcompletedId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}
	public String getTotalpendingamount() {
		return totalpendingamount;
	}
	public void setTotalpendingamount(String totalpendingamount) {
		this.totalpendingamount = totalpendingamount;
	}
	public List<BillDetailsModel> getBillDetailsModel() {
		return billDetailsModel;
	}
	public void setBillDetailsModel(List<BillDetailsModel> billDetailsModel) {
		this.billDetailsModel = billDetailsModel;
	}
}
