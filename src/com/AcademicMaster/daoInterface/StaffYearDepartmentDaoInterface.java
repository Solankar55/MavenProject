package com.AcademicMaster.daoInterface;

import java.util.List;

import com.AcademicMaster.model.StaffMeetingNoticeModel;
import com.AcademicMaster.model.StaffMeetingNoticeStaffEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeModel;
import com.HOD.model.StaffRegistrationModel;

public interface StaffYearDepartmentDaoInterface {

	List<String> getStaffListUsingStaffType(String staffType);

	void saveStaffMeetingNoticeModel(StaffMeetingNoticeModel staffMeetingNoticeModel);

	int getMaxStaffMeetingNoticeID();

	void saveStaffMeetingNoticeEnteryModel(StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel);

	void saveStaffProgramNoticeModel(StaffProgramNoticeModel staffProgramNoticeModel);

	int getMaxStaffProgramNoticeModelID();

	void saveStaffProgramNoticeEnteryModel(StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel);

	List<StaffRegistrationModel> getStaffContactN(int staffID);

}
