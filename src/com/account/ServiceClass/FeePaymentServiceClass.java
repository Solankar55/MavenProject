package com.account.ServiceClass;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.daoInterface.FeePaymentDaoInterface;
import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.TransactionDetailsModel;
import com.account.model.discountModel;
import com.account.serviceInterface.FeePaymentServiceInterface;
import com.admin.model.AdminRegistrationModel;
@Service
public class FeePaymentServiceClass implements FeePaymentServiceInterface {
	@Autowired
	private FeePaymentDaoInterface feePaymentDaoInterface;
	
	@Transactional
	@Override
	public List<String> fetchListOfStudInfo(int registrationID) {

		return feePaymentDaoInterface.fetchStudInfo(registrationID);
	}

	public FeePaymentDaoInterface getFeePaymentDaoInterface() {
		return feePaymentDaoInterface;
	}

	public void setFeePaymentDaoInterface(FeePaymentDaoInterface feePaymentDaoInterface) {
		this.feePaymentDaoInterface = feePaymentDaoInterface;
	}

	@Transactional
	@Override
	public HashMap<String, String> GetBankList() {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetBankList();
	}

	@Transactional
	@Override
	public List<String> GetAccNumberList(int bankID) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetAccountNumberList(bankID);
	}

	@Transactional
	@Override
	public List<String> GetDetailInformation(int studId, String standard, String acYear,String Stream,String Branch) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetStudentDetailInfo(studId,standard,acYear,Stream,Branch);
	}
	
	@Transactional
	@Override
	public List<String> GetFEEDetailInformation(int studId, String standard, String acYear, String stream,
			String branch) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetFEEStudentDetailInfo(studId,standard,acYear,stream,branch);
	}

	@Transactional
	@Override
	public List<String> CheckStudent(int studId) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.CheckStudent(studId);
	}

	@Transactional
	@Override
	public List<String> FetchOldFeeDetails(int studId, String standard, String acYear,String Stream) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.FetchOldFeeDetails(studId,standard,acYear,Stream);
	}

	@Transactional
	@Override
	public int getReceiptNumber() {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetReceiptNumber();
	}

	@Transactional
	@Override
	public void saveTransactionModel(TransactionDetailsModel transactionDetailsModel) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.saveTransactionModel(transactionDetailsModel);
	}

	@Transactional
	@Override
	public void saveLedgerFeeModel(LedgerFeePaidModel ledgerFeePaidModel) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.saveLedgerFeeModel(ledgerFeePaidModel);
	}

	@Transactional
	@Override
	public void saveDiscountModel(discountModel discountModel) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.saveDiscountModel(discountModel);
	}

	/*@Transactional
	@Override
	public void saveFeePaymentReciptPrintModel(FeePaymentReciptPrintModel feePaymentReciptPrintModel) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.saveFeePaymentReciptPrintModel(feePaymentReciptPrintModel);
	}*/

	@Transactional
	@Override
	public List<String> getStudentInformation(int studID) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetStudentInformation(studID);
	}

	
	@Transactional
	@Override
	public List<AdminRegistrationModel> CheckAdmin(String username) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.checkAdmin(username);
	}

	@Transactional
	@Override
	public List<String> getLedgerFeeAndLedger(int studId, int standard, int stream, int acYear, int branch) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.getLedgerFeeAndLedger( studId,  standard,  stream,  acYear,  branch);
	}

	@Transactional
	@Override
	public List<String> getTransactionDetailsToPrint(int studId, int standard, int stream, int acYear, int branch) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.getTransactionDetailsToPrint(studId,  standard,  stream,  acYear,  branch);
	}

	@Transactional
	@Override
	public void saveRefoundModel(RefundAmountModel refundAmountModel) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.saveRefoundModel(refundAmountModel);
	}

	@Transactional
	@Override
	public List<String> getStudentdata(String StudentName) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.getStudentData(StudentName);
	}

	@Transactional
	@Override
	public void updateRefundData(int refundId, String bankName, String branchName, String checkNumber,
			String checkDate,String iFSCCode,int StudentID,String refundAmtDate) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.updataRefundData( refundId,  bankName,  branchName,  checkNumber,
				 checkDate,iFSCCode,StudentID, refundAmtDate);
	}

	@Transactional
	@Override
	public void updatePendingS(int regId) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.updatePendingS( regId);
	}

	@Transactional
	@Override
	public void updatePendingStatus(String totFee, String pendFee, int regId) {
		// TODO Auto-generated method stub
		feePaymentDaoInterface.updatePendingStatus( totFee,  pendFee,  regId);
	}

	@Transactional
	@Override
	public List<String> GetFEERefundDetailInformation(int studId, String standard, String acYear, String stream,
			String branch) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.GetFEERefundDetailInformation( studId,  standard,  acYear,  stream,
				 branch);
	}

	@Transactional
	@Override
	public List<String> getStudentRefundAmt(int studID) {
		// TODO Auto-generated method stub
		return feePaymentDaoInterface.getStudentRefundAmount(studID);
	}

	
	

}
