package com.HOD.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.staff.model.StudentAssignmentModel;
import com.staff.model.StudentAttendance;

@Entity
@Table(name="SubjectMasterHOD")
public class HODSubjectMasterModel {

	@Id
	@GeneratedValue
	
	private int SubjectID;
	private String SubjectName;
	
	@OneToOne
	@JoinColumn(name="acadamicYearId")
	private acadamicYearModel  acadamicYearModel;
	
	@OneToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel;
	
	@OneToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel;
	
	@OneToOne
	@JoinColumn(name="standardId")
	private StandardMasterModel standardMasterModel;
	
	@OneToOne(mappedBy="hodSubjectMasterModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToOne(mappedBy="hodSubjectMasterModel")
	private StudentAttendance studentAttendance;
	
	@OneToOne(mappedBy="hodSubjectMasterModel")
	private StudentAssignmentModel studentAssignmentModel;
	
	public int getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public AssignSubjectTeacherModel getAssignSubjectTeacherModel() {
		return assignSubjectTeacherModel;
	}
	public void setAssignSubjectTeacherModel(AssignSubjectTeacherModel assignSubjectTeacherModel) {
		this.assignSubjectTeacherModel = assignSubjectTeacherModel;
	}
	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}
	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}
	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}
	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}
	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}
	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
	}
	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}
	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}
	public StudentAttendance getStudentAttendance() {
		return studentAttendance;
	}
	public void setStudentAttendance(StudentAttendance studentAttendance) {
		this.studentAttendance = studentAttendance;
	}
	public StudentAssignmentModel getStudentAssignmentModel() {
		return studentAssignmentModel;
	}
	public void setStudentAssignmentModel(StudentAssignmentModel studentAssignmentModel) {
		this.studentAssignmentModel = studentAssignmentModel;
	}
	
	
	
}
