package com.staff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="StudentEnteryOfAttendance")
public class StudentEnteryOfAttendance {

	@Id
	@GeneratedValue
	
	private int StudentEnteryOfAttendanceid;
	private String StudentPresenty="Absent";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="AttendanceID")
	private StudentAttendance studentAttendance;

	public int getStudentEnteryOfAttendanceid() {
		return StudentEnteryOfAttendanceid;
	}

	public void setStudentEnteryOfAttendanceid(int studentEnteryOfAttendanceid) {
		StudentEnteryOfAttendanceid = studentEnteryOfAttendanceid;
	}

	public String getStudentPresenty() {
		return StudentPresenty;
	}

	public void setStudentPresenty(String studentPresenty) {
		StudentPresenty = studentPresenty;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public StudentAttendance getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(StudentAttendance studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	
	
}
