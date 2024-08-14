package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerMasterModel;
import com.account.model.SubLedgerMasterModel;

public interface masterLedgerInterface {

	void saveMasterLedger(LedgerMasterModel ledgerMasterModel);

	List<LedgerMasterModel> fetchMasterLedger();
	
	HashMap fetchSubmasterLedger();

	void saveSubledgerMaster(SubLedgerMasterModel subLedgerMasterModel);
	
	List<SubLedgerMasterModel> fetchListofSavedsubledger();

	void SaveUpdateLedger(int ledgerID, String accType, String ledgerName, String type);

	void DeleteLedger(int ledgerID);

	void UpdateSubLedger(int subLedgerID, String subLedgerName);

	void DeleteSubLegder(int subLedgerID);


}
