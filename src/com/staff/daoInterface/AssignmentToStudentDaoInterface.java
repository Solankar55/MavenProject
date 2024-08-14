package com.staff.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.StaffRegistrationModel;
import com.staff.model.StudentAssignmentEnteryReportModel;
import com.staff.model.StudentAssignmentModel;

public interface AssignmentToStudentDaoInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	List<String> GetCheckAvability(int staffID);

	HashMap<String, String> GetYearList(int staffID);

	HashMap<String, String> GetBranchlist(int staffID);

	HashMap<String, String> GetStreamList(int staffID);

	HashMap<String, String> GetStandardList(int staffID);

	HashMap<String, String> GetSubjectList(int staffID);

	List<String> GetStudentList(int yearID, int streamID, int branchID, int standardID, int subjectID);

	void saveStudentAssignment(StudentAssignmentModel studentAssignmentModel);

	int getMaxAssignmentID();

	void saveStudentRecordWithAssignment(StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel);

}
