package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StudentProfilePic")
public class StudentProfilePicModel {

	@Id
	@GeneratedValue
	
	private int StudentPicId;
	private String imageName;
	private String uploadDate;
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	public int getStudentPicId() {
		return StudentPicId;
	}

	public void setStudentPicId(int studentPicId) {
		StudentPicId = studentPicId;
	}

	
	public String getImageName() {
		return imageName;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	
	
}
