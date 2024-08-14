package com.account.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.account.model.LedgerFeePaidModel;
import com.account.model.RefundAmountModel;
import com.account.model.TransactionDetailsModel;
import com.account.model.discountModel;
import com.admin.model.AdminRegistrationModel;

public interface FeePaymentServiceInterface {

	List fetchListOfStudInfo(int registrationID);

	HashMap<String, String> GetBankList();

	List<String> GetAccNumberList(int bankID);

	List<String> GetDetailInformation(int studId, String standard, String acYear,String Stream, String branch);

	List<String> CheckStudent(int studId);

	List<String> FetchOldFeeDetails(int studId, String standard, String acYear,String Stream);

	int getReceiptNumber();

	void saveTransactionModel(TransactionDetailsModel transactionDetailsModel);

	void saveLedgerFeeModel(LedgerFeePaidModel ledgerFeePaidModel);

	void saveDiscountModel(discountModel discountModel);

	List<String> GetFEEDetailInformation(int studId, String standard, String acYear, String stream, String branch);

/*	void saveFeePaymentReciptPrintModel(FeePaymentReciptPrintModel feePaymentReciptPrintModel);*/

	List<String> getStudentInformation(int studID);

	List<AdminRegistrationModel> CheckAdmin(String username);

	List<String> getLedgerFeeAndLedger(int studId, int standard, int stream, int acYear, int branch);

	List<String> getTransactionDetailsToPrint(int studId, int standard, int stream, int acYear, int branch);

	void saveRefoundModel(RefundAmountModel refundAmountModel);

	//List<String> getStudentdata(int registrationID);

	void updateRefundData(int refundId, String bankName, String branchName, String checkNumber, String checkDate, String iFSCCode, int studentID, String refundAmtDate);

	void updatePendingS(int regId);

	void updatePendingStatus(String totFee, String pendFee, int regId);

	List<String> GetFEERefundDetailInformation(int studId, String standard, String acYear, String stream,
			String branch);

	List<String> getStudentRefundAmt(int studID);

	List<String> getStudentdata(String studentName);

	
}
