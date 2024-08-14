package com.Alumini.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Alumini.daoInterface.AluminiSendLinkToStudentDaoInterface;
import com.Alumini.serviceInterface.AluminiSendLinkToStudentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Service
public class AluminiSendLinkToStudentService implements AluminiSendLinkToStudentServiceInterface{

	@Autowired
	private AluminiSendLinkToStudentDaoInterface aluminiSendLinkToStudentDaoInterface;

	public AluminiSendLinkToStudentDaoInterface getAluminiSendLinkToStudentDaoInterface() {
		return aluminiSendLinkToStudentDaoInterface;
	}

	public void setAluminiSendLinkToStudentDaoInterface(
			AluminiSendLinkToStudentDaoInterface aluminiSendLinkToStudentDaoInterface) {
		this.aluminiSendLinkToStudentDaoInterface = aluminiSendLinkToStudentDaoInterface;
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentInfo(String mailID) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getStudentInfo(mailID);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getStaffInfo(username);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getBranchList( id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface. getStandardList( branchid);
	}

	@Transactional
	@Override
	public List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getStudentDetailsForAdmission( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentMail(int boxValue) {
		// TODO Auto-generated method stub
		return aluminiSendLinkToStudentDaoInterface.getStudentMail( boxValue);
	}

	
}
