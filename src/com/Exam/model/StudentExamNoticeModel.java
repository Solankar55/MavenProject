package com.Exam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;

@Entity
@Table(name="studentexamnoticemodel")
public class StudentExamNoticeModel {

	@Id
	@GeneratedValue
	
	private int examniticeid;
	private String examnoticedate;
	
	@Column(length = 10000)
	private String examnotice;
	private String examnoticestatus="Active";
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
	
	@OneToMany(mappedBy="studentExamNoticeModel",cascade=CascadeType.ALL)
	private List<StudentExamNoticeEnteryModel> studentExamNoticeEnteryModel=new ArrayList<StudentExamNoticeEnteryModel>();

	/*Getter and Setter*/
	
	public int getExamniticeid() {
		return examniticeid;
	}

	public String getExamnoticedate() {
		return examnoticedate;
	}

	public String getExamnotice() {
		return examnotice;
	}

	public String getExamnoticestatus() {
		return examnoticestatus;
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

	public List<StudentExamNoticeEnteryModel> getStudentExamNoticeEnteryModel() {
		return studentExamNoticeEnteryModel;
	}

	public void setExamniticeid(int examniticeid) {
		this.examniticeid = examniticeid;
	}

	public void setExamnoticedate(String examnoticedate) {
		this.examnoticedate = examnoticedate;
	}

	public void setExamnotice(String examnotice) {
		this.examnotice = examnotice;
	}

	public void setExamnoticestatus(String examnoticestatus) {
		this.examnoticestatus = examnoticestatus;
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

	public void setStudentExamNoticeEnteryModel(List<StudentExamNoticeEnteryModel> studentExamNoticeEnteryModel) {
		this.studentExamNoticeEnteryModel = studentExamNoticeEnteryModel;
	}

	
}
