package com.Exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Exam.daoInterface.ExamNoticeDaoInterface;
import com.Exam.model.ParentExamNoticeEnteryModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeEnteryModel;
import com.Exam.model.StudentExamNoticeModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Repository
public class ExamNoticeDaoClass implements ExamNoticeDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		List<StaffRegistrationModel> DataList = new ArrayList<>();

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"
						+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));

		DataList = query.list();

		return DataList;
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapToYear=new HashMap();
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map:list)
		{
			mapToYear.put(map.get("acadamicYearId"), map.get("acadamicYear"));
		}
		return mapToYear;
	}

	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		List<HashMap> Streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Streamlist=query.list();
		
		for(HashMap map :Streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranchlist(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;
	}

	@Override
	public List<String> getStandardList(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchid+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		
		return StandardList;
	}

	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> StudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public HashMap<String, String> getYearListP() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapToYear=new HashMap();
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map:list)
		{
			mapToYear.put(map.get("acadamicYearId"), map.get("acadamicYear"));
		}
		return mapToYear;
	}

	@Override
	public HashMap<String, String> getStreamListP() {
		// TODO Auto-generated method stub
		List<HashMap> Streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Streamlist=query.list();
		
		for(HashMap map :Streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranchP(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;
	}

	@Override
	public List<String> getStandardListP(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchid+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();
		
		return StandardList;
	}

	@Override
	public List<String> getStandardWiseListP(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> StudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber,s.fatherFirstName,s.fatherLastName,s.fatherEmail,s.fatherContactNumber,s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();
		
		return StudentList;
	}

	@Override
	public void saveStudentExamNoticeModel(StudentExamNoticeModel studentExamNoticeModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentExamNoticeModel);
	}

	@Override
	public int noticeStudentExamMaxID() {
		// TODO Auto-generated method stub
		List getId;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.examniticeid) as examniticeid FROM studentexamnoticemodel s");
		getId=query.list();
		
		int id=0;
		if(getId.get(0)==null)
		{
			return id;
		}
		else
		{
			return id=(int)getId.get(0);
		}
	}

	@Override
	public void saveStudentExamNoticeStudentEntryModel(StudentExamNoticeEnteryModel studentExamNoticeEnteryModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentExamNoticeEnteryModel);
	}

	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> studentContact;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.studentContactNumber,s.fatherContactNumber FROM studentadmission s where s.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		
		studentContact=query.list();
		return studentContact;
	}

	@Override
	public void saveParentExamNoticeModel(ParentExamNoticeModel parentExamNoticeModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(parentExamNoticeModel);
	}

	@Override
	public int noticeParentExamMaxID() {
		// TODO Auto-generated method stub
		List getId;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(p.parentexamnoticeid) as parentexamnoticeid FROM parentexamnoticemodel p");
		getId=query.list();
		
		int id=0;
		if(getId.get(0)==null)
		{
			return id;
		}
		else
		{
			return id=(int)getId.get(0);
		}
	}

	@Override
	public void saveParentExamNoticeStudentEntryModel(ParentExamNoticeEnteryModel parentExamNoticeEnteryModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(parentExamNoticeEnteryModel);
	}
	
	
}
