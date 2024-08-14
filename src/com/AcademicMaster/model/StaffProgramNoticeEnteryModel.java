package com.AcademicMaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.HOD.model.StaffRegistrationModel;

@Entity
@Table(name="StaffProgramNoticeEntery")
public class StaffProgramNoticeEnteryModel {
	
	@Id
	@GeneratedValue
	
	private int staffProgramNoticeEnteryID;
	private String staffProgramNoticeEnteryStatus="Active";
	
	/*------------ Mapping  --------------*/
	
	@OneToOne
	@JoinColumn(name="staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;
	
	@ManyToOne
	@JoinColumn(name="StaffProgramNoticeID")
	private StaffProgramNoticeModel staffProgramNoticeModel;
	
	/*------------Getter And Setter Methods --------------*/
	public int getStaffProgramNoticeEnteryID() {
		return staffProgramNoticeEnteryID;
	}
	public String getStaffProgramNoticeEnteryStatus() {
		return staffProgramNoticeEnteryStatus;
	}
	public void setStaffProgramNoticeEnteryID(int staffProgramNoticeEnteryID) {
		this.staffProgramNoticeEnteryID = staffProgramNoticeEnteryID;
	}
	public void setStaffProgramNoticeEnteryStatus(String staffProgramNoticeEnteryStatus) {
		this.staffProgramNoticeEnteryStatus = staffProgramNoticeEnteryStatus;
	}
	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}
	public StaffProgramNoticeModel getStaffProgramNoticeModel() {
		return staffProgramNoticeModel;
	}
	public void setStaffRegistrationModel(StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}
	public void setStaffProgramNoticeModel(StaffProgramNoticeModel staffProgramNoticeModel) {
		this.staffProgramNoticeModel = staffProgramNoticeModel;
	}
	
	

}
