package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IDCardRequest")
public class StudentIDCardRequestModel {

	@Id
	@GeneratedValue
	
	private int IDCardRequestID;
	private int IDrequestFlag=0;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	public int getIDCardRequestID() {
		return IDCardRequestID;
	}

	public void setIDCardRequestID(int iDCardRequestID) {
		IDCardRequestID = iDCardRequestID;
	}

	public int getIDrequestFlag() {
		return IDrequestFlag;
	}

	public void setIDrequestFlag(int iDrequestFlag) {
		IDrequestFlag = iDrequestFlag;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	
}
