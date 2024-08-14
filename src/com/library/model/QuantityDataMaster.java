package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="QuantityDataMaster")
public class QuantityDataMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int QuantityId;
	@Column
	private String Title;
	@Column
	private String Author;
	@Column
	private String Edition;
	@Column
	private String PublicationYear;
	@Column
	private String Publisher;
	@Column
	private String ClassNumber;
	@Column
	private String BookFor;
	@Column
	private double SizeOfBook;
	@Column
	private double PrizePerBook;
	@Column
	private String Vendor;
	@Column
	private String InDate;
	@Column
	private int Quantity;
	@Column
	private double Discount,paybleAmount;
	
	@Column
	private double TotalAmount;//total amount per quantity
	@Column
	private String DiscountRemark;
	@Column
	private String CollegeRemark;
	
	private String purRemark;
	private String donarName;
	private String YearID,InvoiceNo,InviceDate;
	
	@OneToOne
	@JoinColumn(name = "LibrarySubjectMasterId")
	private LibrarySubjectMaster LSMaster;
	
	@OneToOne
	@JoinColumn(name = "BooktypeId")
	private BookTypeMaster BTMaster;
	
	@ManyToOne
	@JoinColumn(name="vendorId")
	VendorMasterModel vendorMasterModel;
	
	@ManyToOne
	@JoinColumn(name="purId")
	PurchaceBooKModel purchaceBooKModel;
	

	public int getQuantityId() {
		return QuantityId;
	}

	public void setQuantityId(int quantityId) {
		QuantityId = quantityId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getEdition() {
		return Edition;
	}

	public void setEdition(String edition) {
		Edition = edition;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getPublicationYear() {
		return PublicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(String classNumber) {
		ClassNumber = classNumber;
	}

	public String getBookFor() {
		return BookFor;
	}

	public void setBookFor(String bookFor) {
		BookFor = bookFor;
	}

	public double getSizeOfBook() {
		return SizeOfBook;
	}

	public void setSizeOfBook(double sizeOfBookk) {
		SizeOfBook = sizeOfBookk;
	}

	public double getPrizePerBook() {
		return PrizePerBook;
	}

	public void setPrizePerBook(double prizePerBook) {
		PrizePerBook = prizePerBook;
	}

	public String getVendor() {
		return Vendor;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public String getInDate() {
		return InDate;
	}

	public void setInDate(String inDate) {
		InDate = inDate;
	}

	
	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getDiscountRemark() {
		return DiscountRemark;
	}

	public void setDiscountRemark(String discountRemark) {
		DiscountRemark = discountRemark;
	}

	public String getCollegeRemark() {
		return CollegeRemark;
	}




	public void setCollegeRemark(String collegeRemark) {
		CollegeRemark = collegeRemark;
	}

	public LibrarySubjectMaster getLSMaster() {
		return LSMaster;
	}

	public void setLSMaster(LibrarySubjectMaster lSMaster) {
		LSMaster = lSMaster;
	}

	public BookTypeMaster getBTMaster() {
		return BTMaster;
	}

	public double getPaybleAmount() {
		return paybleAmount;
	}

	public void setPaybleAmount(double paybleAmount) {
		this.paybleAmount = paybleAmount;
	}

	public void setBTMaster(BookTypeMaster bTMaster) {
		BTMaster = bTMaster;
	}

	public VendorMasterModel getVendorMasterModel() {
		return vendorMasterModel;
	}

	public void setVendorMasterModel(VendorMasterModel vendorMasterModel) {
		this.vendorMasterModel = vendorMasterModel;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public String getYearID() {
		return YearID;
	}

	public void setYearID(String yearID) {
		YearID = yearID;
	}

	public String getInvoiceNo() {
		return InvoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}

	public String getInviceDate() {
		return InviceDate;
	}

	public void setInviceDate(String inviceDate) {
		InviceDate = inviceDate;
	}

	public String getPurRemark() {
		return purRemark;
	}

	public void setPurRemark(String purRemark) {
		this.purRemark = purRemark;
	}

	public PurchaceBooKModel getPurchaceBooKModel() {
		return purchaceBooKModel;
	}

	public void setPurchaceBooKModel(PurchaceBooKModel purchaceBooKModel) {
		this.purchaceBooKModel = purchaceBooKModel;
	}

		
	
	

}
