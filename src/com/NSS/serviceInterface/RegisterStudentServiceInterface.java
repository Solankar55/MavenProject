package com.NSS.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.NSS.model.RegisterNssStudentModel;

public interface RegisterStudentServiceInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> SetStream();

	List<String> getBranchList(int id);

	List<String> getStandardList(int id);

	void saveNssUser(RegisterNssStudentModel registerNssStudentModel);

}
