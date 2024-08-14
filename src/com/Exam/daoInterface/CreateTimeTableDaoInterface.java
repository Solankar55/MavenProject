package com.Exam.daoInterface;

import java.util.List;

import com.Exam.model.CreateTimeTableModel;
import com.HOD.model.StaffRegistrationModel;

public interface CreateTimeTableDaoInterface {

	void saveTimeTable(CreateTimeTableModel createTimeTableModel);

	List<String> getTimeTableList();

	List<StaffRegistrationModel> getStaffInfo(String username);

}
