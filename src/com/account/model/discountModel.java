package com.account.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="Discount")
public class discountModel {
	
	@Id
	@GeneratedValue
	private int discountId;
	private String discountReason;
	private String otherreason;
	private String totaldiscount;
	private String Standard;
	
	
	@OneToMany(mappedBy="DiscountModel")
	private List<LedgerFeePaidModel> ledgerFeePaidModel=new ArrayList<LedgerFeePaidModel>();
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	/*@OneToMany(mappedBy="DiscountModel")
	private List<RefundAmountModel> refundAmountModel=new ArrayList<RefundAmountModel>();
	*/
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public String getDiscountReason() {
		return discountReason;
	}
	public void setDiscountReason(String discountReason) {
		this.discountReason = discountReason;
	}
	public String getOtherreason() {
		return otherreason;
	}
	public void setOtherreason(String otherreason) {
		this.otherreason = otherreason;
	}
	public String getTotaldiscount() {
		return totaldiscount;
	}
	public void setTotaldiscount(String totaldiscount) {
		this.totaldiscount = totaldiscount;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public List<LedgerFeePaidModel> getLedgerFeePaidModel() {
		return ledgerFeePaidModel;
	}
	public void setLedgerFeePaidModel(List<LedgerFeePaidModel> ledgerFeePaidModel) {
		this.ledgerFeePaidModel = ledgerFeePaidModel;
	}
	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}
	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	/*public List<RefundAmountModel> getRefundAmountModel() {
		return refundAmountModel;
	}
	public void setRefundAmountModel(List<RefundAmountModel> refundAmountModel) {
		this.refundAmountModel = refundAmountModel;
	}
	*/

}
