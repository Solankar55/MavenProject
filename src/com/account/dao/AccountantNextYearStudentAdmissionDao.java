package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.AccountantNextYearStudentAdmissionDaoInterface;
import com.account.model.LedgerFeePaidModel;
import com.account.model.StandardMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentBarcodeMaster;

@Repository
public class AccountantNextYearStudentAdmissionDao implements AccountantNextYearStudentAdmissionDaoInterface{

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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId,a.acadamicYear FROM acadamicyear a where a.astatus='On' and a.ActiveAcadamicYr='Active'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();
		
		for(HashMap map :list){

			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<String, String> GetStreamList() {
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
	public List<String> getStudentDetailsListForAdmission(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> getStudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentList=query.list();
		return getStudentList;
	}

	@Override
	public List<String> getStudentDetailsForNextYearAdmission(int academicYearID, int streamID, int branchID,
			int standardID) {
		// TODO Auto-generated method stub
		List<String> getStudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamID+"' and s.branchId='"+branchID+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+academicYearID+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getStudentList=query.list();
		return getStudentList;
	}

	@Override
	public int getStudentCountToTransferAdmission(int yearID, int streamID, int branchID, int standardID) {
		// TODO Auto-generated method stub
		Integer StudentCount=0;
		List StudCount=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT count(s.admissionRegId) as admissionID FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamID+"' and s.branchId='"+branchID+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearID+"' and s.status='Approved'");
		query.setResultTransformer(Transformers.TO_LIST);
		StudCount=query.list();
		
		StudentCount=(Integer)StudCount.get(0);
		return StudentCount;
	}

	@Override
	public List<acadamicYearModel> getStudentACYear(int yearID) {
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
	public void transferStrudentToNextYear(int rergId, int branchID, int streamID, int acadamicYearID, int standardID,
			String studentBarcode) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update studentadmission s set branchId='"+branchID+"',standardId='"+standardID+"',acadamicYearId='"+acadamicYearID+"',streamId='"+streamID+"',studentBarcode='"+studentBarcode+"' where admissionRegId='"+rergId+"'");
		query.executeUpdate();
	}

	/*Student next Year admission Process*/
	@Override
	public Integer getStudentInfo(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.acadamicYearId FROM studentadmission s left join acadamicyear a on a.acadamicYearId=s.acadamicYearId where s.admissionRegId='"+studentId+"'");
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
	public List<LedgerFeePaidModel> getFeeDetails(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query =sessionFactory.getCurrentSession().createSQLQuery("SELECT l.FeePaidID, l.feeStatus,l.PendingFees FROM ledgerfeepaid l where l.FeePaidID=(select max(l.FeePaidID) as FeePaidID from ledgerfeepaid l where l.admissionRegId='"+studentId+"')");
		query.setResultTransformer(Transformers.aliasToBean(LedgerFeePaidModel.class));
		
		List<LedgerFeePaidModel> details;
		details=query.list();
		
		return details;
	}

	@Override
	public List<String> getStudentDetailInfo(int studentId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM studentadmission s where s.admissionRegId='"+studentId+"'");
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
	public Integer getStudentId(int registrationID) {
		// TODO Auto-generated method stub
		List stud;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.admissionRegId=(select max(s.admissionRegId) as admissionRegId FROM studentadmission s where s.lastadmissionid='"+registrationID+"')");
		stud=query.list();
		
		Integer studYearId=0;
		studYearId=(Integer) stud.get(0);

		return studYearId;
	}
	
	
}
