package com.Exam.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;

public interface AcademicYearDepartmentMasterserviceInterface {

	List<String> GetAcademicYearList();

	void SaveYear(acadamicYearModel acadamicYearModel);

	HashMap<String, String> GetAcademicYearListKeyValue();

	List<String> ActiveYearList();

	void setActiveYear(int yearID);

	void UpadteYear(int yearId, String year);

	List<StaffRegistrationModel> getStaffList(String username);

	void DeleteYear(int yearId);

}
