package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.StudentBonafideDeoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBonafideRequestModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.StudentBonafideRequestInterface;
@Repository
public class StudentBonafideRequestC implements StudentBonafideRequestInterface{

	@Autowired
	private StudentBonafideDeoInterface studentBonafideDeoInterface;

	public StudentBonafideDeoInterface getStudentBonafideDeoInterface() {
		return studentBonafideDeoInterface;
	}

	public void setStudentBonafideDeoInterface(StudentBonafideDeoInterface studentBonafideDeoInterface) {
		this.studentBonafideDeoInterface = studentBonafideDeoInterface;
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return studentBonafideDeoInterface.getStudInfo(username);
	}

	@Transactional
	@Override
	public List<String> GetDetailInfo(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return studentBonafideDeoInterface.getDetailInfo(studName,studCon,studEmail);
	}

	@Transactional
	@Override
	public void SaveRequest(StudentBonafideRequestModel studentBonafideRequestModel) {
		// TODO Auto-generated method stub
		studentBonafideDeoInterface.SaveRequest(studentBonafideRequestModel);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return studentBonafideDeoInterface.GetStudDetails(username);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon,String Emailstud) {
		// TODO Auto-generated method stub
		return studentBonafideDeoInterface.getStudInfoOfRequest(studName,studCon,Emailstud);
	}

	@Transactional
	@Override
	public int GetBonafideCount(int StudID) {
		// TODO Auto-generated method stub
		return studentBonafideDeoInterface.getBonafideCount(StudID);
	}

}
