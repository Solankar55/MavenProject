package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BankMaster")

public class BankMasterModel {

	@Id
	@GeneratedValue
	
	private int bankId;
	private String bankName;
	private String branchName;
	private String accuntNumber;
	private String NEFT_RTGS_IFSC;
	private String status="On";
	
	/*@OneToMany(mappedBy="bankMasterModel",cascade=CascadeType.ALL)
	private List<TransactionDetailsModel> transactionDetailsModel=new ArrayList<TransactionDetailsModel>();
	*/
	
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccuntNumber() {
		return accuntNumber;
	}
	public void setAccuntNumber(String accuntNumber) {
		this.accuntNumber = accuntNumber;
	}
	public String getNEFT_RTGS_IFSC() {
		return NEFT_RTGS_IFSC;
	}
	public void setNEFT_RTGS_IFSC(String nEFT_RTGS_IFSC) {
		NEFT_RTGS_IFSC = nEFT_RTGS_IFSC;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
