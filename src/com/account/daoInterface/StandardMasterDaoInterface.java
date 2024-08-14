package com.account.daoInterface;

import java.util.List;

import com.account.model.StandardMasterModel;

public interface StandardMasterDaoInterface {

	void SaveStandard(StandardMasterModel standardMasterModel);

	List<StandardMasterModel> GetListOfStandard();

	void UpdateStandard(int stndardID, String standard);

	void deleteStandard(int stndardID);

}
