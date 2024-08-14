package com.account.serviceInterface;

import java.util.List;

import com.account.model.StandardMasterModel;

public interface StandardMasterInterface {

	void AddStandard(StandardMasterModel standardMasterModel);

	List<StandardMasterModel> GetStandardList();

	void UpdateStandard(int stndardID, String standard);

	void DeleteStandard(int stndardID);

}
