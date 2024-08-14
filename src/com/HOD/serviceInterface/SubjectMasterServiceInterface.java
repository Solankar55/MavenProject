package com.HOD.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.admin.model.AdminRegistrationModel;

public interface SubjectMasterServiceInterface {

	void saveSubject(HODSubjectMasterModel hodSubjectMasterModel);

	List<String> getSubjectList();

	HashMap<String, String> GetYearList();

	HashMap<Integer, String> getTeachingStaff();

	HashMap<Integer, String> SubjectList();

	HashMap<String, String> GetStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	void saveAssignValues(AssignSubjectTeacherModel assignSubjectTeacherModel);

	List<String> getDataList(int yearID, int streamID, int branchID, int teacherID, int standardID, int subjectID);

	List<String> getAssignSubjectTeacherList();

	List<String> getTeacherList(int yearId, int streamId, int branchid, int standardID);

	void setAssignSubjectToDisAssign(int yearID, int streamID, int branchID, int standardID, int teacherID,
			int subjectID);

	List<AdminRegistrationModel> CheckAdmin(String username);

	void updateSubjectAssignVlaue(int yearID, int streamID, int branchID, int standardID, int teacherID, int subjectID);


}
