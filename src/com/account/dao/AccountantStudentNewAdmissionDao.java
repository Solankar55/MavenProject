package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.AccountantStudentNewAdmissionDaoInterface;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentRegistrationModel;

@Repository
public class AccountantStudentNewAdmissionDao implements AccountantStudentNewAdmissionDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int getStudentID() {
		// TODO Auto-generated method stub
		List getStudentID=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select max(s.admissionRegId)as admissionRegId from studentadmission s");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentID=query.list();
		
		int StudentID=0;
		
		if(getStudentID.get(0)==null)
		{
			return StudentID+1;
		}
		else
		{
			return StudentID=(int)getStudentID.get(0)+1;
		}
		
		
	}

	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.ActiveAcadamicYr='Active' and a.astatus='On'");
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
		List<HashMap> streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.streamId,r.streamName from streammaster r where r.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		streamlist=query.list();
		System.out.println("listOfmasterLedger"+streamlist);

		for(HashMap map :streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * from branchmaster b where b.streamId='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		System.out.println("listOfBranch"+BranchList);
		return BranchList;
	}

	@Override
	public List<String> getStandardList(int id) {
		// TODO Auto-generated method stub
		List<String> GetStandard=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from standardmaster s where s.branchId='"+id+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStandard=query.list();
		return GetStandard;
	}

	@Override
	public void SaveStudentAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentAdmissionModel);
	}

	@Override
	public List<acadamicYearModel> getStudentAcyear(int yearID) {
		// TODO Auto-generated method stub
		List<acadamicYearModel> acyear=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYear FROM acadamicyear a where a.acadamicYearId='"+yearID+"' and a.astatus='On'");
		query.setResultTransformer(Transformers.aliasToBean(acadamicYearModel.class));
		acyear=query.list();
		return acyear;
	}

	@Override
	public List<StandardMasterModel> getStudentStandard(int standardId) {
		// TODO Auto-generated method stub
		List<StandardMasterModel> studStandard=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.standard FROM standardmaster s where s.standardId='"+standardId+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.aliasToBean(StandardMasterModel.class));
		studStandard=query.list();
		return studStandard;
	}

	@Override
	public void saveRegisterDetails(StudentRegistrationModel studentRegistrationModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentRegistrationModel);
	}

	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentBarcodeMaster);
	}

	@Override
	public List<String> getStudentCheckId(int studentId) {
		// TODO Auto-generated method stub
		List<String> StudentInfo=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.admissionRegId='"+studentId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentInfo=query.list();
		return StudentInfo;
	}
	
	
}
