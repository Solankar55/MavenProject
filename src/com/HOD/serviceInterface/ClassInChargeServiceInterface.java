package com.HOD.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.AssignSubjectTeacherModel;

public interface ClassInChargeServiceInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	HashMap<Integer, String> getTeachingStaff();

	List<String> getDataList(int yearID, int streamID, int branchID, int standardID);

	void saveAssignValues(AssignClassInchargeModel assignClassInchargeModel);

	List<String> getAssignInchargeList();

	String deleteClassInChrage(String elementid);

	void setClassInchargeDisAssignClass(int yearID, int streamID, int branchID, int standardID, int teacherID);

	void updateClassInChargeAssignValue(int yearID, int streamID, int branchID, int standardID, int teacherID);


}
