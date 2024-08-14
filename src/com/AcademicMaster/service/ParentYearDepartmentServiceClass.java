package com.AcademicMaster.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AcademicMaster.daoInterface.ParentYearDepartmentDaoInterface;
import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.ParentMessageModel;
import com.AcademicMaster.serviceInterface.ParentYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Service
public class ParentYearDepartmentServiceClass implements ParentYearDepartmentServiceInterface {

	@Autowired
	private ParentYearDepartmentDaoInterface parentYearDepartmentDaoInterface;

	public ParentYearDepartmentDaoInterface getParentYearDepartmentDaoInterface() {
		return parentYearDepartmentDaoInterface;
	}

	public void setParentYearDepartmentDaoInterface(ParentYearDepartmentDaoInterface parentYearDepartmentDaoInterface) {
		this.parentYearDepartmentDaoInterface = parentYearDepartmentDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getStaffList( username);
	}

	@Transactional
	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getBranch( id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.GetStamdardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getStandardWiseList( yearId,  streamid,  branchid,  standardID);
	}
	
	@Transactional
	@Override
	public void saveParentMessageModel(ParentMessageModel parentMessageModel) {
		// TODO Auto-generated method stub
		
		parentYearDepartmentDaoInterface.saveParentMessageModel(parentMessageModel);
		
	}
	
	@Transactional
	@Override
	public int getMaxParentID() {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getMaxParentID();
	}
    
	@Transactional
	@Override
	public void saveParentMessageEntryModel(ParentMessageEntryModel parentMessageEntryModel) {
		// TODO Auto-generated method stub
		parentYearDepartmentDaoInterface.saveParentMessageEntryModel(parentMessageEntryModel);
		
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		return parentYearDepartmentDaoInterface.getStudentContactN(studID);
	}
	
	
}
