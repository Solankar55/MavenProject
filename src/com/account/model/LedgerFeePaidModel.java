package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="LedgerFeePaid")
public class LedgerFeePaidModel {

	@Id
	@GeneratedValue
	private int FeePaidID;
	@Column(name = "totalFee", nullable = false, columnDefinition = "float default 0.0")
	private float totalFee;
	@Column(name = "AlreadyPaidFees", nullable = false, columnDefinition = "float default 0.0")
	private float AlreadyPaidFees;
	@Column(name = "PaidFees", nullable = false, columnDefinition = "float default 0.0")
	private float PaidFees;	
	@Column(name = "PendingFees", nullable = false, columnDefinition = "float default 0.0")
	private float PendingFees;
	private String feeStatus="pending";
	private String Standard;
	private String AcademicYear;
	
	private int StreamID;
	private int StandardID;
	private int BranchID;
	private int AcdemicYearID;
	
	
	/*private int LedgerFeePaidID;
	private float LedgerAlreadyPaidFees;
	private float LedgerPaidFees;
	private float LedgerPendingFees;
*/	
	/*@OneToOne
	@JoinColumn(name="StandardFeeId")
	private  StandardFeeMasterModel standardFeeMasterModel;
	*/
	
	@ManyToOne
	@JoinColumn(name="discountId")
	private  discountModel DiscountModel;
	
	
	/*@ManyToOne
	@JoinColumn(name="acadamicYearId")
	private  acadamicYearModel AcadamicYearModel;*/
	
	@ManyToOne
	@JoinColumn(name="transactionDetailsId")
	private TransactionDetailsModel transactionDetailsModels;

	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private  StudentAdmissionModel studentAdmissionModel;

	
	/*@ManyToOne
	@JoinColumn(name="ledgerFeeID")
	private LedgerFeeMaster ledgerFeeMaster;*/
	
	public int getFeePaidID() {
		return FeePaidID;
	}


	public void setFeePaidID(int feePaidID) {
		FeePaidID = feePaidID;
	}


	public float getTotalFee() {
		return totalFee;
	}


	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}


	public float getAlreadyPaidFees() {
		return AlreadyPaidFees;
	}


	public void setAlreadyPaidFees(float alreadyPaidFees) {
		AlreadyPaidFees = alreadyPaidFees;
	}


	public float getPaidFees() {
		return PaidFees;
	}


	public void setPaidFees(float paidFees) {
		PaidFees = paidFees;
	}


	public float getPendingFees() {
		return PendingFees;
	}


	public void setPendingFees(float pendingFees) {
		PendingFees = pendingFees;
	}


	public String getFeeStatus() {
		return feeStatus;
	}


	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}


	public String getStandard() {
		return Standard;
	}


	public void setStandard(String standard) {
		Standard = standard;
	}


	public discountModel getDiscountModel() {
		return DiscountModel;
	}


	public void setDiscountModel(discountModel discountModel) {
		DiscountModel = discountModel;
	}


	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}


	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}


	public TransactionDetailsModel getTransactionDetailsModels() {
		return transactionDetailsModels;
	}


	public void setTransactionDetailsModels(TransactionDetailsModel transactionDetailsModels) {
		this.transactionDetailsModels = transactionDetailsModels;
	}


	public String getAcademicYear() {
		return AcademicYear;
	}


	public void setAcademicYear(String academicYear) {
		AcademicYear = academicYear;
	}


	public int getStreamID() {
		return StreamID;
	}


	public void setStreamID(int streamID) {
		StreamID = streamID;
	}


	public int getStandardID() {
		return StandardID;
	}


	public void setStandardID(int standardID) {
		StandardID = standardID;
	}


	public int getBranchID() {
		return BranchID;
	}


	public void setBranchID(int branchID) {
		BranchID = branchID;
	}


	public int getAcdemicYearID() {
		return AcdemicYearID;
	}


	public void setAcdemicYearID(int acdemicYearID) {
		AcdemicYearID = acdemicYearID;
	}

/*
	public StandardFeeMasterModel getStandardFeeMasterModel() {
		return standardFeeMasterModel;
	}


	public void setStandardFeeMasterModel(StandardFeeMasterModel standardFeeMasterModel) {
		this.standardFeeMasterModel = standardFeeMasterModel;
	}

*/


	
	
}
