package com.student.daoInteerface;

import java.util.HashMap;
import java.util.List;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentProfilePicModel;

public interface StudentAdmisssionDaoInterface {

	void saveAdmission(StudentAdmissionModel studentAdmissionModel);

	HashMap<String, String> GetStreamList();

	List<String> getBranchList(int id);

	List<String> GetStandardList(int id);

	HashMap<String, String> GetYearList();

	int getStudentID();

	List<StudentAdmissionModel> getStudDetailsToCheckPresentOrNot(String studName, String studContact, String studEmail);

	List<acadamicYearModel> getStudentAcademicYearID(int yearID);

	List<StandardMasterModel> getStudentStandard(int standardId);

	void imageUpload(StudentProfilePicModel studentProfilePicModel);

	void saveStudentBarcodeMaster(StudentBarcodeMaster studentBarcodeMaster);

	
	

	
	

}
