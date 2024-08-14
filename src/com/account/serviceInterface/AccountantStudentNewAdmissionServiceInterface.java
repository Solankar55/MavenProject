package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.StandardMasterModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentRegistrationModel;

public interface AccountantStudentNewAdmissionServiceInterface {

	int getStudentID();

	HashMap<String, String> GetYearList();

	HashMap<String, String> SetStream();

	List<String> getBranchList(int id);

	List<String> getStandardList(int id);

	void saveAdmission(StudentAdmissionModel studentAdmissionModel);

	List<com.account.model.acadamicYearModel> getStudentACYear(int yearID);

	List<StandardMasterModel> getStudentStandard(int standardId);

	void saveRegisterDetails(StudentRegistrationModel studentRegistrationModel);

	void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	List<String> getStudentCheckId(int studentId);

}
