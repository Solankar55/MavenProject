package com.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.model.LedgerFeePaidModel;
import com.account.model.acadamicYearModel;
import com.student.daoInteerface.StudentNextYearAdmissionDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

@Repository
public class StudentNextYearAdmissionDaoClass implements StudentNextYearAdmissionDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer getStudentInformation(int studId) {
		// TODO Auto-generated method stub
		
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where s.admissionRegId='"+studId+"'");
	//	query.setResultTransformer(Transformers.aliasToBean(StudentAdmissionModel.class));
		List studYear;
		studYear=query.list();
		Integer studYearId;
		studYearId=(Integer) studYear.get(0);

		return studYearId;
	}

	@Override
	public List<acadamicYearModel> getActiveYear() {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId FROM acadamicyear a where a.ActiveAcadamicYr='Active'");
		query.setResultTransformer(Transformers.aliasToBean(acadamicYearModel.class));
		
		List<acadamicYearModel> yearList=new ArrayList<>();
		yearList=query.list();
		
		return yearList;
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
	public HashMap<String, String> SetStream() {
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

	@Override
	public List<String> getStudentDetailInfo(int studId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM studentadmission s where s.admissionRegId='"+studId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<String> studInfo;
		studInfo=query.list();
		
		return studInfo;
	}

	@Override
	public void saveBracodeMaster(StudentBarcodeMaster studentBarcodeMaster) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentBarcodeMaster);
	}

	@Override
	public void saveAdmission(StudentAdmissionModel studentAdmissionModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(studentAdmissionModel);
	}

	@Override
	public List<LedgerFeePaidModel> getFeeDetails(int studId) {
		// TODO Auto-generated method stub
		SQLQuery query =sessionFactory.getCurrentSession().createSQLQuery("SELECT l.FeePaidID, l.feeStatus,l.PendingFees FROM ledgerfeepaid l where l.FeePaidID=(select max(l.FeePaidID) as FeePaidID from ledgerfeepaid l where l.admissionRegId='"+studId+"')");
		query.setResultTransformer(Transformers.aliasToBean(LedgerFeePaidModel.class));
		
		List<LedgerFeePaidModel> details;
		details=query.list();
		
		return details;
	}
	
	
}
