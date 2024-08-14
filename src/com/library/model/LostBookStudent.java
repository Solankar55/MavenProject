package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="LostBookStudent")
public class LostBookStudent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int LostbookStudentId;
	
	@Column
	private String DateLost;
	@Column
	private String FinePaidDate;
	@Column
	private String FineStatus;
	@Column
	private String ActiveAcademicYear;
	
	
	@ManyToOne
	@JoinColumn(name="AccessionLibraryRegisterId")
	private AccessionLibraryRegister ALRegister;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="acadamicYearId")
	private acadamicYearModel acadamicYearModel;

	
	public int getLostbookStudentId() {
		return LostbookStudentId;
	}

	public void setLostbookStudentId(int lostbookStudentId) {
		LostbookStudentId = lostbookStudentId;
	}

	public String getDateLost() {
		return DateLost;
	}

	public void setDateLost(String dateLost) {
		DateLost = dateLost;
	}

	public String getFinePaidDate() {
		return FinePaidDate;
	}

	public void setFinePaidDate(String finePaidDate) {
		FinePaidDate = finePaidDate;
	}

	public String getFineStatus() {
		return FineStatus;
	}

	public void setFineStatus(String fineStatus) {
		FineStatus = fineStatus;
	}

	
	public void setActiveAcademicYear(String acYear) {
		ActiveAcademicYear = acYear;
	}

	public AccessionLibraryRegister getALRegister() {
		return ALRegister;
	}

	public void setALRegister(AccessionLibraryRegister aLRegister) {
		ALRegister = aLRegister;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}

	public String getActiveAcademicYear() {
		return ActiveAcademicYear;
	}
	
	
}
