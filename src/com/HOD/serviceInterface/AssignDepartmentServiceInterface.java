package com.HOD.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.AssignDepartmentmodel;

public interface AssignDepartmentServiceInterface {

	HashMap<Integer, String> getTeachingStaff();

	void saveAssignDepartment(AssignDepartmentmodel assignDepartmentmodel);

	List<String> getAssignList();

	List<String> getDepartmentList(String departmentName, int staffID);

	void removeDepartmentAuthority(int staffID, String departmentName);

	List<String> getDepartmentList1(String departmentName);

	void updateAssignDepartment(String departmentName, int staffID);

}
