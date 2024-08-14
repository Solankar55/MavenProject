package com.administrator.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.administrator.daoInterface.AdministratorDaoInterface;
import com.administrator.serviceInterface.AdministratorServiceInterface;
@Repository
public class AdministratorServiceC implements AdministratorServiceInterface{

	@Autowired
	private AdministratorDaoInterface administratorDaoInterface;

	public AdministratorDaoInterface getAdministratorDaoInterface() {
		return administratorDaoInterface;
	}

	public void setAdministratorDaoInterface(AdministratorDaoInterface administratorDaoInterface) {
		this.administratorDaoInterface = administratorDaoInterface;
	}

	@Transactional
	@Override
	public void RegAuthorisedUser(AdminRegistrationModel adminRegistrationModel) {
		// TODO Auto-generated method stub
		administratorDaoInterface.saveNewAuthorisedUser(adminRegistrationModel);
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return administratorDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return administratorDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return administratorDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		return administratorDaoInterface.getStandardlist(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return administratorDaoInterface.getStandardWiseReport(yearId,streamid,branchid,standardID);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return administratorDaoInterface.checkAdmin(username);
	}

	@Transactional
	@Override
	public List<String> getUserNameCheck(String userName) {
		// TODO Auto-generated method stub
		return administratorDaoInterface.getUserNameCheck( userName);
	}
	
	
}
