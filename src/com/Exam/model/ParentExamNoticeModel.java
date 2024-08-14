package com.Exam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;

@Entity
@Table(name="parentexamnoticemodel")
public class ParentExamNoticeModel {

	@Id
	@GeneratedValue
	
	private int parentexamnoticeid;
	private String parentexamnoticedate;
	
	@Column(length = 10000)
	private String parentexamnotice;
	private String parentexamnoticestatus="Active";
	private String username;
	
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
	
	@OneToMany(mappedBy="parentExamNoticeModel")
	private List<ParentExamNoticeEnteryModel> parentExamNoticeEnteryModels=new ArrayList<ParentExamNoticeEnteryModel>();

	public int getParentexamnoticeid() {
		return parentexamnoticeid;
	}

	public String getParentexamnoticedate() {
		return parentexamnoticedate;
	}

	public String getParentexamnotice() {
		return parentexamnotice;
	}

	public String getParentexamnoticestatus() {
		return parentexamnoticestatus;
	}

	public String getUsername() {
		return username;
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

	public List<ParentExamNoticeEnteryModel> getParentExamNoticeEnteryModels() {
		return parentExamNoticeEnteryModels;
	}

	public void setParentexamnoticeid(int parentexamnoticeid) {
		this.parentexamnoticeid = parentexamnoticeid;
	}

	public void setParentexamnoticedate(String parentexamnoticedate) {
		this.parentexamnoticedate = parentexamnoticedate;
	}

	public void setParentexamnotice(String parentexamnotice) {
		this.parentexamnotice = parentexamnotice;
	}

	public void setParentexamnoticestatus(String parentexamnoticestatus) {
		this.parentexamnoticestatus = parentexamnoticestatus;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setParentExamNoticeEnteryModels(List<ParentExamNoticeEnteryModel> parentExamNoticeEnteryModels) {
		this.parentExamNoticeEnteryModels = parentExamNoticeEnteryModels;
	}

	
}
