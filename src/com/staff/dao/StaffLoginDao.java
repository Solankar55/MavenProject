package com.staff.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.StaffRegistrationModel;
import com.staff.daoInterface.StaffLoginDaoInterface;

@Repository
public class StaffLoginDao implements StaffLoginDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StaffRegistrationModel> GetStaffList(String userName, String passWord) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> getStaffList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.SatffDepartment,s.StaffAddress,s.StaffEmail,s.StaffName,s.UserName,s.Password  FROM staffregistration s where s.UserName='"+userName+"' and s.Password='"+passWord+"'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		
		getStaffList=query.list();
		
		return getStaffList;
	}

	@Override
	public List<StaffRegistrationModel> getEmailDetails(String userEmail) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> getDetails=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.Password,s.UserName,s.MobileNumber,s.StaffEmail FROM staffregistration s where s.StaffEmail='"+userEmail+"'");
		
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		getDetails=query.list();
		
		return getDetails;
	}
	
	
}
