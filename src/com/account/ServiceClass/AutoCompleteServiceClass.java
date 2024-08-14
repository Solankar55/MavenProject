package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.dao.AutoCompleteDaoClass;
import com.account.daoInterface.AutoCompleteDaoInterface;
import com.account.serviceInterface.AutoCompleteServiceInterface;

@Service
public class AutoCompleteServiceClass implements AutoCompleteServiceInterface{

	@Autowired
	private AutoCompleteDaoInterface autoCompleteDaoInterface;

	public AutoCompleteDaoInterface getAutoCompleteDaoInterface() {
		return autoCompleteDaoInterface;
	}

	public void setAutoCompleteDaoInterface(AutoCompleteDaoInterface autoCompleteDaoInterface) {
		this.autoCompleteDaoInterface = autoCompleteDaoInterface;
	}

	@Transactional
	@Override
	public List<String> serchStudentName(String keyword) {
		// TODO Auto-generated method stub
		return autoCompleteDaoInterface.serchStudentName(keyword);
	}

	@Transactional
	@Override
	public List<String> getStudentAllDataForPayment(String studentName) {
		// TODO Auto-generated method stub
		return autoCompleteDaoInterface.getStudentAllDataForPayment(studentName);
	}
	
	

	
	
	
}
