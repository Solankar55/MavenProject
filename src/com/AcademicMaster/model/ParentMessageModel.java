package com.AcademicMaster.model;

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
@Table(name="ParentMessageModel")
public class ParentMessageModel {
	
	@Id
	@GeneratedValue
	private int parentMessageID;
	private String parentMessageDate;
	private String parentMessageStatus="Active";
	
	@Column(length = 10000)
	private String parentMessage;
	private String TeacherName;
	
	/*-----------Mapping----------*/
	
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
	private StandardMasterModel standardMasterModel ;
	
	@OneToMany(mappedBy="parentMessageModel")
	List<ParentMessageEntryModel> parentMessageEntryModel=new ArrayList<ParentMessageEntryModel>();

	/*----------Getter And Setter ------*/
	public int getParentMessageID() {
		return parentMessageID;
	}

	public String getParentMessageDate() {
		return parentMessageDate;
	}

	public String getParentMessageStatus() {
		return parentMessageStatus;
	}

	public String getParentMessage() {
		return parentMessage;
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

	public List<ParentMessageEntryModel> getParentMessageEntryModel() {
		return parentMessageEntryModel;
	}

	public void setParentMessageID(int parentMessageID) {
		this.parentMessageID = parentMessageID;
	}

	public void setParentMessageDate(String parentMessageDate) {
		this.parentMessageDate = parentMessageDate;
	}

	public void setParentMessageStatus(String parentMessageStatus) {
		this.parentMessageStatus = parentMessageStatus;
	}

	public void setParentMessage(String parentMessage) {
		this.parentMessage = parentMessage;
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

	public void setParentMessageEntryModel(List<ParentMessageEntryModel> parentMessageEntryModel) {
		this.parentMessageEntryModel = parentMessageEntryModel;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
	
	                 

}
