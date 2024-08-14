package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.BranchMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface BranchMasterInterface {

	void AddNewBranch(BranchMasterModel branchMasterModel);

	List<BranchMasterModel> GetBranchList();

	HashMap<String, String> setBranch();

	void UpdateBranch(int branchID, String branchName);

	void DeleteBranch(int branchID);

	List<AdminRegistrationModel> CheckAdmin(String username);

}
