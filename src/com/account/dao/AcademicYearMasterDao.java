package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.AcademicYearMasterDaoInterface;
import com.account.model.acadamicYearModel;

@Repository
public class AcademicYearMasterDao implements AcademicYearMasterDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveYear(acadamicYearModel acadamicYearModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(acadamicYearModel);
	}

	@Override
	public List<String> GetYearList() {
		// TODO Auto-generated method stub
		
		List<String> YearList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId, a.acadamicYear, a.ActiveAcadamicYr FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		YearList=query.list();
		
		return YearList;
	}

	@Override
	public void UpdateYear(int yearId, String year) {
		// TODO Auto-generated method stub
		SQLQuery quer=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.acadamicYear='"+year+"' where a.acadamicYearId='"+yearId+"'");
		quer.executeUpdate();
	}

	@Override
	public void DeleteYear(int yearId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update acadamicyear a set a.astatus='Off' where a.acadamicYearId='"+yearId+"'");
		query.executeUpdate();
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
	public void setActiveYear(int yearID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On' ");
		int OLDYearID=0;
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
	public List<String> ActiveYearList() {
		// TODO Auto-generated method stub
		List<String> YearList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId,a.acadamicyear,a.ActiveAcadamicYr FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		YearList=query.list();
		return YearList;
	}
	
	
}
