package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.DivisionMasterModel;

public interface DivisionMasterDaoInterface {

	HashMap<String, String> getStudStdList();

	void SaveDivision(DivisionMasterModel divisionMasterModel);

	List<DivisionMasterModel> GetListOfDivision();

	void UpdateDivision(int divId, String division);

	void deleteDivision(int divId);

}
