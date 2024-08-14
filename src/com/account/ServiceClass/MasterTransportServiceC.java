package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.MasterTransportDaoInterface;
import com.account.model.BankMasterModel;
import com.account.model.TransportMasterModel;
import com.account.serviceInterface.MasterTransportInterface;
import com.admin.model.AdminRegistrationModel;
@Service
public class MasterTransportServiceC implements  MasterTransportInterface{
	
	@Autowired
	MasterTransportDaoInterface masterTransportDaoInterface;

	
	@Transactional
	@Override
	public void TransportMgmt(TransportMasterModel transportMasterModel) {
		// TODO Auto-generated method stub
		masterTransportDaoInterface.TransportMgmt(transportMasterModel);
		
	}

	@Transactional
	@Override
	public List<TransportMasterModel> fetchMasterTransport() {
		// TODO Auto-generated method stub
		return masterTransportDaoInterface.fetchMasterTransport();
	}

	@Transactional
	@Override
	public void UpdateTransportCharges(int transID, String transCharge) {
		// TODO Auto-generated method stub
		masterTransportDaoInterface.UpdateTransportCharges(transID,transCharge);
	}

	@Transactional
	@Override
	public void DeleteTransportCharges(int transID) {
		// TODO Auto-generated method stub
		masterTransportDaoInterface.DeleteTransport(transID);
		
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return masterTransportDaoInterface.checkAdmin(username);
	}

	
}
