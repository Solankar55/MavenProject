package com.TAP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.daoInterface.TAPReportDaoInterface;
import com.TAP.serviceInterface.TAPReportServiceInterface;

@Service
public class TAPReportServiceClass implements TAPReportServiceInterface{

	@Autowired
	private TAPReportDaoInterface tapReportDaoInterface;

	public TAPReportDaoInterface getTapReportDaoInterface() {
		return tapReportDaoInterface;
	}

	public void setTapReportDaoInterface(TAPReportDaoInterface tapReportDaoInterface) {
		this.tapReportDaoInterface = tapReportDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStudentTapDetails() {
		// TODO Auto-generated method stub
		return tapReportDaoInterface.getStudentTapDetails();
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return tapReportDaoInterface.getStaffList(username);
	}
	
}
