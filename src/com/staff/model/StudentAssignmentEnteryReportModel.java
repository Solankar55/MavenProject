package com.staff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="StudentAssignmentEnteryReport")
public class StudentAssignmentEnteryReportModel {

	@Id
	@GeneratedValue
	
	private int AssignmentStudentEnteryID;
	private String AssignmentStudentStatus="Given";
	
	@OneToOne
	@JoinColumn(name="admissionRegId")
	private StudentAdmissionModel studentAdmissionModel;
	
	@ManyToOne
	@JoinColumn(name="AssignmentID")
	private StudentAssignmentModel studentAssignmentModel;

	public int getAssignmentStudentEnteryID() {
		return AssignmentStudentEnteryID;
	}

	public String getAssignmentStudentStatus() {
		return AssignmentStudentStatus;
	}

	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}

	public StudentAssignmentModel getStudentAssignmentModel() {
		return studentAssignmentModel;
	}

	public void setAssignmentStudentEnteryID(int assignmentStudentEnteryID) {
		AssignmentStudentEnteryID = assignmentStudentEnteryID;
	}

	public void setAssignmentStudentStatus(String assignmentStudentStatus) {
		AssignmentStudentStatus = assignmentStudentStatus;
	}

	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}

	public void setStudentAssignmentModel(StudentAssignmentModel studentAssignmentModel) {
		this.studentAssignmentModel = studentAssignmentModel;
	}
	
	
}
