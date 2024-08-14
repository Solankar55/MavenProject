package com.student.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.model.LedgerFeePaidModel;
import com.account.model.acadamicYearModel;
import com.student.daoInteerface.StudentNextYearAdmissionDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.serviceInterface.StudentNextYearAdmissionServiceInterface;

@Service
public class StudentNextYearAdmissionServiceClass implements StudentNextYearAdmissionServiceInterface {

	@Autowired
	private StudentNextYearAdmissionDaoInterface studentNextYearAdmissionDaoInterface;

	public StudentNextYearAdmissionDaoInterface getStudentNextYearAdmissionDaoInterface() {
		return studentNextYearAdmissionDaoInterface;
	}

	public void setStudentNextYearAdmissionDaoInterface(
			StudentNextYearAdmissionDaoInterface studentNextYearAdmissionDaoInterface) {
		this.studentNextYearAdmissionDaoInterface = studentNextYearAdmissionDaoInterface;
	}

	@Transactional
	@Override
	public Integer getStudentInfo(int studentId) {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.getStudentInformation(studentId);
	}

	@Transactional
	@Override
	public List<acadamicYearModel> getActiveYear() {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.getActiveYear();
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.SetStream();
	}

	@Transactional
	@Override
	public List<String> getStudentDetailInfo(int studId) {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.getStudentDetailInfo(studId);
	}

	@Transactional
	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		studentNextYearAdmissionDaoInterface.saveBracodeMaster(studentBarcodeMaster);
	}

	@Transactional
	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		studentNextYearAdmissionDaoInterface.saveAdmission(studentAdmissionModel);
	}

	@Transactional
	@Override
	public List<LedgerFeePaidModel> getFeeDetails(int studId) {
		// TODO Auto-generated method stub
		return studentNextYearAdmissionDaoInterface.getFeeDetails(studId);
	}
	
}
