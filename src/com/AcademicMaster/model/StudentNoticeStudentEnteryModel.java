package com.AcademicMaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="StudentNoticeEntery")
public class StudentNoticeStudentEnteryModel {

	@Id
	@GeneratedValue
	
	private int NoticeStudentEnteryID;
	private String NoticeStatusStudent="Active";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="NoticeID")
	private StudentNoticeModel studentNoticeModel;

	public int getNoticeStudentEnteryID() {
		return NoticeStudentEnteryID;
	}

	public String getNoticeStatusStudent() {
		return NoticeStatusStudent;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public StudentNoticeModel getStudentNoticeModel() {
		return studentNoticeModel;
	}

	public void setNoticeStudentEnteryID(int noticeStudentEnteryID) {
		NoticeStudentEnteryID = noticeStudentEnteryID;
	}

	public void setNoticeStatusStudent(String noticeStatusStudent) {
		NoticeStatusStudent = noticeStatusStudent;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setStudentNoticeModel(StudentNoticeModel studentNoticeModel) {
		this.studentNoticeModel = studentNoticeModel;
	}
	
}
