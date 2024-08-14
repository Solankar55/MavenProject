package com.account.ServiceClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.StandardMasterDaoInterface;
import com.account.model.StandardMasterModel;
import com.account.serviceInterface.StandardMasterInterface;
@Service
public class StandardMasterServiceC implements StandardMasterInterface{

	@Autowired
	private StandardMasterDaoInterface standardMasterDaoInterface;

	public StandardMasterDaoInterface getStandardMasterDaoInterface() {
		return standardMasterDaoInterface;
	}

	public void setStandardMasterDaoInterface(StandardMasterDaoInterface standardMasterDaoInterface) {
		this.standardMasterDaoInterface = standardMasterDaoInterface;
	}

	@Transactional
	@Override
	public void AddStandard(StandardMasterModel standardMasterModel) {
		// TODO Auto-generated method stub
		standardMasterDaoInterface.SaveStandard(standardMasterModel);
	}

	@Transactional
	@Override
	public List<StandardMasterModel> GetStandardList() {
		// TODO Auto-generated method stub
		return standardMasterDaoInterface.GetListOfStandard();
	}

	@Transactional
	@Override
	public void UpdateStandard(int stndardID, String standard) {
		// TODO Auto-generated method stub
		standardMasterDaoInterface.UpdateStandard(stndardID,standard);
	}

	@Transactional
	@Override
	public void DeleteStandard(int stndardID) {
		// TODO Auto-generated method stub
		standardMasterDaoInterface.deleteStandard(stndardID);
	}
}
