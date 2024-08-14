package com.HOD.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.AcademicMaster.model.StaffMeetingNoticeStaffEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeEnteryModel;
import com.library.model.IssueAndReturnBookLecturer;

@Entity
@Table(name = "StaffRegistration")
public class StaffRegistrationModel {

	@Id
	@GeneratedValue
	private int staffRegistrationId;
	private String StaffType;
	private String StaffName;
	private String Qalification;
	private String YearOfExperience;
	private String StaffAddress;
	private String SatffDepartment;
	private String MobileNumber;
	private String StaffEmail;
	private String StaffRegDate;
	private String UserName;
	private String Password;
	private String barcode;
	
	private String staffstatus="On";
	
	/*------------ Mapping  --------------*/
	
	@OneToOne(mappedBy = "staffRegistrationModel")
	private AssignClassInchargeModel assignClassInchargeModel;

	@OneToOne(mappedBy = "staffRegistrationModel")
	private AssignDepartmentmodel assignDepartmentmodel;

	@OneToOne(mappedBy="staffRegistrationModel")
	private AssignSubjectTeacherModel assignSubjectTeacherModel;
	
	@OneToMany(mappedBy="staffRegistrationModel")
	private List<IssueAndReturnBookLecturer> issueAndReturnBookLecturer=new ArrayList<IssueAndReturnBookLecturer>();
	
	@OneToOne(mappedBy="staffRegistrationModel")
	private StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel;
	
	@OneToOne(mappedBy="staffRegistrationModel")
	private StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel;
	
	/*------------Getter And Setter Methods --------------*/
	
	public int getStaffRegistrationId() {
		return staffRegistrationId;
	}

	public void setStaffRegistrationId(int staffRegistrationId) {
		this.staffRegistrationId = staffRegistrationId;
	}

	public String getStaffType() {
		return StaffType;
	}

	public void setStaffType(String staffType) {
		StaffType = staffType;
	}

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public String getQalification() {
		return Qalification;
	}

	public void setQalification(String qalification) {
		Qalification = qalification;
	}

	public String getYearOfExperience() {
		return YearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		YearOfExperience = yearOfExperience;
	}

	public String getStaffAddress() {
		return StaffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		StaffAddress = staffAddress;
	}

	public String getSatffDepartment() {
		return SatffDepartment;
	}

	public void setSatffDepartment(String satffDepartment) {
		SatffDepartment = satffDepartment;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getStaffEmail() {
		return StaffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		StaffEmail = staffEmail;
	}

	public String getStaffRegDate() {
		return StaffRegDate;
	}

	public void setStaffRegDate(String staffRegDate) {
		StaffRegDate = staffRegDate;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public AssignClassInchargeModel getAssignClassInchargeModel() {
		return assignClassInchargeModel;
	}

	public void setAssignClassInchargeModel(AssignClassInchargeModel assignClassInchargeModel) {
		this.assignClassInchargeModel = assignClassInchargeModel;
	}

	public AssignDepartmentmodel getAssignDepartmentmodel() {
		return assignDepartmentmodel;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setAssignDepartmentmodel(AssignDepartmentmodel assignDepartmentmodel) {
		this.assignDepartmentmodel = assignDepartmentmodel;
	}

	public AssignSubjectTeacherModel getAssignSubjectTeacherModel() {
		return assignSubjectTeacherModel;
	}

	public void setAssignSubjectTeacherModel(AssignSubjectTeacherModel assignSubjectTeacherModel) {
		this.assignSubjectTeacherModel = assignSubjectTeacherModel;
	}

	public List<IssueAndReturnBookLecturer> getIssueAndReturnBookLecturer() {
		return issueAndReturnBookLecturer;
	}

	public void setIssueAndReturnBookLecturer(List<IssueAndReturnBookLecturer> issueAndReturnBookLecturer) {
		this.issueAndReturnBookLecturer = issueAndReturnBookLecturer;
	}

	public StaffMeetingNoticeStaffEnteryModel getStaffMeetingNoticeStaffEnteryModel() {
		return staffMeetingNoticeStaffEnteryModel;
	}

	public void setStaffMeetingNoticeStaffEnteryModel(
			StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel) {
		this.staffMeetingNoticeStaffEnteryModel = staffMeetingNoticeStaffEnteryModel;
	}

	public StaffProgramNoticeEnteryModel getStaffProgramNoticeEnteryModel() {
		return staffProgramNoticeEnteryModel;
	}

	public void setStaffProgramNoticeEnteryModel(StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel) {
		this.staffProgramNoticeEnteryModel = staffProgramNoticeEnteryModel;
	}

	public String getStaffstatus() {
		return staffstatus;
	}

	public void setStaffstatus(String staffstatus) {
		this.staffstatus = staffstatus;
	}

}
