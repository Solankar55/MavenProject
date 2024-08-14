package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.DownloadDaoInterface;
import com.account.model.DuplicateLeavingCertificateModel;
import com.account.model.LedgerFeePaidModel;
import com.account.serviceInterface.DownloadServiceInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;

@Service
public class DownloadServiceClass implements DownloadServiceInterface{

	@Autowired
	private DownloadDaoInterface downloadDaoInterface;

	public DownloadDaoInterface getDownloadDaoInterface() {
		return downloadDaoInterface;
	}

	public void setDownloadDaoInterface(DownloadDaoInterface downloadDaoInterface) {
		this.downloadDaoInterface = downloadDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStudentDetails(int registrationID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetails(registrationID);
	}

	@Transactional
	@Override
	public void UpdateBonafideFlag(int studID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateBonafideFlag( studID);
	}

	@Transactional
	@Override
	public List<String> getStudentIDDetails(int registrationID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentIDDetails(registrationID);
	}

	@Transactional
	@Override
	public void updateIDCardFlag(int studentID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateIDCardFlag(studentID);
	}

	@Transactional
	@Override
	public List<String> getSTudentLCDetails(int registrationID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getSTudentLCDetails(registrationID);
	}

	@Transactional
	@Override
	public void updateLeavingCertificateFlag(int studentID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateLeavingCertificateFlag(studentID);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.CheckAdmin(username);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForDuplicateLC(int registrationID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetailsForDuplicateLC(registrationID);
	}

	@Transactional
	@Override
	public void saveDuplicateLcDetails(DuplicateLeavingCertificateModel duplicateLeavingCertificateModel) {
		// TODO Auto-generated method stub
		downloadDaoInterface.saveDuplicateLcDetails(duplicateLeavingCertificateModel);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsAnyConditionLC(String studentName) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetailsAnyConditionLC(studentName);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsTogetLC(int studentId) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetailsTogetLC( studentId);
	}

	@Transactional
	@Override
	public List<LedgerFeePaidModel> getStudentDetailsAnyFeeCondition(int studentId) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetailsAnyFeeCondition( studentId);
	}

	@Transactional
	@Override
	public void saveLeavingCertificate(StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		// TODO Auto-generated method stub
		downloadDaoInterface.saveLeavingCertificate( studentLeavingCertificateRequestModel) ;
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentStatus(int studentId) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentStatus(studentId);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsAnyConditionBonafide(int studentId) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDetailsAnyConditionBonafide(studentId);
	}

	@Transactional
	@Override
	public void saveStudentBonfideAnycondition(StudentBonafideRequestModel studentBonafideRequestModel) {
		// TODO Auto-generated method stub
		downloadDaoInterface.saveStudentBonfideAnyCondition(studentBonafideRequestModel);
	}

	@Transactional
	@Override
	public void UpdateBonafideFlagAnyCondition(int studentId) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateBonafideAnyCondition(studentId);
	}

	@Transactional
	@Override
	public List<String> getStudentDataIDAnyCondition(int studentId) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudentDataIDAnyCondition( studentId);
	}

	@Transactional
	@Override
	public void saveStudentIdAnyConditionDetails(StudentIDCardRequestModel studentIDCardRequestModel) {
		// TODO Auto-generated method stub
		downloadDaoInterface.saveStudentIdAnyConditionDetails(studentIDCardRequestModel);
	}

	
}
