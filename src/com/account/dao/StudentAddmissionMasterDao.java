package com.account.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.StudentAddmissionMasterDaoInterface;
import com.admin.model.AdminRegistrationModel;
@Repository
public class StudentAddmissionMasterDao implements StudentAddmissionMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> GetStudentAddmissionList() {
		// TODO Auto-generated method stub
		List<String> StudentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.streamName,b.branchName,t.standard,s.admissionRegId, s.aadharCardNumber,  s.accountNumber, s.admissionDate, s.bankBranch, s.bankIFSCCode, s.bankName, s.fatherEmail, s.fatherFirstName, s.fatherLastName, s.fatherMonthlyIncome, s.fatherOccupation, s.fatherPermananetAddress, s.fathermiddleName, s.status, s.studentCast, s.studentCategory, s.studentContactNumber, s.studentDateOfBirth, s.studentEmail, s.studentFirstName, s.studentGender, s.studentImage, s.studentLastName, s.studentMiddleName, s.studentMotherName, s.studentMotherTongue, s.studentNationality, s.studentParentContactNumber, s.studentPermanenetAddress, s.studentPinCode, s.studentPlaceOfBirth, s.studentReligion, s.studentResidentialAddress, s.studentSubCast,s.branchId,s.divisionId,s.streamId,s.standardId FROM studentadmission s left join branchmaster b on s.branchId =b.branchId left join standardmaster t on s.standardId=t.standardId left join streammaster r on s.streamId=r.streamId where status='Pending' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//query.addEntity(StudentAdmissionModel.class);
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public void TakeAddmission(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission set status='Approved' where admissionRegId='"+studentID+"' ");
		query.executeUpdate();
	}

	@Override
	public void CancelAdmission(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission set status='Cancel' where admissionRegId='"+studentID+"' ");
		query.executeUpdate();
	}

	@Override
	public List<String> GetApprovedStudentList() {
		// TODO Auto-generated method stub
		List<String> StudentApprovedList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.streamName,b.branchName,t.standard,s.admissionRegId, s.aadharCardNumber,s.accountNumber, s.admissionDate, s.bankBranch, s.bankIFSCCode, s.bankName,s.fatherEmail, s.fatherFirstName, s.fatherLastName, s.fatherMonthlyIncome,s.fatherOccupation, s.fatherPermananetAddress, s.fathermiddleName, s.status,s.studentCast, s.studentCategory, s.studentContactNumber, s.studentDateOfBirth,s.studentEmail, s.studentFirstName, s.studentGender, s.studentImage, s.studentLastName, s.studentMiddleName, s.studentMotherName, s.studentMotherTongue, s.studentNationality, s.studentParentContactNumber, s.studentPermanenetAddress, s.studentPinCode, s.studentPlaceOfBirth,  s.studentReligion, s.studentResidentialAddress, s.studentSubCast,s.branchId,s.divisionId,s.streamId,s.standardId,s.acadamicYearId FROM studentadmission s  left join branchmaster b on s.branchId =b.branchId  left join standardmaster t on s.standardId=t.standardId  left join streammaster r on s.streamId=r.streamId where status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentApprovedList=query.list();
		
		
		return StudentApprovedList;
	}

	@Override
	public List<String> GetCancelStudentList() {
		// TODO Auto-generated method stub
		
		List<String> CancelAdmissionList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.streamName,b.branchName,t.standard,s.admissionRegId, s.aadharCardNumber, s.accountNumber, s.admissionDate, s.bankBranch, s.bankIFSCCode, s.bankName, s.fatherEmail, s.fatherFirstName, s.fatherLastName, s.fatherMonthlyIncome, s.fatherOccupation, s.fatherPermananetAddress, s.fathermiddleName, s.status, s.studentCast, s.studentCategory, s.studentContactNumber, s.studentDateOfBirth, s.studentEmail, s.studentFirstName, s.studentGender, s.studentImage, s.studentLastName, s.studentMiddleName, s.studentMotherName, s.studentMotherTongue, s.studentNationality, s.studentParentContactNumber, s.studentPermanenetAddress, s.studentPinCode, s.studentPlaceOfBirth, s.studentReligion, s.studentResidentialAddress, s.studentSubCast,s.branchId,s.divisionId,s.streamId,s.standardId FROM studentadmission s left join branchmaster b on s.branchId =b.branchId left join standardmaster t on s.standardId=t.standardId left join streammaster r on s.streamId=r.streamId where status='Cancel' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		CancelAdmissionList=query.list();
		
		return CancelAdmissionList;
	}

	@Override
	public List<String> getStudentList(String studentName) {
		// TODO Auto-generated method stub
		List<String> StudentList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.streamName,b.branchName,t.standard,s.admissionRegId, s.aadharCardNumber,  s.accountNumber, s.admissionDate, s.bankBranch, s.bankIFSCCode, s.bankName, s.fatherEmail, s.fatherFirstName, s.fatherLastName, s.fatherMonthlyIncome, s.fatherOccupation, s.fatherPermananetAddress, s.fathermiddleName, s.status, s.studentCast, s.studentCategory, s.studentContactNumber, s.studentDateOfBirth, s.studentEmail, s.studentFirstName, s.studentGender, s.studentImage, s.studentLastName, s.studentMiddleName, s.studentMotherName, s.studentMotherTongue, s.studentNationality, s.studentParentContactNumber, s.studentPermanenetAddress, s.studentPinCode, s.studentPlaceOfBirth, s.studentReligion, s.studentResidentialAddress, s.studentSubCast,s.branchId,s.divisionId,s.streamId,s.standardId FROM studentadmission s left join branchmaster b on s.branchId =b.branchId left join standardmaster t on s.standardId=t.standardId left join streammaster r on s.streamId=r.streamId where status='Pending' and s.studentFirstName='"+studentName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//query.addEntity(StudentAdmissionModel.class);
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminData;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId, a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type, a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminData=query.list();
		
		return adminData;
	}

	@Override
	public List<String> getStudentInformation(int studentID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM studentadmission s where s.admissionRegId='"+studentID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studInfo;
		studInfo=query.list();
		
		return studInfo;
	}

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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission s set s.AddressTaluka='"+addressTaluka+"', s.Addressdistrict='"+addressdistrict+"', s.aadharCardNumber='"+aadharCardNumber+"', s.accountNumber='"+accountNumber+"',s.bankBranch='"+branchName+"', s.bankIFSCCode='"+iFSCCode+"', s.bankName='"+bankName+"', s.fatherContactNumber='"+fatherContactNumber+"', s.fatherDesignation='"+fatherDesignation+"',s.fatherEducationalQualification='"+fatherEducationalQualification+"', s.fatherEmail='"+fatherMail+"', s.fatherFirstName='"+fatherFirstName+"', s.fatherLastName='"+fatherLastName+"',s.fatherMonthlyIncome='"+annualIncome+"', s.fatherOccupation='"+fatherOccupation+"', s.fatherOrganization='"+fatherOrganization+"', s.fatherPermananetAddress='"+fatherPermentAddress+"',s.fathermiddleName='"+fathermiddleName+"', s.finbpharmOutOfMarks='"+finbpharmOutOfMarks+"', s.finbpharmPercentage='"+finbpharmPercentage+"', s.finbpharmTotalMarks='"+finbpharmTotalMarks+"',s.fybpharmOutOfMarks='"+fybpharmOutOfMarks+"', s.fybpharmPercentage='"+fybpharmPercentage+"', s.fybpharmTotalMarks='"+fybpharmTotalMarks+"', s.hscOutOfMarks='"+hscOutOfMarks+"', s.hscPCBMarks='"+hscPCMMarks+"',s.hscPCMMarks='"+hscPCMMarks+"', s.hscPCMPCBTotalMarks='"+hscPCMPCBTotalMarks+"', s.hscTotalMarks='"+hscTotalMarks+"', s.hscpcbpcm='"+hscpcbpcm+"', s.motherContactNumber='"+motherContactNumber+"',s.motherDesignation='"+motherDesignation+"', s.motherEducationalQualification='"+motherEducationalQualification+"', s.motherEmail='"+motherEmail+"', s.motherFirstName='"+motherFirstName+"', s.motherLastName='"+motherLastName+"',s.motherMonthlyIncome='"+motherMonthlyIncome+"', s.motherOccupation='"+motherOccupation+"', s.motherOrganization='"+motherOrganization+"', s.mothermiddleName='"+mothermiddleName+"',s.sscOutOfMarks='"+sscOutOfMarks+"', s.sscTotalMarks='"+sscTotalMarks+"', s.sscXIIRegNo='"+sscXIIRegNo+"' ,s.studentBloodGroup='"+studentBloodGroup+"',s.studentCast='"+studentCast+"', s.studentCategory='"+studCategory+"', s.studentChildNumber='"+studentChildNumber+"', studentDateOfBirth='"+birthDate+"', s.studentDomicileofMaharashtra='"+studentDomicileofMaharashtra+"',s.studentFirstName='"+studentFirstName+"', s.studentGender='"+studentGender+"', s.studentHostel='"+studentHostel+"', s.studentIfYesAmountRs='"+studentIfYesAmountRs+"',s.studentLastName='"+studentLastName+"', s.studentLastYearscholarshipApplied='"+studentLastYearscholarshipApplied+"', s.studentMiddleName='"+studentMidddleName+"', s.studentMotherName='"+motherName+"',s.studentNationality='"+studentNationality+"', s.studentParentContactNumber='"+parentContactNumber+"', s.studentPermanenetAddress='"+permanentAddress+"',s.studentPinCode='"+pinCode+"', s.studentPlaceOfBirth='"+birthDate+"', s.studentPreviousschoolName='"+studentPreviousschoolName+"', s.studentReligion='"+studReligion+"', s.studentResidentialAddress='"+residentialAddress+"',s.studentScholarshipsanctioned='"+studentScholarshipsanctioned+"', studentnamessc='"+studentsscname+"', s.sybpharmOutOfMarks='"+sybpharmOutOfMarks+"',s.sybpharmPercentage='"+sybpharmPercentage+"', s.sybpharmTotalMarks='"+sybpharmTotalMarks+"', s.tybpharmOutOfMarks='"+tybpharmOutOfMarks+"', s.tybpharmPercentage='"+tybpharmPercentage+"',s.tybpharmTotalMarks='"+tybpharmTotalMarks+"', s.uniidnumber='"+uniidnumber+"'where s.admissionRegId='"+registrationID+"'");
		query.executeUpdate();		
	}

	@Override
	public void updateStudentRegistrationDetails(String studentFirstName, String username) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentregistration s set s.StudentName='"+studentFirstName+"' where s.StudentUserName='"+username+"'");
		query.executeUpdate();
	}

	
}
