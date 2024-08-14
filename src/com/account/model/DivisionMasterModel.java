package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.StudentAdmissionModel;

@Entity
@Table(name="DivisionMaster")
public class DivisionMasterModel {

	@Id
	@GeneratedValue
	private int divisionId;
	private String diviosin;
	
	

	
	@ManyToOne
	@JoinColumn(name="standardId")
	private StandardMasterModel standardMasterModel;
	
	@ManyToOne
	@JoinColumn(name="streamId")
	private StreamMasterModel streamMasterModel ;
	
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private BranchMasterModel branchMasterModel ;
	
	@OneToOne(mappedBy="divisionMasterModel")
	private StudentAdmissionModel studentAdmissionModel;
	
	/*getter and setter */
	
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	public String getDiviosin() {
		return diviosin;
	}
	public void setDiviosin(String diviosin) {
		this.diviosin = diviosin;
	}
	public StandardMasterModel getStandardMasterModel() {
		return standardMasterModel;
	}
	public void setStandardMasterModel(StandardMasterModel standardMasterModel) {
		this.standardMasterModel = standardMasterModel;
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
	public StudentAdmissionModel getStudentAdmissionModel() {
		return studentAdmissionModel;
	}
	public void setStudentAdmissionModel(StudentAdmissionModel studentAdmissionModel) {
		this.studentAdmissionModel = studentAdmissionModel;
	}
	
}
