package com.HOD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.StaffInformationEditDaoInterface;
import com.HOD.serviceInterface.StaffInformationEditServiceInterface;
import com.admin.model.AdminRegistrationModel;

@Service
public class StaffInformationEditServiceClass implements StaffInformationEditServiceInterface{

	@Autowired
	private StaffInformationEditDaoInterface staffInformationEditDaoInterface;

	public StaffInformationEditDaoInterface getStaffInformationEditDaoInterface() {
		return staffInformationEditDaoInterface;
	}

	public void setStaffInformationEditDaoInterface(StaffInformationEditDaoInterface staffInformationEditDaoInterface) {
		this.staffInformationEditDaoInterface = staffInformationEditDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStaffInformation() {
		// TODO Auto-generated method stub
		return staffInformationEditDaoInterface.getStaffInfo();
	}

	@Transactional
	@Override
	public void updateStaffInfo(int staffId, String staffName, String staffMb, String staffEmail, String staffQ,
			String staffD, String staffT, String barcode, String staffAdd, String staffExp) {
		// TODO Auto-generated method stub
		staffInformationEditDaoInterface.updateStaffInfo( staffId,  staffName,  staffMb,  staffEmail,  staffQ,
				 staffD,  staffT,  barcode,  staffAdd,  staffExp);
	}

	@Transactional
	@Override
	public void deleteStaffInfo(int staffId) {
		// TODO Auto-generated method stub
		staffInformationEditDaoInterface.deleteStaffInfo(staffId);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return staffInformationEditDaoInterface.CheckAdmin(username);
	}
	
	
}
