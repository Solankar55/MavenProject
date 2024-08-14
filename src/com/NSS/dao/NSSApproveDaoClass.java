package com.NSS.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.StaffRegistrationModel;
import com.NSS.daoInterface.NSSApproveDaoInterface;

@Repository
public class NSSApproveDaoClass implements NSSApproveDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> GetNSSStudentList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.NSSRegisterID,r.MobileNumber,r.StudAddress,r.StudCategory,r.StudMail,r.StudName FROM registernssuser r where r.status='DisApproved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList=new ArrayList<>();
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public void updateStudentStatus(String boxValue,String currentDate) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update registernssuser r set  r.status='Approved',r.ApproveDate='"+currentDate+"' where r.NSSRegisterID='"+boxValue+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> GetNSSStudentListDisApproved() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.NSSRegisterID,r.MobileNumber,r.StudAddress,r.StudCategory,r.StudMail,r.StudName FROM registernssuser r where r.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList=new ArrayList<>();
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public void updateStudentStatusDisApproved(String boxValue,String currentDate) {
		// TODO Auto-generated method stub
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("update registernssuser r set  r.status='DisApproved',r.DisApproveDate='"+currentDate+"' where r.NSSRegisterID='"+boxValue+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> GetNSSStudentListApproved() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.NSSRegisterID,r.MobileNumber,r.StudAddress,r.StudCategory,r.StudMail,r.StudName FROM registernssuser r where r.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList=new ArrayList<>();
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public List<String> GetNSSStudentDisApprovedList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.NSSRegisterID,r.MobileNumber,r.StudAddress,r.StudCategory,r.StudMail,r.StudName FROM registernssuser r where r.status='DisApproved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> StudentList=new ArrayList<>();
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public List<StaffRegistrationModel> getStaffInfo(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> staffInfo;
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"	+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		staffInfo=query.list();
		
		return staffInfo;
		
	}
	
	
}
