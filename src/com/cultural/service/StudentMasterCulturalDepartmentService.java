package com.cultural.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.cultural.daoInterface.StudentMasterCulturalDepartmentDaoInterface;
import com.cultural.serviceInterface.StudentMasterCulturalDepartmentServiceInterface;
import com.student.model.StudentAdmissionModel;

@Service
public class StudentMasterCulturalDepartmentService implements StudentMasterCulturalDepartmentServiceInterface {

	@Autowired
	private StudentMasterCulturalDepartmentDaoInterface studentMasterCulturalDepartmentDaoInterface;

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getStudentDetailsForAdmission( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentMail(int boxValue) {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getStudentMail( boxValue);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return studentMasterCulturalDepartmentDaoInterface.getStaffInfo(username);
	}
}
