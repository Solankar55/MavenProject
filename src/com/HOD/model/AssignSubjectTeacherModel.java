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

@Entity
@Table(name="AssignSubjectTeacher")
public class AssignSubjectTeacherModel {

	@Id
	@GeneratedValue
	
	private int AssignSubjectTeacherID;
	private String StatusToTeacher="Assign";
	
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
	@JoinColumn(name="staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;
	
	@OneToOne
	@JoinColumn(name="SubjectID")
	private HODSubjectMasterModel hodSubjectMasterModel;

	public int getAssignSubjectTeacherID() {
		return AssignSubjectTeacherID;
	}

	public void setAssignSubjectTeacherID(int assignSubjectTeacherID) {
		AssignSubjectTeacherID = assignSubjectTeacherID;
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

	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}

	public void setStaffRegistrationModel(StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}

	public HODSubjectMasterModel getHodSubjectMasterModel() {
		return hodSubjectMasterModel;
	}

	public void setHodSubjectMasterModel(HODSubjectMasterModel hodSubjectMasterModel) {
		this.hodSubjectMasterModel = hodSubjectMasterModel;
	}

	public String getStatusToTeacher() {
		return StatusToTeacher;
	}

	public void setStatusToTeacher(String statusToTeacher) {
		StatusToTeacher = statusToTeacher;
	}
	
	
}
