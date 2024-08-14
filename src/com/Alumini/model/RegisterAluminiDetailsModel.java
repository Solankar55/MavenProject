package com.Alumini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AluminiRegistratiorUser")
public class RegisterAluminiDetailsModel {

	@Id
	@GeneratedValue
	
	private int AluminiRegID;
	private String RegisterUserName;
	private String RegisterUserBirthDate;
	private String UserBloodGroup;
	private String UserResidentialAddress;
	private String UserOfficialAddress;
	private String MobileNumber;
	private String UserEmail;
	private String Education;
	private String YearOfPassing;
	private int UserRegisterationNumber;
	private String PresentStudies;
	private String Designation;
	private String DetailsEmployment;
	private String DateRegistration;
	private int ReceiptNumber;
	private int MemberID;
	
	public int getAluminiRegID() {
		return AluminiRegID;
	}
	public void setAluminiRegID(int aluminiRegID) {
		AluminiRegID = aluminiRegID;
	}
	public String getRegisterUserName() {
		return RegisterUserName;
	}
	public void setRegisterUserName(String registerUserName) {
		RegisterUserName = registerUserName;
	}
	public String getRegisterUserBirthDate() {
		return RegisterUserBirthDate;
	}
	public void setRegisterUserBirthDate(String registerUserBirthDate) {
		RegisterUserBirthDate = registerUserBirthDate;
	}
	public String getUserBloodGroup() {
		return UserBloodGroup;
	}
	public void setUserBloodGroup(String userBloodGroup) {
		UserBloodGroup = userBloodGroup;
	}
	public String getUserResidentialAddress() {
		return UserResidentialAddress;
	}
	public void setUserResidentialAddress(String userResidentialAddress) {
		UserResidentialAddress = userResidentialAddress;
	}
	public String getUserOfficialAddress() {
		return UserOfficialAddress;
	}
	public void setUserOfficialAddress(String userOfficialAddress) {
		UserOfficialAddress = userOfficialAddress;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getYearOfPassing() {
		return YearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) {
		YearOfPassing = yearOfPassing;
	}
	public int getUserRegisterationNumber() {
		return UserRegisterationNumber;
	}
	public void setUserRegisterationNumber(int userRegisterationNumber) {
		UserRegisterationNumber = userRegisterationNumber;
	}
	public String getPresentStudies() {
		return PresentStudies;
	}
	public void setPresentStudies(String presentStudies) {
		PresentStudies = presentStudies;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDetailsEmployment() {
		return DetailsEmployment;
	}
	public void setDetailsEmployment(String detailsEmployment) {
		DetailsEmployment = detailsEmployment;
	}
	public String getDateRegistration() {
		return DateRegistration;
	}
	public void setDateRegistration(String dateRegistration) {
		DateRegistration = dateRegistration;
	}
	public int getReceiptNumber() {
		return ReceiptNumber;
	}
	public void setReceiptNumber(int receiptNumber) {
		ReceiptNumber = receiptNumber;
	}
	public int getMemberID() {
		return MemberID;
	}
	public void setMemberID(int memberID) {
		MemberID = memberID;
	}
	
	
}
