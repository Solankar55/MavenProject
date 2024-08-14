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
@Table(name="studentexamnoticeenterymodel")
public class StudentExamNoticeEnteryModel {

	@Id
	@GeneratedValue
	
	private int examnoticeenteryid;
	private String examnoticestatus="Active";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="examniticeid")
	private StudentExamNoticeModel studentExamNoticeModel;

	public int getExamnoticeenteryid() {
		return examnoticeenteryid;
	}

	public String getExamnoticestatus() {
		return examnoticestatus;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public StudentExamNoticeModel getStudentExamNoticeModel() {
		return studentExamNoticeModel;
	}

	public void setExamnoticeenteryid(int examnoticeenteryid) {
		this.examnoticeenteryid = examnoticeenteryid;
	}

	public void setExamnoticestatus(String examnoticestatus) {
		this.examnoticestatus = examnoticestatus;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setStudentExamNoticeModel(StudentExamNoticeModel studentExamNoticeModel) {
		this.studentExamNoticeModel = studentExamNoticeModel;
	}
	
	
}
