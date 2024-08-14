package com.library.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.BookInDepartment;

public interface AddBookInDepDaoInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> departmentList();

	List<BookInDepartment> getBookInDeptList();

	int getAccId(String accerId);

	void saveBookInDepartment(BookInDepartment bookInDepartment);

	int getDeptId(String department);

	int getAccIdUpdate(String accerId);

	void updateDepartmentData1(BookInDepartment bookInDepartment);

	void deleteBookFromDepartment(int bookInDepId, String bookName, String departmentName);

}
