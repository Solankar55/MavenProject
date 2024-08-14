package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="libraryacademicyearmodel")
public class LibraryAcademicYearModel {

	@Id
	@GeneratedValue
	private int labacademicyearid;
	private String labacademicyear;
	private String status="Active";
	
	@OneToOne(mappedBy="libraryAcademicYearModel")
	private AccessionLibraryRegister accessionLibraryRegister;
	
	@OneToOne(mappedBy="libraryAcademicYearModel")
	private AccessibilityMaster accessibilityMaster;
	
	
	public AccessionLibraryRegister getAccessionLibraryRegister() {
		return accessionLibraryRegister;
	}
	public void setAccessionLibraryRegister(AccessionLibraryRegister accessionLibraryRegister) {
		this.accessionLibraryRegister = accessionLibraryRegister;
	}
	public int getLabacademicyearid() {
		return labacademicyearid;
	}
	public String getLabacademicyear() {
		return labacademicyear;
	}
	public void setLabacademicyearid(int labacademicyearid) {
		this.labacademicyearid = labacademicyearid;
	}
	public void setLabacademicyear(String labacademicyear) {
		this.labacademicyear = labacademicyear;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AccessibilityMaster getAccessibilityMaster() {
		return accessibilityMaster;
	}
	public void setAccessibilityMaster(AccessibilityMaster accessibilityMaster) {
		this.accessibilityMaster = accessibilityMaster;
	}
	
	
}
