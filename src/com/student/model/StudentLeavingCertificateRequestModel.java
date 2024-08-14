package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LeavingCertificateRequest")
public class StudentLeavingCertificateRequestModel {

	@Id
	@GeneratedValue
	
	private int LeavingCertificateReuestId;
	private String LeavingCertificateDate;
	private int LeavingCertificateFlag=0;
	private String Remark;
	private String DateOfLeaving;
	private String Conduct;
	private String ReasonForLeaving;
	
	public int getLeavingCertificateFlag() {
		return LeavingCertificateFlag;
	}

	public void setLeavingCertificateFlag(int leavingCertificateFlag) {
		LeavingCertificateFlag = leavingCertificateFlag;
	}

	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	/*Getter And Setter*/
	public int getLeavingCertificateReuestId() {
		return LeavingCertificateReuestId;
	}

	public void setLeavingCertificateReuestId(int leavingCertificateReuestId) {
		LeavingCertificateReuestId = leavingCertificateReuestId;
	}

	
	public String getLeavingCertificateDate() {
		return LeavingCertificateDate;
	}

	public void setLeavingCertificateDate(String leavingCertificateDate) {
		LeavingCertificateDate = leavingCertificateDate;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public String getRemark() {
		return Remark;
	}

	public String getDateOfLeaving() {
		return DateOfLeaving;
	}

	public String getConduct() {
		return Conduct;
	}

	public String getReasonForLeaving() {
		return ReasonForLeaving;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public void setDateOfLeaving(String dateOfLeaving) {
		DateOfLeaving = dateOfLeaving;
	}

	public void setConduct(String conduct) {
		Conduct = conduct;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		ReasonForLeaving = reasonForLeaving;
	}
	
	
}
