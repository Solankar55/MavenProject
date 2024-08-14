package com.AcademicMaster.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AcademicMaster.daoInterface.StudentControllerYearDepartmentDaoInterface;
import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentAttendanceNoticeStudentEnteryModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Repository
public class StudentControllerYearDepartmentDaoClass implements StudentControllerYearDepartmentDaoInterface{

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
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		
		return BranchList;

	}

	@Override
	public List<String> GetStamdardList(int branchid) {
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
	public void saveStudentNoticeModel(StudentNoticeModel studentNoticeModel) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(studentNoticeModel);
		
	}

	@Override
	public int getMaxNoticeID() {
		// TODO Auto-generated method stub
		
		List maxNoticeID;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.NoticeID) as MaxNoticeID FROM studentnotice s ");
		maxNoticeID=query.list();
		
		int maxNoticeId=0;
		if(maxNoticeID.get(0)==null)
		{
			return maxNoticeId+1;
		}
		else
		{ 
			maxNoticeId=(int)maxNoticeID.get(0);
			return maxNoticeId;
		}
		
	}

	@Override
	public void saveStudentNoticeStudentEntryModel(StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(studentNoticeStudentEnteryModel);
		
	}

	@Override
	public void saveStudentAttendanceNoticeModel(StudentAttendanceNoticeModel studentAttendanceNoticeModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentAttendanceNoticeModel);
	}

	@Override
	public int getStudentAttendanceNoticeMaxID() {
		// TODO Auto-generated method stub
		List getMaxID;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.StudentAttendenceNoticeID) as StudentAttendenceNoticeID FROM studentattendancenotice s");
		
		getMaxID=query.list();
		
		int NoticeMaxID=0;
		if(getMaxID.get(0)==null)
		{
			return NoticeMaxID+1;
		}
		else
		{
			return NoticeMaxID=(int)getMaxID.get(0);
		}
		
	}

	@Override
	public void saveStudentAttendenceNoticeEnteryModel(
			StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(studentAttendanceNoticeStudentEnteryModel);
	}

	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.studentContactNumber FROM studentadmission s where s.admissionRegId='"+studID+"'");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		
		List<StudentAdmissionModel> Studno;
		Studno=query.list();
		return Studno;
	}
	
	
}
