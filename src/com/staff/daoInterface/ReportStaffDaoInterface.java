package com.staff.daoInterface;

import java.util.List;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;

public interface ReportStaffDaoInterface {

	List<HODSubjectMasterModel> GetSubjectList(int staffID);

	List<String> getStudentList(int subjectID);

	List<Object[]> getStudentD(int subjectID);

	List<String> getStudentPresentList(Integer attendenceID, Integer yearID, Integer branchID, Integer standardID,
			Integer streamID);

}
