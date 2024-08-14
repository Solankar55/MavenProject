package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="RefundAmountModel")
public class RefundAmountModel {

	@Id
	@GeneratedValue
	private int refundid;
	private float refundamount;
	private String Status="NotRefunded";
	private String refunddate;
	private String cheacknumber;
	private String cheackDate;
	private String checkBankName;
	private String cheackBranchCode;
	private String CheckBankIFSCCode;
	
	@ManyToOne
	@JoinColumn(name="acadamicYearId")
	private  acadamicYearModel acadamicYearModel;
	
	/*@ManyToOne
	@JoinColumn(name="transactionDetailsId")
	private TransactionDetailsModel transactionDetailsModels;

	@ManyToOne
	@JoinColumn(name="discountId")
	private  discountModel DiscountModel;*/
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private  StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel;

	@ManyToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel;
	
	@ManyToOne
	@JoinColumn(name="standardId")
	private StandardMasterModel standardMasterModel;

	public int getRefundid() {
		return refundid;
	}

	public float getRefundamount() {
		return refundamount;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	/*public TransactionDetailsModel getTransactionDetailsModels() {
		return transactionDetailsModels;
	}*/

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}

	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}

	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}

	public void setRefundid(int refundid) {
		this.refundid = refundid;
	}

	public void setRefundamount(float refundamount) {
		this.refundamount = refundamount;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}

	/*public void setTransactionDetailsModels(TransactionDetailsModel transactionDetailsModels) {
		this.transactionDetailsModels = transactionDetailsModels;
	}
*/
	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}

	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
	}

	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getCheacknumber() {
		return cheacknumber;
	}

	public String getCheackDate() {
		return cheackDate;
	}

	public String getCheckBankName() {
		return checkBankName;
	}

	public String getCheackBranchCode() {
		return cheackBranchCode;
	}

	public void setCheacknumber(String cheacknumber) {
		this.cheacknumber = cheacknumber;
	}

	public void setCheackDate(String cheackDate) {
		this.cheackDate = cheackDate;
	}

	public void setCheckBankName(String checkBankName) {
		this.checkBankName = checkBankName;
	}

	public void setCheackBranchCode(String cheackBranchCode) {
		this.cheackBranchCode = cheackBranchCode;
	}

	public String getCheckBankIFSCCode() {
		return CheckBankIFSCCode;
	}

	public void setCheckBankIFSCCode(String checkBankIFSCCode) {
		CheckBankIFSCCode = checkBankIFSCCode;
	}

	public String getRefunddate() {
		return refunddate;
	}

	public void setRefunddate(String refunddate) {
		this.refunddate = refunddate;
	}

	/*public discountModel getDiscountModel() {
		return DiscountModel;
	}

	public void setDiscountModel(discountModel discountModel) {
		DiscountModel = discountModel;
	}
	*/
	
}
