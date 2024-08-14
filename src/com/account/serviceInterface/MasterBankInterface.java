package com.account.serviceInterface;

import java.util.List;

import com.account.model.BankMasterModel;

public interface MasterBankInterface {

	void saveBank(BankMasterModel bankMasterModel);

	List<BankMasterModel> fetchMasterBank();

	void UpdateBankDetails(int bankId, String bankAccountNumber, String iFSCCode, String bankName, String branchName);

	void DeleteBank(int bankId);


}
