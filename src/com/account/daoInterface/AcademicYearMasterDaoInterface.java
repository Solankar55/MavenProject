package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.acadamicYearModel;

public interface AcademicYearMasterDaoInterface {

	void saveYear(acadamicYearModel acadamicYearModel);

	List<String> GetYearList();

	void UpdateYear(int yearId, String year);

	void DeleteYear(int yearId);

	HashMap<String, String> GetAcademicYearListKeyValue();

	void setActiveYear(int yearID);

	List<String> ActiveYearList();

}
