package com.admin.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class RegisterUserDaoC implements RegisterUserDaoI {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void RegisterUser(AdminRegistrationModel adminRegistrationModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(adminRegistrationModel);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List GetAdminList(String uN, String pS) {
		// TODO Auto-generated method stub
		
		List AdminList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from adminregistration where Username='"+uN+"' and Password='"+pS+"' ");
	//	query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AdminList=query.list();
		return AdminList;
	}

	@Override
	public List<StudentRegistrationModel> getEmailDetails(String sendTo) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> StudDetailsOfEmails=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentName,s.StudentEmail,s.StudentUserName,s.StudentPassword FROM studentregistration s where s.StudentEmail='"+sendTo+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		StudDetailsOfEmails=query.list();
		return StudDetailsOfEmails;
	}
}
