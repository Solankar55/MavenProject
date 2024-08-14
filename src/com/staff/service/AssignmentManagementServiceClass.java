package com.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.HODSubjectMasterModel;
import com.staff.daoInterface.AssignmentManagementDaoInterface;
import com.staff.serviceInterface.AssignmentManagementServiceInterface;

@Service
public class AssignmentManagementServiceClass implements AssignmentManagementServiceInterface{

	@Autowired
	private AssignmentManagementDaoInterface assignmentManagementDaoInterface;

	public AssignmentManagementDaoInterface getAssignmentManagementDaoInterface() {
		return assignmentManagementDaoInterface;
	}

	public void setAssignmentManagementDaoInterface(AssignmentManagementDaoInterface assignmentManagementDaoInterface) {
		this.assignmentManagementDaoInterface = assignmentManagementDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getGivenAssignMentList(String SubjectName) {
		// TODO Auto-generated method stub
		return assignmentManagementDaoInterface.getGivenAssignMentList(SubjectName);
	}

	@Transactional
	@Override
	public List<String> getRemoveAssignmentList(String subjectName) {
		// TODO Auto-generated method stub
		return assignmentManagementDaoInterface.getRemoveAssignmentList(subjectName);
	}

	@Transactional
	@Override
	public String deleteAssignment(int assid) {
		// TODO Auto-generated method stub
		return assignmentManagementDaoInterface.deleteAssignment(assid);
	}

	@Transactional
	@Override
	public List<HODSubjectMasterModel> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub
		return assignmentManagementDaoInterface.GetSubjectList( staffID);
	}

	@Transactional
	@Override
	public List<String> getGivenAssignMentListToRemove(String subjectName) {
		// TODO Auto-generated method stub
		return assignmentManagementDaoInterface.getGivenAssignMentListToRemove(subjectName);
	}
	
	
}
