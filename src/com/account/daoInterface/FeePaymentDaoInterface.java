package com.account.daoInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.TransactionDetailsModel;
import com.account.model.discountModel;
import com.admin.model.AdminRegistrationModel;

public interface FeePaymentDaoInterface {

	List fetchStudInfo(int registrationID);

	HashMap<String, String> GetBankList();

	List<String> GetAccountNumberList(int bankID);

	List<String> GetStudentDetailInfo(int studId, String standard, String acYear,String Stream, String branch);

	List<String> CheckStudent(int studId);

	List<String> FetchOldFeeDetails(int studId, String standard, String acYear,String Stream);

	int GetReceiptNumber();

	void saveTransactionModel(TransactionDetailsModel transactionDetailsModel);

	void saveLedgerFeeModel(LedgerFeePaidModel ledgerFeePaidModel);

	void saveDiscountModel(discountModel discountModel);

	List<String> GetFEEStudentDetailInfo(int studId, String standard, String acYear, String stream, String branch);

	/*void saveFeePaymentReciptPrintModel(FeePaymentReciptPrintModel feePaymentReciptPrintModel);*/

	List<String> GetStudentInformation(int studID);

	List<AdminRegistrationModel> checkAdmin(String username);

	List<String> getLedgerFeeAndLedger(int studId, int standard, int stream, int acYear, int branch);

	List<String> getTransactionDetailsToPrint(int studId, int standard, int stream, int acYear, int branch);

	void saveRefoundModel(RefundAmountModel refundAmountModel);

	List<String> getStudentData(String studentName);

	void updataRefundData(int refundId, String bankName, String branchName, String checkNumber, String checkDate, String iFSCCode, int studentID, String refundAmtDate);

	void updatePendingS(int regId);

	void updatePendingStatus(String totFee, String pendFee, int regId);

	List<String> GetFEERefundDetailInformation(int studId, String standard, String acYear, String stream,
			String branch);

	List<String> getStudentRefundAmount(int studID);

	
}
