package com.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.daoInterface.FeePaymentDaoInterface;
import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.TransactionDetailsModel;
import com.account.model.discountModel;
import com.admin.model.AdminRegistrationModel;
@Repository
public class FeePaymentDaoClass implements FeePaymentDaoInterface {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> fetchStudInfo(int registrationID) {
		List<String> FetchStudentInfoList;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,a.acadamicYear,s.admissionDate,s.studentLastName,s.studentFirstName,s.studentMiddleName,s.branchId,b.branchName,a.acadamicYearId,s.standardId,s.divisionId,sm.standard,s.streamId,ss.streamName FROM studentadmission s Left join acadamicyear a on s.acadamicYearId=a.acadamicYearId Left join branchmaster b on s.branchId=b.branchId Left join standardmaster sm on sm.standardId=s.standardId left join streammaster ss on ss.streamId=s.streamId where s.admissionRegId ='"+registrationID+"' and status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		FetchStudentInfoList = query.list();
		return FetchStudentInfoList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HashMap<String, String> GetBankList() {
		// TODO Auto-generated method stub

		List<HashMap> BankList=new ArrayList<>();
		HashMap MapBankList=new HashMap<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM bankmaster b where b.status='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		BankList=query.list();

		for(HashMap map:BankList)
		{
			MapBankList.put(map.get("bankId"),map.get("bankName"));
		}

		return MapBankList;
	}

	@Override
	public List<String> GetAccountNumberList(int bankID) {
		// TODO Auto-generated method stub
		List<String> AccountNumberList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM bankmaster b where b.bankId='"+bankID+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		AccountNumberList=query.list();

		return AccountNumberList;
	}

	@Override
	public List<String> GetStudentDetailInfo(int studId, String standard, String acYear, String Stream,String Branch) {
		// TODO Auto-generated method stub

		List<String> StudentDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(" select s.fee,sub.subledger from standardfeemaster s left join subledgermaster sub on sub.SubLedgerId=s.SubLedgerId left join ledgermaster l on l.LedgerId=s.LedgerId left join acadamicyear a on a.acadamicYearId=s.acadamicYearId left join branchmaster b on b.branchId=s.branchId left join standardmaster stand on stand.standardId=s.standardId left join streammaster stream on stream.streamId=s.streamId where a.acadamicYear='"+acYear+"' and b.branchName='"+Branch+"' and stand.standard='"+standard+"' and stream.streamName='"+Stream+"' and l.AccountType='Assets' and s.sfstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();

		return StudentDetails;
	}

	@Override
	public List<String> GetFEEStudentDetailInfo(int studId, String standard, String acYear, String stream,
			String branch) {
		// TODO Auto-generated method stub
		List<String> FeeDetails =new ArrayList<>();
		List<LedgerFeePaidModel> lg=new ArrayList<>();
		System.out.println("st"+studId);
		SQLQuery query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT max(FeePaidID) as FeePaidID  FROM ledgerfeepaid  where admissionRegId='"+studId+"'");


		int id=(int) query.uniqueResult();
		//FeeDetails.clear();
		//SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT (max(l.FeePaidID)),l.AlreadyPaidFees, l.PaidFees,l.PendingFees,l.totalFee  FROM ledgerfeepaid l where l.admissionRegId='"+studId+"' ");
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("SELECT AlreadyPaidFees, PaidFees, PendingFees, Standard, feeStatus, totalFee FROM ledgerfeepaid  where FeePaidID='"+id+"'");
		query1.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		FeeDetails=query1.list();
		return FeeDetails;
	}

	@Override
	public List<String> CheckStudent(int studId) {
		// TODO Auto-generated method stub
		List<String> CheckList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM ledgerfee l where l.admissionRegId='"+studId+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		CheckList=query.list();

		return CheckList;
	}

	@Override
	public List<String> FetchOldFeeDetails(int studId, String standard, String acYear,String Stream) {
		// TODO Auto-generated method stub
		List<String> OldFeeDetailList;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(l.LedgerFeePaidID),l.LedgerAlreadyPaidFees,l.LedgerPendingFees,lf.ledgerTotalFees,lf.feeStatus,sl.SubLedgerId,sl.subledger,s.admissionRegId,a.acadamicYear,s.admissionDate,s.studentLastName,s.studentFirstName,s.studentMiddleName,b.branchName,s.divisionId,sm.standard,s.streamId,ss.streamName FROM ledgerfeepaid l left join collegemgmtsystem.ledgerfee lf on lf.ledgerFeeID=l.ledgerFeeID and lf.admissionRegId ='"+studId+"' left join collegemgmtsystem.subledgermaster sl on sl.SubLedgerId=lf.SubLedgerId left join studentadmission s on s.admissionRegId=lf.admissionRegId left join acadamicyear a on s.acadamicYearId=a.acadamicYearId and a.acadamicYear='"+acYear+"' Left join branchmaster b on s.branchId=b.branchId Left join standardmaster sm on sm.standardId=s.standardId and sm.standard='"+standard+"' left join streammaster ss on ss.streamId=s.streamId ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		OldFeeDetailList=query.list();

		return OldFeeDetailList;
	}

	@Override
	public int GetReceiptNumber() {
		// TODO Auto-generated method stub
		List ReciptNumber=new ArrayList<>();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT max(t.receiptNo) FROM transactiondetails t");
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		ReciptNumber=query.list();

		int Number=0;
		if (ReciptNumber.get(0)==null){
			return Number+1;
		}else{
			return Number=(int)ReciptNumber.get(0)+1;
		}
	}

	@Override
	public void saveTransactionModel(TransactionDetailsModel transactionDetailsModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transactionDetailsModel);
	}

	@Override
	public void saveLedgerFeeModel(LedgerFeePaidModel ledgerFeePaidModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(ledgerFeePaidModel);
	}

	@Override
	public void saveDiscountModel(discountModel discountModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(discountModel);
	}

	/*@Override
	public void saveFeePaymentReciptPrintModel(FeePaymentReciptPrintModel feePaymentReciptPrintModel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(feePaymentReciptPrintModel);
	}*/

	@Override
	public List<String> GetStudentInformation(int studID) {
		// TODO Auto-generated method stub
		List<String> FetchStudentInfoList;
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId,a.acadamicYear,s.admissionDate,s.studentLastName,s.studentFirstName,s.studentMiddleName,s.branchId,b.branchName,a.acadamicYearId,s.standardId,s.divisionId,sm.standard,s.streamId,ss.streamName FROM studentadmission s Left join acadamicyear a on s.acadamicYearId=a.acadamicYearId Left join branchmaster b on s.branchId=b.branchId Left join standardmaster sm on sm.standardId=s.standardId left join streammaster ss on ss.streamId=s.streamId where s.admissionRegId ='"+studID+"' and status='Approved' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		FetchStudentInfoList = query.list();
		return FetchStudentInfoList;
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
	public List<String> getLedgerFeeAndLedger(int studId, int standard, int stream, int acYear, int branch) {
		// TODO Auto-generated method stub
		List<String> StudentDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select s.Fee,sub.subledger from standardfeemaster s left join subledgermaster sub on sub.SubLedgerId=s.SubLedgerId left join ledgermaster l on l.LedgerId=s.LedgerId where s.acadamicYearId='"+acYear+"' and s.branchId='"+branch+"' and s.standardId='"+standard+"' and s.streamId='"+stream+"' and l.AccountType='Assets' and s.sfstatus='On'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		StudentDetails=query.list();

		return StudentDetails;
	}

	@Override
	public List<String> getTransactionDetailsToPrint(int studId, int standard, int stream, int acYear, int branch) {
		// TODO Auto-generated method stub
		List<String> getTrDetails;
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT l.AlreadyPaidFees,l.PaidFees,l.PendingFees,l.totalFee,t.paymentMode,t.receiptDate,t.receiptNo,t.transactionDate,t.bankName,t.transactionNumber,(SELECT max(d.totaldiscount) as Discount FROM discount d where d.admissionRegId='"+studId+"')as Discount FROM ledgerfeepaid l left join transactiondetails t on t.transactionDetailsId=l.transactionDetailsId where l.AcdemicYearID='"+acYear+"' and l.BranchID='"+branch+"' and l.StandardID='"+standard+"' and l.admissionRegId='"+studId+"' and l.StreamID='"+stream+"'");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		getTrDetails=query.list();

		return getTrDetails;
	}

	@Override
	public void saveRefoundModel(RefundAmountModel refundAmountModel) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(refundAmountModel);
	}

	@Override
	public List<String> getStudentData(String StudentName) {
		// TODO Auto-generated method stub

		int registrationID=0;
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("SELECT s.admissionRegId FROM studentadmission s where s.studentnamessc='"+StudentName+"'");
		registrationID=(int)query1.uniqueResult();

		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.refundid,r.refundamount,a.acadamicYear,s.standard,stud.admissionDate,stud.studentFirstName,stud.studentLastName, (select sum(l.PaidFees) as PaidFees from ledgerfeepaid l left join studentadmission s on s.admissionRegId=l.admissionRegId where s.admissionRegId='"+registrationID+"') as PaidFees, (select distinct(l.totalFee) from ledgerfeepaid l left join studentadmission s on s.admissionRegId=l.admissionRegId where s.admissionRegId='"+registrationID+"' group by s.admissionRegId) as totalFee FROM refundamountmodel r left join acadamicyear a on a.acadamicYearId=r.acadamicYearId left join standardmaster s on s.standardId=r.standardId left join studentadmission stud on stud.admissionRegId=r.admissionRegId where r.refundid=(select max(r.refundid) as refundid from refundamountmodel r where r.admissionRegId='"+registrationID+"' and r.Status='NotRefunded')");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<String> StudentData=new ArrayList<>();
		StudentData=query.list();

		return StudentData;
	}

	@Override
	public void updataRefundData(int refundId, String bankName, String branchName, String checkNumber,
			String checkDate,String iFSCCode,int StudentID,String refundAmtDate) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update refundamountmodel r set r.Status='Refunded' where r.admissionRegId='"+StudentID+"'");
		query.executeUpdate();
		SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("update refundamountmodel r set r.Status='Refunded',r.cheackBranchCode='"+branchName+"',r.cheackDate='"+checkDate+"',r.cheacknumber='"+checkNumber+"',r.CheckBankIFSCCode='"+iFSCCode+"',r.checkBankName='"+bankName+"',r.refunddate='"+refundAmtDate+"' where r.refundid='"+refundId+"'");
		query1.executeUpdate();
	}

	@Override
	public void updatePendingS(int regId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update ledgerfeepaid l set l.feeStatus='Complete' where  l.admissionRegId='"+regId+"' ");
		query.executeUpdate();

	}

	@Override
	public void updatePendingStatus(String totFee, String pendFee, int regId) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update ledgerfeepaid l set l.feeStatus='pre_pending' where '"+pendFee+"' < '"+totFee+"' and l.admissionRegId='"+regId+"'");
		query.executeUpdate();


	}

	@Override
	public List<String> GetFEERefundDetailInformation(int studId, String standard, String acYear, String stream,
			String branch) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.refundid,r.refundamount FROM refundamountmodel r where r.refundid=(select max(r.refundid) as refundid from refundamountmodel r left join acadamicyear a on a.acadamicYearId=r.acadamicYearId left join branchmaster b on b.branchId=r.branchId left join standardmaster s on s.standardId=r.standardId left join streammaster str on str.streamId=r.streamId left join studentadmission stud on stud.admissionRegId=r.admissionRegId where r.admissionRegId='"+studId+"' and r.Status='NotRefunded' and a.acadamicYear='"+acYear+"' and b.branchName='"+branch+"' and s.standard='"+standard+"' and str.streamName='"+stream+"')");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<String> StudentData=new ArrayList<>();
		StudentData=query.list();

		return StudentData;
	}

	@Override
	public List<String> getStudentRefundAmount(int studID) {
		// TODO Auto-generated method stub
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT r.refundid,r.refundamount FROM refundamountmodel r where r.refundid=(select max(r.refundid) as refundid from refundamountmodel r left join acadamicyear a on a.acadamicYearId=r.acadamicYearId left join branchmaster b on b.branchId=r.branchId left join standardmaster s on s.standardId=r.standardId left join streammaster str on str.streamId=r.streamId left join studentadmission stud on stud.admissionRegId=r.admissionRegId where r.admissionRegId='"+studID+"' and r.Status='Refunded')");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<String> StudentData=new ArrayList<>();
		StudentData=query.list();

		return StudentData;
	}


}
