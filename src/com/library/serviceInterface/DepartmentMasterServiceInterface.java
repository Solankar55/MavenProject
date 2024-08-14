package com.library.serviceInterface;

import java.util.List;

import com.admin.model.AdminRegistrationModel;
import com.library.model.Department;

public interface DepartmentMasterServiceInterface {

	List<AdminRegistrationModel> checkAdmin(String username);

	List<Department> getListOfDepartment();

	void saveDepartment(Department department);

	void updateDepartmentData(int id, String department);

	void deleteDepartmentData(int id);

}
