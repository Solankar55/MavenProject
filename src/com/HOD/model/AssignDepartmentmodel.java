package com.HOD.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AssignDepartment")
public class AssignDepartmentmodel {

	@Id
	@GeneratedValue
	
	private int AssignDepartmentID;
	private String Department;
	private String DepartmentStatus="Assigned";

	@OneToOne
	@JoinColumn(name = "staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;

	/* getter and seter */
	public int getAssignDepartmentID() {
		return AssignDepartmentID;
	}

	public void setAssignDepartmentID(int assignDepartmentID) {
		AssignDepartmentID = assignDepartmentID;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getDepartmentStatus() {
		return DepartmentStatus;
	}

	public void setDepartmentStatus(String departmentStatus) {
		DepartmentStatus = departmentStatus;
	}

	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}

	public void setStaffRegistrationModel(StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}

}
