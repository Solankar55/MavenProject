package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.CancelStudentBonafideDaoInterface;
import com.account.serviceInterface.CancelStudentBonafideServiceInterface;
@Service
public class CancelStudentBonafideServiceC implements CancelStudentBonafideServiceInterface{
	
	@Autowired
	private CancelStudentBonafideDaoInterface cancelStudentBonafideDaoInterface;

	public CancelStudentBonafideDaoInterface getCancelStudentBonafideDaoInterface() {
		return cancelStudentBonafideDaoInterface;
	}

	public void setCancelStudentBonafideDaoInterface(CancelStudentBonafideDaoInterface cancelStudentBonafideDaoInterface) {
		this.cancelStudentBonafideDaoInterface = cancelStudentBonafideDaoInterface;
	}

	@Transactional
	@Override
	public List<String> CancelBonafideList() {
		// TODO Auto-generated method stub
		return cancelStudentBonafideDaoInterface.cancelBonafideList();
	}
	
	

}
