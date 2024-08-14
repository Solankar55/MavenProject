package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.daoInteerface.StudentMessageDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;

@Repository
public class StudentMessageDaoClass implements StudentMessageDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Object[]> getStudDetailsToCheckPresentOrNot(String studName, String studContact,
			String studEmail) {
		// TODO Auto-generated method stub
		List<Object[]> StudentDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.status, s.acadamicYearId, s.branchId,s.standardId, s.streamId FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster st on st.standardId=s.standardId left join streammaster str on str.streamId=s.streamId where s.studentContactNumber='"+studContact+"' and s.studentEmail='"+studEmail+"' and s.studentFirstName='"+studName+"' and a.ActiveAcadamicYr='Active' and s.status='Approved'");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();
		return StudentDetails;
	}

	@Override
	public List<String> getNoticeDetails(int studID, String studStatus, int studYear, int studBranch, int studStandard,
			int studStream) {
		// TODO Auto-generated method stub
		
		List<String> NoticeDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT sn.NoticeID,sn.StudentNotice FROM studentnoticeentery s left join studentnotice sn on sn.NoticeID=s.NoticeID left join studentadmission sa on sa.admissionRegId=s.admissionRegId where sn.acadamicYearId='"+studYear+"' and sn.branchId='"+studBranch+"' and sn.standardId='"+studStandard+"' and sn.streamId='"+studStream+"' and sa.status='"+studStatus+"' and sn.NoticeStatus='Active' and s.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		NoticeDetails=query.list();
		
		return NoticeDetails;
	}

	@Override
	public List<StudentRegistrationModel> CheckStudent(String username) {
		// TODO Auto-generated method stub
		List<StudentRegistrationModel> CheckStudList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery(" select * from studentregistration where StudentUserName='" + username + "' ");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		CheckStudList = query.list();
		return CheckStudList;
	}

	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		List<String> GetStudInfo = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery("select * from studentregistration where StudentUserName='" + username + "' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStudInfo = query.list();
		return GetStudInfo;
	}

	@Override
	public List<StudentRegistrationModel> getStudInfo(String userName) {
		// TODO Auto-generated method stub
		
		List<StudentRegistrationModel> CheckStudList = new ArrayList<>();
		SQLQuery query = sessionFactory.getCurrentSession()
				.createSQLQuery(" select * from studentregistration where StudentUserName='" + userName + "' ");
		query.setResultTransformer(Transformers.aliasToBean(StudentRegistrationModel.class));
		CheckStudList = query.list();
		return CheckStudList;
	}
 
	@Override
	public List<Object[]> getStudDetailList(String sName, String sContact, String sEmail) {
		// TODO Auto-generated method stub
		List<Object[]> StudentDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.status, s.acadamicYearId, s.branchId,s.standardId, s.streamId FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster st on st.standardId=s.standardId left join streammaster str on str.streamId=s.streamId where s.studentContactNumber='"+sContact+"' and s.studentEmail='"+sEmail+"' and s.studentFirstName='"+sName+"' and a.ActiveAcadamicYr='Active' and s.status='Approved'");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();
		return StudentDetails;
	}

	@Override
	public List<String> getAttendenceNoticeDetail(Integer studID, Integer studYear, String studStatus,
			Integer studBranch, Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		
		List<String> attendenceMeesage;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AttnedenceNoticeEnteryID,st.AttendanceNotice,s.StudentAttendenceNoticeID FROM studentattendencenoticeentery s left join studentattendancenotice st on st.StudentAttendenceNoticeID=s.StudentAttendenceNoticeID where st.acadamicYearId='"+studYear+"' and st.branchId='"+studBranch+"' and st.standardId='"+studStandard+"' and st.streamId='"+studStream+"' and st.AttendanceNoticeStatus='Active' and s.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		attendenceMeesage=query.list();
		
		return attendenceMeesage;
	}

	@Override
	public List<String> getAssignmentDetails(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		List<String> assignmentMessage;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.AssignmentMessage,s.AssignmentID,s.AssignmentDate,su.SubjectName FROM studentassignment s left join studentassignmententeryreport st on st.AssignmentID=s.AssignmentID left join subjectmasterhod su on su.SubjectID=s.SubjectID where s.acadamicYearId='"+studYear+"' and s.branchId='"+studBranch+"' and s.standardId='"+studStandard+"' and s.streamId='"+studStream+"' and st.admissionRegId='"+studID+"' and s.AssignmentStatus='Given'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		assignmentMessage=query.list();
		
		return assignmentMessage;
	}

	@Override
	public List<String> getExamNoticeList(Integer studID, String studStatus, Integer studYear, Integer studBranch,
			Integer studStandard, Integer studStream) {
		// TODO Auto-generated method stub
		List<String> examNoticeMessage;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.examniticeid, s.examnotice,s.examnoticedate FROM studentexamnoticemodel s left join studentexamnoticeenterymodel sen on sen.examniticeid=s.examniticeid where s.acadamicYearId='"+studYear+"' and s.branchId='"+studBranch+"' and s.standardId='"+studStandard+"' and  s.streamId='"+studStream+"' and sen.admissionRegId='"+studID+"' and s.examnoticestatus='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		examNoticeMessage=query.list();
		
		return examNoticeMessage;
	}

	
}
