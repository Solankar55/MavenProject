package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

import org.hibernate.SQLQuery;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class RegisterStudentDaoC implements RegisterStudentDaoI {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void RegisterStudent(StudentRegistrationModel studentRegistrationModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentRegistrationModel);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetStudentList(String uN, String pS) {
		// TODO Auto-generated method stub
		List<String> GetListOfStudent = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("select * from studentregistration where StudentUserName='" + uN
						+ "' and StudentPassword='" + pS + "'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetListOfStudent = query.list();
		return GetListOfStudent;
	}

	@Override
	public List<StudentRegistrationModel> getStudDetailsForEdit(String username) {
		// TODO Auto-generated method stub

		List<StudentRegistrationModel> GetDetails = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery(" select * from studentregistration where StudentUserName='" + username + "' ");
		// query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetDetails = query.list();
		return GetDetails;
	}

	@Override                                              
	public List<String> getStudInfo(String username) {
		// TODO Auto-generated method stub
		List<String> GetStudInfo = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("select * from studentregistration where StudentUserName='" + username + "' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStudInfo = query.list();
		return GetStudInfo;
	}

	@Override
	public List<String> getStudUserDetails(String studEmail,String studContact) {
		// TODO Auto-generated method stub
		List<String> StudList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT * FROM studentregistration s where s.StudentEmail='" + studEmail + "' and s.StudentContactNumber='"+studContact+"' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudList = query.list();
		return StudList;
	}

	@Override
	public List<String> getUserNameList(String userNameValue,String studEmail,String studContact) {
		// TODO Auto-generated method stub
		List<String> StudUserNameList = new ArrayList<>();
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		List<String> list3=new ArrayList<>();
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId FROM adminregistration a where a.Username='"+userNameValue+"'");
		list1=query.list();
		StudUserNameList.addAll(list1);
		
		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId FROM staffregistration s where s.UserName='"+userNameValue+"'");
		list2=query2.list();
		StudUserNameList.addAll(list2);
		
		SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StudentRegistrationId FROM studentregistration s where s.StudentUserName='"+userNameValue+"'");
		list3=query3.list();
		StudUserNameList.addAll(list3);
		
		return StudUserNameList;
	}

	@Override
	public List<String> getStudentDetailsInfo(String studentName, String studentContact, String studentEmail) {
		// TODO Auto-generated method stub
		List<String> StudInfoList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.studentFirstName,s.studentMiddleName,s.studentLastName,s.studentGender,s.studentEmail,s.studentContactNumber,s.studentDateOfBirth,s.studentPermanenetAddress FROM studentadmission s where s.studentContactNumber='"
						+ studentContact + "' and s.studentFirstName='" + studentName + "' and s.studentEmail='"
						+ studentEmail + "' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudInfoList = query.list();
		return StudInfoList;
	}

	@Override
	public List<StudentRegistrationModel> checkStudent(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> CheckStudList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery(" select * from studentregistration where StudentUserName='" + username + "' ");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		CheckStudList = query.list();
		return CheckStudList;
	}

	@Override
	public List<StudentRegistrationModel> getStudDetails(String uN, String pS) {

		List<StudentRegistrationModel> StudList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select s.StudentContactNumber,s.StudentEmail,s.StudentName from studentregistration s where s.StudentPassword='"
						+ pS + "' and s.StudentUserName='" + uN + "'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));

		StudList = query.list();
		System.out.println(StudList);
		return StudList;
	}

	@Override
	public List<StudentAdmissionModel> getStudentStatus(String sName, String sMail, String sContact) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> StudList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.admissionRegId,s.status FROM studentadmission s where s.studentContactNumber='" + sContact
						+ "' and s.studentEmail='" + sMail + "' and s.studentFirstName='" + sName + "'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		StudList = query.list();

		return StudList;
	}

	@Override
	public List<StudentRegistrationModel> getStudDetailsHome(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> StudList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"select s.StudentContactNumber,s.StudentEmail,s.StudentName from studentregistration s where s.StudentUserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));

		StudList = query.list();
		System.out.println(StudList);
		return StudList;
	}

}
