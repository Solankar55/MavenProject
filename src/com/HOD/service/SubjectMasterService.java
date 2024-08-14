package com.HOD.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.SubjectMasterDaoInterface;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.HOD.serviceInterface.SubjectMasterServiceInterface;
import com.admin.model.AdminRegistrationModel;

@Service
public class SubjectMasterService implements SubjectMasterServiceInterface{

	@Autowired
	private SubjectMasterDaoInterface subjectMasterDaoInterface;

	public SubjectMasterDaoInterface getSubjectMasterDaoInterface() {
		return subjectMasterDaoInterface;
	}

	public void setSubjectMasterDaoInterface(SubjectMasterDaoInterface subjectMasterDaoInterface) {
		this.subjectMasterDaoInterface = subjectMasterDaoInterface;
	}

	@Transactional
	@Override
	public void saveSubject(HODSubjectMasterModel hodSubjectMasterModel) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.saveSubject(hodSubjectMasterModel);
	}

	@Transactional
	@Override
	public List<String> getSubjectList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getSubjectList();
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<Integer, String> getTeachingStaff() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getTeachingStaff();
	}

	@Transactional
	@Override
	public HashMap<Integer, String> SubjectList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.SubjectList();
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStreamList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.GetStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getBranchList( id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getStandardList( branchid);
	}

	@Transactional
	@Override
	public void saveAssignValues(AssignSubjectTeacherModel assignSubjectTeacherModel) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.saveAssignSunjectValue(assignSubjectTeacherModel);
	}

	@Transactional
	@Override
	public List<String> getDataList(int yearID, int streamID, int branchID, int teacherID, int standardID,
			int subjectID) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getDataList( yearID,  streamID,  branchID,  teacherID,  standardID,
				 subjectID);
	}

	@Transactional
	@Override
	public List<String> getAssignSubjectTeacherList() {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getAssignSubjectTeacherList();
	}

	@Transactional
	@Override
	public List<String> getTeacherList(int yearId, int streamId, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.getTeacherList( yearId,  streamId,  branchid,  standardID);
	}

	@Transactional
	@Override
	public void setAssignSubjectToDisAssign(int yearID, int streamID, int branchID, int standardID, int teacherID,
			int subjectID) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.setAssignSubjectToDisAssign( yearID,  streamID,  branchID,  standardID,  teacherID,
				 subjectID);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return subjectMasterDaoInterface.checkAdmin(username);
	}

	@Transactional
	@Override
	public void updateSubjectAssignVlaue(int yearID, int streamID, int branchID, int standardID, int teacherID,
			int subjectID) {
		// TODO Auto-generated method stub
		subjectMasterDaoInterface.updateSubjectAssignVlaue( yearID,  streamID,  branchID,  standardID,  teacherID,
				 subjectID);
	}

	
}
