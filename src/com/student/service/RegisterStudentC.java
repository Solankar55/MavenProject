package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.RegisterStudentDaoI;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
@Repository
public class RegisterStudentC implements RegisterStudentI {

	@Autowired
	private RegisterStudentDaoI registerStudentDaoI;
	
	@Transactional
	@Override
	public void RegisterStudent(StudentRegistrationModel studentRegistrationModel) {
		// TODO Auto-generated method stub
		registerStudentDaoI.RegisterStudent(studentRegistrationModel);
	}

	public RegisterStudentDaoI getRegisterStudentDaoI() {
		return registerStudentDaoI;
	}

	public void setRegisterStudentDaoI(RegisterStudentDaoI registerStudentDaoI) {
		this.registerStudentDaoI = registerStudentDaoI;
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> GetDetailsForEdit(String username) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudDetailsForEdit(username);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudInfo(username);
	}

	@Transactional
	@Override
	public List<String> GetStudentDetails(String uN, String pS) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.GetStudentList(uN,pS);
	}

	@Transactional
	@Override
	public List<String> getStudentList(String studEmail,String studContact) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudUserDetails(studEmail,studContact);
	}

	@Transactional
	@Override
	public List<String> getUserNameList(String userNameValue,String studEmail,String studContact) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getUserNameList(userNameValue,studEmail,studContact);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailInfo(String studentName, String studentContact, String studentEmail) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudentDetailsInfo(studentName,studentContact,studentEmail);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> CheckStudent(String username) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.checkStudent(username);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudDetails(String uN, String pS) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudDetails(uN, pS);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentStatus(String sName, String sMail, String sContact) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudentStatus(sName,sMail,sContact);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudDetailsHome(String username) {
		// TODO Auto-generated method stub
		return registerStudentDaoI.getStudDetailsHome(username);
	}
	

}
