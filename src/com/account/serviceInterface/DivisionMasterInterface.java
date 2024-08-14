package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.DivisionMasterModel;

public interface DivisionMasterInterface {

	HashMap<String, String> GetStdList();

	void SaveDivision(DivisionMasterModel divisionMasterModel);

	List<DivisionMasterModel> GetDivisionList();

	void UpdateDivision(int divId, String division);

	void DeleteDivision(int divId);

}
