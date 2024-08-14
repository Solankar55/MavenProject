package com.account.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.account.model.BranchMasterModel;
import com.account.model.DivisionMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.account.serviceInterface.AcademicYearMasterServiceInterface;
import com.account.serviceInterface.BranchMasterInterface;
import com.account.serviceInterface.DivisionMasterInterface;
import com.account.serviceInterface.StandardMasterInterface;
import com.account.serviceInterface.StreamMasterInterface;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

import freemarker.core.ReturnInstruction.Return;

@Controller
public class BranchMasterController {

	@Autowired
	private StreamMasterInterface streamMasterInterface;
	@Autowired
	private BranchMasterInterface branchMasterInterface;
	@Autowired
	private StandardMasterInterface standardMasterInterface;
	@Autowired
	private DivisionMasterInterface divisionMasterInterface;
	@Autowired
	private AcademicYearMasterServiceInterface academicYearMasterServiceInterface;

	@RequestMapping("AcademicYearMaster")
	public ModelAndView AcademicYearMaster(Model model,
			@ModelAttribute("YearMaster") acadamicYearModel acadamicYearModel, HttpServletRequest request,
			HttpSession session, @ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Academic Year Master");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = branchMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);
			String[] str = curentdate.split("-");
			int m = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			StringBuilder builder = new StringBuilder();
			if (m > 6) {
				y += 1;
				builder.append(str[2]);
				builder.append("-");
				builder.append(String.valueOf(y));

			} else {
				y -= 1;
				builder.append(String.valueOf(y));
				builder.append("-");
				builder.append(str[2]);

			}
			String str1 = new String(builder);
			model.addAttribute("curentdate", curentdate);
			model.addAttribute("academic", str1);

			List<String> AcademicYearList;
			AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearList();
			System.out.println(AcademicYearList);

			model.addAttribute("AcademicYearList", AcademicYearList);

			return new ModelAndView("AcademicYearMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "SaveAcademicYear", params = "AddAcademicYear")
	public ModelAndView SaveAcademicYear(Model model,
			@ModelAttribute("YearMaster") acadamicYearModel acadamicYearModel) {
		System.out.println("way to add year");
		academicYearMasterServiceInterface.SaveYear(acadamicYearModel);
		List<String> AcademicYearList;
		AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);
		return new ModelAndView("AcademicYearMasterPage");
	}

	@RequestMapping(value = "SaveAcademicYear", params = "SetActiveYear")
	public ModelAndView SetActiveYear(Model model) {
		System.out.println("Set Active Year");

		HashMap<String, String> AcademicYearList;
		AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearListKeyValue();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		List<String> ActiveYearList;
		ActiveYearList = academicYearMasterServiceInterface.ActiveYearList();
		System.out.println(ActiveYearList);

		model.addAttribute("ActiveYearList", ActiveYearList);

		return new ModelAndView("SetActiveYearPage");
	}

	@RequestMapping(value = "SaveActiveYear", method = RequestMethod.GET)
	public ModelAndView SaveActiveYear(HttpServletRequest request, Model model,
			@ModelAttribute("YearMaster") acadamicYearModel acadamicYearModel) {
		System.out.println("In Activete Year");

		int yearID = Integer.parseInt(request.getParameter("ActiveYearID"));
		System.out.println(yearID);

		academicYearMasterServiceInterface.setActiveYear(yearID);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcademicYearMasterPage");
	}

	@RequestMapping(value = "YearOpration", params = "Update", method = RequestMethod.POST)
	public ModelAndView YearOpration(Model model, HttpServletRequest request,
			@ModelAttribute("YearMaster") acadamicYearModel acadamicYearModel) {
		System.out.println("Way to Upadate Year");

		int YearId = Integer.parseInt(request.getParameter("AcYearID"));
		System.out.println(YearId);

		String Year = (String) request.getParameter("AcYear");
		System.out.println(Year);

		academicYearMasterServiceInterface.UpadteYear(YearId, Year);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcademicYearMasterPage");
	}

	@RequestMapping(value = "YearOpration", params = "Delete", method = RequestMethod.POST)
	public ModelAndView YearOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("YearMaster") acadamicYearModel acadamicYearModel) {
		System.out.println("Way to Delete Year");

		int YearId = Integer.parseInt(request.getParameter("AcYearID"));
		System.out.println(YearId);

		academicYearMasterServiceInterface.DeleteYear(YearId);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcademicYearMasterPage");
	}

	@RequestMapping("StreamMaster")
	public ModelAndView StreamMaster(Model model, @ModelAttribute("saveStream") StreamMasterModel streamMasterModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Add Stream Master Page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = branchMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			List<StreamMasterModel> streamList;
			streamList = streamMasterInterface.GetStream();
			System.out.println(streamList);
			model.addAttribute("StreamList", streamList);
			return new ModelAndView("StreamMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("BranchMaster")
	public ModelAndView BranchMaster(Model model, @ModelAttribute("AddNewBranch") BranchMasterModel branchMasterModel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way To Add Branch Master");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = branchMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> streamList;
			streamList = streamMasterInterface.SetStream();
			System.out.println(streamList);
			model.addAttribute("StreamListForBranch", streamList);

			List<BranchMasterModel> branchList;
			branchList = branchMasterInterface.GetBranchList();
			System.out.println(branchList);
			model.addAttribute("BranchList", branchList);

			return new ModelAndView("BranchMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("StandardMaster")
	public ModelAndView SatandardMaster(Model model,
			@ModelAttribute("AddStandard") StandardMasterModel standardMasterModel, HttpServletRequest request,
			HttpSession session, @ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Standard Master");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = branchMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> streamList;
			streamList = streamMasterInterface.SetStream();
			System.out.println(streamList);
			model.addAttribute("StreamListForStandard", streamList);

			HashMap<String, String> branchList;
			branchList = branchMasterInterface.setBranch();
			System.out.println(branchList);
			model.addAttribute("BranchListForStandard", branchList);

			List<StandardMasterModel> standardList;
			standardList = standardMasterInterface.GetStandardList();
			System.out.println(standardList);
			model.addAttribute("StandardListOfStudent", standardList);

			return new ModelAndView("StandardMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	/* open division */
	@RequestMapping("DivisionMaster")
	public ModelAndView DivisionMaster(Model model, HttpServletRequest request,
			@ModelAttribute("SaveDivisionpage") DivisionMasterModel divisionMasterModel, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Division Master");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = branchMasterInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> streamList;
			streamList = streamMasterInterface.SetStream();
			System.out.println(streamList);
			model.addAttribute("StreamListForStandard", streamList);

			HashMap<String, String> branchList;
			branchList = branchMasterInterface.setBranch();
			System.out.println(branchList);
			model.addAttribute("BranchListForStandard", branchList);

			HashMap<String, String> standardList;
			standardList = divisionMasterInterface.GetStdList();
			System.out.println(standardList);
			model.addAttribute("StandardListOfStudent", standardList);

			List<DivisionMasterModel> DivisionList;
			DivisionList = divisionMasterInterface.GetDivisionList();
			System.out.println(DivisionList);
			model.addAttribute("DivisionListOfStudent", DivisionList);

			return new ModelAndView("DivisionMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "SaveStream", method = RequestMethod.POST)
	public ModelAndView AddStream(Model model, @ModelAttribute("saveStream") StreamMasterModel streamMasterModel) {
		System.out.println("Way TO Add Stream");
		streamMasterInterface.AddStream(streamMasterModel);
		List<StreamMasterModel> streamList;
		streamList = streamMasterInterface.GetStream();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);
		return new ModelAndView("StreamMasterPage");
	}

	@RequestMapping(value = "StreamOpration", params = "Update", method = RequestMethod.POST)
	public ModelAndView StreamOpration(Model model, HttpServletRequest request,
			@ModelAttribute("saveStream") StreamMasterModel streamMasterModel) {
		System.out.println("Way to Update Stream Name");

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		String StreamName = (String) request.getParameter("StreamName");
		System.out.println(StreamName);

		streamMasterInterface.UpdateStream(StreamID, StreamName);

		List<StreamMasterModel> streamList;
		streamList = streamMasterInterface.GetStream();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);

		return new ModelAndView("StreamMasterPage");
	}

	@RequestMapping(value = "StreamOpration", params = "Delete", method = RequestMethod.POST)
	public ModelAndView StreamOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("saveStream") StreamMasterModel streamMasterModel) {
		System.out.println("Delete Stream Operation");

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		streamMasterInterface.DeleteStream(StreamID);

		List<StreamMasterModel> streamList;
		streamList = streamMasterInterface.GetStream();
		System.out.println(streamList);
		model.addAttribute("StreamList", streamList);

		return new ModelAndView("StreamMasterPage");
	}

	@RequestMapping(value = "AddNewBranch", method = RequestMethod.POST)
	public ModelAndView AddBranch(HttpServletRequest request, Model model,
			@ModelAttribute("AddNewBranch") BranchMasterModel branchMasterModel) {
		/*
		 * System.out.println("Way To Add New Branch");
		 * System.out.println(branchMasterModel.getBranchId());
		 * System.out.println(branchMasterModel.getBranchName());
		 */
		int streamId = Integer.parseInt(request.getParameter("streamMasterId"));
		System.out.println(streamId);
		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		branchMasterModel.setStreamMasterModel(streamMasterModel);

		branchMasterInterface.AddNewBranch(branchMasterModel);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForBranch", streamList);

		List<BranchMasterModel> branchList;
		branchList = branchMasterInterface.GetBranchList();
		System.out.println(branchList);
		model.addAttribute("BranchList", branchList);

		return new ModelAndView("BranchMasterPage");
	}

	@RequestMapping(value = "BranchOpration", params = "Update", method = RequestMethod.POST)
	public ModelAndView BranchOpration(Model model, HttpServletRequest request,
			@ModelAttribute("AddNewBranch") BranchMasterModel branchMasterModel) {
		System.out.println("Way to Update Branch");

		int BranchID = Integer.parseInt(request.getParameter("BranchID"));
		System.out.println(BranchID);

		String BranchName = (String) request.getParameter("BranchName");
		System.out.println(BranchName);

		branchMasterInterface.UpdateBranch(BranchID, BranchName);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForBranch", streamList);

		List<BranchMasterModel> branchList;
		branchList = branchMasterInterface.GetBranchList();
		System.out.println(branchList);
		model.addAttribute("BranchList", branchList);

		return new ModelAndView("BranchMasterPage");
	}

	@RequestMapping(value = "BranchOpration", params = "Delete", method = RequestMethod.POST)
	public ModelAndView BranchOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("AddNewBranch") BranchMasterModel branchMasterModel) {
		System.out.println("Way to Delete Branch");

		int BranchID = Integer.parseInt(request.getParameter("BranchID"));
		System.out.println(BranchID);

		branchMasterInterface.DeleteBranch(BranchID);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForBranch", streamList);

		List<BranchMasterModel> branchList;
		branchList = branchMasterInterface.GetBranchList();
		System.out.println(branchList);
		model.addAttribute("BranchList", branchList);

		return new ModelAndView("BranchMasterPage");
	}

	@RequestMapping(value = "SaveStandard", method = RequestMethod.POST)
	public ModelAndView SaveStandard(Model model, HttpServletRequest request,
			@ModelAttribute("AddStandard") StandardMasterModel standardMasterModel) {
		System.out.println("Way To Add Standard");
		int StreamId = Integer.parseInt(request.getParameter("StreamId"));
		System.out.println(StreamId);
		int BranchId = Integer.parseInt(request.getParameter("BranchId"));
		System.out.println(BranchId);

		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(StreamId);
		standardMasterModel.setStreamMasterModel(streamMasterModel);

		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(BranchId);
		standardMasterModel.setBranchMasterModel(branchMasterModel);

		standardMasterInterface.AddStandard(standardMasterModel);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		List<StandardMasterModel> standardList;
		standardList = standardMasterInterface.GetStandardList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		return new ModelAndView("StandardMasterPage");
	}

	@RequestMapping(value = "StandardOpration", params = "Update", method = RequestMethod.POST)
	public ModelAndView StandardOpration(Model model, HttpServletRequest request,
			@ModelAttribute("AddStandard") StandardMasterModel standardMasterModel) {
		System.out.println("Way to Update Standard");

		int StndardID = Integer.parseInt(request.getParameter("StndID"));
		System.out.println(StndardID);

		String Standard = (String) request.getParameter("Standard");
		System.out.println(Standard);

		standardMasterInterface.UpdateStandard(StndardID, Standard);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		List<StandardMasterModel> standardList;
		standardList = standardMasterInterface.GetStandardList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		return new ModelAndView("StandardMasterPage");
	}

	@RequestMapping(value = "StandardOpration", params = "Delete", method = RequestMethod.POST)
	public ModelAndView StandardOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("AddStandard") StandardMasterModel standardMasterModel) {
		System.out.println("Way to Update Standard");

		int StndardID = Integer.parseInt(request.getParameter("StndID"));
		System.out.println(StndardID);

		standardMasterInterface.DeleteStandard(StndardID);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		List<StandardMasterModel> standardList;
		standardList = standardMasterInterface.GetStandardList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		return new ModelAndView("StandardMasterPage");
	}

	@RequestMapping(value = "SaveDivision", method = RequestMethod.POST)
	public ModelAndView SaveDivision(Model model, HttpServletRequest request,
			@ModelAttribute("SaveDivisionpage") DivisionMasterModel divisionMasterModel) {
		System.out.println("Way to Add New Division");
		int StreamId = Integer.parseInt(request.getParameter("StreamId"));
		System.out.println(StreamId);
		int BranchId = Integer.parseInt(request.getParameter("BranchId"));
		System.out.println(BranchId);
		int StandardId = Integer.parseInt(request.getParameter("StandardId"));
		System.out.println(StandardId);

		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(StreamId);
		divisionMasterModel.setStreamMasterModel(streamMasterModel);

		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(BranchId);
		divisionMasterModel.setBranchMasterModel(branchMasterModel);

		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(StandardId);
		divisionMasterModel.setStandardMasterModel(standardMasterModel);

		divisionMasterInterface.SaveDivision(divisionMasterModel);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		HashMap<String, String> standardList;
		standardList = divisionMasterInterface.GetStdList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		List<DivisionMasterModel> DivisionList;
		DivisionList = divisionMasterInterface.GetDivisionList();
		System.out.println(DivisionList);
		model.addAttribute("DivisionListOfStudent", DivisionList);

		return new ModelAndView("DivisionMasterPage");
	}

	@RequestMapping(value = "DivisionOpration", params = "Update", method = RequestMethod.POST)
	public ModelAndView DivisionOpration(Model model, HttpServletRequest request,
			@ModelAttribute("SaveDivisionpage") DivisionMasterModel divisionMasterModel) {
		System.out.println("Way To Update Division");

		int DivId = Integer.parseInt(request.getParameter("DivId"));
		System.out.println(DivId);

		String Division = (String) request.getParameter("Division");
		System.out.println(Division);

		divisionMasterInterface.UpdateDivision(DivId, Division);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		HashMap<String, String> standardList;
		standardList = divisionMasterInterface.GetStdList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		List<DivisionMasterModel> DivisionList;
		DivisionList = divisionMasterInterface.GetDivisionList();
		System.out.println(DivisionList);
		model.addAttribute("DivisionListOfStudent", DivisionList);

		return new ModelAndView("DivisionMasterPage");
	}

	@RequestMapping(value = "DivisionOpration", params = "Delete", method = RequestMethod.POST)
	public ModelAndView DivisionOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("SaveDivisionpage") DivisionMasterModel divisionMasterModel) {
		System.out.println("Way To Update Division");

		int DivId = Integer.parseInt(request.getParameter("DivId"));
		System.out.println(DivId);

		divisionMasterInterface.DeleteDivision(DivId);

		HashMap<String, String> streamList;
		streamList = streamMasterInterface.SetStream();
		System.out.println(streamList);
		model.addAttribute("StreamListForStandard", streamList);

		HashMap<String, String> branchList;
		branchList = branchMasterInterface.setBranch();
		System.out.println(branchList);
		model.addAttribute("BranchListForStandard", branchList);

		HashMap<String, String> standardList;
		standardList = divisionMasterInterface.GetStdList();
		System.out.println(standardList);
		model.addAttribute("StandardListOfStudent", standardList);

		List<DivisionMasterModel> DivisionList;
		DivisionList = divisionMasterInterface.GetDivisionList();
		System.out.println(DivisionList);
		model.addAttribute("DivisionListOfStudent", DivisionList);

		return new ModelAndView("DivisionMasterPage");
	}

	public StreamMasterInterface getStreamMasterInterface() {
		return streamMasterInterface;
	}

	public void setStreamMasterInterface(StreamMasterInterface streamMasterInterface) {
		this.streamMasterInterface = streamMasterInterface;
	}

	public BranchMasterInterface getBranchMasterInterface() {
		return branchMasterInterface;
	}

	public void setBranchMasterInterface(BranchMasterInterface branchMasterInterface) {
		this.branchMasterInterface = branchMasterInterface;
	}

	public StandardMasterInterface getStandardMasterInterface() {
		return standardMasterInterface;
	}

	public void setStandardMasterInterface(StandardMasterInterface standardMasterInterface) {
		this.standardMasterInterface = standardMasterInterface;
	}

	public DivisionMasterInterface getDivisionMasterInterface() {
		return divisionMasterInterface;
	}

	public void setDivisionMasterInterface(DivisionMasterInterface divisionMasterInterface) {
		this.divisionMasterInterface = divisionMasterInterface;
	}

	public AcademicYearMasterServiceInterface getAcademicYearMasterServiceInterface() {
		return academicYearMasterServiceInterface;
	}

	public void setAcademicYearMasterServiceInterface(
			AcademicYearMasterServiceInterface academicYearMasterServiceInterface) {
		this.academicYearMasterServiceInterface = academicYearMasterServiceInterface;
	}

}
