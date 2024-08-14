package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.DepartmentMasterDaoInterface;
import com.library.model.Department;
import com.library.serviceInterface.DepartmentMasterServiceInterface;

@Service
@Transactional
public class DepartmentMasterServiceClass implements DepartmentMasterServiceInterface {

	@Autowired
	private DepartmentMasterDaoInterface departmentMasterDaoInterface;

	public DepartmentMasterDaoInterface getDepartmentMasterDaoInterface() {
		return departmentMasterDaoInterface;
	}

	public void setDepartmentMasterDaoInterface(DepartmentMasterDaoInterface departmentMasterDaoInterface) {
		this.departmentMasterDaoInterface = departmentMasterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return departmentMasterDaoInterface.checkAdmin(username);
	}

	@Override
	public List<Department> getListOfDepartment() {
		// TODO Auto-generated method stub
		return departmentMasterDaoInterface.getListOfDepartment();
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMasterDaoInterface.saveDepartment( department);
	}

	@Override
	public void updateDepartmentData(int id, String department) {
		// TODO Auto-generated method stub
		departmentMasterDaoInterface.updateDepartmentData( id,  department);
	}

	@Override
	public void deleteDepartmentData(int id) {
		// TODO Auto-generated method stub
		departmentMasterDaoInterface.deleteDepartmentData( id);
	}
	
	
}
