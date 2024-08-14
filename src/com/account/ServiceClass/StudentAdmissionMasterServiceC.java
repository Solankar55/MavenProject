package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.StudentAddmissionMasterDaoInterface;
import com.account.model.DivisionMasterModel;
import com.account.serviceInterface.StudentAddmissionMasterinterface;
import com.admin.model.AdminRegistrationModel;
@Service
public class StudentAdmissionMasterServiceC implements StudentAddmissionMasterinterface{

	@Autowired
	private StudentAddmissionMasterDaoInterface studentAddmissionMasterDaoInterface;
	
	public StudentAddmissionMasterDaoInterface getStudentAddmissionMasterDaoInterface() {
		return studentAddmissionMasterDaoInterface;
	}

	public void setStudentAddmissionMasterDaoInterface(
			StudentAddmissionMasterDaoInterface studentAddmissionMasterDaoInterface) {
		this.studentAddmissionMasterDaoInterface = studentAddmissionMasterDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetStudentAddmissionList() {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.GetStudentAddmissionList();
	}

	@Transactional
	@Override
	public void TakeAddmission(int studentID) {
		// TODO Auto-generated method stub
		studentAddmissionMasterDaoInterface.TakeAddmission(studentID);
	}

	@Transactional
	@Override
	public void CancelAdmission(int studentID) {
		// TODO Auto-generated method stub
		studentAddmissionMasterDaoInterface.CancelAdmission(studentID);
	}

	@Transactional
	@Override
	public List<String> GetApprovedStudentList() {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.GetApprovedStudentList();
	}

	@Transactional
	@Override
	public List<String> GetCancelAdmissionList() {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.GetCancelStudentList();
	}

	@Transactional
	@Override
	public List<String> getStudentList(String studentName) {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.getStudentList(studentName);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.CheckAdmin(username);
	}

	@Transactional
	@Override
	public List<String> getStudentInformation(int studentID) {
		// TODO Auto-generated method stub
		return studentAddmissionMasterDaoInterface.getStudentInformation(studentID);
	}

	@Transactional
	@Override
	public void updateStudentInformation(String studentsscname, String addressTaluka, String addressdistrict,
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
			String accountNumber, String bankName, String branchName, String iFSCCode,String studentNationality) {
		// TODO Auto-generated method stub 
		//int yearID, int streamId, int branchId, int standardId,
		studentAddmissionMasterDaoInterface.updateStudentInformation( studentsscname,  addressTaluka,  addressdistrict,
				 uniidnumber,  studentHostel,  studentLastYearscholarshipApplied,
				 studentScholarshipsanctioned,  studentIfYesAmountRs,  studentPreviousschoolName,
				 studentDomicileofMaharashtra,  sscTotalMarks,  sscOutOfMarks,  sscXIIRegNo,
				 hscTotalMarks,  hscOutOfMarks,  hscpcbpcm,  hscPCMMarks,
				 hscPCMPCBTotalMarks,  finbpharmTotalMarks,  finbpharmOutOfMarks,
				 finbpharmPercentage,  tybpharmTotalMarks,  tybpharmOutOfMarks,  tybpharmPercentage,
				 sybpharmTotalMarks,  sybpharmOutOfMarks,  sybpharmPercentage,  fybpharmTotalMarks,
				 fybpharmOutOfMarks,  fybpharmPercentage,  fatherEducationalQualification,
				 fatherDesignation,  fatherOrganization,  fatherContactNumber,  motherLastName,
				 motherFirstName,  mothermiddleName,  motherEducationalQualification,
				 motherOccupation,  motherDesignation,  motherMonthlyIncome,  motherContactNumber,
				 motherEmail,  motherOrganization,  studentChildNumber,  studentBloodGroup,
				 studentLastName,  studentFirstName,  studentMidddleName,  motherName,
				 birthDate,  birthPlace,  fatherLastName,  fatherFirstName,  fathermiddleName,
				 fatherPermentAddress,  fatherOccupation,  annualIncome,  fatherMail,
				 studentCast,  residentialAddress,  permanentAddress,  pinCode,
				 parentContactNumber,  registrationID,  
				 studentGender,  studReligion,  studCategory,  aadharCardNumber,
				 accountNumber,  bankName,  branchName,  iFSCCode,studentNationality);
		//yearID,  streamId,  branchId,  standardId,
	}

	@Transactional
	@Override
	public void updateStudentRegistrationDetails(String studentFirstName, String username) {
		// TODO Auto-generated method stub
		studentAddmissionMasterDaoInterface.updateStudentRegistrationDetails( studentFirstName,  username);
	}

	
	
	
}
