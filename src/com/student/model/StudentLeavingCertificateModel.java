package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LeavingCertificate")
public class StudentLeavingCertificateModel {

	@Id
	@GeneratedValue
	
	private int LeavingCertificateId;
	private String Remark;
	private String Status;
	private String DateOfLeaving;
	private String Conduct;
	private String Progress;
	private String ReasonForLeaving;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	 /*Getter And Setter*/
	public int getLeavingCertificateId() {
		return LeavingCertificateId;
	}

	public void setLeavingCertificateId(int leavingCertificateId) {
		LeavingCertificateId = leavingCertificateId;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDateOfLeaving() {
		return DateOfLeaving;
	}

	public void setDateOfLeaving(String dateOfLeaving) {
		DateOfLeaving = dateOfLeaving;
	}

	public String getConduct() {
		return Conduct;
	}

	public void setConduct(String conduct) {
		Conduct = conduct;
	}

	public String getProgress() {
		return Progress;
	}

	public void setProgress(String progress) {
		Progress = progress;
	}

	public String getReasonForLeaving() {
		return ReasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		ReasonForLeaving = reasonForLeaving;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	
	
}
