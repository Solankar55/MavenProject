package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.CancelStudentIDCardDaoInterface;
import com.account.serviceInterface.CancelStudentIDCardServiceInterface;
@Service
public class CancelStudentIDCardServiceC implements CancelStudentIDCardServiceInterface{
	
	@Autowired
	private CancelStudentIDCardDaoInterface cancelStudentIDCardDaoInterface;

	public CancelStudentIDCardDaoInterface getCancelStudentIDCardDaoInterface() {
		return cancelStudentIDCardDaoInterface;
	}

	public void setCancelStudentIDCardDaoInterface(CancelStudentIDCardDaoInterface cancelStudentIDCardDaoInterface) {
		this.cancelStudentIDCardDaoInterface = cancelStudentIDCardDaoInterface;
	}

	@Transactional
	@Override
	public List<String> CancelList() {
		// TODO Auto-generated method stub
		return cancelStudentIDCardDaoInterface.cancelIDcardList();
	}
	
	

}
