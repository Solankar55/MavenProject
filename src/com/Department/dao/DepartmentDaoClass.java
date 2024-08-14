package com.Department.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Department.daoInterface.DepartmentDaoInterface;
import com.HOD.model.StaffRegistrationModel;

@Repository
public class DepartmentDaoClass implements DepartmentDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> checkDepartmentLogin(String password, String username, String departmentName) {
		List<String> dataOfLogin = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select s.staffRegistrationId,s.Password,s.UserName,a.Department,a.DepartmentStatus FROM assigndepartment a left join staffregistration s on a.staffRegistrationId=s.staffRegistrationId where a.DepartmentStatus='Assigned' and a.Department='"
						+ departmentName + "' and s.Password='" + password + "' and s.UserName='" + username + "'");
		query.setResultTransformer(Transformers.TO_LIST);
		dataOfLogin = query.list();
		
		/*SQLQuery query1 = sessionFactory.getCurrentSession().createSQLQuery(
				"select s.staffRegistrationId ,s.Password FROM assigndepartment a left join staffregistration s on a.staffRegistrationId=s.staffRegistrationId where a.DepartmentStatus='Assigned' and a.Department='"
						+ departmentName + "' and s.Password='" + password + "' and s.UserName='" + username + "'");
		System.out.println("Object By Unick result:"+query1.uniqueResult().getClass());*/
		
		System.out.println("" + dataOfLogin);
		return dataOfLogin;

	}

	@Override
	public List<StaffRegistrationModel> getEmailDetails(String emailAddress) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> getDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.Password,s.UserName,s.MobileNumber,s.StaffEmail FROM staffregistration s where s.StaffEmail='"+emailAddress+"'");
		
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		getDetails=query.list();
		
		return getDetails;
	}

}
