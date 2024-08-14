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
@Table(name="ParentMessageEntryModel")
public class ParentMessageEntryModel {
	
	@Id
	@GeneratedValue
	
	private int parentMessageEntryID;
	private String parentMessageEntryStatus="Active";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="parentMessageID")
	private ParentMessageModel parentMessageModel;
	
	/*----------Getter And Setter ------*/

	public int getParentMessageEntryID() {
		return parentMessageEntryID;
	}

	public String getParentMessageEntryStatus() {
		return parentMessageEntryStatus;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public ParentMessageModel getParentMessageModel() {
		return parentMessageModel;
	}

	public void setParentMessageEntryID(int parentMessageEntryID) {
		this.parentMessageEntryID = parentMessageEntryID;
	}

	public void setParentMessageEntryStatus(String parentMessageEntryStatus) {
		this.parentMessageEntryStatus = parentMessageEntryStatus;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setParentMessageModel(ParentMessageModel parentMessageModel) {
		this.parentMessageModel = parentMessageModel;
	}
	
	
	
	

}
