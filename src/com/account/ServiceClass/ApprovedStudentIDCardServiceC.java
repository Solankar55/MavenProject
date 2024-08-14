package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApprovedStudentIDCardDaoInterface;
import com.account.serviceInterface.ApprovedStudentIDCardServiceInterface;
@Service
public class ApprovedStudentIDCardServiceC implements ApprovedStudentIDCardServiceInterface {

	@Autowired
	private ApprovedStudentIDCardDaoInterface approvedStudentIDCardDaoInterface;

	public ApprovedStudentIDCardDaoInterface getApprovedStudentIDCardDaoInterface() {
		return approvedStudentIDCardDaoInterface;
	}

	public void setApprovedStudentIDCardDaoInterface(ApprovedStudentIDCardDaoInterface approvedStudentIDCardDaoInterface) {
		this.approvedStudentIDCardDaoInterface = approvedStudentIDCardDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetStudentIDCardList() {
		// TODO Auto-generated method stub
		return approvedStudentIDCardDaoInterface.getApprovedIDCardList();
	}
	
	

}
