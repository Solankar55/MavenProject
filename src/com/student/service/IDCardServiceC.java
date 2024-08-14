package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.IDCardDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentIDCardRequestModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.IDCardServiceInterface;
@Repository
public class IDCardServiceC implements IDCardServiceInterface{

	@Autowired
	private IDCardDaoInterface idCardDaoInterface;

	public IDCardDaoInterface getIdCardDaoInterface() {
		return idCardDaoInterface;
	}

	public void setIdCardDaoInterface(IDCardDaoInterface idCardDaoInterface) {
		this.idCardDaoInterface = idCardDaoInterface;
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return idCardDaoInterface.GetInfo(username);
	}

	@Transactional
	@Override
	public List<String> getStudDetails(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return idCardDaoInterface.GetStudDetails(studName,studCon,studEmail);
	}

	@Transactional
	@Override
	public void SaveIDCardRequest(StudentIDCardRequestModel studentIDCardRequestModel) {
		// TODO Auto-generated method stub
		idCardDaoInterface.SaveIDCardRequest(studentIDCardRequestModel);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return idCardDaoInterface.GetStudDetails(username);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentID(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return idCardDaoInterface.getStudentID( studName,  studCon,  studEmail);
	}

	@Transactional
	@Override
	public List<String> getIdRequestCheck(int studID) {
		// TODO Auto-generated method stub
		return idCardDaoInterface.getCheackIDRequest(studID);
	}
	
}
