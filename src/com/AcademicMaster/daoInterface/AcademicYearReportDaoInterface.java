package com.AcademicMaster.daoInterface;

import java.util.List;

public interface AcademicYearReportDaoInterface {

	List<String> getStudentNoticeList();

	List<String> getAttendenceNoticeList();

	List<String> getStaffNoticeList();

	List<String> getStaffProgramNoticeList();

	List<String> getParentNoticeList();

}
