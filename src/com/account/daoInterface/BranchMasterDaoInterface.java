package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.BranchMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface BranchMasterDaoInterface {

	void addNewBranch(BranchMasterModel branchMasterModel);

	List<BranchMasterModel> getBranchList();

	HashMap<String, String> GetBranch();

	void UpdateBranch(int branchID, String branchName);

	void DeleteBranch(int branchID);

	List<AdminRegistrationModel> CheckAdmin(String username);

}
