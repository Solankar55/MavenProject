package com.NSS.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.NSS.daoInterface.RegisterStudentDaoInterface;
import com.NSS.model.RegisterNssStudentModel;
import com.NSS.serviceInterface.RegisterStudentServiceInterface;

@Service
public class RegisterStudentServiceClass implements RegisterStudentServiceInterface{

	@Autowired
	private RegisterStudentDaoInterface registerStudentDaoInterface;

	public RegisterStudentDaoInterface getRegisterStudentDaoInterface() {
		return registerStudentDaoInterface;
	}

	public void setRegisterStudentDaoInterface(RegisterStudentDaoInterface registerStudentDaoInterface) {
		this.registerStudentDaoInterface = registerStudentDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return registerStudentDaoInterface.GetYearList() ;
	}

	@Transactional
	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		return registerStudentDaoInterface.SetStream();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return registerStudentDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return registerStudentDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public void saveNssUser(RegisterNssStudentModel registerNssStudentModel) {
		// TODO Auto-generated method stub
		registerStudentDaoInterface.saveNSSUser(registerNssStudentModel);
	}
	
	
}
