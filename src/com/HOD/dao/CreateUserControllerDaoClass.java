package com.HOD.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.CreateUserControllerDaoInterface;
import com.HOD.model.StaffRegistrationModel;
import com.admin.model.AdminRegistrationModel;

@Repository
public class CreateUserControllerDaoClass implements CreateUserControllerDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveStaff(StaffRegistrationModel staffRegistrationModel) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().save(staffRegistrationModel);
	}

	@Override
	public int getStaffID() {
		// TODO Auto-generated method stub
		List StaffIDList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.staffRegistrationId) FROM staffregistration s");
		StaffIDList=query.list();
		
		int staffId=0;
		if(StaffIDList.get(0)==null)
		{
			return staffId+1;
		}
		else
		{
			staffId=(int)StaffIDList.get(0)+1;
			return staffId;
		}
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId,a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type,a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminList=query.list();
		
		return adminList;
	}
	
	
}
