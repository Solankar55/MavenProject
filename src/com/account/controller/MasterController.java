package com.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BankMasterModel;
import com.account.model.BranchMasterModel;
import com.account.model.LedgerMasterModel;
import com.account.model.StandardFeeMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.SubLedgerMasterModel;
import com.account.model.TransportMasterModel;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.MasterBankInterface;
import com.account.serviceInterface.MasterTransportInterface;
import com.account.serviceInterface.StudentStandardFeeServiceInterface;
import com.account.serviceInterface.masterLedgerInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

@Controller
public class MasterController {
	@Autowired
	private masterLedgerInterface MasterLedgerInterface;

	@Autowired
	private MasterBankInterface MasterBankInterface;

	@Autowired
	private MasterTransportInterface MasterTransportInterface;

	@Autowired
	private StudentStandardFeeServiceInterface studentStandardFeeServiceInterface;

	@RequestMapping("MasterTransport")
	public ModelAndView MasterTransport(Model model,
			@ModelAttribute("masterTransport") TransportMasterModel transportMasterModel, HttpServletRequest request,
			HttpSession session, @ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel)

	{
		System.out.println("Way to Master Tranport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<TransportMasterModel> listofTransport;
			listofTransport = MasterTransportInterface.fetchMasterTransport();
			model.addAttribute("listofTransport", listofTransport);
			return new ModelAndView("MasterTransportPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("MasterBank")
	public ModelAndView MasterBank(Model model, @ModelAttribute("masterBank") BankMasterModel bankMasterModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Master Bank");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<BankMasterModel> listofbank;
			listofbank = MasterBankInterface.fetchMasterBank();
			model.addAttribute("listofbank", listofbank);
			return new ModelAndView("MasterBankPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("MasterLedger")
	public ModelAndView MasterLedger1(Model model, @ModelAttribute("masterLedger") LedgerMasterModel ledgerMasterModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Master Ledger");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<LedgerMasterModel> listOfmasterLedger;
			listOfmasterLedger = MasterLedgerInterface.fetchMasterLedger();
			model.addAttribute("listOfmasterLedger", listOfmasterLedger);
			return new ModelAndView("MasterLedgerPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "UpdateLedger", params = "Update", method = RequestMethod.POST)
	public ModelAndView UpdateLedger(Model model, HttpServletRequest request,
			@ModelAttribute("masterLedger") LedgerMasterModel ledgerMasterModel,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel, HttpSession session) {
		System.out.println("Way to update Ledger");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int ledgerID = Integer.parseInt(request.getParameter("LedgerID"));
			System.out.println(ledgerID);
			String AccType = request.getParameter("AccType");
			System.out.println(AccType);
			String LedgerName = request.getParameter("LegderName");
			System.out.println(LedgerName);
			String Type = request.getParameter("Type");
			System.out.println(Type);

			MasterLedgerInterface.SaveUpdateLedger(ledgerID, AccType, LedgerName, Type);

			List<LedgerMasterModel> listOfmasterLedger;
			listOfmasterLedger = MasterLedgerInterface.fetchMasterLedger();
			model.addAttribute("listOfmasterLedger", listOfmasterLedger);

			return new ModelAndView("MasterLedgerPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "UpdateLedger", params = "Delete", method = RequestMethod.POST)
	public ModelAndView DeleteLedger(Model model, HttpServletRequest request,
			@ModelAttribute("masterLedger") LedgerMasterModel ledgerMasterModel) {
		System.out.println("Way to Delete Ledger");
		int ledgerID = Integer.parseInt(request.getParameter("LedgerID"));
		System.out.println(ledgerID);

		MasterLedgerInterface.DeleteLedger(ledgerID);

		List<LedgerMasterModel> listOfmasterLedger;
		listOfmasterLedger = MasterLedgerInterface.fetchMasterLedger();
		model.addAttribute("listOfmasterLedger", listOfmasterLedger);

		return new ModelAndView("MasterLedgerPage");
	}

	@RequestMapping("MasterStudentStandardFee")
	public ModelAndView MasterStudentStandardFee(HttpServletRequest request, Model model, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {

		System.out.println("Way to Master Student St Fee");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = studentStandardFeeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentStandardFeeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> LedgerList;
			LedgerList = studentStandardFeeServiceInterface.GetLedgerList();
			System.out.println(LedgerList);
			model.addAttribute("LedgerList", LedgerList);

			List<String> LedgerFee;
			LedgerFee = studentStandardFeeServiceInterface.GetLegderFeeList();
			System.out.println(LedgerFee);
			model.addAttribute("Ledgerfee", LedgerFee);

			return new ModelAndView("MasterStudentStandardFeePage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "UpdateStnadardFee.html", params = "Update", method = RequestMethod.POST)
	public ModelAndView UpdateStnadardFee(Model model, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel, HttpSession session) {
		System.out.println("Way to Update Standard fee");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int ledgerID = Integer.parseInt(request.getParameter("LedgerID"));
			System.out.println(ledgerID);

			int SubLedgerId=Integer.parseInt(request.getParameter("SubLedgerId"));
			System.out.println(SubLedgerId);

			String s= request.getParameter("LedgerFee");
			float StandardFee=Float.parseFloat(s);

			System.out.println(StandardFee);

			int StdFeeId=Integer.parseInt(request.getParameter("StdFeeId"));
			System.out.println(StdFeeId);

			studentStandardFeeServiceInterface.UpdateStandardFee(ledgerID, StandardFee,SubLedgerId,StdFeeId);

			HashMap<String, String> YearList;
			YearList = studentStandardFeeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentStandardFeeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> LedgerList;
			LedgerList = studentStandardFeeServiceInterface.GetLedgerList();
			System.out.println(LedgerList);
			model.addAttribute("LedgerList", LedgerList);

			List<String> LedgerFee;
			LedgerFee = studentStandardFeeServiceInterface.GetLegderFeeList();
			System.out.println(LedgerFee);
			model.addAttribute("Ledgerfee", LedgerFee);

			return new ModelAndView("MasterStudentStandardFeePage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "UpdateStnadardFee.html", params = "Delete", method = RequestMethod.POST)
	public ModelAndView DeleteStnadardFee(Model model, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel, HttpSession session) {
		System.out.println("Way to Update Standard fee");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			int ledgerID = Integer.parseInt(request.getParameter("LedgerID"));
			System.out.println(ledgerID);

			int SubLedgerId=Integer.parseInt(request.getParameter("SubLedgerId"));
			System.out.println(SubLedgerId);

			String StandardFee = request.getParameter("LedgerFee");
			System.out.println(StandardFee);

			int StdFeeId=Integer.parseInt(request.getParameter("StdFeeId"));
			System.out.println(StdFeeId);

			studentStandardFeeServiceInterface.DeleteStandardFee(StdFeeId);

			HashMap<String, String> YearList;
			YearList = studentStandardFeeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentStandardFeeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> LedgerList;
			LedgerList = studentStandardFeeServiceInterface.GetLedgerList();
			System.out.println(LedgerList);
			model.addAttribute("LedgerList", LedgerList);

			List<String> LedgerFee;
			LedgerFee = studentStandardFeeServiceInterface.GetLegderFeeList();
			System.out.println(LedgerFee);
			model.addAttribute("Ledgerfee", LedgerFee);

			return new ModelAndView("MasterStudentStandardFeePage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJson", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = studentStandardFeeServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSON", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = studentStandardFeeServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "GetSubLedgerListJson", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetSubLedgerListJson(int ledgerid) {
		System.out.println("way to get Sub Ledger list");
		System.out.println(ledgerid);

		List<String> SubLedgerList;
		SubLedgerList = studentStandardFeeServiceInterface.GetSubLedgerList(ledgerid);
		System.out.println(SubLedgerList);

		return SubLedgerList;
	}

	@RequestMapping(value = "GetSubLedger", method = RequestMethod.POST)
	public ModelAndView GetSubLedger(HttpSession session, HttpServletRequest request, Model model,
			@ModelAttribute("") StandardFeeMasterModel standardFeeMasterModel) {

		int LedgerId = Integer.parseInt(request.getParameter("ledgername"));
		session.setAttribute("LedgerID", LedgerId);
		System.out.println(LedgerId);

		List<String> SubLedgerList;
		SubLedgerList = studentStandardFeeServiceInterface.GetSubLedgerList(LedgerId);
		System.out.println(SubLedgerList);

		model.addAttribute("SubLedgerList", SubLedgerList);

		int YearID = Integer.parseInt(request.getParameter("YearName"));
		System.out.println("YEar" + YearID);
		session.setAttribute("YearID", YearID);

		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println("Stream" + StreanID);
		session.setAttribute("StreamID", StreanID);

		int branchID = Integer.parseInt(request.getParameter("branchName"));
		System.out.println("Branch" + branchID);
		session.setAttribute("BranchID", branchID);

		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		System.out.println("Standard" + StandardID);
		session.setAttribute("StandardID", StandardID);

		HashMap<String, String> YearList;
		YearList = studentStandardFeeServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = studentStandardFeeServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		HashMap<String, String> LedgerList;
		LedgerList = studentStandardFeeServiceInterface.GetLedgerList();
		System.out.println(LedgerList);
		model.addAttribute("LedgerList", LedgerList);

		List<String> LedgerFees;
		LedgerFees = studentStandardFeeServiceInterface.GetLegderFeeList();
		System.out.println(LedgerFees);
		model.addAttribute("Ledgerfee", LedgerFees);

		return new ModelAndView("MasterStudentStandardFeePage");
	}

	@RequestMapping(value="getSubledgerForassignFee")
	@ResponseBody
	public List<String> getSubledgerForassignFee(int yearId,int streamid,int branchid,int standardID,int ledgername)
	{
		System.out.println("getSubledgerForassignFee");

		List<String> getsubledger=new ArrayList<>();
		getsubledger=studentStandardFeeServiceInterface.getStandardLedger(yearId,streamid,branchid,standardID,ledgername);
		return getsubledger;
	}

	@RequestMapping(value = "AddSubLedgerFee", method = RequestMethod.POST)
	public ModelAndView AddSubLedgerFee(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("") StandardFeeMasterModel standardFeeMasterModel) {
		System.out.println("Way to Add Sub Ledger fee");

		// Set Academic Year
		int YearID = Integer.parseInt(request.getParameter("YearName"));
		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(YearID);
		standardFeeMasterModel.setAcadamicYearModel(acadamicYearModel);

		// set Stream
		int StreanID = Integer.parseInt(request.getParameter("StreamID"));
		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(StreanID);
		standardFeeMasterModel.setStreamMasterModel(streamMasterModel);

		// set branch
		int branchID = Integer.parseInt(request.getParameter("branchName"));
		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(branchID);
		standardFeeMasterModel.setBranchMasterModel(branchMasterModel);

		// set standard
		int StandardID = Integer.parseInt(request.getParameter("standardName"));
		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(StandardID);
		standardFeeMasterModel.setStandardMasterModel(standardMasterModel);

		int LedgerID = Integer.parseInt(request.getParameter("ledgername"));
		LedgerMasterModel ledgerMasterModel = new LedgerMasterModel();
		ledgerMasterModel.setLedgerId(LedgerID);
		standardFeeMasterModel.setLedgerMasterModel(ledgerMasterModel);

		System.out.println("YearID" + YearID);
		System.out.println("StreamID" + StreanID);
		System.out.println("BranchID" + branchID);
		System.out.println("StandardID" + StandardID);

		// set ledger id

		int checkCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println(checkCount);
		checkCount = checkCount + 100;

		String selectedLedger;
		String selectedLedgerFee;
		for (int i = 0; i <= checkCount; i++) {
			selectedLedger = request.getParameter("legerId" + i);
			selectedLedgerFee=request.getParameter("legerFee"+i);
			if (selectedLedger == null) {
				continue;
			}
			System.out.println("ledgerid"+selectedLedger);
			System.out.println("LedgerFee"+selectedLedgerFee);

			//	int studID = Integer.parseInt(selectedLedger);

			int SubLedgerID = Integer.parseInt(selectedLedger);
			SubLedgerMasterModel subLedgerMasterModel = new SubLedgerMasterModel();
			subLedgerMasterModel.setSubLedgerId(SubLedgerID);
			standardFeeMasterModel.setSubLedgerMasterModel(subLedgerMasterModel);

			System.out.println("SubLedger" + SubLedgerID);

			String LedgerFee = selectedLedgerFee;
			System.out.println("Leger Fee" + LedgerFee);
			standardFeeMasterModel.setFee(Float.parseFloat(LedgerFee));

			studentStandardFeeServiceInterface.SaveFee(standardFeeMasterModel);
		}

		/*

		int LedgerID = (Integer) session.getAttribute("LedgerID");
		LedgerMasterModel ledgerMasterModel = new LedgerMasterModel();
		ledgerMasterModel.setLedgerId(LedgerID);
		standardFeeMasterModel.setLedgerMasterModel(ledgerMasterModel);

		int SubLedgerID = Integer.parseInt(request.getParameter("SubLedgerID"));
		SubLedgerMasterModel subLedgerMasterModel = new SubLedgerMasterModel();
		subLedgerMasterModel.setSubLedgerId(SubLedgerID);
		standardFeeMasterModel.setSubLedgerMasterModel(subLedgerMasterModel);

		System.out.println("SubLedger" + SubLedgerID);

		int LedgerFee = Integer.parseInt(request.getParameter("Fee"));
		System.out.println("Leger Fee" + LedgerFee);

		studentStandardFeeServiceInterface.SaveFee(standardFeeMasterModel);*/

		HashMap<String, String> YearList;
		YearList = studentStandardFeeServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = studentStandardFeeServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		HashMap<String, String> LedgerList;
		LedgerList = studentStandardFeeServiceInterface.GetLedgerList();
		System.out.println(LedgerList);
		model.addAttribute("LedgerList", LedgerList);

		List<String> LedgerFees;
		LedgerFees = studentStandardFeeServiceInterface.GetLegderFeeList();
		System.out.println(LedgerFees);
		model.addAttribute("Ledgerfee", LedgerFees);

		return new ModelAndView("MasterStudentStandardFeePage");
	}

	@RequestMapping(value = "saveMasterLedger", method = RequestMethod.GET)
	public ModelAndView MasterLedger(Model model, @ModelAttribute("masterLedger") LedgerMasterModel ledgerMasterModel) {

		MasterLedgerInterface.saveMasterLedger(ledgerMasterModel);
		List<LedgerMasterModel> listOfmasterLedger;
		listOfmasterLedger = MasterLedgerInterface.fetchMasterLedger();
		model.addAttribute("listOfmasterLedger", listOfmasterLedger);
		return new ModelAndView("MasterLedgerPage");

	}

	@RequestMapping(value = "TransportMgmt", method = RequestMethod.GET)
	public ModelAndView TransportAdd(Model model,
			@ModelAttribute("masterTransport") TransportMasterModel transportMasterModel) {
		System.out.println("Way to Final Transport");
		MasterTransportInterface.TransportMgmt(transportMasterModel);
		List<TransportMasterModel> listofTransport;
		listofTransport = MasterTransportInterface.fetchMasterTransport();
		model.addAttribute("listofTransport", listofTransport);
		return new ModelAndView("MasterTransportPage");

	}

	@RequestMapping(value = "UpdateTransportCharge", params = "Update", method = RequestMethod.POST)
	public ModelAndView UpdateTransportCharge(Model model, HttpServletRequest request,
			@ModelAttribute("masterTransport") TransportMasterModel transportMasterModel) {
		System.out.println("Way to Update Transport Charge");

		int TransID = Integer.parseInt(request.getParameter("TransID"));
		System.out.println(TransID);

		String TransCharge = request.getParameter("Charges");
		System.out.println(TransCharge);

		MasterTransportInterface.UpdateTransportCharges(TransID, TransCharge);

		List<TransportMasterModel> listofTransport;
		listofTransport = MasterTransportInterface.fetchMasterTransport();
		model.addAttribute("listofTransport", listofTransport);

		return new ModelAndView("MasterTransportPage");
	}

	@RequestMapping(value = "UpdateTransportCharge", params = "Delete", method = RequestMethod.POST)
	public ModelAndView DeleteTransportCharge(Model model, HttpServletRequest request,
			@ModelAttribute("masterTransport") TransportMasterModel transportMasterModel) {
		System.out.println("Way to Update Transport Charge");

		int TransID = Integer.parseInt(request.getParameter("TransID"));
		System.out.println(TransID);

		MasterTransportInterface.DeleteTransportCharges(TransID);

		List<TransportMasterModel> listofTransport;
		listofTransport = MasterTransportInterface.fetchMasterTransport();
		model.addAttribute("listofTransport", listofTransport);

		return new ModelAndView("MasterTransportPage");
	}

	@RequestMapping(value = "saveBank", method = RequestMethod.GET)
	public ModelAndView BankAdd(Model model, @ModelAttribute("masterBank") BankMasterModel bankMasterModel) {
		System.out.println("way to Add bank");
		MasterBankInterface.saveBank(bankMasterModel);
		List<BankMasterModel> listofbank;
		listofbank = MasterBankInterface.fetchMasterBank();
		model.addAttribute("listofbank", listofbank);
		return new ModelAndView("MasterBankPage");

	}

	@RequestMapping(value = "UpdateBankDetails", params = "Update", method = RequestMethod.POST)
	public ModelAndView UpdateBankDetails(Model model, HttpServletRequest request,
			@ModelAttribute("masterBank") BankMasterModel bankMasterModel) {
		System.out.println("Way to Update Bank Details");

		int BankId = Integer.parseInt(request.getParameter("BankID"));
		System.out.println(BankId);

		String BankName=request.getParameter("BankName");
		System.out.println(BankName);

		String BranchName=request.getParameter("BranchName");
		System.out.println(BranchName);

		String BankAccountNumber = request.getParameter("AccountNumber");
		System.out.println(BankAccountNumber);

		String IFSCCode = request.getParameter("IFSC");
		System.out.println(IFSCCode);

		MasterBankInterface.UpdateBankDetails(BankId, BankAccountNumber, IFSCCode,BankName,BranchName);

		// MasterBankInterface.saveBank(bankMasterModel);

		List<BankMasterModel> listofbank;
		listofbank = MasterBankInterface.fetchMasterBank();
		model.addAttribute("listofbank", listofbank);

		return new ModelAndView("MasterBankPage");
	}

	@RequestMapping(value = "UpdateBankDetails", params = "Delete", method = RequestMethod.POST)
	public ModelAndView DeleteBankDetails(Model model, HttpServletRequest request,
			@ModelAttribute("masterBank") BankMasterModel bankMasterModel) {
		System.out.println("Way To Delete Bank ");

		int BankId = Integer.parseInt(request.getParameter("BankID"));
		System.out.println(BankId);

		MasterBankInterface.DeleteBank(BankId);

		List<BankMasterModel> listofbank;
		listofbank = MasterBankInterface.fetchMasterBank();
		model.addAttribute("listofbank", listofbank);

		return new ModelAndView("MasterBankPage");
	}

	/* open sub ledger */
	@RequestMapping("MasterSubLedger")
	public ModelAndView MasterSubLedger(Model model,
			@ModelAttribute("masterSubLedger") SubLedgerMasterModel subLedgerMasterModel, HttpSession session,
			HttpServletRequest request) {
		System.out.println("Way to Master Sub Ledger");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = MasterTransportInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<SubLedgerMasterModel> fetchListofSavedSubLedger;

			HashMap<String, String> subLedgerMasterModelList;
			subLedgerMasterModelList = MasterLedgerInterface.fetchSubmasterLedger();
			model.addAttribute("subLedgerMasterModelList", subLedgerMasterModelList);

			fetchListofSavedSubLedger = MasterLedgerInterface.fetchListofSavedsubledger();
			model.addAttribute("fetchListofSavedSubLedger", fetchListofSavedSubLedger);

			return new ModelAndView("MasterSubLedgerPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	/* save sub ledger */
	@RequestMapping("saveSubLedger")
	public ModelAndView saveLedgerSubmaster(Model model,
			@ModelAttribute("masterSubLedger") SubLedgerMasterModel subLedgerMasterModel, HttpServletRequest request) {
		int ledgerId = Integer.parseInt(request.getParameter("ledgermasterId"));

		LedgerMasterModel ledgerMasterModel = new LedgerMasterModel();
		ledgerMasterModel.setLedgerId(ledgerId);
		subLedgerMasterModel.setLedgerMasterModel(ledgerMasterModel);

		MasterLedgerInterface.saveSubledgerMaster(subLedgerMasterModel);

		HashMap<String, String> subLedgerMasterModelList;
		subLedgerMasterModelList = MasterLedgerInterface.fetchSubmasterLedger();
		model.addAttribute("subLedgerMasterModelList", subLedgerMasterModelList);
		List<SubLedgerMasterModel> fetchListofSavedSubLedger;
		fetchListofSavedSubLedger = MasterLedgerInterface.fetchListofSavedsubledger();
		model.addAttribute("fetchListofSavedSubLedger", fetchListofSavedSubLedger);

		return new ModelAndView("MasterSubLedgerPage");
	}

	@RequestMapping(value = "SubLedgerUpdate", params = "Update", method = RequestMethod.POST)
	public ModelAndView SubLedgerUpdate(@ModelAttribute("masterSubLedger") SubLedgerMasterModel subLedgerMasterModel,
			HttpServletRequest request, Model model) {
		System.out.println("Way to Update Sub Ledger");
		int SubLedgerID = Integer.parseInt(request.getParameter("SubLedgerID"));
		System.out.println(SubLedgerID);

		String SubLedgerName = request.getParameter("SubLedName");
		System.out.println(SubLedgerName);

		MasterLedgerInterface.UpdateSubLedger(SubLedgerID, SubLedgerName);

		HashMap<String, String> subLedgerMasterModelList;
		subLedgerMasterModelList = MasterLedgerInterface.fetchSubmasterLedger();
		model.addAttribute("subLedgerMasterModelList", subLedgerMasterModelList);
		List<SubLedgerMasterModel> fetchListofSavedSubLedger;
		fetchListofSavedSubLedger = MasterLedgerInterface.fetchListofSavedsubledger();
		model.addAttribute("fetchListofSavedSubLedger", fetchListofSavedSubLedger);

		return new ModelAndView("MasterSubLedgerPage");
	}

	@RequestMapping(value = "SubLedgerUpdate", params = "Delete", method = RequestMethod.POST)
	public ModelAndView SubLedgerDelete(@ModelAttribute("masterSubLedger") SubLedgerMasterModel subLedgerMasterModel,
			HttpServletRequest request, Model model) {
		System.out.println("Delete Sub Ledger");
		int SubLedgerID = Integer.parseInt(request.getParameter("SubLedgerID"));
		System.out.println(SubLedgerID);

		MasterLedgerInterface.DeleteSubLegder(SubLedgerID);

		HashMap<String, String> subLedgerMasterModelList;
		subLedgerMasterModelList = MasterLedgerInterface.fetchSubmasterLedger();
		model.addAttribute("subLedgerMasterModelList", subLedgerMasterModelList);
		List<SubLedgerMasterModel> fetchListofSavedSubLedger;
		fetchListofSavedSubLedger = MasterLedgerInterface.fetchListofSavedsubledger();
		model.addAttribute("fetchListofSavedSubLedger", fetchListofSavedSubLedger);

		return new ModelAndView("MasterSubLedgerPage");

	}

	public void setMasterBankInterface(MasterBankInterface masterBankInterface) {
		MasterBankInterface = masterBankInterface;
	}

	public MasterBankInterface getMasterBankInterface() {
		return MasterBankInterface;
	}

	public masterLedgerInterface getMasterLedgerInterface() {
		return MasterLedgerInterface;
	}

	public void setMasterLedgerInterface(masterLedgerInterface masterLedgerInterface) {
		MasterLedgerInterface = masterLedgerInterface;
	}

	public MasterTransportInterface getMasterTransportInterface() {
		return MasterTransportInterface;
	}

	public void setMasterTransportInterface(MasterTransportInterface masterTransportInterface) {
		MasterTransportInterface = masterTransportInterface;
	}

	public StudentStandardFeeServiceInterface getStudentStandardFeeServiceInterface() {
		return studentStandardFeeServiceInterface;
	}

	public void setStudentStandardFeeServiceInterface(
			StudentStandardFeeServiceInterface studentStandardFeeServiceInterface) {
		this.studentStandardFeeServiceInterface = studentStandardFeeServiceInterface;
	}

}
