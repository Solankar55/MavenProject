package com.HOD.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.AssignDepartmentDaoInterface;
import com.HOD.model.AssignDepartmentmodel;
import com.HOD.serviceInterface.AssignDepartmentServiceInterface;

@Service
public class AssignDepartmentServiceClass implements AssignDepartmentServiceInterface{

	@Autowired
	private AssignDepartmentDaoInterface assignDepartmentDaoInterface;

	public AssignDepartmentDaoInterface getAssignDepartmentDaoInterface() {
		return assignDepartmentDaoInterface;
	}

	public void setAssignDepartmentDaoInterface(AssignDepartmentDaoInterface assignDepartmentDaoInterface) {
		this.assignDepartmentDaoInterface = assignDepartmentDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<Integer, String> getTeachingStaff() {
		// TODO Auto-generated method stub
		return assignDepartmentDaoInterface.getTeachingStaff();
	}

	@Transactional
	@Override
	public void saveAssignDepartment(AssignDepartmentmodel assignDepartmentmodel) {
		// TODO Auto-generated method stub
		assignDepartmentDaoInterface.saveAssignDepartment(assignDepartmentmodel);
	}

	@Transactional
	@Override
	public List<String> getAssignList() {
		// TODO Auto-generated method stub
		return assignDepartmentDaoInterface.getAssignDepartmentList();
	}

	@Transactional
	@Override
	public List<String> getDepartmentList(String departmentName,int staffID) {
		// TODO Auto-generated method stub
		return assignDepartmentDaoInterface.getDepartmentList(departmentName,staffID);
	}

	@Transactional
	@Override
	public void removeDepartmentAuthority(int staffID, String departmentName) {
		// TODO Auto-generated method stub
		assignDepartmentDaoInterface.removeDepartmentAuthority(staffID, departmentName);
	}

	@Transactional
	@Override
	public List<String> getDepartmentList1(String departmentName) {
		return assignDepartmentDaoInterface.getDepartmentList1(departmentName);
	}

	@Transactional
	@Override
	public void updateAssignDepartment(String departmentName, int staffID) {
		// TODO Auto-generated method stub
		assignDepartmentDaoInterface.updateAssignDepartment(departmentName,staffID);
	}
	
	
}
