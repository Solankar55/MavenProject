package com.Department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Department.daoInterface.DepartmentDaoInterface;
import com.Department.serviceInterface.DepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Service
public class DepartmentServiceClass implements DepartmentServiceInterface {

	@Autowired
	private DepartmentDaoInterface departmentDaoInterface;

	public DepartmentDaoInterface getDepartmentDaoInterface() {
		return departmentDaoInterface;
	}

	public void setDepartmentDaoInterface(DepartmentDaoInterface departmentDaoInterface) {
		this.departmentDaoInterface = departmentDaoInterface;
	}

	@Transactional
	@Override
	public List<String> checkStaff(String password, String username, String DepartmentName) {
		// TODO Auto-generated method stub
		return departmentDaoInterface.checkDepartmentLogin(password, username, DepartmentName);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getEmailDetails(String emailAddress) {
		// TODO Auto-generated method stub
		return departmentDaoInterface.getEmailDetails(emailAddress);
	}

}
