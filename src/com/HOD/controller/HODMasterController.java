package com.HOD.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.AssignDepartmentmodel;
import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.HOD.model.StaffRegistrationModel;
import com.HOD.serviceInterface.AssignDepartmentServiceInterface;
import com.HOD.serviceInterface.ClassInChargeServiceInterface;
import com.HOD.serviceInterface.SubjectMasterServiceInterface;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.admin.model.AdminRegistrationModel;
import com.student.model.StudentRegistrationModel;

@Controller
public class HODMasterController {

	@Autowired
	private ClassInChargeServiceInterface classInChargeServiceInterface;

	@Autowired
	private SubjectMasterServiceInterface subjectMasterServiceInterface;

	@Autowired
	private AssignDepartmentServiceInterface assignDepartmentServiceInterface;

	@RequestMapping("SubjectMaster")
	public ModelAndView SubjectMaster(Model model,
			@ModelAttribute("SaveSubject") HODSubjectMasterModel hodSubjectMasterModel, HttpServletRequest request,
			HttpSession session, @ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Subject master Page");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = subjectMasterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = subjectMasterServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = subjectMasterServiceInterface.GetStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			List<String> SubjectList;
			SubjectList = subjectMasterServiceInterface.getSubjectList();
			System.out.println(SubjectList);
			model.addAttribute("SubjectList", SubjectList);

			return new ModelAndView("SubjectMasterPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonMasterSubject")
	@ResponseBody
	public List<String> GetBranchListJsonMasterSubject(int id) {
		List<String> getBranchList = new ArrayList<>();
		getBranchList = subjectMasterServiceInterface.getBranchList(id);
		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONMasterSubject")
	@ResponseBody
	public List<String> GetStandardListJSONMasterSubject(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = subjectMasterServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping("SaveSubjectHOD")
	public ModelAndView SaveSubjectHOD(HttpServletRequest request, Model model,
			@ModelAttribute("SaveSubject") HODSubjectMasterModel hodSubjectMasterModel) {
		System.out.println("Save Subject HOD");

		int YearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);

		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(YearID);
		hodSubjectMasterModel.setAcadamicYearModel(acadamicYearModel);

		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(StreamID);
		hodSubjectMasterModel.setStreamMasterModel(streamMasterModel);

		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(BranchID);
		hodSubjectMasterModel.setBranchMasterModel(branchMasterModel);

		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(StandardID);
		hodSubjectMasterModel.setStandardMasterModel(standardMasterModel);

		subjectMasterServiceInterface.saveSubject(hodSubjectMasterModel);

		HashMap<String, String> YearList;
		YearList = subjectMasterServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = subjectMasterServiceInterface.GetStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		List<String> SubjectList;
		SubjectList = subjectMasterServiceInterface.getSubjectList();
		System.out.println(SubjectList);
		model.addAttribute("SubjectList", SubjectList);

		return new ModelAndView("SubjectMasterPage");
	}

	@RequestMapping(value = "AssignSubjectToLect")
	public ModelAndView AssignSubjectToLect(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("AssignSubjectToLect");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = subjectMasterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = subjectMasterServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = subjectMasterServiceInterface.GetStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = subjectMasterServiceInterface.getTeachingStaff();
			System.out.println(TeacherList);
			model.addAttribute("TeacherList", TeacherList);

			/*
			 * HashMap<Integer, String> SubjectList; SubjectList =
			 * subjectMasterServiceInterface.SubjectList();
			 * System.out.println(SubjectList);
			 * model.addAttribute("SubjectList", SubjectList);
			 */

			List<String> AssignTeacherList;
			AssignTeacherList = subjectMasterServiceInterface.getAssignSubjectTeacherList();
			System.out.println(AssignTeacherList);
			model.addAttribute("AssignTeacherList", AssignTeacherList);

			return new ModelAndView("AssignSubjectToLectPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonAssignSubject")
	@ResponseBody
	public List<String> GetBranchListJsonAssignSubject(int id) {
		List<String> getBranchList = new ArrayList<>();
		getBranchList = subjectMasterServiceInterface.getBranchList(id);
		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONAssignSubject")
	@ResponseBody
	public List<String> GetStandardListJSONAssignSubject(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = subjectMasterServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping(value = "GetTeacherListJSON")
	@ResponseBody
	public List<String> GetTeacherListJSON(int YearId, int streamId, int branchid, int StandardID) {
		List<String> getTeacherList = new ArrayList<>();
		getTeacherList = subjectMasterServiceInterface.getTeacherList(YearId, streamId, branchid, StandardID);
		return getTeacherList;
	}

	@RequestMapping(value = "AssignSubjectToTeacher", params = "AssignSubject")
	public ModelAndView AssignSubjectToTeacher(HttpServletRequest request, Model model) {
		System.out.println("Save Assign Subject To Teacher");

		AssignSubjectTeacherModel assignSubjectTeacherModel = new AssignSubjectTeacherModel();

		int YearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);

		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		int TeacherID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(TeacherID);

		int SubjectID = Integer.parseInt(request.getParameter("SubjectID"));
		System.out.println(SubjectID);

		List<String> GetListAvailableOrnot;
		GetListAvailableOrnot = subjectMasterServiceInterface.getDataList(YearID, StreamID, BranchID, TeacherID,
				StandardID, SubjectID);

		System.out.println(GetListAvailableOrnot);
	
		if (GetListAvailableOrnot.size() == 0) {
			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(YearID);
			assignSubjectTeacherModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(StreamID);
			assignSubjectTeacherModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(BranchID);
			assignSubjectTeacherModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(StandardID);
			assignSubjectTeacherModel.setStandardMasterModel(standardMasterModel);

			StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
			staffRegistrationModel.setStaffRegistrationId(TeacherID);
			assignSubjectTeacherModel.setStaffRegistrationModel(staffRegistrationModel);

			HODSubjectMasterModel hodSubjectMasterModel = new HODSubjectMasterModel();
			hodSubjectMasterModel.setSubjectID(SubjectID);
			assignSubjectTeacherModel.setHodSubjectMasterModel(hodSubjectMasterModel);

			subjectMasterServiceInterface.saveAssignValues(assignSubjectTeacherModel);

			HashMap<String, String> YearList;
			YearList = subjectMasterServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = subjectMasterServiceInterface.GetStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = subjectMasterServiceInterface.getTeachingStaff();
			System.out.println(TeacherList);
			model.addAttribute("TeacherList", TeacherList);

			
			/* * HashMap<Integer, String> SubjectList; SubjectList =
			 * subjectMasterServiceInterface.SubjectList();
			 * System.out.println(SubjectList);
			 * model.addAttribute("SubjectList", SubjectList);*/
			 

			List<String> AssignTeacherList;
			AssignTeacherList = subjectMasterServiceInterface.getAssignSubjectTeacherList();
			System.out.println(AssignTeacherList);
			model.addAttribute("AssignTeacherList", AssignTeacherList);

			return new ModelAndView("AssignSubjectToLectPage");
		} else {

			subjectMasterServiceInterface.updateSubjectAssignVlaue(YearID,StreamID,BranchID,StandardID,TeacherID,SubjectID);
			
			HashMap<String, String> YearList;
			YearList = subjectMasterServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = subjectMasterServiceInterface.GetStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = subjectMasterServiceInterface.getTeachingStaff();
			System.out.println(TeacherList);
			model.addAttribute("TeacherList", TeacherList);

			HashMap<Integer, String> SubjectList;
			SubjectList = subjectMasterServiceInterface.SubjectList();
			System.out.println(SubjectList);
			model.addAttribute("SubjectList", SubjectList);

			List<String> AssignTeacherList;
			AssignTeacherList = subjectMasterServiceInterface.getAssignSubjectTeacherList();
			System.out.println(AssignTeacherList);
			model.addAttribute("AssignTeacherList", AssignTeacherList);

			return new ModelAndView("AssignSubjectToLectPage");
		}
		//	return new ModelAndView();
	}

	/*@RequestMapping(value = "AssignSubjectToTeacher", params = "DisAssignSubject")
	public ModelAndView AssignSubjectToTeacherDis(Model model, HttpServletRequest request) {
		System.out.println("Dis Assign Subject To Lectural");

		int YearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);

		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		int TeacherID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(TeacherID);

		int SubjectID = Integer.parseInt(request.getParameter("SubjectID"));
		System.out.println(SubjectID);

		subjectMasterServiceInterface.setAssignSubjectToDisAssign(YearID, StreamID, BranchID, StandardID, TeacherID,
				SubjectID);

		HashMap<String, String> YearList;
		YearList = subjectMasterServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = subjectMasterServiceInterface.GetStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		HashMap<Integer, String> TeacherList;
		TeacherList = subjectMasterServiceInterface.getTeachingStaff();
		System.out.println(TeacherList);
		model.addAttribute("TeacherList", TeacherList);

		HashMap<Integer, String> SubjectList;
		SubjectList = subjectMasterServiceInterface.SubjectList();
		System.out.println(SubjectList);
		model.addAttribute("SubjectList", SubjectList);

		List<String> AssignTeacherList;
		AssignTeacherList = subjectMasterServiceInterface.getAssignSubjectTeacherList();
		System.out.println(AssignTeacherList);
		model.addAttribute("AssignTeacherList", AssignTeacherList);

		return new ModelAndView("AssignSubjectToLectPage");
	}*/

	@RequestMapping("ClassInChargeAssign")
	public ModelAndView ClassInChargeAssign(Model model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("Way to Classd In charge Page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = subjectMasterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = classInChargeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = classInChargeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = classInChargeServiceInterface.getTeachingStaff();
			System.out.println(TeacherList);
			model.addAttribute("TeacherList", TeacherList);

			List<String> getAssignClassInChargeList;
			getAssignClassInChargeList = classInChargeServiceInterface.getAssignInchargeList();
			System.out.println(getAssignClassInChargeList);
			model.addAttribute("getAssignClassInChargeList", getAssignClassInChargeList);

			return new ModelAndView("ClassInChargeAssignPage");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonClassInCharge")
	@ResponseBody
	public List<String> GetBranchListJsonClassInCharge(int id) {
		List<String> getBranchList = new ArrayList<>();
		getBranchList = classInChargeServiceInterface.getBranchList(id);
		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONClassinCharge")
	@ResponseBody
	public List<String> GetStandardListJSONClassinCharge(int branchid) {
		List<String> getStandardList = new ArrayList<>();
		getStandardList = classInChargeServiceInterface.getStandardList(branchid);
		return getStandardList;
	}

	@RequestMapping(value = "AssignClassIncharge", params = "Assignclass")
	public ModelAndView AssignClassIncharge(Model model, HttpServletRequest request,
			AssignClassInchargeModel assignClassInchargeModel) {
		System.out.println("Assign Teacher Class");

		int YearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);

		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		int TeacherID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(TeacherID);

		List<String> GetListAvailableOrnot;
		GetListAvailableOrnot = classInChargeServiceInterface.getDataList(YearID, StreamID, BranchID, StandardID);

		if (GetListAvailableOrnot.size() == 0) {
			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(YearID);
			assignClassInchargeModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(StreamID);
			assignClassInchargeModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(BranchID);
			assignClassInchargeModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(StandardID);
			assignClassInchargeModel.setStandardMasterModel(standardMasterModel);

			StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
			staffRegistrationModel.setStaffRegistrationId(TeacherID);
			assignClassInchargeModel.setStaffRegistrationModel(staffRegistrationModel);

			classInChargeServiceInterface.saveAssignValues(assignClassInchargeModel);

			HashMap<String, String> YearList;
			YearList = classInChargeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = classInChargeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = classInChargeServiceInterface.getTeachingStaff();

			model.addAttribute("TeacherList", TeacherList);

			List<String> getAssignClassInChargeList;
			getAssignClassInChargeList = classInChargeServiceInterface.getAssignInchargeList();
			System.out.println(getAssignClassInChargeList);
			model.addAttribute("getAssignClassInChargeList", getAssignClassInChargeList);

			return new ModelAndView("ClassInChargeAssignPage");
		} else {
			
			classInChargeServiceInterface.updateClassInChargeAssignValue(YearID,StreamID,BranchID,StandardID,TeacherID);
			
			HashMap<String, String> YearList;
			YearList = classInChargeServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = classInChargeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<Integer, String> TeacherList;
			TeacherList = classInChargeServiceInterface.getTeachingStaff();

			model.addAttribute("TeacherList", TeacherList);

			List<String> getAssignClassInChargeList;
			getAssignClassInChargeList = classInChargeServiceInterface.getAssignInchargeList();
			System.out.println(getAssignClassInChargeList);
			model.addAttribute("getAssignClassInChargeList", getAssignClassInChargeList);

			return new ModelAndView("ClassInChargeAssignPage");
		}

	}

	/*@RequestMapping(value = "AssignClassIncharge", params = "DisAssignclass")
	public ModelAndView AssignClassInchargeDis(HttpServletRequest request, Model model) {
		System.out.println("Dis Asssign Class Incharge");

		int YearID = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(YearID);

		int StreamID = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(StreamID);

		int BranchID = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(BranchID);

		int StandardID = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(StandardID);

		int TeacherID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(TeacherID);

		classInChargeServiceInterface.setClassInchargeDisAssignClass(YearID, StreamID, BranchID, StandardID, TeacherID);

		HashMap<String, String> YearList;
		YearList = classInChargeServiceInterface.GetYearList();
		System.out.println(YearList);
		model.addAttribute("YearList", YearList);

		HashMap<String, String> StreamList;
		StreamList = classInChargeServiceInterface.getStreamList();
		System.out.println(StreamList);
		model.addAttribute("StreamList", StreamList);

		HashMap<Integer, String> TeacherList;
		TeacherList = classInChargeServiceInterface.getTeachingStaff();

		model.addAttribute("TeacherList", TeacherList);

		List<String> getAssignClassInChargeList;
		getAssignClassInChargeList = classInChargeServiceInterface.getAssignInchargeList();
		System.out.println(getAssignClassInChargeList);
		model.addAttribute("getAssignClassInChargeList", getAssignClassInChargeList);

		return new ModelAndView("ClassInChargeAssignPage");
	}
*/
	@RequestMapping("deleterow")
	@ResponseBody
	public String deleterow(String elementid) {
		String str = classInChargeServiceInterface.deleteClassInChrage(elementid);
		System.out.println("deleting row");
		return str;
	}

	@RequestMapping("AssignDepartment")
	public ModelAndView assignDeparment(Model model,
			@ModelAttribute("AssignDepartmentCommand") AssignDepartmentmodel assignDepartmentmodel,
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = subjectMasterServiceInterface.CheckAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap<Integer, String> TeacherList;
			TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
			model.addAttribute("TeacherList", TeacherList);

			List<String> GetAssignDepartmentList;
			GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
			System.out.println(GetAssignDepartmentList);
			model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

			return new ModelAndView("AssignDepartment");
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

/*	@RequestMapping(value = "AssignDepartmentAction", params = "Assignclass")
	public ModelAndView saveDeparment(Model model,
			@ModelAttribute("AssignDepartmentCommand") AssignDepartmentmodel assignDepartmentmodel,
			HttpServletRequest request) {

		System.out.println("Save Deparment Action");

		int StaffID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(StaffID);

		StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
		staffRegistrationModel.setStaffRegistrationId(StaffID);
		assignDepartmentmodel.setStaffRegistrationModel(staffRegistrationModel);

		String departmentName = request.getParameter("Department");
		System.out.println(departmentName);

		List<String> DepartmentList;
		DepartmentList = assignDepartmentServiceInterface.getDepartmentList(departmentName, StaffID);
		System.out.println(DepartmentList);

		if (DepartmentList.size() == 0) {
			assignDepartmentServiceInterface.saveAssignDepartment(assignDepartmentmodel);

			HashMap<Integer, String> TeacherList;
			TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
			model.addAttribute("TeacherList", TeacherList);

			List<String> GetAssignDepartmentList;
			GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
			System.out.println(GetAssignDepartmentList);
			model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

			return new ModelAndView("AssignDepartment");
		} else {
			HashMap<Integer, String> TeacherList;
			TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
			model.addAttribute("TeacherList", TeacherList);

			List<String> GetAssignDepartmentList;
			GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
			System.out.println(GetAssignDepartmentList);
			model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

			return new ModelAndView("AssignDepartment");
		}

	}
*/

	
	@RequestMapping(value = "AssignDepartmentAction", params = "Assignclass")
	public ModelAndView saveDeparment(Model model,
			@ModelAttribute("AssignDepartmentCommand") AssignDepartmentmodel assignDepartmentmodel,
			HttpServletRequest request) {

		System.out.println("Save Deparment Action");

		int StaffID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(StaffID);

		StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
		staffRegistrationModel.setStaffRegistrationId(StaffID);
		assignDepartmentmodel.setStaffRegistrationModel(staffRegistrationModel);

		String departmentName = request.getParameter("Department");
		System.out.println(departmentName);

		List<String> DepartmentList;
		DepartmentList = assignDepartmentServiceInterface.getDepartmentList1(departmentName);
		System.out.println(DepartmentList);

		if (DepartmentList.size() == 0) {
			assignDepartmentServiceInterface.saveAssignDepartment(assignDepartmentmodel);

			HashMap<Integer, String> TeacherList;
			TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
			model.addAttribute("TeacherList", TeacherList);

			List<String> GetAssignDepartmentList;
			GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
			System.out.println(GetAssignDepartmentList);
			model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

			return new ModelAndView("AssignDepartment");
		} else {
						
			assignDepartmentServiceInterface.updateAssignDepartment(departmentName,StaffID);
			
			HashMap<Integer, String> TeacherList;
			TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
			model.addAttribute("TeacherList", TeacherList);

			List<String> GetAssignDepartmentList;
			GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
			System.out.println(GetAssignDepartmentList);
			model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

			return new ModelAndView("AssignDepartment");
		}

	}
		
	/*@RequestMapping(value = "AssignDepartmentAction", params = "DisAssignclass")
	public ModelAndView RemoveAuthorityDepartment(Model model,
			@ModelAttribute("AssignDepartmentCommand") AssignDepartmentmodel assignDepartmentmodel,
			HttpServletRequest request) {
		System.out.println("Remove Authority Department");

		int StaffID = Integer.parseInt(request.getParameter("TeacherID"));
		System.out.println(StaffID);

		String departmentName = request.getParameter("Department");
		System.out.println(departmentName);

		assignDepartmentServiceInterface.removeDepartmentAuthority(StaffID, departmentName);

		HashMap<Integer, String> TeacherList;
		TeacherList = assignDepartmentServiceInterface.getTeachingStaff();
		model.addAttribute("TeacherList", TeacherList);

		List<String> GetAssignDepartmentList;
		GetAssignDepartmentList = assignDepartmentServiceInterface.getAssignList();
		System.out.println(GetAssignDepartmentList);
		model.addAttribute("GetAssignDepartmentList", GetAssignDepartmentList);

		return new ModelAndView("AssignDepartment");
	}*/

	public ClassInChargeServiceInterface getClassInChargeServiceInterface() {
		return classInChargeServiceInterface;
	}

	public void setClassInChargeServiceInterface(ClassInChargeServiceInterface classInChargeServiceInterface) {
		this.classInChargeServiceInterface = classInChargeServiceInterface;
	}

	public AssignDepartmentServiceInterface getAssignDepartmentServiceInterface() {
		return assignDepartmentServiceInterface;
	}

	public void setAssignDepartmentServiceInterface(AssignDepartmentServiceInterface assignDepartmentServiceInterface) {
		this.assignDepartmentServiceInterface = assignDepartmentServiceInterface;
	}

	public SubjectMasterServiceInterface getSubjectMasterServiceInterface() {
		return subjectMasterServiceInterface;
	}

	public void setSubjectMasterServiceInterface(SubjectMasterServiceInterface subjectMasterServiceInterface) {
		this.subjectMasterServiceInterface = subjectMasterServiceInterface;
	}

}
