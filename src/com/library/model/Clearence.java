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
@Table(name="ClearenceStudent")
public class Clearence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int ClearenceId;
	@Column
	private int TotalFine;
	@Column
	private int PaidFine;
	@Column
	private String Date;
	@Column
	private String StudentYearId;
	
	//When StudentAdmission Table generate.
		/*@ManyToOne
		@JoinColumn(name = "StudentAdmissionId")
		private StudentAdmission studentadmission;*/
	
	@OneToOne
	@JoinColumn(name = "LecturerId")
	private IssueAndReturnBookLecturer ClearID;
	
	@OneToOne
	@JoinColumn(name = "LecturerBarcode")
	private IssueAndReturnBookLecturer ClearBarcode;

	public int getClearenceId() {
		return ClearenceId;
	}

	public void setClearenceId(int clearenceId) {
		ClearenceId = clearenceId;
	}

	public int getTotalFine() {
		return TotalFine;
	}

	public void setTotalFine(int totalFine) {
		TotalFine = totalFine;
	}

	public int getPaidFine() {
		return PaidFine;
	}

	public void setPaidFine(int paidFine) {
		PaidFine = paidFine;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStudentYearId() {
		return StudentYearId;
	}

	public void setStudentYearId(String studentYearId) {
		StudentYearId = studentYearId;
	}

	public IssueAndReturnBookLecturer getClearID() {
		return ClearID;
	}

	public void setClearID(IssueAndReturnBookLecturer clearID) {
		ClearID = clearID;
	}

	public IssueAndReturnBookLecturer getClearBarcode() {
		return ClearBarcode;
	}

	public void setClearBarcode(IssueAndReturnBookLecturer clearBarcode) {
		ClearBarcode = clearBarcode;
	}

	
		
	
	
}
