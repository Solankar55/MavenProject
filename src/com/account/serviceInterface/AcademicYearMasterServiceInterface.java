package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.acadamicYearModel;

public interface AcademicYearMasterServiceInterface {

	void SaveYear(acadamicYearModel acadamicYearModel);

	List<String> GetAcademicYearList();

	void UpadteYear(int yearId, String year);

	void DeleteYear(int yearId);

	HashMap<String, String> GetAcademicYearListKeyValue();

	void setActiveYear(int yearID);

	List<String> ActiveYearList();

}
