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

import com.HOD.model.StaffRegistrationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="IssueAndReturnBookLecturer")
public class IssueAndReturnBookLecturer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int IssueAndReturnBookLecturerId;
	@Column
	private int LecturerId;
	@Column
	private String ReturnDate;
	@Column
	private String IssueDate;
	@Column
	private int Fine;
	@Column
	private String BookBarcode;
	@Column
	private String LecturerBarcode;
	private String ExtraBookStatus="Regular";
	private String IssuedBookStatus="Issued";
///
	@ManyToOne
	@JoinColumn(name = "BookAccessionId")
	private IssueAndReturnBookStudent IARBLecturerID;
	
	@ManyToOne
	@JoinColumn(name = "AccessionLibraryRegisterId")
	private AccessionLibraryRegister IARBLecturerA;
	
	@ManyToOne
	@JoinColumn(name = "AccessibilityId")
	private AccessibilityMaster IARBLecturer;
	
	@JsonIgnore
	@OneToOne(mappedBy = "ClearID")
	private Clearence clearence;
	
	@JsonIgnore
	@OneToOne(mappedBy = "ClearBarcode")
	private Clearence clear;

	@ManyToOne
	@JoinColumn(name="staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;

	public int getIssueAndReturnBookLecturerId() {
		return IssueAndReturnBookLecturerId;
	}

	public void setIssueAndReturnBookLecturerId(int issueAndReturnBookLecturerId) {
		IssueAndReturnBookLecturerId = issueAndReturnBookLecturerId;
	}

	public int getLecturerId() {
		return LecturerId;
	}

	public void setLecturerId(int lecturerId) {
		LecturerId = lecturerId;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public String getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}

	public int getFine() {
		return Fine;
	}

	public void setFine(int fine) {
		Fine = fine;
	}

	public String getBookBarcode() {
		return BookBarcode;
	}

	public void setBookBarcode(String bookBarcode) {
		BookBarcode = bookBarcode;
	}

	public String getLecturerBarcode() {
		return LecturerBarcode;
	}

	public void setLecturerBarcode(String lecturerBarcode) {
		LecturerBarcode = lecturerBarcode;
	}

	public String getExtraBookStatus() {
		return ExtraBookStatus;
	}

	public void setExtraBookStatus(String extraBookStatus) {
		ExtraBookStatus = extraBookStatus;
	}

	public String getIssuedBookStatus() {
		return IssuedBookStatus;
	}

	public void setIssuedBookStatus(String issuedBookStatus) {
		IssuedBookStatus = issuedBookStatus;
	}

	public IssueAndReturnBookStudent getIARBLecturerID() {
		return IARBLecturerID;
	}

	public void setIARBLecturerID(IssueAndReturnBookStudent iARBLecturerID) {
		IARBLecturerID = iARBLecturerID;
	}

	public AccessionLibraryRegister getIARBLecturerA() {
		return IARBLecturerA;
	}

	public void setIARBLecturerA(AccessionLibraryRegister iARBLecturerA) {
		IARBLecturerA = iARBLecturerA;
	}

	public AccessibilityMaster getIARBLecturer() {
		return IARBLecturer;
	}

	public void setIARBLecturer(AccessibilityMaster iARBLecturer) {
		IARBLecturer = iARBLecturer;
	}

	public Clearence getClearence() {
		return clearence;
	}

	public void setClearence(Clearence clearence) {
		this.clearence = clearence;
	}

	public Clearence getClear() {
		return clear;
	}

	public void setClear(Clearence clear) {
		this.clear = clear;
	}

	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}

	public void setStaffRegistrationModel(
			StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}
	
	
	
	
}
