package com.Exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exam.daoInterface.AcademicYearDepartmentMasterDaoInterface;
import com.Exam.serviceInterface.AcademicYearDepartmentMasterserviceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;

@Service
public class AcademicYearDepartmentMasterservice implements AcademicYearDepartmentMasterserviceInterface{

	@Autowired
	private AcademicYearDepartmentMasterDaoInterface academicYearDepartmentMasterDaoInterface;

	public AcademicYearDepartmentMasterDaoInterface getAcademicYearDepartmentMasterDaoInterface() {
		return academicYearDepartmentMasterDaoInterface;
	}

	public void setAcademicYearDepartmentMasterDaoInterface(
			AcademicYearDepartmentMasterDaoInterface academicYearDepartmentMasterDaoInterface) {
		this.academicYearDepartmentMasterDaoInterface = academicYearDepartmentMasterDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetAcademicYearList() {
		// TODO Auto-generated method stub
		return academicYearDepartmentMasterDaoInterface.GetAcademicYearList();
	}

	@Transactional
	@Override
	public void SaveYear(acadamicYearModel acadamicYearModel) {
		// TODO Auto-generated method stub
		academicYearDepartmentMasterDaoInterface.SaveYear(acadamicYearModel);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetAcademicYearListKeyValue() {
		// TODO Auto-generated method stub
		return academicYearDepartmentMasterDaoInterface.GetAcademicYearListKeyValue();
	}

	@Transactional
	@Override
	public List<String> ActiveYearList() {
		// TODO Auto-generated method stub
		return academicYearDepartmentMasterDaoInterface.ActiveYearList();
	}

	@Transactional
	@Override
	public void setActiveYear(int yearID) {
		// TODO Auto-generated method stub
		academicYearDepartmentMasterDaoInterface.setActiveYear(yearID);
	}

	@Transactional
	@Override
	public void UpadteYear(int yearId, String year) {
		// TODO Auto-generated method stub
		academicYearDepartmentMasterDaoInterface.UpadteYear(yearId, year);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return academicYearDepartmentMasterDaoInterface.getStaffList(username);
	}

	@Transactional
	@Override
	public void DeleteYear(int yearId) {
		// TODO Auto-generated method stub
		academicYearDepartmentMasterDaoInterface.deleteYear(yearId);
	}
	
	
}
