package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerMasterModel;
import com.account.model.SubLedgerMasterModel;

public interface MasterLedgerDaoInterface {

	void saveMasterLedger(LedgerMasterModel ledgerMasterModel);

	List<LedgerMasterModel> fetchMasterLedger();
	
	HashMap fetchSubMasterLedger();

	void saveSubLedgerMaster(SubLedgerMasterModel subLedgerMasterModel);

	List<SubLedgerMasterModel> fetchSubledgerInterface();

	void SaveUpdateLedger(int ledgerID, String accType, String ledgerName, String type);

	void DeleteLedger(int ledgerID);

	void UpdateSubLedger(int subLedgerID, String subLedgerName);

	void DeleteSubLedger(int subLedgerID);

}
