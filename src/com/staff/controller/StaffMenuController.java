package com.staff.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.AssignClassInchargeModel;
import com.HOD.model.HODSubjectMasterModel;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.staff.model.StudentAttendance;
import com.staff.model.StudentEnteryOfAttendance;
import com.staff.serviceInterface.ReportStaffServiceInterface;
import com.staff.serviceInterface.StaffClassInChargeServiceInterface;
import com.staff.serviceInterface.StaffMenuServiceInterface;
import com.student.model.StudentAdmissionModel;

@Controller
public class StaffMenuController {

	@Autowired
	private StaffMenuServiceInterface staffMenuServiceInterface;

	@Autowired
	private StaffClassInChargeServiceInterface staffClassInChargeServiceInterface;

	@Autowired
	private ReportStaffServiceInterface reportStaffServiceInterface;
	
	public ReportStaffServiceInterface getReportStaffServiceInterface() {
		return reportStaffServiceInterface;
	}

	public void setReportStaffServiceInterface(ReportStaffServiceInterface reportStaffServiceInterface) {
		this.reportStaffServiceInterface = reportStaffServiceInterface;
	}

	public StaffClassInChargeServiceInterface getStaffClassInChargeServiceInterface() {
		return staffClassInChargeServiceInterface;
	}

	public void setStaffClassInChargeServiceInterface(
			StaffClassInChargeServiceInterface staffClassInChargeServiceInterface) {
		this.staffClassInChargeServiceInterface = staffClassInChargeServiceInterface;
	}

	public StaffMenuServiceInterface getStaffMenuServiceInterface() {
		return staffMenuServiceInterface;
	}

	public void setStaffMenuServiceInterface(StaffMenuServiceInterface staffMenuServiceInterface) {
		this.staffMenuServiceInterface = staffMenuServiceInterface;
	}

	@RequestMapping("CheckStaffHasAssignSubject")
	public ModelAndView CheckStaffHasAssignSubject(Model model, HttpSession httpSession, HttpServletRequest request) {
		System.out.println("Check Staff Has Assign Subject");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> CheckSubjectAssignOrNot;
			CheckSubjectAssignOrNot = staffMenuServiceInterface.GetCheckAvability(StaffID);
			System.out.println(CheckSubjectAssignOrNot);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			HashMap<String, String> YearList;
			YearList = staffMenuServiceInterface.GetYearList(StaffID);
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = staffMenuServiceInterface.GetStreamList(StaffID);
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> BranchList;
			BranchList = staffMenuServiceInterface.GetBranchlist(StaffID);
			System.out.println(BranchList);
			model.addAttribute("BranchList", BranchList);

			HashMap<String, String> StandardList;
			StandardList = staffMenuServiceInterface.GetStandardList(StaffID);
			System.out.println(StandardList);
			model.addAttribute("StandardList", StandardList);

			HashMap<String, String> SubjectList;
			SubjectList = staffMenuServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);
			model.addAttribute("SubjectList", SubjectList);

			if (CheckSubjectAssignOrNot.size() == 0) {
				System.out.println("Staff Has No Subject Assgin ");

				return new ModelAndView("StaffNotAssignSubjectPage");
			} else {
				System.out.println("Staff has Assign Subject");

				return new ModelAndView("StaffAssignSubjectPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}

	}

	@RequestMapping("getStudentListJSONSubjectAssignStaff")
	@ResponseBody
	public List<String> getStudentListJSONSubjectAssignStaff(int YearID, int StreamID, int branchID, int standardID,
			int SubjectID) {
		List<String> GetStudentList;
		GetStudentList = staffMenuServiceInterface.GetStudentList(YearID, StreamID, branchID, standardID, SubjectID);
		System.out.println(GetStudentList);
		return GetStudentList;
	}

	@RequestMapping(value = "TakeAttendanceSubjectVis", params = "SubjectVisAttendence")
	public ModelAndView TakeAttendanceSubjectVis(HttpServletRequest request, Model model) {
		System.out.println("Take Attendance Subject Vis");

		String CurrrentDate = request.getParameter("DateCurrent");
		System.out.println(CurrrentDate);

		String LectStartTime = request.getParameter("LectStartTime");
		System.out.println(LectStartTime);

		String LectEndTime = request.getParameter("LectEndTime");
		System.out.println(LectEndTime);

		int NumberofLect = Integer.parseInt(request.getParameter("NumberOflectSub"));
		System.out.println(NumberofLect);

		int yearId = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(yearId);

		int streamId = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(streamId);

		int branchId = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(branchId);

		int standardId = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(standardId);

		int subjectId = Integer.parseInt(request.getParameter("SubjectID"));
		System.out.println(subjectId);

		StudentAttendance studentAttendance = new StudentAttendance();
		studentAttendance.setCurrentDate(CurrrentDate);
		studentAttendance.setLectStartTimeDate(LectStartTime);
		studentAttendance.setLectEndTimeDate(LectEndTime);
		studentAttendance.setNumberOfLect(NumberofLect);

		acadamicYearModel acadamicYearModel = new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearId);
		studentAttendance.setAcadamicYearModel(acadamicYearModel);

		BranchMasterModel branchMasterModel = new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		studentAttendance.setBranchMasterModel(branchMasterModel);

		StreamMasterModel streamMasterModel = new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		studentAttendance.setStreamMasterModel(streamMasterModel);

		StandardMasterModel standardMasterModel = new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		studentAttendance.setStandardMasterModel(standardMasterModel);

		HODSubjectMasterModel hodSubjectMasterModel = new HODSubjectMasterModel();
		hodSubjectMasterModel.setSubjectID(subjectId);
		studentAttendance.setHodSubjectMasterModel(hodSubjectMasterModel);

		staffMenuServiceInterface.saveSubjectVisStudentAttendance(studentAttendance);

		int StudentAttendanceID = 0;
		StudentAttendanceID = staffMenuServiceInterface.getMaxStudentAttendanceID();
		System.out.println("SttendanceID" + StudentAttendanceID);

		int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println(studentCount);
		studentCount=studentCount+100000;

		StudentEnteryOfAttendance studentEnteryOfAttendance = new StudentEnteryOfAttendance();

		String selectedStudent;
		for (int i = 0; i <= studentCount; i++) {
			selectedStudent = request.getParameter("StudID" + i);
			if (selectedStudent == null) {
				continue;
			}
			System.out.println(selectedStudent);
			int StudentID = Integer.parseInt(selectedStudent);
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(StudentID);
			studentEnteryOfAttendance.setStudentAdmissionModel(studentAdmissionModel);

			StudentAttendance studentAttendance2 = new StudentAttendance();
			studentAttendance2.setAttendanceID(StudentAttendanceID);
			studentEnteryOfAttendance.setStudentAttendance(studentAttendance2);

			staffMenuServiceInterface.saveStudentAttendanceBySubjectVis(studentEnteryOfAttendance);
		}
		model.addAttribute("MessageOfAttendance", "Student Attendance is Successfully Save...");

		List<String> StudentList;
		StudentList = reportStaffServiceInterface.getStudentList(subjectId);
		System.out.println(StudentList);
		model.addAttribute("AbsentStudentList", StudentList);
		
		List<Object[]> getStudentD;
		getStudentD = reportStaffServiceInterface.getPresentStudentList(subjectId);
		System.out.println(getStudentD);

		Integer AttendenceID=0;
		Integer YearID=0;
		Integer StreamID=0;
		Integer BranchID=0;
		Integer StandardID=0;
		
		for(Object[] obj:getStudentD)
		{
			AttendenceID=(Integer)obj[0];
			YearID=(Integer)obj[1];
			BranchID=(Integer) obj[2];
			StandardID=(Integer)obj[3];
			StreamID=(Integer)obj[4];
		}
		System.out.println(AttendenceID);
		System.out.println(YearID);
		System.out.println(StreamID);
		System.out.println(BranchID);
		System.out.println(StandardID);
		
		List<String> getStudentPresentList;
		getStudentPresentList=reportStaffServiceInterface.getStudentPresentList(AttendenceID,YearID,BranchID,StandardID,StreamID);
		System.out.println(getStudentPresentList);
		
		model.addAttribute("PresentStudentList",getStudentPresentList);
	
		return new ModelAndView("StudentAttendenceViewPage");
	}

	@RequestMapping("CheckAttendenceByClassIncharge")
	public ModelAndView CheckStaffIsClassIncharge(Model model, HttpSession httpSession, HttpServletRequest request) {
		System.out.println("Check Staff Is Class Incharge");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffClassInChargeServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			List<String> CheckClassInchargeOrNot;
			CheckClassInchargeOrNot = staffClassInChargeServiceInterface.CheckClassInchargeOrNot(StaffID);
			System.out.println(CheckClassInchargeOrNot);

			if (CheckClassInchargeOrNot.size() == 0) {
				System.out.println("Staff Is Not Class INCharge ");

				return new ModelAndView("StaffNotClassInchargePage");
			} else {
				System.out.println("Staff has Assign Subject");

				List<Object[]> getStaffDetails;
				getStaffDetails = staffClassInChargeServiceInterface.getPresentClassInchargeDetails(StaffID);
				System.out.println(getStaffDetails);
				
				Integer YearID=0;
				Integer StreamID=0;
				Integer BranchID=0;
				Integer StandardID=0;
				
				for(Object[] obj:getStaffDetails)
				{
					YearID=(Integer)obj[1];
					BranchID=(Integer) obj[2];
					StandardID=(Integer)obj[3];
					StreamID=(Integer)obj[4];
				}
				System.out.println(YearID);
				System.out.println(StreamID);
				System.out.println(BranchID);
				System.out.println(StandardID);
				
				List<String> getAbsentStudentList;
				getAbsentStudentList=staffClassInChargeServiceInterface.getStudentAbsentList(YearID,StreamID,BranchID,StandardID);
				System.out.println(getAbsentStudentList);
				model.addAttribute("AbsentStudentList",getAbsentStudentList);
				
				/*List<String> getStudentPresentList;
				getStudentPresentList=staffClassInChargeServiceInterface.getStudentPresentList(YearID,BranchID,StandardID,StreamID);
				System.out.println(getStudentPresentList);
				model.addAttribute("PresentStudent",getStudentPresentList);*/
				
				return new ModelAndView("StaffClassInchargePage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}
	}

	@RequestMapping("getStudentListJSONClassInCharge")
	@ResponseBody
	public List<String> getStudentListJSONClassInCharge(int YearID, int StreamID, int branchID, int standardID) {
		List<String> StudentList;
		StudentList = staffClassInChargeServiceInterface.getStudentList(YearID, StreamID, branchID, standardID);
		System.out.println(StudentList);
		return StudentList;
	}

	@RequestMapping(value = "TakeAttendanceByClassIncharge", params = "AttendanceByClassIncharge")
	public ModelAndView TakeAttendanceByClassIncharge(HttpServletRequest request, Model model) {
		System.out.println("Take Attendance By Class Incharge");

		String CurrrentDate = request.getParameter("DateCurrent");
		System.out.println(CurrrentDate);

		/*
		 * String LectStartTime = request.getParameter("LectStartTime");
		 * System.out.println(LectStartTime);
		 * 
		 * String LectEndTime = request.getParameter("LectEndTime");
		 * System.out.println(LectEndTime);
		 * 
		 * int NumberofLect =
		 * Integer.parseInt(request.getParameter("NumberOflectSub"));
		 * System.out.println(NumberofLect);
		 */
		int yearId = Integer.parseInt(request.getParameter("YearID"));
		System.out.println(yearId);

		int streamId = Integer.parseInt(request.getParameter("StreamID"));
		System.out.println(streamId);

		int branchId = Integer.parseInt(request.getParameter("branchID"));
		System.out.println(branchId);

		int standardId = Integer.parseInt(request.getParameter("standardID"));
		System.out.println(standardId);
		/*
		 * int studentCount =
		 * Integer.parseInt(request.getParameter("CheckCount"));
		 * System.out.println(studentCount);
		 * 
		 * StudentAttendance studentAttendance=new StudentAttendance();
		 * studentAttendance.setCurrentDate(CurrrentDate);
		 * studentAttendance.setLectStartTimeDate(LectStartTime);
		 * studentAttendance.setLectEndTimeDate(LectEndTime);
		 * studentAttendance.setNumberOfLect(NumberofLect);
		 * 
		 * acadamicYearModel acadamicYearModel=new acadamicYearModel();
		 * acadamicYearModel.setAcadamicYearId(yearId);
		 * studentAttendance.setAcadamicYearModel(acadamicYearModel);
		 * 
		 * BranchMasterModel branchMasterModel=new BranchMasterModel();
		 * branchMasterModel.setBranchId(branchId);
		 * studentAttendance.setBranchMasterModel(branchMasterModel);
		 * 
		 * StreamMasterModel streamMasterModel=new StreamMasterModel();
		 * streamMasterModel.setStreamId(streamId);
		 * studentAttendance.setStreamMasterModel(streamMasterModel);
		 * 
		 * StandardMasterModel standardMasterModel=new StandardMasterModel();
		 * standardMasterModel.setStandardId(standardId);
		 * studentAttendance.setStandardMasterModel(standardMasterModel);
		 */

		// staffMenuServiceInterface.saveAttendanceByClassIncharge(studentAttendance);

		/*
		 * int StudentAttendanceID=0;
		 * StudentAttendanceID=staffMenuServiceInterface.
		 * getMaxStudentAttendanceID();
		 * System.out.println("SttendanceID"+StudentAttendanceID);
		 * 
		 * StudentEnteryOfAttendance studentEnteryOfAttendance=new
		 * StudentEnteryOfAttendance();
		 * 
		 * String selectedStudent; for (int i = 0; i <= studentCount; i++) {
		 * selectedStudent = request.getParameter("StudID" + i); if
		 * (selectedStudent == null) { continue; }
		 * System.out.println(selectedStudent); int
		 * StudentID=Integer.parseInt(selectedStudent); StudentAdmissionModel
		 * studentAdmissionModel=new StudentAdmissionModel();
		 * studentAdmissionModel.setAdmissionRegId(StudentID);
		 * studentEnteryOfAttendance.setStudentAdmissionModel(
		 * studentAdmissionModel);
		 * 
		 * StudentAttendance studentAttendance2=new StudentAttendance();
		 * studentAttendance2.setAttendanceID(StudentAttendanceID);
		 * studentEnteryOfAttendance.setStudentAttendance(studentAttendance2);
		 * 
		 * //staffMenuServiceInterface.saveStudentAttendanceByClassInCharge(
		 * studentEnteryOfAttendance); }
		 */
		model.addAttribute("MessageOfAttendance", "Student Attendance is Successfully Save...");
		return new ModelAndView("StaffHomePage");
	}

	@RequestMapping("StudentStaffIsClassInCharge")
	public ModelAndView StudentStaffIsClassInCharge(Model model, HttpSession httpSession, HttpServletRequest request) {
		System.out.println("StudentStaffIsClassInCharge");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffClassInChargeServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			List<String> CheckClassInchargeOrNot;
			CheckClassInchargeOrNot = staffClassInChargeServiceInterface.CheckClassInchargeOrNot(StaffID);
			System.out.println(CheckClassInchargeOrNot);

			HashMap<String, String> YearList;
			YearList = staffClassInChargeServiceInterface.GetYearList(StaffID);
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = staffClassInChargeServiceInterface.GetStreamList(StaffID);
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> BranchList;
			BranchList = staffClassInChargeServiceInterface.GetBranchlist(StaffID);
			System.out.println(BranchList);
			model.addAttribute("BranchList", BranchList);

			HashMap<String, String> StandardList;
			StandardList = staffClassInChargeServiceInterface.GetStandardList(StaffID);
			System.out.println(StandardList);
			model.addAttribute("StandardList", StandardList);

			if (CheckClassInchargeOrNot.size() == 0) {
				System.out.println("Staff Is Not Class IN Charge ");

				return new ModelAndView("StaffNotClassInchargePage");
			} else {
				System.out.println("Staff has Assign Class Incharge");

				return new ModelAndView("StudentStaffAttendencePage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}

	}

	@RequestMapping(value = "getSubjectListJSON")
	@ResponseBody
	public List<String> getSubjectListJSON(int YearID, int StreamID, int branchID, int standardID) {
		System.out.println("getSubjectListJSON");

		List<String> getSubjectList;
		getSubjectList = staffMenuServiceInterface.getSubjectListStaff(YearID, StreamID, branchID, standardID);
		System.out.println(getSubjectList);

		return getSubjectList;
	}

	/* Get Attendance of Student bY subject */
	@RequestMapping(value = "getStudentAttendanceBySub",params="getdata")
	public ModelAndView getAttedanceBySubject(Model model, HttpServletRequest request) {
		
		System.out.println("Student Attendence Subject");
		int yrId = Integer.parseInt(request.getParameter("YearID"));
		int streamId = Integer.parseInt(request.getParameter("StreamID"));
		int BranchId = Integer.parseInt(request.getParameter("branchID"));
		int StandId = Integer.parseInt(request.getParameter("standardID"));
		int subId = Integer.parseInt(request.getParameter("subjectID"));

		/* total number of lecture */
		List totalNoOFLect = staffMenuServiceInterface.gettotalNoOFLect(yrId, streamId, BranchId, StandId, subId);
		
		System.out.println(totalNoOFLect.get(0));

		
		
		
		/* List OF Student */
		List<Object[]> ListofStudent = new ArrayList<>();
		ListofStudent = staffMenuServiceInterface.getstudentListForAtt(yrId, streamId, BranchId, StandId, subId);
		System.out.println("ListofStudent"+ListofStudent);
		
		for(int i=0;i<ListofStudent.size();i++){
			Object[] oneStudent = ListofStudent.get(i);
			for(int j=0;j< oneStudent.length;j++){
				int RollNumber= (int) oneStudent[0];
				System.out.println(RollNumber);
				String StudentName= oneStudent[1]+" "+oneStudent[2]+" "+oneStudent[3];
				System.out.println(StudentName);
			}
			 System.out.println("out is "+ListofStudent.get(i));
			}
		
		return new ModelAndView("StudentStaffAttendencePage");

		/*
		 * SELECT sum(a.NumberOfLect) FROM studententeryofattendance s left join
		 * studentattendance a on a.AttendanceID=s.AttendanceID where
		 * s.admissionRegId='4';
		 */

	}

}
