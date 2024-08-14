package com.Exam.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;

public interface AcademicYearDepartmentMasterDaoInterface {

	List<String> GetAcademicYearList();

	void SaveYear(acadamicYearModel acadamicYearModel);

	HashMap<String, String> GetAcademicYearListKeyValue();

	List<String> ActiveYearList();

	void setActiveYear(int yearID);

	void UpadteYear(int yearId, String year);

	List<StaffRegistrationModel> getStaffList(String username);

	void deleteYear(int yearId);

}
