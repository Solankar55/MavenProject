package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.FeeDetailsDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.FeeDetailsServiceInterface;

@Service
public class FeeDetailsServiceClass implements FeeDetailsServiceInterface{

	@Autowired
	private FeeDetailsDaoInterface feeDetailsDaoInterface;

	public FeeDetailsDaoInterface getFeeDetailsDaoInterface() {
		return feeDetailsDaoInterface;
	}

	public void setFeeDetailsDaoInterface(FeeDetailsDaoInterface feeDetailsDaoInterface) {
		this.feeDetailsDaoInterface = feeDetailsDaoInterface;
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return feeDetailsDaoInterface.getStudInfo(username);
	}

	@Transactional
	@Override
	public List<Object[]> getCheckStudInfo(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return feeDetailsDaoInterface.getCheckStudInfo( studName,  studCon,  studEmail);
	}

	@Transactional
	@Override
	public List<String> getFeeDetails(int studentID, int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return feeDetailsDaoInterface.getFeeDetails( studentID,  yearID,  streamID,  branchID,  standardID);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return feeDetailsDaoInterface.GetStudDetails(username);
	}
	
	
}
