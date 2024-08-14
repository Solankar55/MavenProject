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
@Table(name="StudentNotice")
public class StudentNoticeModel {

	@Id
	@GeneratedValue
	
	private int NoticeID;
	private String NoticeDate;
	
	@Column(length = 10000)
	private String StudentNotice;
	private String NoticeStatus="Active";
	private String TeacherName;
	
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
	
	@OneToMany(mappedBy="studentNoticeModel")
	private List<StudentNoticeStudentEnteryModel> studentNoticeStudentEnteryModels=new ArrayList<StudentNoticeStudentEnteryModel>();

	public int getNoticeID() {
		return NoticeID;
	}

	public String getNoticeDate() {
		return NoticeDate;
	}

	public String getStudentNotice() {
		return StudentNotice;
	}

	public String getNoticeStatus() {
		return NoticeStatus;
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

	public List<StudentNoticeStudentEnteryModel> getStudentNoticeStudentEnteryModels() {
		return studentNoticeStudentEnteryModels;
	}

	public void setNoticeID(int noticeID) {
		NoticeID = noticeID;
	}

	public void setNoticeDate(String noticeDate) {
		NoticeDate = noticeDate;
	}

	public void setStudentNotice(String studentNotice) {
		StudentNotice = studentNotice;
	}

	public void setNoticeStatus(String noticeStatus) {
		NoticeStatus = noticeStatus;
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

	public void setStudentNoticeStudentEnteryModels(
			List<StudentNoticeStudentEnteryModel> studentNoticeStudentEnteryModels) {
		this.studentNoticeStudentEnteryModels = studentNoticeStudentEnteryModels;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
}
