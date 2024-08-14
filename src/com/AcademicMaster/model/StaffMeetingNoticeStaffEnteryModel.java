package com.AcademicMaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.HOD.model.StaffRegistrationModel;

@Entity
@Table(name="StaffMeetingNoticeEntery")
public class StaffMeetingNoticeStaffEnteryModel {

	@Id
	@GeneratedValue
	
	private int StaffNoticeEnteryID;
	private String StaffEnteryStatus="Active";
	
	@OneToOne
	@JoinColumn(name="staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;
	
	@ManyToOne
	@JoinColumn(name="StaffMeetingNoticeID")
	private StaffMeetingNoticeModel staffMeetingNoticeModel;

	public int getStaffNoticeEnteryID() {
		return StaffNoticeEnteryID;
	}

	public String getStaffEnteryStatus() {
		return StaffEnteryStatus;
	}

	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}

	public StaffMeetingNoticeModel getStaffMeetingNoticeModel() {
		return staffMeetingNoticeModel;
	}

	public void setStaffNoticeEnteryID(int staffNoticeEnteryID) {
		StaffNoticeEnteryID = staffNoticeEnteryID;
	}

	public void setStaffEnteryStatus(String staffEnteryStatus) {
		StaffEnteryStatus = staffEnteryStatus;
	}

	public void setStaffRegistrationModel(StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}

	public void setStaffMeetingNoticeModel(StaffMeetingNoticeModel staffMeetingNoticeModel) {
		this.staffMeetingNoticeModel = staffMeetingNoticeModel;
	}
	
	
}
