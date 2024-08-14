package com.HOD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.CreateUserControllerDaoInterface;
import com.HOD.model.StaffRegistrationModel;
import com.HOD.serviceInterface.CreateUserControllerServiceInterface;
import com.admin.model.AdminRegistrationModel;

@Repository
public class CreateUserControllerServiceClass implements CreateUserControllerServiceInterface{

	@Autowired
	private CreateUserControllerDaoInterface createUserControllerDaoInterface;

	public CreateUserControllerDaoInterface getCreateUserControllerDaoInterface() {
		return createUserControllerDaoInterface;
	}

	public void setCreateUserControllerDaoInterface(CreateUserControllerDaoInterface createUserControllerDaoInterface) {
		this.createUserControllerDaoInterface = createUserControllerDaoInterface;
	}

	@Transactional
	@Override
	public void saveStaff(StaffRegistrationModel staffRegistrationModel) {
		// TODO Auto-generated method stub
		createUserControllerDaoInterface.saveStaff(staffRegistrationModel);
	}

	@Transactional
	@Override
	public int getStaffRegID() {
		// TODO Auto-generated method stub
		return createUserControllerDaoInterface.getStaffID();
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return createUserControllerDaoInterface.checkAdmin(username);
	}
	
	
}
