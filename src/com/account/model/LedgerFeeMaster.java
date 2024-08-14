package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="LedgerFee")
public class LedgerFeeMaster {

	@Id
	@GeneratedValue
	
	private int ledgerFeeID;
	private float ledgerTotalFees;
	private String feeStatus;
	private int ledgermasterID;
	private int subLedgerID;
	private int AcademiconYearID;
	private String Standard;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	/*@OneToMany(mappedBy="ledgerFeeMaster")
	private List<LedgerFeePaidModel> ledgerFeePaidModel=new ArrayList<LedgerFeePaidModel>();
*/
	public int getLedgerFeeID() {
		return ledgerFeeID;
	}

	public void setLedgerFeeID(int ledgerFeeID) {
		this.ledgerFeeID = ledgerFeeID;
	}

	public float getLedgerTotalFees() {
		return ledgerTotalFees;
	}

	public void setLedgerTotalFees(float ledgerTotalFees) {
		this.ledgerTotalFees = ledgerTotalFees;
	}

	public String getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}

	public int getLedgermasterID() {
		return ledgermasterID;
	}

	public void setLedgermasterID(int ledgermasterID) {
		this.ledgermasterID = ledgermasterID;
	}

	public int getSubLedgerID() {
		return subLedgerID;
	}

	public void setSubLedgerID(int subLedgerID) {
		this.subLedgerID = subLedgerID;
	}

	public int getAcademiconYearID() {
		return AcademiconYearID;
	}

	public void setAcademiconYearID(int academiconYearID) {
		AcademiconYearID = academiconYearID;
	}

	public String getStandard() {
		return Standard;
	}

	public void setStandard(String standard) {
		Standard = standard;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	/*public List<LedgerFeePaidModel> getLedgerFeePaidModel() {
		return ledgerFeePaidModel;
	}

	public void setLedgerFeePaidModel(List<LedgerFeePaidModel> ledgerFeePaidModel) {
		this.ledgerFeePaidModel = ledgerFeePaidModel;
	}
	*/
	
}
