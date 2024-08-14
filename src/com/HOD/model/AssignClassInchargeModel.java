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
@Table(name="AssignClassIncharge")
public class AssignClassInchargeModel {
	
	@Id
	@GeneratedValue
	
	private int AssignClassInchargeId;
	private String Status="Assigned";
	private String OkOrNot="Complete";
	
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

	public int getAssignClassInchargeId() {
		return AssignClassInchargeId;
	}

	public void setAssignClassInchargeId(int assignClassInchargeId) {
		AssignClassInchargeId = assignClassInchargeId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	public String getOkOrNot() {
		return OkOrNot;
	}

	public void setOkOrNot(String okOrNot) {
		OkOrNot = okOrNot;
	}
	
	
}
