package com.admin.dao;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

public interface RegisterUserDaoI {

	void RegisterUser(AdminRegistrationModel adminRegistrationModel);

	List<String> GetAdminList(String uN, String pS);

	List<StudentRegistrationModel> getEmailDetails(String sendTo);

}
