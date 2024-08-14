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
@Table(name="StaffProgramNotice")
public class StaffProgramNoticeModel {

	@Id
	@GeneratedValue
	
	private int StaffProgramNoticeID;
	private String staffProgramNoticeDate;
	private String staffType;
	
	@Column(length = 10000)
	private String staffProgramNotice;
	private String staffProgramNoticeStatus="Active";
	private String TeacherName;
	
	/*------------ Mapping  --------------*/
	
	 @OneToMany(mappedBy="staffProgramNoticeModel")
	 List<StaffProgramNoticeEnteryModel> staffProgramNoticeEnteryModel=new ArrayList<StaffProgramNoticeEnteryModel>();
	
	 /*------------Getter And Setter Methods --------------*/
	
	public int getStaffProgramNoticeID() {
		return StaffProgramNoticeID;
	}
	public String getStaffProgramNoticeDate() {
		return staffProgramNoticeDate;
	}
	public String getStaffType() {
		return staffType;
	}
	public String getStaffProgramNotice() {
		return staffProgramNotice;
	}
	public String getStaffProgramNoticeStatus() {
		return staffProgramNoticeStatus;
	}
	public void setStaffProgramNoticeID(int staffProgramNoticeID) {
		StaffProgramNoticeID = staffProgramNoticeID;
	}
	public void setStaffProgramNoticeDate(String staffProgramNoticeDate) {
		this.staffProgramNoticeDate = staffProgramNoticeDate;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public void setStaffProgramNotice(String staffProgramNotice) {
		this.staffProgramNotice = staffProgramNotice;
	}
	public void setStaffProgramNoticeStatus(String staffProgramNoticeStatus) {
		this.staffProgramNoticeStatus = staffProgramNoticeStatus;
	}
	public List<StaffProgramNoticeEnteryModel> getStaffProgramNoticeEnteryModel() {
		return staffProgramNoticeEnteryModel;
	}
	public void setStaffProgramNoticeEnteryModel(List<StaffProgramNoticeEnteryModel> staffProgramNoticeEnteryModel) {
		this.staffProgramNoticeEnteryModel = staffProgramNoticeEnteryModel;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
	
}
