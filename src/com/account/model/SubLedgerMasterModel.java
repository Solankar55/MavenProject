package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubLedgerMaster")
public class SubLedgerMasterModel {

	@Id
	@GeneratedValue
	
	private int SubLedgerId;
	private String subledger;
	private String sstatus="On";
	
	
	/*,cascade=CascadeType.ALL*/
	
	@OneToOne
	@JoinColumn(name="LedgerId")
	private LedgerMasterModel ledgerMasterModel;

	@OneToMany(mappedBy="subLedgerMasterModel",cascade=CascadeType.ALL)
	List<StandardFeeMasterModel> standardFeeMasterModel = new ArrayList<StandardFeeMasterModel>();

	public List<StandardFeeMasterModel> getStandardFeeMasterModel() {
		return standardFeeMasterModel;
	}

	public void setStandardFeeMasterModel(List<StandardFeeMasterModel> standardFeeMasterModel) {
		this.standardFeeMasterModel = standardFeeMasterModel;
	}

	/*Getter And Setter*/
	public int getSubLedgerId() {
		return SubLedgerId;
	}

	public void setSubLedgerId(int subLedgerId) {
		SubLedgerId = subLedgerId;
	}

	public LedgerMasterModel getLedgerMasterModel() {
		return ledgerMasterModel;
	}

	public void setLedgerMasterModel(LedgerMasterModel ledgerMasterModel) {
		this.ledgerMasterModel = ledgerMasterModel;
	}

	public String getSubledger() {
		return subledger;
	}

	public void setSubledger(String subledger) {
		this.subledger = subledger;
	}

	public String getSstatus() {
		return sstatus;
	}

	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}
	
	
}
