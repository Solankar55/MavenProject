package com.library.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.BookInDepartment;

public interface AddBookInDepServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	HashMap<String, String> departmentList();

	List<BookInDepartment> getBookInDeptList();

	int getAccId(String accerId);

	void saveBookInDepartment(BookInDepartment bookInDepartment);

	int getDeptId(String department);

	int getAccIdUpdate(String accerId);

	void updateDepartmentData1(BookInDepartment bookInDepartment);

	void deleteBookFromDepartment(int bookInDepId, String bookname, String departmentName);

}
