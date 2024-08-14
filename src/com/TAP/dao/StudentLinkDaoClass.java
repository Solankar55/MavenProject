package com.TAP.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HOD.model.StaffRegistrationModel;
import com.TAP.daoInterface.StudentLinkDaoInterface;
import com.TAP.model.StudentRegistrationTAPModel;
import com.student.model.StudentAdmissionModel;

@Repository
public class StudentLinkDaoClass implements StudentLinkDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId,a.acadamicYear FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
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
	public List<String> getBranchList(int id) {
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
	public List<String> getStudentDetailsForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> getStudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentList=query.list();
		return getStudentList;
	}

	@Override
	public int getTAPID() {
		// TODO Auto-generated method stub
		List getListIDS;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select max(s.TAPId) from studentRegistrationTAP s");
		getListIDS=query.list();
		int id=0;
		if(getListIDS.get(0)==null)
		{
			return id+1;
		}
		else
		{
			return id=(int)getListIDS.get(0)+1;
		}
	}

	@Override
	public void saveStudentRegistrationTAPDetails(StudentRegistrationTAPModel studentRegistrationTAPModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentRegistrationTAPModel);
	}

	@Override
	public List<StudentAdmissionModel> getStudentMail(int boxValue) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> getStudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,s.studentEmail FROM studentadmission s where s.admissionRegId='"+boxValue+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		getStudentList=query.list();
		return getStudentList;
	}

	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
List<StaffRegistrationModel> staffInfo;
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.staffRegistrationId,s.MobileNumber, s.Password,s.Qalification, s.SatffDepartment,s.StaffAddress, s.StaffEmail, s.StaffName, s.StaffRegDate, s.StaffType,s.UserName, s.YearOfExperience, s.barcode FROM staffregistration s where s.UserName='"	+ username + "'");
		query.setResultTransformer(Transformers.aliasToBean(StaffRegistrationModel.class));
		
		staffInfo=query.list();
		
		return staffInfo;
	}
	
	
}
