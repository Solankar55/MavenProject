package com.AcademicMaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="StaffMeetingNotice")
public class StaffMeetingNoticeModel {

	@Id
	@GeneratedValue
	
	private int StaffMeetingNoticeID;
	private String StaffNoticeDate;
	private String StaffType;
	
	@Column(length = 10000)
	private String StaffNotice;
	private String StaffNoticeStatus="Active";
	private String TeacherName;
	
	@OneToMany(mappedBy="staffMeetingNoticeModel")
	private List<StaffMeetingNoticeStaffEnteryModel> staffMeetingNoticeStaffEnteryModels=new ArrayList<>();

	public int getStaffMeetingNoticeID() {
		return StaffMeetingNoticeID;
	}

	public String getStaffNoticeDate() {
		return StaffNoticeDate;
	}

	public String getStaffType() {
		return StaffType;
	}

	public String getStaffNotice() {
		return StaffNotice;
	}

	public String getStaffNoticeStatus() {
		return StaffNoticeStatus;
	}

	public List<StaffMeetingNoticeStaffEnteryModel> getStaffMeetingNoticeStaffEnteryModels() {
		return staffMeetingNoticeStaffEnteryModels;
	}

	public void setStaffMeetingNoticeID(int staffMeetingNoticeID) {
		StaffMeetingNoticeID = staffMeetingNoticeID;
	}

	public void setStaffNoticeDate(String staffNoticeDate) {
		StaffNoticeDate = staffNoticeDate;
	}

	public void setStaffType(String staffType) {
		StaffType = staffType;
	}

	public void setStaffNotice(String staffNotice) {
		StaffNotice = staffNotice;
	}

	public void setStaffNoticeStatus(String staffNoticeStatus) {
		StaffNoticeStatus = staffNoticeStatus;
	}

	public void setStaffMeetingNoticeStaffEnteryModels(
			List<StaffMeetingNoticeStaffEnteryModel> staffMeetingNoticeStaffEnteryModels) {
		this.staffMeetingNoticeStaffEnteryModels = staffMeetingNoticeStaffEnteryModels;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
	
}
