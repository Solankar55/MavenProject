package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.LeavingCertificateDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentLeavingCertificateRequestModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.LeavingCertificateInterface;
@Repository
public class LeavingCertificateServiceC implements LeavingCertificateInterface {

	@Autowired
	private LeavingCertificateDaoInterface leavingCertificateDaoInterface;

	public LeavingCertificateDaoInterface getLeavingCertificateDaoInterface() {
		return leavingCertificateDaoInterface;
	}

	public void setLeavingCertificateDaoInterface(LeavingCertificateDaoInterface leavingCertificateDaoInterface) {
		this.leavingCertificateDaoInterface = leavingCertificateDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetStudentDetails(String studName, String studCon,String studEmail) {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.GetStudentDetails(studName,studCon,studEmail);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.GetStudentInfo(username);
	}

	@Transactional
	@Override
	public void SaveLeavingCertificateRequest(
			StudentLeavingCertificateRequestModel studentLeavingCertificateRequestModel) {
		// TODO Auto-generated method stub
		leavingCertificateDaoInterface.SaveLeavingCertificateRequest(studentLeavingCertificateRequestModel);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.GetStudDetails(username);
	}

	@Transactional
	@Override
	public int GetLCNumber() {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.getLCNumber();
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudID(String studName, String studCon, String studEmailAddress) {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.getStudID(studName,studCon,studEmailAddress);
	}

	@Transactional
	@Override
	public List<String> getCheckIDAvailableOrNot(int studentRequestID) {
		// TODO Auto-generated method stub
		return leavingCertificateDaoInterface.getCheckStudPresentOrNot(studentRequestID);
	}
	
	

}
