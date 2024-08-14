package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.StudentMessageDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.StudentMessageServiceInterface;

@Service
public class StudentMessageServiceClass implements StudentMessageServiceInterface{

	@Autowired
	private StudentMessageDaoInterface studentMessageDaoInterface;

	public StudentMessageDaoInterface getStudentMessageDaoInterface() {
		return studentMessageDaoInterface;
	}

	public void setStudentMessageDaoInterface(StudentMessageDaoInterface studentMessageDaoInterface) {
		this.studentMessageDaoInterface = studentMessageDaoInterface;
	}

	@Transactional
	@Override
	public List<Object[]> getStudDetailsToCheckPresentOrNot(String studName, String studContact,
			String studEmail) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getStudDetailsToCheckPresentOrNot( studName,  studContact,
				 studEmail);
	}

	@Transactional
	@Override
	public List<String> getNoticeDetails(int studID, String studStatus, int studYear, int studBranch, int studStandard,
			int studStream) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getNoticeDetails( studID,  studStatus,  studYear,  studBranch,  studStandard,
				 studStream);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> CheckStudent(String username) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.CheckStudent(username);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username1) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.GetStudDetails(username1);
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String userName) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getStudInfo(userName);
	}

	@Transactional
	@Override
	public List<Object[]> getStudDetailList(String sName, String sContact, String sEmail) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getStudDetailList(sName,sContact,sEmail);
	}
	
	@Transactional
	@Override
	public List<String> getAttendenceNoticeDetail(Integer studID, Integer studYear, String studStatus,
			Integer studBranch, Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getAttendenceNoticeDetail(studID,studYear,  studStatus,
				 studBranch,  studStandard,  studStream);
	}

	@Transactional
	@Override
	public List<String> getAssignmentDetails(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getAssignmentDetails( studID,  studStatus,  studYear,  studBranch,
 studStandard,  studStream);
	}

	@Transactional
	@Override
	public List<String> getExamNoticeList(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		return studentMessageDaoInterface.getExamNoticeList( studID,  studStatus,  studYear,  studBranch,
				 studStandard,  studStream);
	}


	
	
}
