package com.HOD.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HOD.daoInterface.ClassInChargeDaoInterface;
import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.serviceInterface.ClassInChargeServiceInterface;

@Service
public class ClassInChargeServiceClass implements ClassInChargeServiceInterface{

	@Autowired
	private ClassInChargeDaoInterface classInChargeDaoInterface;

	public ClassInChargeDaoInterface getClassInChargeDaoInterface() {
		return classInChargeDaoInterface;
	}

	public void setClassInChargeDaoInterface(ClassInChargeDaoInterface classInChargeDaoInterface) {
		this.classInChargeDaoInterface = classInChargeDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.GetYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getBranchList(id);
	}

	@Transactional
	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public HashMap<Integer, String> getTeachingStaff() {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getTeachingStaff();
	}

	@Transactional
	@Override
	public List<String> getDataList(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getDataList(yearID,streamID,branchID,standardID);
	}

	@Transactional
	@Override
	public void saveAssignValues(AssignClassInchargeModel assignClassInchargeModel) {
		// TODO Auto-generated method stub
		classInChargeDaoInterface.saveAssignValue(assignClassInchargeModel);
	}

	@Transactional
	@Override
	public List<String> getAssignInchargeList() {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.getAssignInchargeList();
	}

	@Transactional
	@Override
	public String deleteClassInChrage(String elementid) {
		// TODO Auto-generated method stub
		return classInChargeDaoInterface.deleteClassInChrage(elementid);
	}

	@Transactional
	@Override
	public void setClassInchargeDisAssignClass(int yearID, int streamID, int branchID, int standardID, int teacherID) {
		// TODO Auto-generated method stub
		classInChargeDaoInterface.setClassInchargeDisAssignClass( yearID,  streamID, branchID,  standardID,  teacherID);
	}

	@Transactional
	@Override
	public void updateClassInChargeAssignValue(int yearID, int streamID, int branchID, int standardID, int teacherID) {
		// TODO Auto-generated method stub
		classInChargeDaoInterface.updateClassInChargeAssignValue( yearID,  streamID,  branchID,  standardID,  teacherID);
	}

}
