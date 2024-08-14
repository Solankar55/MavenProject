package com.student.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.daoInteerface.StudentAdmisssionDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentProfilePicModel;
import com.student.serviceInterface.StudentAdmisssionInterface;
@Repository
public class StudentAdmisssionServiceC implements StudentAdmisssionInterface{
	@Autowired
	StudentAdmisssionDaoInterface StudentAdmisssionDaoInterface;

	@Transactional
	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		StudentAdmisssionDaoInterface.saveAdmission(studentAdmissionModel);
		
	}

	@Transactional
	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.GetStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> GetStandardList(int id) {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.GetStandardList(id);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public int getStudentID() {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.getStudentID();
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudDetailsToCheckPresentOrNot(String studName, String studContact, String studEmail) {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.getStudDetailsToCheckPresentOrNot(studName,studContact,studEmail);
	}

	@Transactional
	@Override
	public List<acadamicYearModel> getStudentACYear(int yearID) {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.getStudentAcademicYearID(yearID);
	}

	@Transactional
	@Override
	public List<StandardMasterModel> getStudentStandard(int standardId) {
		// TODO Auto-generated method stub
		return StudentAdmisssionDaoInterface.getStudentStandard(standardId);
	}

	@Transactional
	@Override
	public void imageUpload(StudentProfilePicModel studentProfilePicModel) {
		// TODO Auto-generated method stub
		StudentAdmisssionDaoInterface.imageUpload( studentProfilePicModel);
	}

	@Transactional
	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		StudentAdmisssionDaoInterface.saveStudentBarcodeMaster(studentBarcodeMaster);
	}
}
