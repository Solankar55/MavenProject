package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;


@Entity
@Table(name="LostBookStaff")
public class LostBookStaff {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int LostBookStaffId;
	@Column
	private String DateLost;
	@Column
	private String FinePaidDate;
	@Column
	private String FineStatus;
	@Column
	private String ActiveAcademicYear;
	
	@ManyToOne
	@JoinColumn(name="AccessionLibraryRegisterId")
	private AccessionLibraryRegister ALRegisterStaff;
	
	@ManyToOne
	@JoinColumn(name="acadamicYearId")
	private acadamicYearModel acadamicYearModelStaff;

	@ManyToOne
	@JoinColumn(name="staffRegistrationId")
	private StaffRegistrationModel staffRegistrationModel;
	
	
	public int getLostBookStaffId() {
		return LostBookStaffId;
	}

	public void setLostBookStaffId(int lostBookStaffId) {
		LostBookStaffId = lostBookStaffId;
	}

	public String getDateLost() {
		return DateLost;
	}

	public void setDateLost(String dateLost) {
		DateLost = dateLost;
	}

	public String getFinePaidDate() {
		return FinePaidDate;
	}

	public void setFinePaidDate(String finePaidDate) {
		FinePaidDate = finePaidDate;
	}

	public String getFineStatus() {
		return FineStatus;
	}

	public void setFineStatus(String fineStatus) {
		FineStatus = fineStatus;
	}

	public AccessionLibraryRegister getALRegisterStaff() {
		return ALRegisterStaff;
	}

	public void setALRegisterStaff(AccessionLibraryRegister aLRegisterStaff) {
		ALRegisterStaff = aLRegisterStaff;
	}

	public acadamicYearModel getAcadamicYearModelStaff() {
		return acadamicYearModelStaff;
	}

	public void setAcadamicYearModelStaff(acadamicYearModel acadamicYearModelStaff) {
		this.acadamicYearModelStaff = acadamicYearModelStaff;
	}

	public StaffRegistrationModel getStaffRegistrationModel() {
		return staffRegistrationModel;
	}

	public void setStaffRegistrationModel(
			StaffRegistrationModel staffRegistrationModel) {
		this.staffRegistrationModel = staffRegistrationModel;
	}

	public String getActiveAcademicYear() {
		return ActiveAcademicYear;
	}

	public void setActiveAcademicYear(String activeAcademicYear) {
		ActiveAcademicYear = activeAcademicYear;
	}

		
	
	
	
	
	
	
	
}
