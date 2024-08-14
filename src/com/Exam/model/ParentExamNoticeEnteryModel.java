package com.Exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="parentexambnoticeenterymodel")
public class ParentExamNoticeEnteryModel {

	@Id
	@GeneratedValue
	
	private int parentexamnoticeenteryid;
	private String parentexamnoticestatus="Active";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="parentexamnoticeid")
	private ParentExamNoticeModel parentExamNoticeModel;

	public int getParentexamnoticeenteryid() {
		return parentexamnoticeenteryid;
	}

	public ParentExamNoticeModel getParentExamNoticeModel() {
		return parentExamNoticeModel;
	}

	public void setParentexamnoticeenteryid(int parentexamnoticeenteryid) {
		this.parentexamnoticeenteryid = parentexamnoticeenteryid;
	}

	public void setParentExamNoticeModel(ParentExamNoticeModel parentExamNoticeModel) {
		this.parentExamNoticeModel = parentExamNoticeModel;
	}

	public String getParentexamnoticestatus() {
		return parentexamnoticestatus;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setParentexamnoticestatus(String parentexamnoticestatus) {
		this.parentexamnoticestatus = parentexamnoticestatus;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	
	
}
