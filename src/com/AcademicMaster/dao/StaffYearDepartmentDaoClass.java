package com.AcademicMaster.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AcademicMaster.daoInterface.StaffYearDepartmentDaoInterface;
import com.AcademicMaster.model.StaffMeetingNoticeModel;
import com.AcademicMaster.model.StaffMeetingNoticeStaffEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeModel;
import com.HOD.model.StaffRegistrationModel;

@Repository
public class StaffYearDepartmentDaoClass implements StaffYearDepartmentDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStaffListUsingStaffType(String staffType) {
		// TODO Auto-generated method stub
		List<String> GetStaffList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId, s.MobileNumber, s.Password, s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType, s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.StaffType='"+staffType+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		GetStaffList=query.list();
		
		return GetStaffList;
	}

	@Override
	public void saveStaffMeetingNoticeModel(StaffMeetingNoticeModel staffMeetingNoticeModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(staffMeetingNoticeModel);
	}

	@Override
	public int getMaxStaffMeetingNoticeID() {
		// TODO Auto-generated method stub
		List maxIDs;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.StaffMeetingNoticeID) as StaffMeetingNoticeID FROM staffmeetingnotice s");
		
		maxIDs=query.list();
		int MAxID=0;
		if(maxIDs.get(0)==null)
		{
			return MAxID+1;
		}
		else
		{
			return MAxID=(int)maxIDs.get(0);
		}
		
	}

	@Override
	public void saveStaffMeetingNoticeEnteryModel(
			StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(staffMeetingNoticeStaffEnteryModel);
	}

	@Override
	public void saveStaffProgramNoticeModel(StaffProgramNoticeModel staffProgramNoticeModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(staffProgramNoticeModel);
	}

	@Override
	public int getMaxStaffProgramNoticeModelID() {
		// TODO Auto-generated method stub
		List maxIDs;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.StaffProgramNoticeID) as StaffProgramNoticeID FROM staffprogramnotice s");
		
		maxIDs=query.list();
		int MAxID=0;
		if(maxIDs.get(0)==null)
		{
			return MAxID+1;
		}
		else
		{
			return MAxID=(int)maxIDs.get(0);
		}
	}

	@Override
	public void saveStaffProgramNoticeEnteryModel(StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(staffProgramNoticeEnteryModel);
	}

	@Override
	public List<StaffRegistrationModel> getStaffContactN(int staffID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.MobileNumber FROM staffregistration s where s.staffRegistrationId='"+staffID+"'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		List<StaffRegistrationModel> ListStaff;
		ListStaff=query.list();
		
		return ListStaff;
	}
	
	
}
