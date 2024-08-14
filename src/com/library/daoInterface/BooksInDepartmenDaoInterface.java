package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;

public interface BooksInDepartmenDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> departmentList();

	List getListOfBooksInDepartment(String department);

}
