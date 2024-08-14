package com.HOD.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.daoInterface.StaffInformationEditDaoInterface;
import com.admin.model.AdminRegistrationModel;

@Repository
public class StaffInformationEditDaoClass implements StaffInformationEditDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStaffInfo() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.staffRegistrationId, a.MobileNumber, a.Password, a.Qalification, a.SatffDepartment, a.StaffAddress, a.StaffEmail,a.StaffName, a.StaffRegDate,a.StaffType, a.UserName, a.YearOfExperience, a.barcode FROM staffregistration a where  a.staffstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> staffList;
		staffList=query.list();
		
		return staffList;
		
	}

	@Override
	public void updateStaffInfo(int staffId, String staffName, String staffMb, String staffEmail, String staffQ,
			String staffD, String staffT, String barcode, String staffAdd, String staffExp) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update staffregistration a set a.MobileNumber='"+staffMb+"',a.Qalification='"+staffQ+"', a.SatffDepartment='"+staffD+"', a.StaffAddress='"+staffAdd+"',a.StaffEmail='"+staffEmail+"',a.StaffName='"+staffName+"',a.StaffType='"+staffT+"',a.YearOfExperience='"+staffExp+"', a.barcode='"+barcode+"' where a.staffRegistrationId='"+staffId+"'");
		query.executeUpdate();
	}

	@Override
	public void deleteStaffInfo(int staffId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update staffregistration s set s.staffstatus='Off' where s.staffRegistrationId='"+staffId+"'");
		query.executeUpdate();
	}

	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		List<AdminRegistrationModel> adminList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId,a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type,a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));
		
		adminList=query.list();
		
		return adminList;
	}
	
	
}
