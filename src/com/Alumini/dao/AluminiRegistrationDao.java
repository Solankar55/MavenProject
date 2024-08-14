package com.Alumini.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alumini.daoInterface.AluminiRegistrationDaoInterface;
import com.Alumini.model.RegisterAluminiDetailsModel;
import com.HOD.model.StaffRegistrationModel;
@Repository
public class AluminiRegistrationDao implements AluminiRegistrationDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEnteredDetails(RegisterAluminiDetailsModel registerAluminiDetailsModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(registerAluminiDetailsModel);
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> staffInfo;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"	+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		staffInfo=query.list();
		
		return staffInfo;
		
	}
	
	
}
