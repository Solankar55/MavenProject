package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BonafideRequest")
public class StudentBonafideRequestModel {

	@Id
	@GeneratedValue
	
	private int BonafideRequestId;
	private String BonafideDate;
	private int BonafideFlag=0;
	private int DownloadCount=0;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	/*Getter And Setter*/
	public int getBonafideRequestId() {
		return BonafideRequestId;
	}

	public void setBonafideRequestId(int bonafideRequestId) {
		BonafideRequestId = bonafideRequestId;
	}
	
	public String getBonafideDate() {
		return BonafideDate;
	}

	public void setBonafideDate(String bonafideDate) {
		BonafideDate = bonafideDate;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	
	public int getBonafideFlag() {
		return BonafideFlag;
	}

	public void setBonafideFlag(int bonafideFlag) {
		BonafideFlag = bonafideFlag;
	}

	public int getDownloadCount() {
		return DownloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		DownloadCount = downloadCount;
	}
}
