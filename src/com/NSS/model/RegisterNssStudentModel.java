package com.NSS.model;

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
@Table(name="RegisterNSSUser")
public class RegisterNssStudentModel {

	@Id
	@GeneratedValue
	
	private int NSSRegisterID;
	private String status="DisApproved";
	private String StudName;
	private String StudAddress;
	private String PhoneNumber;
	private String MobileNumber;
	private String StudMail;
	private String StudCategory;
	private int StudMark;
	private int StudMarkOutOff;
	private String StudPercent;
	private String ApplicaionDate;
	private String StudPlace;
	private String ApproveDate="CurrentDate";
	private String DisApproveDate="CurrentDate";
	
	private int StudMarkPCM;
	private int StudMarkPCB;
	private int StudMarkPCMB;
	
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

	public int getNSSRegisterID() {
		return NSSRegisterID;
	}

	public void setNSSRegisterID(int nSSRegisterID) {
		NSSRegisterID = nSSRegisterID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudName() {
		return StudName;
	}

	public void setStudName(String studName) {
		StudName = studName;
	}

	public String getStudAddress() {
		return StudAddress;
	}

	public void setStudAddress(String studAddress) {
		StudAddress = studAddress;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getStudMail() {
		return StudMail;
	}

	public void setStudMail(String studMail) {
		StudMail = studMail;
	}

	public String getStudCategory() {
		return StudCategory;
	}

	public void setStudCategory(String studCategory) {
		StudCategory = studCategory;
	}

	public int getStudMark() {
		return StudMark;
	}

	public void setStudMark(int studMark) {
		StudMark = studMark;
	}

	public int getStudMarkOutOff() {
		return StudMarkOutOff;
	}

	public void setStudMarkOutOff(int studMarkOutOff) {
		StudMarkOutOff = studMarkOutOff;
	}

	public String getStudPercent() {
		return StudPercent;
	}

	public void setStudPercent(String studPercent) {
		StudPercent = studPercent;
	}

	public String getApplicaionDate() {
		return ApplicaionDate;
	}

	public void setApplicaionDate(String applicaionDate) {
		ApplicaionDate = applicaionDate;
	}

	public String getStudPlace() {
		return StudPlace;
	}

	public void setStudPlace(String studPlace) {
		StudPlace = studPlace;
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

	public String getApproveDate() {
		return ApproveDate;
	}

	public void setApproveDate(String approveDate) {
		ApproveDate = approveDate;
	}

	public String getDisApproveDate() {
		return DisApproveDate;
	}

	public void setDisApproveDate(String disApproveDate) {
		DisApproveDate = disApproveDate;
	}

	public int getStudMarkPCM() {
		return StudMarkPCM;
	}

	public int getStudMarkPCB() {
		return StudMarkPCB;
	}

	public int getStudMarkPCMB() {
		return StudMarkPCMB;
	}

	public void setStudMarkPCM(int studMarkPCM) {
		StudMarkPCM = studMarkPCM;
	}

	public void setStudMarkPCB(int studMarkPCB) {
		StudMarkPCB = studMarkPCB;
	}

	public void setStudMarkPCMB(int studMarkPCMB) {
		StudMarkPCMB = studMarkPCMB;
	}

	

	
}
