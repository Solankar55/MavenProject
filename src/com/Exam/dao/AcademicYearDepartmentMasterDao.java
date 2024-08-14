package com.Exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Exam.daoInterface.AcademicYearDepartmentMasterDaoInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;

@Repository
public class AcademicYearDepartmentMasterDao implements AcademicYearDepartmentMasterDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetAcademicYearList() {
		// TODO Auto-generated method stub
		List<String> YearList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId, a.acadamicYear, a.ActiveAcadamicYr FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		YearList=query.list();
		
		return YearList;
	}

	@Override
	public void SaveYear(acadamicYearModel acadamicYearModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(acadamicYearModel);
	}

	@Override
	public HashMap<String, String> GetAcademicYearListKeyValue() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfYearList= new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId, a.acadamicYear FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		System.out.println("acadamicYear"+list);

		for(HashMap map :list){

			mapOfYearList.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfYearList;
	}

	@Override
	public List<String> ActiveYearList() {
		// TODO Auto-generated method stub
		List<String> YearList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId,a.acadamicyear,a.ActiveAcadamicYr FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		YearList=query.list();
		return YearList;
	}

	@Override
	public void setActiveYear(int yearID) {
		// TODO Auto-generated method stub
		int OLDYearID=0;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId FROM acadamicyear a where a.ActiveAcadamicYr='Active' ");
		try
		{
			
			OLDYearID=(int) query.list().get(0);
			SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.ActiveAcadamicYr='Inactive' where a.acadamicYearId='"+OLDYearID+"'");
			query2.executeUpdate();
			
			SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.ActiveAcadamicYr='Active' where a.acadamicYearId='"+yearID+"'");
			query3.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
			SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.ActiveAcadamicYr='Active' where a.acadamicYearId='"+yearID+"'");
			query3.executeUpdate();
		}
		
	}

	@Override
	public void UpadteYear(int yearId, String year) {
		// TODO Auto-generated method stub
		SQLQuery quer=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.acadamicYear='"+year+"' where a.acadamicYearId='"+yearId+"'");
		quer.executeUpdate();
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> staffList;
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		staffList=query.list();
		
		return staffList;
	}

	@Override
	public void deleteYear(int yearId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.astatus='Off' where a.acadamicYearId='"+yearId+"'");
		query.executeUpdate();
	}
	
}
