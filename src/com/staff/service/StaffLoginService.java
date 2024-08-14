package com.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.StaffLoginDaoInterface;
import com.staff.serviceInterface.StaffLoginServiceInterface;

@Service
public class StaffLoginService implements StaffLoginServiceInterface {

	@Autowired
	private StaffLoginDaoInterface staffLoginDaoInterface;

	public StaffLoginDaoInterface getStaffLoginDaoInterface() {
		return staffLoginDaoInterface;
	}

	public void setStaffLoginDaoInterface(StaffLoginDaoInterface staffLoginDaoInterface) {
		this.staffLoginDaoInterface = staffLoginDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String userName, String passWord) {
		// TODO Auto-generated method stub
		return staffLoginDaoInterface.GetStaffList(userName,passWord);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getEmailDetails(String userEmail) {
		// TODO Auto-generated method stub
		return staffLoginDaoInterface.getEmailDetails(userEmail);
	}
	
	
}
