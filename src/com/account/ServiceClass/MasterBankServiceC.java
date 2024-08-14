package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.MasterBankDaoInterface;
import com.account.model.BankMasterModel;
import com.account.model.LedgerMasterModel;
import com.account.serviceInterface.MasterBankInterface;
@Service
public class MasterBankServiceC implements MasterBankInterface{
	@Autowired
	MasterBankDaoInterface masterBankDaoInterface;
	
	@Transactional
	@Override
	
	public void saveBank(BankMasterModel bankMasterModel){
		masterBankDaoInterface.saveBank(bankMasterModel);
	}
	@Transactional
	@Override
	public List<BankMasterModel> fetchMasterBank() {
		// TODO Auto-generated method stub
		return masterBankDaoInterface.fetchMasterBank();
		
	}

	@Transactional
	@Override
	public void UpdateBankDetails(int bankId, String bankAccountNumber, String iFSCCode,String bankName, String branchName) {
		// TODO Auto-generated method stub
		masterBankDaoInterface.UpdateBankDetails(bankId,bankAccountNumber,iFSCCode, bankName,  branchName);
	}

	@Transactional
	@Override
	public void DeleteBank(int bankId) {
		// TODO Auto-generated method stub
		masterBankDaoInterface.DeleteBank(bankId);
	}

	
	
}
