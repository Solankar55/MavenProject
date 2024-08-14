package com.NSS.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.NSS.model.RegisterNssStudentModel;

public interface RegisterStudentDaoInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> SetStream();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	void saveNSSUser(RegisterNssStudentModel registerNssStudentModel);

}
