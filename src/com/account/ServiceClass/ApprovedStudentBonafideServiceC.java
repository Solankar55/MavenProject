package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApprovedStudentBonafideDaoInterface;
import com.account.serviceInterface.ApprovedBonafideServiceInterface;
@Service
public class ApprovedStudentBonafideServiceC implements ApprovedBonafideServiceInterface {

	@Autowired
	private ApprovedStudentBonafideDaoInterface approvedStudentBonafideDaoInterface;

	public ApprovedStudentBonafideDaoInterface getApprovedStudentBonafideDaoInterface() {
		return approvedStudentBonafideDaoInterface;
	}

	public void setApprovedStudentBonafideDaoInterface(
			ApprovedStudentBonafideDaoInterface approvedStudentBonafideDaoInterface) {
		this.approvedStudentBonafideDaoInterface = approvedStudentBonafideDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getApprovedBonafideList() {
		// TODO Auto-generated method stub
		return approvedStudentBonafideDaoInterface.GetApprovedBonafideList();
	}
	
	
}
