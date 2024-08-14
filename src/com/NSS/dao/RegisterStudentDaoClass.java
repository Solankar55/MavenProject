package com.NSS.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NSS.daoInterface.RegisterStudentDaoInterface;
import com.NSS.model.RegisterNssStudentModel;

@Repository
public class RegisterStudentDaoClass implements RegisterStudentDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM collegemgmtsystem.acadamicyear a ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<String, String> SetStream() {
		// TODO Auto-generated method stub
		List<HashMap> streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT streamId,streamName from streammaster");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		streamlist=query.list();
		System.out.println("listOfmasterLedger"+streamlist);

		for(HashMap map :streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * from branchmaster where streamId='"+id+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		System.out.println("listOfBranch"+BranchList);
		return BranchList;
	}

	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		List<String> GetStandard=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from standardmaster where branchId='"+branchid+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStandard=query.list();
		return GetStandard;
	}

	@Override
	public void saveNSSUser(RegisterNssStudentModel registerNssStudentModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(registerNssStudentModel);
	}
	
	
}
