package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentRegistration")
public class StudentRegistrationModel {

	@Id
	@GeneratedValue
	
	private int StudentRegistrationId;
	private String StudentName;
	private String StudentAddress;
	private String StudentContactNumber;
	private String StudentEmail;
	private String StudentUserName;
	private String StudentPassword;
	
	/*Getter And Setter*/
	public int getStudentRegistrationId() {
		return StudentRegistrationId;
	}
	public void setStudentRegistrationId(int studentRegistrationId) {
		StudentRegistrationId = studentRegistrationId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	public String getStudentContactNumber() {
		return StudentContactNumber;
	}
	public void setStudentContactNumber(String studentContactNumber) {
		StudentContactNumber = studentContactNumber;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public String getStudentUserName() {
		return StudentUserName;
	}
	public void setStudentUserName(String studentUserName) {
		StudentUserName = studentUserName;
	}
	public String getStudentPassword() {
		return StudentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}
	
	
}
