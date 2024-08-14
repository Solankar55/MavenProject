package com.staff.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.StaffClassInChargeDaoInterface;
import com.staff.serviceInterface.StaffClassInChargeServiceInterface;

@Service
public class StaffClassInChargeService implements StaffClassInChargeServiceInterface{

	@Autowired
	private StaffClassInChargeDaoInterface staffClassInChargeDaoInterface;

	public StaffClassInChargeDaoInterface getStaffClassInChargeDaoInterface() {
		return staffClassInChargeDaoInterface;
	}

	public void setStaffClassInChargeDaoInterface(StaffClassInChargeDaoInterface staffClassInChargeDaoInterface) {
		this.staffClassInChargeDaoInterface = staffClassInChargeDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.getStaffList(username);
	}

	@Transactional
	@Override
	public List<String> CheckClassInchargeOrNot(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.CheckClassInchargeOrNot( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.GetYearList( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStreamList(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.GetStreamList( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetBranchlist(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.GetBranchlist( staffID);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetStandardList(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.GetStandardList( staffID);
	}

	@Transactional
	@Override
	public List<String> getStudentList(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.getStudentList( yearID,  streamID,  branchID,  standardID);
	}

	@Transactional
	@Override
	public List<Object[]> getPresentClassInchargeDetails(int staffID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.getPresentClassInchargeDetails(staffID);
	}

	@Transactional
	@Override
	public List<String> getStudentAbsentList(Integer yearID, Integer streamID, Integer branchID, Integer standardID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.getStudentAbsentList( yearID,  streamID,  branchID,  standardID);
	}

	@Transactional
	@Override
	public List<String> getStudentPresentList(Integer yearID, Integer branchID, Integer standardID, Integer streamID) {
		// TODO Auto-generated method stub
		return staffClassInChargeDaoInterface.getStudentPresentList( yearID,  branchID,  standardID,  streamID);
	}
	
	
}
