package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.MasterLedgerDaoInterface;
import com.account.model.LedgerMasterModel;
import com.account.model.SubLedgerMasterModel;
import com.account.serviceInterface.masterLedgerInterface;
@Service
public class MasterLadgerServiceC implements masterLedgerInterface {
	@Autowired
	MasterLedgerDaoInterface masterLedgerDaoInterface;

	@Transactional
	@Override
	public void saveMasterLedger(LedgerMasterModel ledgerMasterModel) {
		masterLedgerDaoInterface.saveMasterLedger(ledgerMasterModel);
	}

	@Transactional
	@Override
	public List<LedgerMasterModel> fetchMasterLedger() {
		// TODO Auto-generated method stub
		return masterLedgerDaoInterface.fetchMasterLedger();
	}

	@Transactional
	@Override
	public void saveSubledgerMaster(SubLedgerMasterModel subLedgerMasterModel) {
		// TODO Auto-generated method stub
		masterLedgerDaoInterface.saveSubLedgerMaster(subLedgerMasterModel);
	}

	@Transactional
	@Override
	public HashMap fetchSubmasterLedger() {
		// TODO Auto-generated method stub
		return masterLedgerDaoInterface.fetchSubMasterLedger();
	}

	@Transactional
	@Override
	public List<SubLedgerMasterModel> fetchListofSavedsubledger() {
		// TODO Auto-generated method stub
		return masterLedgerDaoInterface.fetchSubledgerInterface();
	}

	@Transactional
	@Override
	public void SaveUpdateLedger(int ledgerID, String accType, String ledgerName, String type) {
		// TODO Auto-generated method stub
		masterLedgerDaoInterface.SaveUpdateLedger(ledgerID, accType, ledgerName, type);
	}

	@Transactional
	@Override
	public void DeleteLedger(int ledgerID) {
		// TODO Auto-generated method stub
		masterLedgerDaoInterface.DeleteLedger(ledgerID);
		
	}

	@Transactional
	@Override
	public void UpdateSubLedger(int subLedgerID, String subLedgerName) {
		// TODO Auto-generated method stub
		masterLedgerDaoInterface.UpdateSubLedger(subLedgerID,subLedgerName);
	}

	@Transactional
	@Override
	public void DeleteSubLegder(int subLedgerID) {
		// TODO Auto-generated method stub
		masterLedgerDaoInterface.DeleteSubLedger(subLedgerID);
	}

}
