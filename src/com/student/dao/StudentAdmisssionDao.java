package com.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.daoInteerface.StudentAdmisssionDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;
import com.student.model.StudentProfilePicModel;
@Repository
public class StudentAdmisssionDao implements StudentAdmisssionDaoInterface {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel){
		this.sessionFactory.getCurrentSession().save(studentAdmissionModel);
	}
	
	@Override
	public HashMap<String, String> GetStreamList() {
		// TODO Auto-generated method stub
		List<HashMap> streamlist=new ArrayList<>();
		HashMap mapOfStream = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.streamId,s.streamName from streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		streamlist=query.list();
		System.out.println("listOfmasterLedger"+streamlist);

		for(HashMap map :streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getBranchList(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * from branchmaster b where b.streamId='"+id+"' and b.bstatus='On' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();
		System.out.println("listOfBranch"+BranchList);
		return BranchList;
	}

	@Override
	public List<String> GetStandardList(int id) {
		// TODO Auto-generated method stub
		
		List<String> GetStandard=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from standardmaster s  where s.branchId='"+id+"' and s.stdstatus='On' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		GetStandard=query.list();
		return GetStandard;
	}

	@Override
	public HashMap<String, String> GetYearList() {
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
	public int getStudentID() {
		// TODO Auto-generated method stub
		List StudentID=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(s.admissionRegId) FROM studentadmission s");
		StudentID=query.list();
		
		int studID=0;
		if(StudentID.get(0)==null)
		{
			return studID+1;
		}
		else
		{
			return studID=(int)StudentID.get(0)+1;
		}
		
		
	}

	@Override
	public List<StudentAdmissionModel> getStudDetailsToCheckPresentOrNot(String studName, String studContact, String studEmail) {
		// TODO Auto-generated method stub
		List<StudentAdmissionModel> CheckStudent=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,s.studentnamessc,s.status,s.lastadmissionid FROM studentadmission s where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId from studentadmission s where s.studentFirstName='"+studName+"' and s.studentContactNumber='"+studContact+"' and s.studentEmail='"+studEmail+"')");
		query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		CheckStudent=query.list();
		return CheckStudent;
	}

	@Override
	public List<acadamicYearModel> getStudentAcademicYearID(int yearID) {
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
	public void imageUpload(StudentProfilePicModel studentProfilePicModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentProfilePicModel);
	}

	@Override
	public void saveStudentBarcodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentBarcodeMaster);
	}

	
	
	
	
}
