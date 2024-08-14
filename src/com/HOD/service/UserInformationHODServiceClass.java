package com.HOD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.UserInformationHODDaoInterface;
import com.HOD.serviceInterface.UserInformationHODServiceInterface;

@Service
@Transactional
public class UserInformationHODServiceClass implements UserInformationHODServiceInterface {
	
	
	@Autowired
	private UserInformationHODDaoInterface userInformationHODDaoInterface;

	public UserInformationHODDaoInterface getUserInformationHODDaoInterface() {
		return userInformationHODDaoInterface;
	}

	public void setUserInformationHODDaoInterface(UserInformationHODDaoInterface userInformationHODDaoInterface) {
		this.userInformationHODDaoInterface = userInformationHODDaoInterface;
	}

	@Override
	public List<String> getTeachingStaffRegistrationInfo() {
		// TODO Auto-generated method stub
		return userInformationHODDaoInterface.getTeachingStaffRegistrationInfo();
	}

	@Override
	public List<String> getNonTeachingStaffRegistrationInfo() {
		// TODO Auto-generated method stub
		return userInformationHODDaoInterface.getNonTeachingStaffRegistrationInfo();
	}
	
	

}
