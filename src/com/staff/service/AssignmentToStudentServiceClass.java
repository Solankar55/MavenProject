package com.staff.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.AssignmentToStudentDaoInterface;
import com.staff.model.StudentAssignmentEnteryReportModel;
import com.staff.model.StudentAssignmentModel;
import com.staff.serviceInterface.AssignmentToStudentServiceInterface;

@Service
public class AssignmentToStudentServiceClass implements AssignmentToStudentServiceInterface{

	@Autowired
	private AssignmentToStudentDaoInterface assignmentToStudentDaoInterface;

	public AssignmentToStudentDaoInterface getAssignmentToStudentDaoInterface() {
		return assignmentToStudentDaoInterface;
	}

	public void setAssignmentToStudentDaoInterface(AssignmentToStudentDaoInterface assignmentToStudentDaoInterface) {
		this.assignmentToStudentDaoInterface = assignmentToStudentDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.getStaffList( username);
	}

	@Transactional
	@Override
	public List<String> GetCheckAvability(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetCheckAvability( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetYearList( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStreamList(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetStreamList( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetBranchlist(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetBranchlist( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStandardList(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetStandardList( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetSubjectList( staffID);
	}

	@Transactional
	@Override
	public List<String> GetStudentList(int yearID, int streamID, int branchID, int standardID, int subjectID) {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.GetStudentList( yearID,  streamID,  branchID,  standardID,  subjectID);
	}

	@Transactional
	@Override
	public void saveStudentAssignment(StudentAssignmentModel studentAssignmentModel) {
		// TODO Auto-generated method stub
		assignmentToStudentDaoInterface.saveStudentAssignment(studentAssignmentModel);
	}

	@Transactional
	@Override
	public int getMaxAssignmentID() {
		// TODO Auto-generated method stub
		return assignmentToStudentDaoInterface.getMaxAssignmentID();
	}

	@Transactional
	@Override
	public void saveStudentRecordWithAssignment(StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel) {
		// TODO Auto-generated method stub
		assignmentToStudentDaoInterface.saveStudentRecordWithAssignment(studentAssignmentEnteryReportModel);
	}
	
	
}
