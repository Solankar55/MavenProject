package com.NSS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.NSS.daoInterface.NSSApproveDaoInterface;
import com.NSS.serviceInterface.NSSApproveServiceInterface;

@Service
public class NSSApproveServiceClass implements NSSApproveServiceInterface{

	@Autowired
	private NSSApproveDaoInterface nssApproveDaoInterface;

	public NSSApproveDaoInterface getNssApproveDaoInterface() {
		return nssApproveDaoInterface;
	}

	public void setNssApproveDaoInterface(NSSApproveDaoInterface nssApproveDaoInterface) {
		this.nssApproveDaoInterface = nssApproveDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetNSSStudentList() {
		// TODO Auto-generated method stub
		return nssApproveDaoInterface.GetNSSStudentList();
	}

	@Transactional
	@Override
	public void updateStudentStatus(String boxValue,String currentDate) {
		// TODO Auto-generated method stub
		nssApproveDaoInterface.updateStudentStatus(boxValue,currentDate);
	}

	@Transactional
	@Override
	public List<String> GetNSSStudentListDisApproved() {
		// TODO Auto-generated method stub
		return nssApproveDaoInterface.GetNSSStudentListDisApproved();
	}

	@Transactional
	@Override
	public void updateStudentStatusDisApproved(String boxValue,String currentDate) {
		// TODO Auto-generated method stub
		nssApproveDaoInterface.updateStudentStatusDisApproved(boxValue,currentDate);
	}

	@Transactional
	@Override
	public List<String> GetNSSStudentListApproved() {
		// TODO Auto-generated method stub
		return nssApproveDaoInterface.GetNSSStudentListApproved();
	}

	@Transactional
	@Override
	public List<String> GetNSSStudentDisApprovedList() {
		// TODO Auto-generated method stub
		return nssApproveDaoInterface.GetNSSStudentDisApprovedList();
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return nssApproveDaoInterface.getStaffInfo(username);
	}
	
	
}
