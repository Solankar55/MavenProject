package com.AcademicMaster.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentAttendanceNoticeStudentEnteryModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

public interface StudentControllerYearDepartmentDaoInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	HashMap<String, String> getYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchid);

	List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID);

	void saveStudentNoticeModel(StudentNoticeModel studentNoticeModel);

	int getMaxNoticeID();

	void saveStudentNoticeStudentEntryModel(StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel);

	void saveStudentAttendanceNoticeModel(StudentAttendanceNoticeModel studentAttendanceNoticeModel);

	int getStudentAttendanceNoticeMaxID();

	void saveStudentAttendenceNoticeEnteryModel(
			StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel);

	List<StudentAdmissionModel> getStudentContactN(int studID);

}
