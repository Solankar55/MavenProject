package com.HOD.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.HOD.model.AssignClassInchargeModel;

public interface ClassInChargeDaoInterface {

	HashMap<String, String> GetYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranchList(int id);

	List<String> getStandardList(int branchid);

	HashMap<Integer, String> getTeachingStaff();

	List<String> getDataList(int yearID, int streamID, int branchID, int standardID);

	void saveAssignValue(AssignClassInchargeModel assignClassInchargeModel);

	List<String> getAssignInchargeList();

	String deleteClassInChrage(String elementid);

	void setClassInchargeDisAssignClass(int yearID, int streamID, int branchID, int standardID, int teacherID);

	void updateClassInChargeAssignValue(int yearID, int streamID, int branchID, int standardID, int teacherID);

}
