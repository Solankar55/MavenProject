package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.admin.dao.RegisterUserDaoI;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;
@Repository
public class RegisterUserC implements RegisterUserI {

	@Autowired
	private RegisterUserDaoI registerUserDaoI;
	
	@Transactional
	@Override
	public void RegUser(AdminRegistrationModel adminRegistrationModel) {
		// TODO Auto-generated method stub
		registerUserDaoI.RegisterUser(adminRegistrationModel);
	}

	public RegisterUserDaoI getRegisterUserDaoI() {
		return registerUserDaoI;
	}

	public void setRegisterUserDaoI(RegisterUserDaoI registerUserDaoI) {
		this.registerUserDaoI = registerUserDaoI;
	}

	@Transactional
	@Override
	public List GetAdminList(String uN, String pS) {
		// TODO Auto-generated method stub
		return registerUserDaoI.GetAdminList(uN,pS);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getEmailRelatedDetails(String sendTo) {
		// TODO Auto-generated method stub
		return registerUserDaoI.getEmailDetails(sendTo);
	}
	
}
