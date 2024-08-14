package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApproveStudentIDCardDaoInterface;
import com.account.serviceInterface.ApproveStudentIDCardServiceInterface;
@Service
public class ApproveStudentIDCardServiceC implements ApproveStudentIDCardServiceInterface{

	@Autowired
	private ApproveStudentIDCardDaoInterface approveStudentIDCardDaoInterface;

	public ApproveStudentIDCardDaoInterface getApproveStudentIDCardDaoInterface() {
		return approveStudentIDCardDaoInterface;
	}

	public void setApproveStudentIDCardDaoInterface(ApproveStudentIDCardDaoInterface approveStudentIDCardDaoInterface) {
		this.approveStudentIDCardDaoInterface = approveStudentIDCardDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetRequestListIDCard() {
		// TODO Auto-generated method stub
		return approveStudentIDCardDaoInterface.GetRequestIDCardList();
	}

	@Transactional
	@Override
	public void TakeIDCardRequest(int studID) {
		// TODO Auto-generated method stub
		approveStudentIDCardDaoInterface.TakeIDCardRequest(studID);
	}

	@Transactional
	@Override
	public void cancelIDCrard(int studID) {
		// TODO Auto-generated method stub
		approveStudentIDCardDaoInterface.cancelIDCard(studID);
	}
	
}
