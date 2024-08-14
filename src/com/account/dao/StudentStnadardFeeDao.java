package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.StudentStnadardFeeDaoInterface;
import com.account.model.StandardFeeMasterModel;
@Repository
public class StudentStnadardFeeDao implements StudentStnadardFeeDaoInterface{

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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM acadamicyear a where a.astatus='On'");
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
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("Select s.streamId, s.streamName FROM streammaster s where strstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Streamlist=query.list();

		for(HashMap map :Streamlist){

			mapOfStream.put( map.get("streamId"),map.get("streamName"));

		}
		return mapOfStream;
	}

	@Override
	public List<String> GetBranch(int id) {
		// TODO Auto-generated method stub

		List<String> BranchList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select * from branchmaster b where b.streamid='"+id+"' and b.bstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BranchList=query.list();

		return BranchList;
	}

	@Override
	public List<String> GetStandardList(int branchID) {
		// TODO Auto-generated method stub
		List<String> StandardList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM standardmaster s where s.branchId='"+branchID+"' and stdstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StandardList=query.list();

		return StandardList;
	}

	@Override
	public HashMap<String, String> GetLedgereList() {
		// TODO Auto-generated method stub
		List<HashMap> Ledgerlist=new ArrayList<>();
		HashMap mapOfLedger = new HashMap();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LedgerId, l.LedgerName FROM ledgermaster l where l.lstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Ledgerlist=query.list();

		for(HashMap map :Ledgerlist){

			mapOfLedger.put( map.get("LedgerId"),map.get("LedgerName"));

		}
		return mapOfLedger;
	}

	@Override
	public List<String> GetSubLedgerList(int ledgerId) {
		// TODO Auto-generated method stub

		List<String> SubLedgerList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select s.SubLedgerId, s.subledger,l.LedgerName from subledgermaster s,ledgermaster l where s.LedgerId=l.LedgerId and s.LedgerId='"+ledgerId+"' and s.sstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		SubLedgerList=query.list();

		return SubLedgerList;
	}

	@Override
	public void SaveFeeTODB(StandardFeeMasterModel standardFeeMasterModel) {
		// TODO Auto-generated method stub
		System.out.println("ADD FEE TO DB");

		int yearId=standardFeeMasterModel.getAcadamicYearModel().getAcadamicYearId();
		System.out.println(yearId);

		int branchId=standardFeeMasterModel.getStandardMasterModel().getStandardId();
		System.out.println(branchId);

		int ledgerId=standardFeeMasterModel.getLedgerMasterModel().getLedgerId();
		System.out.println(ledgerId);

		int subledgerId=standardFeeMasterModel.getSubLedgerMasterModel().getSubLedgerId();
		System.out.println(subledgerId);

		int standardId=standardFeeMasterModel.getStandardMasterModel().getStandardId();
		System.out.println(standardId);

		int streamId=standardFeeMasterModel.getStreamMasterModel().getStreamId();
		System.out.println(streamId);

		float fee=standardFeeMasterModel.getFee();
		System.out.println(fee);

		List<String> detailsOfFee=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.StandardFeeId,s.Fee FROM standardfeemaster s where s.acadamicYearId='"+yearId+"' and s.branchId='"+branchId+"' and s.LedgerId='"+ledgerId+"' and s.standardId='"+standardId+"' and s.streamId='"+streamId+"' and s.SubLedgerId='"+subledgerId+"'");
		detailsOfFee=query.list();

		if(detailsOfFee.size()==0)
		{
			System.out.println("No Data");
			this.sessionFactory.getCurrentSession().save(standardFeeMasterModel);
		}
		else
		{
			System.out.println("Data Present And Update");
			SQLQuery query2=sessionFactory.getCurrentSession().createSQLQuery("update standardfeemaster s set s.Fee='"+fee+"' where s.acadamicYearId='"+yearId+"' and s.branchId='"+branchId+"' and s.LedgerId='"+ledgerId+"' and s.standardId='"+standardId+"' and s.streamId='"+streamId+"' and s.SubLedgerId='"+subledgerId+"'");
			query2.executeUpdate();
		}

		//sessionFactory.getCurrentSession().save(standardFeeMasterModel);
	}

	@Override
	public List<String> GetLedgerFeeList() {
		// TODO Auto-generated method stub

		List<String> LedgerFee;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.LedgerId,l.AccountType, s.fee,sl.subledger,l.LedgerName,a.acadamicYear,b.branchName,stream.streamName,standard.standard,s.SubLedgerId,s.StandardFeeId FROM standardfeemaster s left join subledgermaster sl on sl.SubLedgerId=s.SubLedgerId left join ledgermaster l on l.LedgerId=s.LedgerId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId left join branchmaster b on s.branchId=b.branchId left join streammaster stream on s.streamId=stream.streamId left join standardmaster standard on standard.standardId=s.standardId where s.sfstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		LedgerFee=query.list();


		return LedgerFee;
	}

	@Override
	public void UpdateStandardFee(int ledgerID, float standardFee,int subLedgerId,int stdFeeId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update standardfeemaster s set s.Fee='"+standardFee+"' where s.LedgerId='"+ledgerID+"' and s.SubLedgerId='"+subLedgerId+"' and s.StandardFeeId='"+stdFeeId+"' ");
		query.executeUpdate();
	}

	@Override
	public void DeleteStandardFeeD(int stdFeeId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update standardfeemaster s set s.sfstatus='Off' where s.StandardFeeId='"+stdFeeId+"'");
		query.executeUpdate();
	}

	@Override
	public List<String> getStandardLedger(int yearId, int streamid, int branchid, int standardID, int ledgername) {
		// TODO Auto-generated method stub
		List<String> SubLedgerList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select s.SubLedgerId, s.subledger,l.LedgerName from subledgermaster s,ledgermaster l where s.LedgerId=l.LedgerId and s.LedgerId='"+ledgername+"' and s.sstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		SubLedgerList=query.list();

		return SubLedgerList;
	}


}
