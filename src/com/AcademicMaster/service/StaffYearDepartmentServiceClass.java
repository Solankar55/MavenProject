package com.AcademicMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AcademicMaster.daoInterface.StaffYearDepartmentDaoInterface;
import com.AcademicMaster.model.StaffMeetingNoticeModel;
import com.AcademicMaster.model.StaffMeetingNoticeStaffEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeModel;
import com.AcademicMaster.serviceInterface.StaffYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Service
public class StaffYearDepartmentServiceClass implements StaffYearDepartmentServiceInterface{

	@Autowired
	private StaffYearDepartmentDaoInterface staffYearDepartmentDaoInterface;

	public StaffYearDepartmentDaoInterface getStaffYearDepartmentDaoInterface() {
		return staffYearDepartmentDaoInterface;
	}

	public void setStaffYearDepartmentDaoInterface(StaffYearDepartmentDaoInterface staffYearDepartmentDaoInterface) {
		this.staffYearDepartmentDaoInterface = staffYearDepartmentDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStaffListUsingStaffType(String staffType) {
		// TODO Auto-generated method stub
		return staffYearDepartmentDaoInterface.getStaffListUsingStaffType(staffType);
	}

	@Transactional
	@Override
	public void saveStaffMeetingNoticeModel(StaffMeetingNoticeModel staffMeetingNoticeModel) {
		// TODO Auto-generated method stub
		staffYearDepartmentDaoInterface.saveStaffMeetingNoticeModel(staffMeetingNoticeModel);
	}

	@Transactional
	@Override
	public int getMaxStaffMeetingNoticeID() {
		// TODO Auto-generated method stub
		return staffYearDepartmentDaoInterface.getMaxStaffMeetingNoticeID();
	}

	@Transactional
	@Override
	public void saveStaffMeetingNoticeEnteryModel(
			StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel) {
		// TODO Auto-generated method stub
		staffYearDepartmentDaoInterface.saveStaffMeetingNoticeEnteryModel(
				 staffMeetingNoticeStaffEnteryModel);
	}

	@Transactional
	@Override
	public void saveStaffProgramNoticeModel(StaffProgramNoticeModel staffProgramNoticeModel) {
		// TODO Auto-generated method stub
		staffYearDepartmentDaoInterface.saveStaffProgramNoticeModel(staffProgramNoticeModel);
	}

	@Transactional
	@Override
	public int getMaxStaffProgramNoticeModelID() {
		// TODO Auto-generated method stub
		return staffYearDepartmentDaoInterface.getMaxStaffProgramNoticeModelID();
	}

	@Transactional
	@Override
	public void saveStaffProgramNoticeEnteryModel(StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel) {
		// TODO Auto-generated method stub
		staffYearDepartmentDaoInterface.saveStaffProgramNoticeEnteryModel(staffProgramNoticeEnteryModel);
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffContactN(int staffID) {
		// TODO Auto-generated method stub
		return staffYearDepartmentDaoInterface.getStaffContactN( staffID);
	}
	
	
}
