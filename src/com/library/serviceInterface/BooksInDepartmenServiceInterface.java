package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface BooksInDepartmenServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> departmentList();

	List getListOfBooksInDepartment(String department);

}
