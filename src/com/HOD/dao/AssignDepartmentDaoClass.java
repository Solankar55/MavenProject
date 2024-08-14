package com.HOD.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.AssignDepartmentDaoInterface;
import com.HOD.model.AssignDepartmentmodel;
import com.HOD.model.StaffRegistrationModel;

@Repository
public class AssignDepartmentDaoClass implements AssignDepartmentDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<Integer, String> getTeachingStaff() {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> teachingStaff = new ArrayList<>();
		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery("SELECT s.StaffName,s.staffRegistrationId,s.StaffType FROM staffregistration s where s.StaffType='Non Teaching' and  s.staffstatus='On'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		teachingStaff=query.list();

		HashMap<Integer, String> ListOfStaff = new HashMap<>();
		for(int i=0;i<teachingStaff.size();i++){

			int StaffId=teachingStaff.get(i).getStaffRegistrationId();

			String StaffName=teachingStaff.get(i).getStaffName();


			ListOfStaff.put(StaffId,StaffName);

		}

		return ListOfStaff;
	}

	@Override
	public void saveAssignDepartment(AssignDepartmentmodel assignDepartmentmodel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(assignDepartmentmodel);
	}

	@Override
	public List<String> getAssignDepartmentList() {
		// TODO Auto-generated method stub

		List<String> getList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignDepartmentID,a.Department,s.StaffName FROM assigndepartment a left join staffregistration s on s.staffRegistrationId=a.staffRegistrationId where a.DepartmentStatus='Assigned'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getList=query.list();

		return getList;

	}

	@Override
	public List<String> getDepartmentList(String departmentName,int staffID) {
		// TODO Auto-generated method stub
		List<String> getList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignDepartmentID,a.Department FROM assigndepartment a where a.Department='"+departmentName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getList=query.list();

		return getList;
	}

	@Override
	public void removeDepartmentAuthority(int staffID, String departmentName) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update assigndepartment a set a.DepartmentStatus='DisAssigned' where a.staffRegistrationId='"+staffID+"' and a.Department='"+departmentName+"' ");
		query.executeUpdate();
	}

	@Override
	public List<String> getDepartmentList1(String departmentName) {
		List<String> getList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AssignDepartmentID,a.Department FROM assigndepartment a where a.Department='"+departmentName+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getList=query.list();

		return getList;
	}

	@Override
	public void updateAssignDepartment(String departmentName, int staffID) {
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update  assigndepartment a set a.staffRegistrationId='"+staffID+"', a.DepartmentStatus='Assigned'  where a.Department='"+departmentName+"'");
		query.executeUpdate();
	}


}
