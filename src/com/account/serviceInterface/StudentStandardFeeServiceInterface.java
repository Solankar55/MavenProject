package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StandardFeeMasterModel;

public interface StudentStandardFeeServiceInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchID);

	HashMap<String, String> GetLedgerList();

	List<String> GetSubLedgerList(int ledgerId);

	void SaveFee(StandardFeeMasterModel standardFeeMasterModel);

	List<String> GetLegderFeeList();

	void UpdateStandardFee(int ledgerID, float standardFee, int subLedgerId, int stdFeeId);

	void DeleteStandardFee(int stdFeeId);

	List<String> getStandardLedger(int yearId, int streamid, int branchid, int standardID, int ledgername);


}
