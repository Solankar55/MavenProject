package com.Exam.serviceInterface;

import java.util.List;

import com.Exam.model.CreateTimeTableModel;
import com.HOD.model.StaffRegistrationModel;

public interface CreateTimeTableServiceInterface {

	void SaveTimeTable(CreateTimeTableModel createTimeTableModel);

	List<String> getTimeTableList();

	List<StaffRegistrationModel> getStaffList(String username);

}
