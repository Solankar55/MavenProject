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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="IssueAndReturnBookStudent")
public class IssueAndReturnBookStudent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int IssueAndReturnBookStudentId;
	@Column
	private String BookAccessionId;     //****Barcode
	@Column
	private String StudentYearId;
	@Column
	private String ReturnDate;
	@Column
	private String IssueDate;
	@Column
	private int Fine;
	
	private String ExtraBookStatusStud="Regular";
	private String IssuedBookStatusStud="Issued";
	
	//When StudentAdmission Table generate.
	@ManyToOne
	@JoinColumn(name = "admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name = "AccessionLibraryRegisterId")
	private AccessionLibraryRegister IARBStudentA;
	
	//mapping baki
	
	/*@ManyToOne
	@JoinColumn(name = "AccessibilityId")
	private AccessibilityMaster IARBStudent;*/
	
	@JsonIgnore
	@OneToMany(mappedBy = "IARBLecturerID")
	private List<IssueAndReturnBookLecturer> issueandreturnbooklecturer = new ArrayList<>();

	public int getIssueAndReturnBookStudentId() {
		return IssueAndReturnBookStudentId;
	}

	public void setIssueAndReturnBookStudentId(int issueAndReturnBookStudentId) {
		IssueAndReturnBookStudentId = issueAndReturnBookStudentId;
	}

	public String getBookAccessionId() {
		return BookAccessionId;
	}

	public void setBookAccessionId(String bookAccessionId) {
		BookAccessionId = bookAccessionId;
	}

	public String getStudentYearId() {
		return StudentYearId;
	}

	public void setStudentYearId(String studentYearId) {
		StudentYearId = studentYearId;
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

	public AccessionLibraryRegister getIARBStudentA() {
		return IARBStudentA;
	}

	public void setIARBStudentA(AccessionLibraryRegister iARBStudentA) {
		IARBStudentA = iARBStudentA;
	}

/*	public AccessibilityMaster getIARBStudent() {
		return IARBStudent;
	}

	public void setIARBStudent(AccessibilityMaster iARBStudent) {
		IARBStudent = iARBStudent;
	}*/

	public List<IssueAndReturnBookLecturer> getIssueandreturnbooklecturer() {
		return issueandreturnbooklecturer;
	}

	public void setIssueandreturnbooklecturer(List<IssueAndReturnBookLecturer> issueandreturnbooklecturer) {
		this.issueandreturnbooklecturer = issueandreturnbooklecturer;
	}

	public String getExtraBookStatusStud() {
		return ExtraBookStatusStud;
	}

	public void setExtraBookStatusStud(String extraBookStatusStud) {
		ExtraBookStatusStud = extraBookStatusStud;
	}

	public String getIssuedBookStatusStud() {
		return IssuedBookStatusStud;
	}

	public void setIssuedBookStatusStud(String issuedBookStatusStud) {
		IssuedBookStatusStud = issuedBookStatusStud;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	
}
