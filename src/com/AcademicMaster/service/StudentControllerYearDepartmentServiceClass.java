package com.AcademicMaster.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AcademicMaster.daoInterface.StudentControllerYearDepartmentDaoInterface;
import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentAttendanceNoticeStudentEnteryModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.AcademicMaster.serviceInterface.StudentControllerYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Service
public class StudentControllerYearDepartmentServiceClass implements StudentControllerYearDepartmentServiceInterface {

	@Autowired
	private StudentControllerYearDepartmentDaoInterface studentControllerYearDepartmentDaoInterface;

	public StudentControllerYearDepartmentDaoInterface getStudentControllerYearDepartmentDaoInterface() {
		return studentControllerYearDepartmentDaoInterface;
	}

	public void setStudentControllerYearDepartmentDaoInterface(
			StudentControllerYearDepartmentDaoInterface studentControllerYearDepartmentDaoInterface) {
		this.studentControllerYearDepartmentDaoInterface = studentControllerYearDepartmentDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getStaffList(username);
	}

	@Transactional
	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getBranch(id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.GetStamdardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getStandardWiseList(yearId, streamid, branchid, standardID);
	}

	@Transactional
	@Override
	public void saveStudentNoticeModel(StudentNoticeModel studentNoticeModel) {
		// TODO Auto-generated method stub

		studentControllerYearDepartmentDaoInterface.saveStudentNoticeModel(studentNoticeModel);

	}

	@Transactional
	@Override
	public int getMaxNoticeID() {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getMaxNoticeID();
	}

	@Transactional
	@Override
	public void saveStudentNoticeStudentEntryModel(StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel) {
		// TODO Auto-generated method stub
		studentControllerYearDepartmentDaoInterface.saveStudentNoticeStudentEntryModel(studentNoticeStudentEnteryModel);

	}

	@Transactional
	@Override
	public void saveStudentAttendanceNoticeModel(StudentAttendanceNoticeModel studentAttendanceNoticeModel) {
		// TODO Auto-generated method stub
		studentControllerYearDepartmentDaoInterface.saveStudentAttendanceNoticeModel(studentAttendanceNoticeModel);
	}

	@Transactional
	@Override
	public int getStudentAttendanceNoticeMaxID() {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getStudentAttendanceNoticeMaxID();
	}

	@Transactional
	@Override
	public void saveStudentAttendenceNoticeEnteryModel(
			StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel) {
		// TODO Auto-generated method stub
		studentControllerYearDepartmentDaoInterface
				.saveStudentAttendenceNoticeEnteryModel(studentAttendanceNoticeStudentEnteryModel);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		return studentControllerYearDepartmentDaoInterface.getStudentContactN( studID);
	}

}
