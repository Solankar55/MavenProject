package com.Alumini.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alumini.daoInterface.StudentManagmentDaoInterface;

@Repository
public class StudentManagmentDaoClass implements StudentManagmentDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStudentList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.AluminiRegID,a.DateRegistration,a.MemberID,a.MobileNumber,a.RegisterUserName,a.UserEmail,a.YearOfPassing FROM aluminiregistratioruser a");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList;
		StudentList=query.list();
		
		return StudentList;
	}
	
}
