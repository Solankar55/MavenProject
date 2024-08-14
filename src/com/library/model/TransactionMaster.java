package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TransactionMaster")
public class TransactionMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int TransactionMasterId;
	@Column
	private String InvoiceNo;

	@Column
	private String originalInvoiceNo;
	@Column
	private String InvoiceDate;
	/*
	 * @Column private int PrizePerBook;
	 * 
	 * @Column private int Quantity;
	 * 
	 * @Column private int AmountOfBook;
	 * 
	 * @Column private int DiscountPercentage;
	 * 
	 * @Column private int PayableAmount;
	 */
	@Column
	private double TotalAmountOfBook;
	@Column
	private double TotalDiscountAmount;

	@Column
	private double TotalWithoutDiscount;

	@Column
	private double TotalPayableAmount;

	@JsonIgnore
	@OneToMany(mappedBy = "TXMaster")
	private List<AccessionLibraryRegister> accessionlibraryregister = new ArrayList<>();

	public int getTransactionMasterId() {
		return TransactionMasterId;
	}

	public void setTransactionMasterId(int transactionMasterId) {
		TransactionMasterId = transactionMasterId;
	}

	public String getInvoiceNo() {
		return InvoiceNo;
	}

	public String getOriginalInvoiceNo() {
		return originalInvoiceNo;
	}

	public void setOriginalInvoiceNo(String originalInvoiceNo) {
		this.originalInvoiceNo = originalInvoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return InvoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}

	public double getTotalAmountOfBook() {
		return TotalAmountOfBook;
	}

	public void setTotalAmountOfBook(double totalAmountOfBook) {
		TotalAmountOfBook = totalAmountOfBook;
	}

	public double getTotalDiscountAmount() {
		return TotalDiscountAmount;
	}

	public void setTotalDiscountAmount(double totalDiscountAmount) {
		TotalDiscountAmount = totalDiscountAmount;
	}

	public double getTotalWithoutDiscount() {
		return TotalWithoutDiscount;
	}

	public void setTotalWithoutDiscount(double totalWithoutDiscount) {
		TotalWithoutDiscount = totalWithoutDiscount;
	}

	public double getTotalPayableAmount() {
		return TotalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		TotalPayableAmount = totalPayableAmount;
	}

	public List<AccessionLibraryRegister> getAccessionlibraryregister() {
		return accessionlibraryregister;
	}

	public void setAccessionlibraryregister(List<AccessionLibraryRegister> accessionlibraryregister) {
		this.accessionlibraryregister = accessionlibraryregister;
	}

}
