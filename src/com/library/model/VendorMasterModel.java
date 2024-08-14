package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VendorMasterModel {
	@Id
	@GeneratedValue
	private int vendorId;
	private double discountA;
	private String vendorName;
	private String status="Active";
	
	@OneToMany(mappedBy="vendorMasterModel")
	List<QuantityDataMaster> quantityDataMaster=new ArrayList<>();
	
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public double getDiscountA() {
		return discountA;
	}
	public void setDiscountA(double discountA) {
		this.discountA = discountA;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public List<QuantityDataMaster> getQuantityDataMaster() {
		return quantityDataMaster;
	}
	public void setQuantityDataMaster(List<QuantityDataMaster> quantityDataMaster) {
		this.quantityDataMaster = quantityDataMaster;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
