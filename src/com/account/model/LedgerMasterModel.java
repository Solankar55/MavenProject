package com.account.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

@Entity
@Table(name="LedgerMaster")
public class LedgerMasterModel {

	@Id
	@GeneratedValue
	
	private int LedgerId;
	private String AccountType;
	private String LedgerName;
	private String LedgerType;
	private String lstatus="On";
	
	@OneToOne(mappedBy="ledgerMasterModel",cascade=CascadeType.ALL)
	private	SubLedgerMasterModel subLedgerMasterModel ;
	
	@OneToOne(mappedBy="ledgerMasterModel",cascade=CascadeType.ALL)
	private StandardFeeMasterModel standardFeeMasterModel;
	
	/*getter And Setter*/
	public int getLedgerId() {
		return LedgerId;
	}
	public void setLedgerId(int ledgerId) {
		LedgerId = ledgerId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getLedgerName() {
		return LedgerName;
	}
	public void setLedgerName(String ledgerName) {
		LedgerName = ledgerName;
	}
	public String getLedgerType() {
		return LedgerType;
	}
	public void setLedgerType(String ledgerType) {
		LedgerType = ledgerType;
	}
	public SubLedgerMasterModel getSubLedgerMasterModel() {
		return subLedgerMasterModel;
	}
	public void setSubLedgerMasterModel(SubLedgerMasterModel subLedgerMasterModel) {
		this.subLedgerMasterModel = subLedgerMasterModel;
	}
	public StandardFeeMasterModel getStandardFeeMasterModel() {
		return standardFeeMasterModel;
	}
	public void setStandardFeeMasterModel(StandardFeeMasterModel standardFeeMasterModel) {
		this.standardFeeMasterModel = standardFeeMasterModel;
	}
	public String getLstatus() {
		return lstatus;
	}
	public void setLstatus(String lstatus) {
		this.lstatus = lstatus;
	}
	
	
}
