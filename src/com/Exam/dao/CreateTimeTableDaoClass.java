package com.Exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Exam.daoInterface.CreateTimeTableDaoInterface;
import com.Exam.model.CreateTimeTableModel;
import com.HOD.model.StaffRegistrationModel;

@Repository
public class CreateTimeTableDaoClass implements CreateTimeTableDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveTimeTable(CreateTimeTableModel createTimeTableModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(createTimeTableModel);
	}

	@Override
	public List<String> getTimeTableList() {
		// TODO Auto-generated method stub
		List<String> getTimeTableList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT c.TimeTbaleID, c.EventName, c.FromDate, c.TODate, c.TimeTableDate FROM createtimetable c");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getTimeTableList=query.list();
		
		return getTimeTableList;

	}

	@Override
	public List<StaffRegistrationModel> getStaffInfo(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel > staffList;
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"	+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		staffList=query.list();
		
		return staffList;
	}
	
	
}
