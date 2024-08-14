package com.AcademicMaster.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AcademicMaster.daoInterface.AcademicYearReportDaoInterface;

@Repository
public class AcademicYearReportDaoClass implements AcademicYearReportDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getStudentNoticeList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.NoticeID,s.admissionRegId,sa.studentFirstName,sa.studentLastName,sn.NoticeDate,sn.StudentNotice FROM studentnoticeentery s left join studentadmission sa on sa.admissionRegId=s.admissionRegId left join studentnotice sn on sn.NoticeID=s.NoticeID");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> NoticeList;
		NoticeList=query.list();
		return NoticeList;
	}

	@Override
	public List<String> getAttendenceNoticeList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,sa.studentFirstName,sa.studentLastName,san.NoticeDate,san.AttendanceNotice,san.StudentAttendenceNoticeID FROM studentattendencenoticeentery s left join studentadmission sa on sa.admissionRegId=s.admissionRegId left join studentattendancenotice san on san.StudentAttendenceNoticeID=s.StudentAttendenceNoticeID");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> NoticeList;
		NoticeList=query.list();
		return NoticeList;
	}

	@Override
	public List<String> getStaffNoticeList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StaffMeetingNoticeID,sr.SatffDepartment,sr.StaffName,smn.StaffNotice,smn.StaffNoticeDate,smn.StaffType FROM staffmeetingnoticeentery s left join staffregistration sr on sr.staffRegistrationId=s.staffRegistrationId left join staffmeetingnotice smn on smn.StaffMeetingNoticeID=s.StaffMeetingNoticeID");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> NoticeList;
		NoticeList=query.list();
		return NoticeList;
	}

	@Override
	public List<String> getStaffProgramNoticeList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT sr.SatffDepartment,sr.StaffName,spn.TeacherName,spn.staffProgramNotice,spn.staffProgramNoticeDate,spn.staffType, spn.StaffProgramNoticeID fROM staffprogramnoticeentery s left join staffregistration sr on sr.staffRegistrationId=s.staffRegistrationId left join staffprogramnotice spn on spn.StaffProgramNoticeID=s.StaffProgramNoticeID");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> NoticeList;
		NoticeList=query.list();
		return NoticeList;
	}

	@Override
	public List<String> getParentNoticeList() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT p.parentMessageID,pm.TeacherName,pm.parentMessage,pm.parentMessageDate,sa.studentFirstName,sa.studentLastName FROM parentmessageentrymodel p left join parentmessagemodel pm on pm.parentMessageID=p.parentMessageID left join studentadmission sa on sa.admissionRegId=p.admissionRegId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> NoticeList;
		NoticeList=query.list();
		return NoticeList;
	}
	
	
}
