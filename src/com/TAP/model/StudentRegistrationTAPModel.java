package com.TAP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentRegistrationTAP")
public class StudentRegistrationTAPModel {

	@Id
	@GeneratedValue
	
	private int TAPId;
	private String StudentFullName;
	private String StudentAddress;
	private String StudentContactNumber;
	private String StudentGender;
	private String StudentDOB;
	private String StudentEmail;
	private String StudentCategory;
	private String StudentCast;
	private String StudentQualification;
	private String StudentAreaOfJob;
	private String StudentApplicationDate;
	private String StudentApplicationPlace;
	
	
	public int getTAPId() {
		return TAPId;
	}
	public String getStudentFullName() {
		return StudentFullName;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public String getStudentContactNumber() {
		return StudentContactNumber;
	}
	public String getStudentGender() {
		return StudentGender;
	}
	public String getStudentDOB() {
		return StudentDOB;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public String getStudentCategory() {
		return StudentCategory;
	}
	public String getStudentCast() {
		return StudentCast;
	}
	public String getStudentQualification() {
		return StudentQualification;
	}
	public String getStudentAreaOfJob() {
		return StudentAreaOfJob;
	}
	public String getStudentApplicationDate() {
		return StudentApplicationDate;
	}
	public String getStudentApplicationPlace() {
		return StudentApplicationPlace;
	}
	public void setTAPId(int tAPId) {
		TAPId = tAPId;
	}
	public void setStudentFullName(String studentFullName) {
		StudentFullName = studentFullName;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	public void setStudentContactNumber(String studentContactNumber) {
		StudentContactNumber = studentContactNumber;
	}
	public void setStudentGender(String studentGender) {
		StudentGender = studentGender;
	}
	public void setStudentDOB(String studentDOB) {
		StudentDOB = studentDOB;
	}
	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}
	public void setStudentCategory(String studentCategory) {
		StudentCategory = studentCategory;
	}
	public void setStudentCast(String studentCast) {
		StudentCast = studentCast;
	}
	public void setStudentQualification(String studentQualification) {
		StudentQualification = studentQualification;
	}
	public void setStudentAreaOfJob(String studentAreaOfJob) {
		StudentAreaOfJob = studentAreaOfJob;
	}
	public void setStudentApplicationDate(String studentApplicationDate) {
		StudentApplicationDate = studentApplicationDate;
	}
	public void setStudentApplicationPlace(String studentApplicationPlace) {
		StudentApplicationPlace = studentApplicationPlace;
	}
	
	
}
