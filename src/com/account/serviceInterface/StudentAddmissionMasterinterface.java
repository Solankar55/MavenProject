package com.account.serviceInterface;

import java.util.List;

import com.account.model.DivisionMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface StudentAddmissionMasterinterface {

	List<String> GetStudentAddmissionList();

	void TakeAddmission(int studentID);

	void CancelAdmission(int studentID);

	List<String> GetApprovedStudentList();

	List<String> GetCancelAdmissionList();

	List<String> getStudentList(String studentName);

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getStudentInformation(int studentID);

	void updateStudentInformation(String studentsscname, String addressTaluka, String addressdistrict,
			String uniidnumber, String studentHostel, String studentLastYearscholarshipApplied,
			String studentScholarshipsanctioned, String studentIfYesAmountRs, String studentPreviousschoolName,
			String studentDomicileofMaharashtra, String sscTotalMarks, String sscOutOfMarks, String sscXIIRegNo,
			String hscTotalMarks, String hscOutOfMarks, String hscpcbpcm, String hscPCMMarks,
			String hscPCMPCBTotalMarks, String finbpharmTotalMarks, String finbpharmOutOfMarks,
			String finbpharmPercentage, String tybpharmTotalMarks, String tybpharmOutOfMarks, String tybpharmPercentage,
			String sybpharmTotalMarks, String sybpharmOutOfMarks, String sybpharmPercentage, String fybpharmTotalMarks,
			String fybpharmOutOfMarks, String fybpharmPercentage, String fatherEducationalQualification,
			String fatherDesignation, String fatherOrganization, String fatherContactNumber, String motherLastName,
			String motherFirstName, String mothermiddleName, String motherEducationalQualification,
			String motherOccupation, String motherDesignation, String motherMonthlyIncome, String motherContactNumber,
			String motherEmail, String motherOrganization, String studentChildNumber, String studentBloodGroup,
			String studentLastName, String studentFirstName, String studentMidddleName, String motherName,
			String birthDate, String birthPlace, String fatherLastName, String fatherFirstName, String fathermiddleName,
			String fatherPermentAddress, String fatherOccupation, String annualIncome, String fatherMail,
			String studentCast, String residentialAddress, String permanentAddress, String pinCode,
			String parentContactNumber, int registrationID, 
			String studentGender, String studReligion, String studCategory, String aadharCardNumber,
			String accountNumber, String bankName, String branchName, String iFSCCode,String studentNationality);

	void updateStudentRegistrationDetails(String studentFirstName, String username);

	/*int yearID, int streamId, int branchId, int standardId,*/
		
	
}
