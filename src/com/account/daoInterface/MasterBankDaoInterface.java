package com.account.daoInterface;

import java.util.List;

import com.account.model.BankMasterModel;

public interface MasterBankDaoInterface {

	void saveBank(BankMasterModel bankMasterModel);

	List<BankMasterModel> fetchMasterBank();

	void UpdateBankDetails(int bankId, String bankAccountNumber, String iFSCCode, String bankName, String branchName);

	void DeleteBank(int bankId);

	

	}
