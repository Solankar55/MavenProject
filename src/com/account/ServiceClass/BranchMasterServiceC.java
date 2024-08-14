package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.BranchMasterDaoInterface;
import com.account.model.BranchMasterModel;
import com.account.serviceInterface.BranchMasterInterface;
import com.admin.model.AdminRegistrationModel;
@Service
public class BranchMasterServiceC implements BranchMasterInterface{

	@Autowired
	private BranchMasterDaoInterface branchMasterDaoInterface;
	
	@Transactional
	@Override
	public void AddNewBranch(BranchMasterModel branchMasterModel) {
		// TODO Auto-generated method stub
		branchMasterDaoInterface.addNewBranch(branchMasterModel);
	}

	public BranchMasterDaoInterface getBranchMasterDaoInterface() {
		return branchMasterDaoInterface;
	}

	public void setBranchMasterDaoInterface(BranchMasterDaoInterface branchMasterDaoInterface) {
		this.branchMasterDaoInterface = branchMasterDaoInterface;
	}

	@Transactional
	@Override
	public List<BranchMasterModel> GetBranchList() {
		// TODO Auto-generated method stub
		return branchMasterDaoInterface.getBranchList();
	}

	@Transactional
	@Override
	public HashMap<String, String> setBranch() {
		// TODO Auto-generated method stub
		return branchMasterDaoInterface.GetBranch();
	}

	@Transactional
	@Override
	public void UpdateBranch(int branchID, String branchName) {
		// TODO Auto-generated method stub
		branchMasterDaoInterface.UpdateBranch(branchID,branchName);
	}

	@Transactional
	@Override
	public void DeleteBranch(int branchID) {
		// TODO Auto-generated method stub
		branchMasterDaoInterface.DeleteBranch(branchID);
	}

	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return branchMasterDaoInterface.CheckAdmin(username);
	}

}
