package com.staff.serviceInterface;

import java.util.List;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;

public interface ReportStaffServiceInterface {

	List<HODSubjectMasterModel> GetSubjectList(int staffID);

	List<String> getStudentList(int subjectID);

	List<Object[]> getPresentStudentList(int subjectID);

	List<String> getStudentPresentList(Integer attendenceID, Integer yearID, Integer branchID, Integer standardID,
			Integer streamID);


}
