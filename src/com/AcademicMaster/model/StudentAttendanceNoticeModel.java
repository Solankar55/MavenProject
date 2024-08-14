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
@Table(name="StudentAttendanceNotice")
public class StudentAttendanceNoticeModel {

	@Id
	@GeneratedValue
	
	private int StudentAttendenceNoticeID;
	private String NoticeDate;
	
	@Column(length = 10000)
	private String AttendanceNotice;
	private String AttendanceNoticeStatus="Active";
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
	
	@OneToMany(mappedBy="studentAttendanceNoticeModel")
	private List<StudentAttendanceNoticeStudentEnteryModel> studentAttendanceNoticeStudentEnteryModels=new ArrayList<StudentAttendanceNoticeStudentEnteryModel>();

	public int getStudentAttendenceNoticeID() {
		return StudentAttendenceNoticeID;
	}

	public String getNoticeDate() {
		return NoticeDate;
	}

	public String getAttendanceNotice() {
		return AttendanceNotice;
	}

	public String getAttendanceNoticeStatus() {
		return AttendanceNoticeStatus;
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

	public List<StudentAttendanceNoticeStudentEnteryModel> getStudentAttendanceNoticeStudentEnteryModels() {
		return studentAttendanceNoticeStudentEnteryModels;
	}

	public void setStudentAttendenceNoticeID(int studentAttendenceNoticeID) {
		StudentAttendenceNoticeID = studentAttendenceNoticeID;
	}

	public void setNoticeDate(String noticeDate) {
		NoticeDate = noticeDate;
	}

	public void setAttendanceNotice(String attendanceNotice) {
		AttendanceNotice = attendanceNotice;
	}

	public void setAttendanceNoticeStatus(String attendanceNoticeStatus) {
		AttendanceNoticeStatus = attendanceNoticeStatus;
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

	public void setStudentAttendanceNoticeStudentEnteryModels(
			List<StudentAttendanceNoticeStudentEnteryModel> studentAttendanceNoticeStudentEnteryModels) {
		this.studentAttendanceNoticeStudentEnteryModels = studentAttendanceNoticeStudentEnteryModels;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
	
}
