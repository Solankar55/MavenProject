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
@Table(name="StudentAttendenceNoticeEntery")
public class StudentAttendanceNoticeStudentEnteryModel {

	@Id
	@GeneratedValue
	
	private int AttnedenceNoticeEnteryID;
	private String AttendenceNoticeEnteryStatus="Active";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="StudentAttendenceNoticeID")
	private StudentAttendanceNoticeModel studentAttendanceNoticeModel;

	public int getAttnedenceNoticeEnteryID() {
		return AttnedenceNoticeEnteryID;
	}

	public String getAttendenceNoticeEnteryStatus() {
		return AttendenceNoticeEnteryStatus;
	}

	public StudentAttendanceNoticeModel getStudentAttendanceNoticeModel() {
		return studentAttendanceNoticeModel;
	}

	public void setAttnedenceNoticeEnteryID(int attnedenceNoticeEnteryID) {
		AttnedenceNoticeEnteryID = attnedenceNoticeEnteryID;
	}

	public void setAttendenceNoticeEnteryStatus(String attendenceNoticeEnteryStatus) {
		AttendenceNoticeEnteryStatus = attendenceNoticeEnteryStatus;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setStudentAttendanceNoticeModel(StudentAttendanceNoticeModel studentAttendanceNoticeModel) {
		this.studentAttendanceNoticeModel = studentAttendanceNoticeModel;
	}
	
	
}
