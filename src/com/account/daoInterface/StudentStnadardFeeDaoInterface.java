package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StandardFeeMasterModel;

public interface StudentStnadardFeeDaoInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> GetStreamList();

	List<String> GetBranch(int id);

	List<String> GetStandardList(int branchID);

	HashMap<String, String> GetLedgereList();

	List<String> GetSubLedgerList(int ledgerId);

	void SaveFeeTODB(StandardFeeMasterModel standardFeeMasterModel);

	List<String> GetLedgerFeeList();

	void UpdateStandardFee(int ledgerID, float standardFee, int subLedgerId, int stdFeeId);

	void DeleteStandardFeeD(int stdFeeId);

	List<String> getStandardLedger(int yearId, int streamid, int branchid, int standardID, int ledgername);


}
