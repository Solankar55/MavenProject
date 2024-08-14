package com.HOD.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.AssignDepartmentmodel;

public interface AssignDepartmentDaoInterface {

	HashMap<Integer, String> getTeachingStaff();

	void saveAssignDepartment(AssignDepartmentmodel assignDepartmentmodel);

	List<String> getAssignDepartmentList();

	List<String> getDepartmentList(String departmentName, int staffID);

	void removeDepartmentAuthority(int staffID, String departmentName);

	List<String> getDepartmentList1(String departmentName);

	void updateAssignDepartment(String departmentName, int staffID);

}
