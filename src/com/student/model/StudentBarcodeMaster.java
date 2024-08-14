package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentbarcodemaster")
public class StudentBarcodeMaster {

	@Id
	@GeneratedValue
	private int barcodeid;
	private String studentbarcode;
	
	@ManyToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;

	public int getBarcodeid() {
		return barcodeid;
	}

	public String getStudentbarcode() {
		return studentbarcode;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public void setBarcodeid(int barcodeid) {
		this.barcodeid = barcodeid;
	}

	public void setStudentbarcode(String studentbarcode) {
		this.studentbarcode = studentbarcode;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	
	
	
	
	
}
