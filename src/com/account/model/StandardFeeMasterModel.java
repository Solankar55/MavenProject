package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StandardFeeMaster")
public class StandardFeeMasterModel {

	@Id
	@GeneratedValue

	private int StandardFeeId;
	private float Fee;
	private String sfstatus="On";


	@OneToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel;

	@OneToOne
	@JoinColumn(name="branchId")
	private  BranchMasterModel branchMasterModel;

	@OneToOne
	@JoinColumn(name="standardId")
	private  StandardMasterModel standardMasterModel;

	@OneToOne
	@JoinColumn(name="acadamicYearId")
	private  acadamicYearModel acadamicYearModel;

	@OneToOne
	@JoinColumn(name="LedgerId")
	private  LedgerMasterModel ledgerMasterModel;

	@ManyToOne
	@JoinColumn(name="SubLedgerId")
	private SubLedgerMasterModel subLedgerMasterModel ;

	public SubLedgerMasterModel getSubLedgerMasterModel() {
		return subLedgerMasterModel;
	}

	public void setSubLedgerMasterModel(SubLedgerMasterModel subLedgerMasterModel) {
		this.subLedgerMasterModel = subLedgerMasterModel;
	}

	/*Getter And Setter*/
	public int getStandardFeeId() {
		return StandardFeeId;
	}

	public void setStandardFeeId(int standardFeeId) {
		StandardFeeId = standardFeeId;
	}



	public float getFee() {
		return Fee;
	}

	public void setFee(float fee) {
		Fee = fee;
	}

	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}

	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}

	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}

	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
	}

	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}

	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}

	public LedgerMasterModel getLedgerMasterModel() {
		return ledgerMasterModel;
	}

	public void setLedgerMasterModel(LedgerMasterModel ledgerMasterModel) {
		this.ledgerMasterModel = ledgerMasterModel;
	}

	public String getSfstatus() {
		return sfstatus;
	}

	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}



}
