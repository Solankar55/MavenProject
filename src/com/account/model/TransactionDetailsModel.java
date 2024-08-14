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

@Entity
@Table(name="TransactionDetails")
public class TransactionDetailsModel {

	@Id
	@GeneratedValue
	
	private int transactionDetailsId;
	private int receiptNo;
	private String receiptDate;
	private String paymentMode;
	private String transactionNumber;
	private String transactionDate;
	private String bankName;
	private String feeterm;
	
	@ManyToOne
	@JoinColumn(name="bankId")
	private BankMasterModel bankMasterModel;
	
	@OneToMany(mappedBy="FeePaidID")
	private List<LedgerFeePaidModel> ledgerFeePaidModel=new ArrayList<LedgerFeePaidModel>();
	
	/*@OneToMany(mappedBy="transactionDetailsModels")
	private List<RefundAmountModel> refundAmountModels=new ArrayList<RefundAmountModel>();
	*/
	public int getTransactionDetailsId() {
		return transactionDetailsId;
	}
	public void setTransactionDetailsId(int transactionDetailsId) {
		this.transactionDetailsId = transactionDetailsId;
	}
	public int getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getFeeterm() {
		return feeterm;
	}
	public void setFeeterm(String feeterm) {
		this.feeterm = feeterm;
	}
	public BankMasterModel getBankMasterModel() {
		return bankMasterModel;
	}
	public void setBankMasterModel(BankMasterModel bankMasterModel) {
		this.bankMasterModel = bankMasterModel;
	}
	public List<LedgerFeePaidModel> getLedgerFeePaidModel() {
		return ledgerFeePaidModel;
	}
	public void setLedgerFeePaidModel(List<LedgerFeePaidModel> ledgerFeePaidModel) {
		this.ledgerFeePaidModel = ledgerFeePaidModel;
	}
	/*public List<RefundAmountModel> getRefundAmountModels() {
		return refundAmountModels;
	}
	public void setRefundAmountModels(List<RefundAmountModel> refundAmountModels) {
		this.refundAmountModels = refundAmountModels;
	}*/
	
	
}
