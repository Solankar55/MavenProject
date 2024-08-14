package com.TAP.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.daoInterface.StudentLinkDaoInterface;
import com.TAP.model.StudentRegistrationTAPModel;
import com.TAP.serviceInterface.StudentLinkServiceInterface;
import com.student.model.StudentAdmissionModel;

@Service
public class StudentLinkServiceClass implements StudentLinkServiceInterface{

	@Autowired
	private StudentLinkDaoInterface studentLinkDaoInterface;

	public StudentLinkDaoInterface getStudentLinkDaoInterface() {
		return studentLinkDaoInterface;
	}

	public void setStudentLinkDaoInterface(StudentLinkDaoInterface studentLinkDaoInterface) {
		this.studentLinkDaoInterface = studentLinkDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getStandardList( branchid);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getStudentDetailsForAdmission( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public int getTAPId() {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getTAPID();
	}

	@Transactional
	@Override
	public void saveStudentRegistrationTAPDetails(StudentRegistrationTAPModel studentRegistrationTAPModel) {
		// TODO Auto-generated method stub
		studentLinkDaoInterface.saveStudentRegistrationTAPDetails(studentRegistrationTAPModel);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentMail(int boxValue) {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getStudentMail(boxValue);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return studentLinkDaoInterface.getStaffList(username) ;
	}
	
	
}
