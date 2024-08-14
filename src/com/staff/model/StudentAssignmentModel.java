package com.staff.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.HOD.model.HODSubjectMasterModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;

@Entity
@Table(name="StudentAssignment")
public class StudentAssignmentModel {

	@Id
	@GeneratedValue
	
	private int AssignmentID;
	
	private String AssignmentDate;
	
	@Column(length = 10000) 
	private String AssignmentMessage;
	
	private String AssignmentStatus="Given";
	
	@OneToOne
	@JoinColumn(name="acadamicYearId")
	private acadamicYearModel acadamicYearModel;
	
	@OneToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel;
	
	@OneToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel;
	
	@OneToOne
	@JoinColumn(name="standardId")
	private StandardMasterModel standardMasterModel;
	
	@OneToOne
	@JoinColumn(name="SubjectID")
	private HODSubjectMasterModel hodSubjectMasterModel;
	
	@OneToMany(mappedBy="studentAssignmentModel")
	private List<StudentAssignmentEnteryReportModel> StudentAssignmentEnteryReportModel=new ArrayList<StudentAssignmentEnteryReportModel>();

	public int getAssignmentID() {
		return AssignmentID;
	}

	public String getAssignmentDate() {
		return AssignmentDate;
	}

	public String getAssignmentMessage() {
		return AssignmentMessage;
	}

	public String getAssignmentStatus() {
		return AssignmentStatus;
	}

	public acadamicYearModel getAcadamicYearModel() {
		return acadamicYearModel;
	}

	public StreamMasterModel getStreamMasterModel() {
		return streamMasterModel;
	}

	public BranchMasterModel getBranchMasterModel() {
		return branchMasterModel;
	}

	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}

	public HODSubjectMasterModel getHodSubjectMasterModel() {
		return hodSubjectMasterModel;
	}

	public List<StudentAssignmentEnteryReportModel> getStudentAssignmentEnteryReportModel() {
		return StudentAssignmentEnteryReportModel;
	}

	public void setAssignmentID(int assignmentID) {
		AssignmentID = assignmentID;
	}

	public void setAssignmentDate(String assignmentDate) {
		AssignmentDate = assignmentDate;
	}

	public void setAssignmentMessage(String assignmentMessage) {
		AssignmentMessage = assignmentMessage;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		AssignmentStatus = assignmentStatus;
	}

	public void setAcadamicYearModel(acadamicYearModel acadamicYearModel) {
		this.acadamicYearModel = acadamicYearModel;
	}

	public void setStreamMasterModel(StreamMasterModel streamMasterModel) {
		this.streamMasterModel = streamMasterModel;
	}

	public void setBranchMasterModel(BranchMasterModel branchMasterModel) {
		this.branchMasterModel = branchMasterModel;
	}

	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
	}

	public void setHodSubjectMasterModel(HODSubjectMasterModel hodSubjectMasterModel) {
		this.hodSubjectMasterModel = hodSubjectMasterModel;
	}

	public void setStudentAssignmentEnteryReportModel(
			List<StudentAssignmentEnteryReportModel> studentAssignmentEnteryReportModel) {
		StudentAssignmentEnteryReportModel = studentAssignmentEnteryReportModel;
	}
	
	
}
