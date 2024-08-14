package com.library.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.AdminRegistrationModel;
import com.library.daoInterface.AccessibilityMasterDaoInterface;
import com.library.model.AccessibilityMaster;
import com.library.serviceInterface.AccessibilityMasterServiceInterface;

@Service
@Transactional
public class AccessibilityMasterServiceClass implements AccessibilityMasterServiceInterface{

	@Autowired
	private AccessibilityMasterDaoInterface accessibilityMasterDaoInterface;

	public AccessibilityMasterDaoInterface getAccessibilityMasterDaoInterface() {
		return accessibilityMasterDaoInterface;
	}

	public void setAccessibilityMasterDaoInterface(AccessibilityMasterDaoInterface accessibilityMasterDaoInterface) {
		this.accessibilityMasterDaoInterface = accessibilityMasterDaoInterface;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		return accessibilityMasterDaoInterface.checkAdmin( username);
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		return accessibilityMasterDaoInterface.getYearList();
	}

	@Override
	public List<AccessibilityMaster> accessibilityList() {
		// TODO Auto-generated method stub
		return accessibilityMasterDaoInterface.accessibilityList();
	}

	@Override
	public List<String> getValueList(int acyear, String category) {
		// TODO Auto-generated method stub
		return accessibilityMasterDaoInterface.getValueList( acyear,  category);
	}

	@Override
	public void accessibilityDataSave(AccessibilityMaster am) {
		// TODO Auto-generated method stub
	 accessibilityMasterDaoInterface.accessibilityDataSave( am);
	}

	@Override
	public void updateValues(int acyear, String category, int canI, int noDayR, int fCharge) {
		// TODO Auto-generated method stub
		accessibilityMasterDaoInterface.updateValues( acyear,  category,  canI,  noDayR,  fCharge);
	}

	@Override
	public List<String> getFeeData(int acYearID, String category) {
		// TODO Auto-generated method stub
		return accessibilityMasterDaoInterface.getFeeData( acYearID,  category);
	}

	@Override
	public void updateAccessibilityData(int id, String category, int canissue, int returnindays, int fine) {
		// TODO Auto-generated method stub
		accessibilityMasterDaoInterface.updateAccessibilityData( id,  category,  canissue,  returnindays,  fine);
	}
	
	
}
