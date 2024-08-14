package com.admin.service;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

public interface RegisterUserI {

	void RegUser(AdminRegistrationModel adminRegistrationModel);

	List<Object[]> GetAdminList(String uN, String pS);

	List<StudentRegistrationModel> getEmailRelatedDetails(String sendTo);

}
