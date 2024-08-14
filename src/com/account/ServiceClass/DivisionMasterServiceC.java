package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.DivisionMasterDaoInterface;
import com.account.model.DivisionMasterModel;
import com.account.serviceInterface.DivisionMasterInterface;
@Service
public class DivisionMasterServiceC implements DivisionMasterInterface {

	@Autowired
	private DivisionMasterDaoInterface divisionMasterDaoInterface;

	@Transactional
	@Override
	public HashMap<String, String> GetStdList() {
		// TODO Auto-generated method stub
		return divisionMasterDaoInterface.getStudStdList();
	}

	public DivisionMasterDaoInterface getDivisionMasterDaoInterface() {
		return divisionMasterDaoInterface;
	}

	public void setDivisionMasterDaoInterface(DivisionMasterDaoInterface divisionMasterDaoInterface) {
		this.divisionMasterDaoInterface = divisionMasterDaoInterface;
	}

	@Transactional
	@Override
	public void SaveDivision(DivisionMasterModel divisionMasterModel) {
		// TODO Auto-generated method stub
		divisionMasterDaoInterface.SaveDivision(divisionMasterModel);
	}

	@Transactional
	@Override
	public List<DivisionMasterModel> GetDivisionList() {
		// TODO Auto-generated method stub
		return divisionMasterDaoInterface.GetListOfDivision();
	}

	@Transactional
	@Override
	public void UpdateDivision(int divId, String division) {
		// TODO Auto-generated method stub
		divisionMasterDaoInterface.UpdateDivision(divId,division);
	}

	@Transactional
	@Override
	public void DeleteDivision(int divId) {
		// TODO Auto-generated method stub
		divisionMasterDaoInterface.deleteDivision(divId);
	}
	
}
