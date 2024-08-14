package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.StandardReportDaoInterface;
import com.admin.model.AdminRegistrationModel;
@Repository
public class StandardReportDao implements StandardReportDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
	public List<String> GetStandardWiseList(int yearId,int streamid,int branchid,int standardID) {
		// TODO Auto-generated method stub

		List<String> StudentList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId, s.studentContactNumber, s.studentFirstName, s.studentLastName,stream.streamName,b.branchName,stand.standard,a.acadamicYear FROM studentadmission s left join streammaster stream on stream.streamId=s.streamId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId where s.streamId='"+streamid+"' and s.branchId='"+branchid+"' and s.standardId='"+standardID+"' and s.acadamicYearId='"+yearId+"' and s.status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentList=query.list();

		return StudentList;
	}

	@Override
	public HashMap<String, String> GetYearList() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();

		for(HashMap map :list){

			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));

		}
		return mapOfAcadimicYear;
	}

	@Override
	public List<AdminRegistrationModel> checkAdmin(String username) {
		// TODO Auto-generated method stub

		List<AdminRegistrationModel> adminList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.RegistrationId, a.Address, a.Date, a.Email, a.MobileNumber, a.Name, a.Password, a.Type, a.Username FROM adminregistration a where a.Username='"+username+"'");
		query.setResultTransformer(Transformers.aliasToBean(AdminRegistrationModel.class));

		adminList=query.list();

		return adminList;


	}

	@Override
	public List<String> getRefundAmtDetailList() {
		// TODO Auto-generated method stub
		List<String> refundAmtDetailList=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.refundid , r.refundamount , r.status , a.acadamicYear , s.studentFirstName , s.studentLastName, s.studentMiddleName FROM refundamountmodel r left join acadamicyear a on r.acadamicYearId=a.acadamicYearId left join studentadmission s on r.admissionRegId=s.admissionRegId where r.Status='Refunded' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		refundAmtDetailList=query.list();
		return refundAmtDetailList;
	}

	@Override
	public HashMap<String, String> getYearListFee() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfAcadimicYear=new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();

		for(HashMap map:list)
		{
			mapOfAcadimicYear.put( map.get("acadamicYearId"),map.get("acadamicYear"));
		}
		return mapOfAcadimicYear;
	}

	@Override
	public HashMap<String, String> getStreamListFee() {
		// TODO Auto-generated method stub
		List<HashMap> list=new ArrayList<>();
		HashMap mapOfStream=new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM streammaster s where s.strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list=query.list();

		for(HashMap map:list)
		{
			mapOfStream.put(map.get("streamId"), map.get("streamName"));
		}
		return mapOfStream;
	}

	@Override
	public List<String> getBranchListFee(int id) {
		// TODO Auto-generated method stub
		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();

		return BranchList;
	}

	@Override
	public List<String> getStandardListFee(int branchid) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchid+"' and s.stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();

		return StandardList;
	}

	@Override
	public List<String> getPendingFee(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> pendingFeeData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId , s.studentLastName ,s.studentFirstName , s.studentMiddleName , l.AcdemicYearID, l.feeStatus ,l.AcademicYear, l.PendingFees , st.standard ,b.branchName,st.standardId ,b.branchId,st.streamId,sm.streamName FROM studentadmission s left join ledgerfeepaid l on s.admissionRegId=l.admissionRegId left join standardmaster st on s.standardId=st.standardId left join branchmaster b on s.branchId=b.branchId left join streammaster sm on sm.streamId=st.streamId where b.branchId='"+branchid+"' and st.standardId='"+standardID+"' and l.AcdemicYearID='"+yearId+"' and st.streamId='"+streamid+"' and l.feeStatus='pending' group by s.admissionRegId ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		pendingFeeData=	query.list();
		System.out.println("pendingFeeData" +pendingFeeData);
		return pendingFeeData;
	}

	@Override
	public List<String> getCompletedFee(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		List<String> completedFeeData=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId , s.studentLastName ,s.studentFirstName , s.studentMiddleName , l.AcdemicYearID, l.feeStatus ,l.AcademicYear, l.totalFee , st.standard ,b.branchName,st.standardId ,b.branchId,st.streamId,sm.streamName FROM studentadmission s left join ledgerfeepaid l on s.admissionRegId=l.admissionRegId left join standardmaster st on s.standardId=st.standardId left join branchmaster b on s.branchId=b.branchId left join streammaster sm on sm.streamId=st.streamId where b.branchId='"+branchid+"' and st.standardId='"+standardID+"' and l.AcdemicYearID='"+yearId+"' and st.streamId='"+streamid+"' and l.feeStatus='Completed' group by s.admissionRegId ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		completedFeeData=	query.list();
		System.out.println("completedFeeData" +completedFeeData);
		return completedFeeData;
	}

	@Override
	public List<String> getStudentTransactionReport(String studentName) {
		// TODO Auto-generated method stub
		int studentId=0;

		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.studentnamessc='"+studentName+"'");
		studentId=(int)query.uniqueResult();
		System.out.println(studentId);

		List<String> studentTransactioDetails=new ArrayList<>();

		SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.FeePaidID, l.AcademicYear, l.AlreadyPaidFees, l.PaidFees, l.PendingFees, l.Standard,s.streamName,b.branchName,ifnull(d.totaldiscount,'-') as totaldiscount ,ifnull(d.discountReason,'-') as discountReason, l.feeStatus, l.totalFee,l.admissionRegId FROM ledgerfeepaid l left join streammaster s on s.StreamID=l.StreamID left join branchmaster b on b.branchId=l.BranchID left join discount d on d.discountId=l.discountId where l.admissionRegId='"+studentId+"'");
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		studentTransactioDetails=query2.list();

		/*SQLQuery query3=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.CheckBankIFSCCode,r.Status, r.cheackBranchCode, r.cheackDate, r.cheacknumber, r.checkBankName,r.refundamount, r.refunddate FROM refundamountmodel r where r.admissionRegId='"+studentId+"'");
		query3.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		studentTransactioDetails.addAll(query3.list());*/

		return studentTransactioDetails;
	}

}
