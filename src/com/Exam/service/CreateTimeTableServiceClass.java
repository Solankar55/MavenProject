package com.Exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exam.daoInterface.CreateTimeTableDaoInterface;
import com.Exam.model.CreateTimeTableModel;
import com.Exam.serviceInterface.CreateTimeTableServiceInterface;
import com.HOD.model.StaffRegistrationModel;

@Service
public class CreateTimeTableServiceClass implements CreateTimeTableServiceInterface{

	@Autowired
	private CreateTimeTableDaoInterface createTimeTableDaoInterface;

	public CreateTimeTableDaoInterface getCreateTimeTableDaoInterface() {
		return createTimeTableDaoInterface;
	}

	public void setCreateTimeTableDaoInterface(CreateTimeTableDaoInterface createTimeTableDaoInterface) {
		this.createTimeTableDaoInterface = createTimeTableDaoInterface;
	}

	@Transactional
	@Override
	public void SaveTimeTable(CreateTimeTableModel createTimeTableModel) {
		// TODO Auto-generated method stub
		createTimeTableDaoInterface.saveTimeTable(createTimeTableModel);
	}

	@Transactional
	@Override
	public List<String> getTimeTableList() {
		// TODO Auto-generated method stub
		return createTimeTableDaoInterface.getTimeTableList();
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return createTimeTableDaoInterface.getStaffInfo(username);
	}
	
	
}
