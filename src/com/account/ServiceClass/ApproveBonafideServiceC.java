package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.ApproveBonafideDaoInterface;
import com.account.serviceInterface.ApproveBonafideServiceInterface;
@Service
public class ApproveBonafideServiceC implements ApproveBonafideServiceInterface{

	@Autowired
	private ApproveBonafideDaoInterface approveBonafideDaoInterface;

	public ApproveBonafideDaoInterface getApproveBonafideDaoInterface() {
		return approveBonafideDaoInterface;
	}

	public void setApproveBonafideDaoInterface(ApproveBonafideDaoInterface approveBonafideDaoInterface) {
		this.approveBonafideDaoInterface = approveBonafideDaoInterface;
	}

	@Transactional
	@Override
	public List<String> GetRequestBonafide() {
		// TODO Auto-generated method stub
		return approveBonafideDaoInterface.getRequestBonafideList();
	}

	@Transactional
	@Override
	public void TakeBonafideRequest(int studID) {
		// TODO Auto-generated method stub
		approveBonafideDaoInterface.TakeBonafideRequest(studID);
	}

	@Transactional
	@Override
	public void cancelBonafide(int studID) {
		// TODO Auto-generated method stub
		approveBonafideDaoInterface.CancelBonafide(studID);
	}
	
	
}
