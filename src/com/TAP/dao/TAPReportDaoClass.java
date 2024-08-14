package com.TAP.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.daoInterface.TAPReportDaoInterface;

@Repository
public class TAPReportDaoClass implements TAPReportDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStudentTapDetails() {
		// TODO Auto-generated method stub
		List<String> StudentList;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.TAPId,s.StudentAddress,s.StudentApplicationDate,s.StudentApplicationPlace,s.StudentAreaOfJob,s.StudentCast,s.StudentCategory,s.StudentContactNumber,s.StudentDOB, s.StudentEmail, s.StudentFullName, s.StudentGender, s.StudentQualification FROM studentregistrationtap s");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		StudentList = query.list();
		return StudentList;
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> staffInfo;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));

		staffInfo = query.list();

		return staffInfo;
	}

}
