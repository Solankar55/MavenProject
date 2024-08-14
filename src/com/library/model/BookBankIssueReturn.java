package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name = "BookBankIssueReturn")
public class BookBankIssueReturn {
	
	@Id
	@GeneratedValue
	private int bookBandIssueReturnId;
	private String bookAccessionId;
	private String studentAcYearId;
	private String bkReturnDate;
	private String bkIssueDate;
	private String IssuedBookStatus="Issued";
	private double Fine=0.0;
	
	@ManyToOne
	@JoinColumn(name="AccessionLibraryRegisterId")
	private AccessionLibraryRegister accessionLibraryRegister;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel ;
	
	public int getBookBandIssueReturnId() {
		return bookBandIssueReturnId;
	}
	public void setBookBandIssueReturnId(int bookBandIssueReturnId) {
		this.bookBandIssueReturnId = bookBandIssueReturnId;
	}
	
	
	public String getBookAccessionId() {
		return bookAccessionId;
	}
	public void setBookAccessionId(String bookAccessionId) {
		this.bookAccessionId = bookAccessionId;
	}
	public String getStudentAcYearId() {
		return studentAcYearId;
	}
	public void setStudentAcYearId(String studentAcYearId) {
		this.studentAcYearId = studentAcYearId;
	}
	public String getBkReturnDate() {
		return bkReturnDate;
	}
	public void setBkReturnDate(String bkReturnDate) {
		this.bkReturnDate = bkReturnDate;
	}
	public String getBkIssueDate() {
		return bkIssueDate;
	}
	public void setBkIssueDate(String bkIssueDate) {
		this.bkIssueDate = bkIssueDate;
	}
	public String getIssuedBookStatus() {
		return IssuedBookStatus;
	}
	public void setIssuedBookStatus(String issuedBookStatus) {
		IssuedBookStatus = issuedBookStatus;
	}
	public double getFine() {
		return Fine;
	}
	public void setFine(double fine) {
		Fine = fine;
	}
	public AccessionLibraryRegister getAccessionLibraryRegister() {
		return accessionLibraryRegister;
	}
	public void setAccessionLibraryRegister(AccessionLibraryRegister accessionLibraryRegister) {
		this.accessionLibraryRegister = accessionLibraryRegister;
	}
	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}
	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	

	
	

}
