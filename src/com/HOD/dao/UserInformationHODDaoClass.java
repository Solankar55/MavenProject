package com.HOD.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.UserInformationHODDaoInterface;

@Repository
public class UserInformationHODDaoClass implements UserInformationHODDaoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getTeachingStaffRegistrationInfo() {
		// TODO Auto-generated method stub
		List<String> data=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StaffName,s.StaffType,s.MobileNumber,s.StaffEmail,s.barcode,s.UserName,s.Password FROM staffregistration s where s.StaffType='Teaching' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		data=query.list();
		System.out.println("data in dao Class : " +data);
		return data;
		
	}

	@Override
	public List<String> getNonTeachingStaffRegistrationInfo() {
		// TODO Auto-generated method stub
		List<String> data=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StaffName,s.StaffType,s.MobileNumber,s.StaffEmail,s.barcode,s.UserName,s.Password FROM staffregistration s where s.StaffType='Non Teaching' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		data=query.list();
		System.out.println("Non Teaching data in dao Class : " +data);
		return data;
	}
	
	

}
