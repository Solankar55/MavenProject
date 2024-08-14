package com.AcademicMaster.serviceInterface;

import java.util.List;

public interface AcademicYearReportServiceInterface {

	List<String> getStudentNoticeList();

	List<String> getAttendenceNoticeList();

	List<String> getStaffNoticeList();

	List<String> getStaffProgramNoticeList();

	List<String> getParentNoticeList();

}
