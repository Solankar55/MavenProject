package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AccessionLibraryRegister")
public class AccessionLibraryRegister {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int AccessionLibraryRegisterId;
	@Column
	private String AccessionId;                           //*****Barcode
	@Column
	private String DiscountRemark;
	@Column
	private String CollegeRemark;
	@Column
	private String BookFor;
	private String availableStatus;
	
	/*@OneToOne
	@JoinColumn(name = "BooktypeId")
	private BookTypeMaster BTMaster;*/

	/*@OneToOne
	@JoinColumn(name = "LibrarySubjectMasterId")
	private LibrarySubjectMaster LSMaster;*/
	
	@OneToOne(mappedBy="accessionLibraryRegister")
	private BookInDepartment BookInDepartment;
	
	@OneToOne
	@JoinColumn(name="labacademicyearid")
	private LibraryAcademicYearModel libraryAcademicYearModel;
	
	@ManyToOne
	@JoinColumn(name = "TransactionMasterId")
	private TransactionMaster TXMaster;

	@ManyToOne
	@JoinColumn(name = "QuantityId")
	private QuantityDataMaster quantityDataMaster;

	
	@OneToOne(mappedBy="accessionLibraryRegister")
	Barcodemodel barCodeModel;
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "IARBStudentA")
	private List<IssueAndReturnBookStudent> issueandreturnbookstudent = new ArrayList<>();*/
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "IARBLecturerA")
	private List<IssueAndReturnBookLecturer> issueandreturnbooklecturer = new ArrayList<>();*/
	
	
	@OneToMany(mappedBy="ALRegister")
	private List<LostBookStudent> lostBookStudents= new ArrayList<>();
	
	@OneToMany(mappedBy="ALRegisterStaff")
	private List<LostBookStaff> lostBookStaff= new ArrayList<>();
	
	
	
	public int getAccessionLibraryRegisterId() {
		return AccessionLibraryRegisterId;
	}

	public void setAccessionLibraryRegisterId(int accessionLibraryRegisterId) {
		AccessionLibraryRegisterId = accessionLibraryRegisterId;
	}

	
	public String getAccessionId() {
		return AccessionId;
	}

	public void setAccessionId(String accessionId) {
		AccessionId = accessionId;
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

	public TransactionMaster getTXMaster() {
		return TXMaster;
	}

	public void setTXMaster(TransactionMaster tXMaster) {
		TXMaster = tXMaster;
	}

	public QuantityDataMaster getQuantityDataMaster() {
		return quantityDataMaster;
	}

	public void setQuantityDataMaster(QuantityDataMaster quantityDataMaster) {
		this.quantityDataMaster = quantityDataMaster;
	}

	public String getBookFor() {
		return BookFor;
	}

	public void setBookFor(String bookFor) {
		BookFor = bookFor;
	}

	public Barcodemodel getBarCodeModel() {
		return barCodeModel;
	}

	public void setBarCodeModel(Barcodemodel barCodeModel) {
		this.barCodeModel = barCodeModel;
	}

	public BookInDepartment getBookInDepartment() {
		return BookInDepartment;
	}

	public List<LostBookStudent> getLostBookStudents() {
		return lostBookStudents;
	}

	public List<LostBookStaff> getLostBookStaff() {
		return lostBookStaff;
	}

	public void setBookInDepartment(BookInDepartment bookInDepartment) {
		BookInDepartment = bookInDepartment;
	}

	public void setLostBookStudents(List<LostBookStudent> lostBookStudents) {
		this.lostBookStudents = lostBookStudents;
	}

	public void setLostBookStaff(List<LostBookStaff> lostBookStaff) {
		this.lostBookStaff = lostBookStaff;
	}

	public LibraryAcademicYearModel getLibraryAcademicYearModel() {
		return libraryAcademicYearModel;
	}

	public void setLibraryAcademicYearModel(LibraryAcademicYearModel libraryAcademicYearModel) {
		this.libraryAcademicYearModel = libraryAcademicYearModel;
	}

	public String getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}

}
