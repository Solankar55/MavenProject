package com.student.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentProfilePicModel;

public interface StudentAdmisssionInterface {

	void saveAdmission(StudentAdmissionModel studentAdmissionModel);

	HashMap<String, String> SetStream();

	List<String> getBranch(int id);

	List<String> GetStandardList(int id);

	HashMap<String, String> GetYearList();

	int getStudentID();

	List<StudentAdmissionModel> getStudDetailsToCheckPresentOrNot(String studName, String studContact, String studEmail);

	List<com.account.model.acadamicYearModel> getStudentACYear(int yearID);

	List<StandardMasterModel> getStudentStandard(int standardId);

	void imageUpload(StudentProfilePicModel studentProfilePicModel);

	void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	

	

	
	
}
