package com.staff.daoInterface;

import java.util.List;

import com.HOD.model.HODSubjectMasterModel;

public interface AssignmentManagementDaoInterface {

	List<String> getGivenAssignMentList(String subjectName);

	List<String> getRemoveAssignmentList(String subjectName);

	String deleteAssignment(int assid);

	List<HODSubjectMasterModel> GetSubjectList(int staffID);

	List<String> getGivenAssignMentListToRemove(String subjectName);

}
