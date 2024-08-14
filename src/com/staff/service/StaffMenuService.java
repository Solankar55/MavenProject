package com.staff.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.StaffMenuDaoInterface;
import com.staff.model.StudentAttendance;
import com.staff.model.StudentEnteryOfAttendance;
import com.staff.serviceInterface.StaffMenuServiceInterface;

@Service
public class StaffMenuService implements StaffMenuServiceInterface{

	@Autowired
	private StaffMenuDaoInterface staffMenuDaoInterface;

	public StaffMenuDaoInterface getStaffMenuDaoInterface() {
		return staffMenuDaoInterface;
	}

	public void setStaffMenuDaoInterface(StaffMenuDaoInterface staffMenuDaoInterface) {
		this.staffMenuDaoInterface = staffMenuDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.getStaffList(username);
	}

	@Transactional
	@Override
	public List<String> GetCheckAvability(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.getCheckAvabality(staffID);
	}

	@Transactional
	@Override
	public List<String> CheckClassInchargeOrNot(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.CheckClassInchargeOrNot(staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetYearList(staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStreamList(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetStreamList(staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetBranchlist(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetBranchlist( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStandardList(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetStandardList( staffID) ;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetSubjectList(int staffID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetSubjectList( staffID);
	}


	@Transactional
	@Override
	public List<String> GetStudentList(int yearID, int streamID, int branchID, int standardID, int subjectID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.GetStudentList( yearID,  streamID, branchID,  standardID,  subjectID);
	}

	@Transactional
	@Override
	public int getMaxStudentAttendanceID() {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.getMaxStudentAttendanceID();
	}

	@Transactional
	@Override
	public void saveSubjectVisStudentAttendance(StudentAttendance studentAttendance) {
		// TODO Auto-generated method stub
		staffMenuDaoInterface.saveSubjectVisStudentAttendance( studentAttendance);
	}

	@Transactional
	@Override
	public void saveStudentAttendanceBySubjectVis(StudentEnteryOfAttendance studentEnteryOfAttendance) {
		// TODO Auto-generated method stub
		staffMenuDaoInterface.saveStudentAttendanceBySubjectVis( studentEnteryOfAttendance);
	}

	@Transactional
	@Override
	public List<String> getSubjectListStaff(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.getSubjectListStaff(yearID,streamID,branchID,standardID);
	}

	@Transactional
	@Override
	public List<Object[]> getstudentListForAtt(int yrId, int streamId, int branchId, int standId, int subId) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.getStudentListForAtt(yrId,streamId,branchId,standId,subId);
	}

	@Transactional
	@Override
	public List gettotalNoOFLect(int yrId, int streamId, int branchId, int standId, int subId) {
		// TODO Auto-generated method stub
		return staffMenuDaoInterface.gettotalNoOFLect(yrId,streamId, branchId,  standId,  subId);
	}

	


	
	
}
