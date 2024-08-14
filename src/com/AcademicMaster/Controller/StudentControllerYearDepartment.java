package com.AcademicMaster.Controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.AcademicMaster.model.StudentAttendanceNoticeModel;
import com.AcademicMaster.model.StudentAttendanceNoticeStudentEnteryModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.AcademicMaster.serviceInterface.StudentControllerYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.util.FixKareSMS;

@Controller
public class StudentControllerYearDepartment {

	@Autowired
	private StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface;

	public StudentControllerYearDepartmentServiceInterface getStudentControllerYearDepartmentServiceInterface() {
		return studentControllerYearDepartmentServiceInterface;
	}

	public void setStudentControllerYearDepartmentServiceInterface(
			StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface) {
		this.studentControllerYearDepartmentServiceInterface = studentControllerYearDepartmentServiceInterface;
	}

	@RequestMapping("NoticeForStudent")
	public ModelAndView NoticeForStudent(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("NoticeForStudent");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentControllerYearDepartmentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			HashMap<String, String> YearList;
			YearList = studentControllerYearDepartmentServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentControllerYearDepartmentServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("NoticeForStudentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonStandardForYear", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = studentControllerYearDepartmentServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandardForYear", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = studentControllerYearDepartmentServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "StudentStandardWiseRecord", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardWiseRecord(int yearId, int streamid, int branchid, int standardID) {
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList = new ArrayList<>();
		StudentStandardList = studentControllerYearDepartmentServiceInterface.getStandardWiseList(yearId, streamid,
				branchid, standardID);
		System.out.println(StudentStandardList);

		return StudentStandardList;
	}

	@RequestMapping(value = "SendNoticeToStudent", params = "SendNotice")
	public ModelAndView SendNoticeToStudent(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("Send Notice To Student");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {
			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			int yearId = Integer.parseInt(request.getParameter("YearName"));
			System.out.println(yearId);

			int streamId = Integer.parseInt(request.getParameter("StreamID"));
			System.out.println(streamId);

			int branchId = Integer.parseInt(request.getParameter("branchName"));
			System.out.println(branchId);

			int standardId = Integer.parseInt(request.getParameter("standardName"));
			System.out.println(standardId);

			String StudentNotice = request.getParameter("StudentNotice");
			System.out.println(StudentNotice);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentNoticeModel studentNoticeModel = new StudentNoticeModel();
			studentNoticeModel.setNoticeDate(CurrrentDate);
			studentNoticeModel.setStudentNotice(StudentNotice);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentNoticeModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentNoticeModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentNoticeModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentNoticeModel.setStandardMasterModel(standardMasterModel);

			studentNoticeModel.setTeacherName(username);

			studentControllerYearDepartmentServiceInterface.saveStudentNoticeModel(studentNoticeModel);

			int noticeMaxID = 0;
			noticeMaxID = studentControllerYearDepartmentServiceInterface.getMaxNoticeID();
			System.out.println("noticeMaxID : " + noticeMaxID);

			/*
			 * int AssignmentID=0;
			 * AssignmentID=assignmentToStudentServiceInterface.
			 * getMaxAssignmentID(); System.out.println(AssignmentID);
			 */
			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel = new StudentNoticeStudentEnteryModel();
				StudentNoticeModel studentModel = new StudentNoticeModel();
				studentModel.setNoticeID(noticeMaxID);
				studentNoticeStudentEnteryModel.setStudentNoticeModel(studentNoticeModel);
				;

				// StudentNoticeStudentEnteryModel
				// studentNoticeStudentEnteryModel2=new
				// StudentNoticeStudentEnteryModel();
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				studentNoticeStudentEnteryModel.setStudentAdmissionModel(studentAdmissionModel);

				studentControllerYearDepartmentServiceInterface
						.saveStudentNoticeStudentEntryModel(studentNoticeStudentEnteryModel);

			}

			model.addAttribute("MessageOfNoticeStudent", "Student Get Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}

	}

	@RequestMapping(value = "SendNoticeToStudent", params = "SendSMS")
	public ModelAndView SendNoticeToStudentSMS(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("Send Notice To Student");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {
			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			int yearId = Integer.parseInt(request.getParameter("YearName"));
			System.out.println(yearId);

			int streamId = Integer.parseInt(request.getParameter("StreamID"));
			System.out.println(streamId);

			int branchId = Integer.parseInt(request.getParameter("branchName"));
			System.out.println(branchId);

			int standardId = Integer.parseInt(request.getParameter("standardName"));
			System.out.println(standardId);

			String StudentNotice = request.getParameter("StudentNotice");
			System.out.println(StudentNotice);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentNoticeModel studentNoticeModel = new StudentNoticeModel();
			studentNoticeModel.setNoticeDate(CurrrentDate);
			studentNoticeModel.setStudentNotice(StudentNotice);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentNoticeModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentNoticeModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentNoticeModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentNoticeModel.setStandardMasterModel(standardMasterModel);

			studentNoticeModel.setTeacherName(username);

			studentControllerYearDepartmentServiceInterface.saveStudentNoticeModel(studentNoticeModel);

			int noticeMaxID = 0;
			noticeMaxID = studentControllerYearDepartmentServiceInterface.getMaxNoticeID();
			System.out.println("noticeMaxID : " + noticeMaxID);

			/*
			 * int AssignmentID=0;
			 * AssignmentID=assignmentToStudentServiceInterface.
			 * getMaxAssignmentID(); System.out.println(AssignmentID);
			 */
			FixKareSMS fixKareSMS=new FixKareSMS();
			
			
			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				StudentNoticeStudentEnteryModel studentNoticeStudentEnteryModel = new StudentNoticeStudentEnteryModel();
				StudentNoticeModel studentModel = new StudentNoticeModel();
				studentModel.setNoticeID(noticeMaxID);
				studentNoticeStudentEnteryModel.setStudentNoticeModel(studentNoticeModel);
				;

				// StudentNoticeStudentEnteryModel
				// studentNoticeStudentEnteryModel2=new
				// StudentNoticeStudentEnteryModel();
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				studentNoticeStudentEnteryModel.setStudentAdmissionModel(studentAdmissionModel);

				studentControllerYearDepartmentServiceInterface
						.saveStudentNoticeStudentEntryModel(studentNoticeStudentEnteryModel);

				List<StudentAdmissionModel> StudentCOntactNo;
				StudentCOntactNo=studentControllerYearDepartmentServiceInterface.getStudentContactN(studID);
				System.out.println(StudentCOntactNo);
				
				String ContactNo=StudentCOntactNo.get(0).getStudentContactNumber();
				
				try {
					fixKareSMS.sendSMS(ContactNo,StudentNotice);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			model.addAttribute("MessageOfNoticeStudent", "Student Get Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}

	}
	@RequestMapping("AttendanceRelatedMessage")
	public ModelAndView AttendanceRelatedMessage(HttpServletRequest request, HttpSession httpSession, Model model) {
		System.out.println("AttendanceRelatedMessage");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentControllerYearDepartmentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			HashMap<String, String> YearList;
			YearList = studentControllerYearDepartmentServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentControllerYearDepartmentServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("AttendanceRelatedMessagePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "SendAttendanceMessage", params = "AttendanceMessage")
	public ModelAndView SendAttendanceMessage(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("Send Attendance Message");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			int yearId = Integer.parseInt(request.getParameter("YearName"));
			System.out.println(yearId);

			int streamId = Integer.parseInt(request.getParameter("StreamID"));
			System.out.println(streamId);

			int branchId = Integer.parseInt(request.getParameter("branchName"));
			System.out.println(branchId);

			int standardId = Integer.parseInt(request.getParameter("standardName"));
			System.out.println(standardId);

			String AttendanceMessage = request.getParameter("AttendanceMessage");
			System.out.println(AttendanceMessage);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentAttendanceNoticeModel studentAttendanceNoticeModel = new StudentAttendanceNoticeModel();
			studentAttendanceNoticeModel.setNoticeDate(CurrrentDate);
			studentAttendanceNoticeModel.setAttendanceNotice(AttendanceMessage);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentAttendanceNoticeModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentAttendanceNoticeModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentAttendanceNoticeModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentAttendanceNoticeModel.setStandardMasterModel(standardMasterModel);

			studentAttendanceNoticeModel.setTeacherName(username);
			
			studentControllerYearDepartmentServiceInterface
					.saveStudentAttendanceNoticeModel(studentAttendanceNoticeModel);

			int StudentAttendenceNoticeMaxID = 0;
			StudentAttendenceNoticeMaxID = studentControllerYearDepartmentServiceInterface
					.getStudentAttendanceNoticeMaxID();
			System.out.println(StudentAttendenceNoticeMaxID);

			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int StudentID = Integer.parseInt(selectedStudent);
				System.out.println(StudentID);

				StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel = new StudentAttendanceNoticeStudentEnteryModel();

				StudentAttendanceNoticeModel studentAttendanceNoticeModel2 = new StudentAttendanceNoticeModel();
				studentAttendanceNoticeModel2.setStudentAttendenceNoticeID(StudentAttendenceNoticeMaxID);
				studentAttendanceNoticeStudentEnteryModel
						.setStudentAttendanceNoticeModel(studentAttendanceNoticeModel2);

				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(StudentID);
				studentAttendanceNoticeStudentEnteryModel.setStudentAdmissionModel(studentAdmissionModel);

				studentControllerYearDepartmentServiceInterface
						.saveStudentAttendenceNoticeEnteryModel(studentAttendanceNoticeStudentEnteryModel);

			}
			model.addAttribute("MessageOfAttendenceStudent", "Student Get Attendance Related Message Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}

	@RequestMapping(value = "SendAttendanceMessage", params = "SendSMS")
	public ModelAndView SendAttendanceMessageSMS(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("Send Attendance Message");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			FixKareSMS fixKareSMS=new FixKareSMS();
			
			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			int yearId = Integer.parseInt(request.getParameter("YearName"));
			System.out.println(yearId);

			int streamId = Integer.parseInt(request.getParameter("StreamID"));
			System.out.println(streamId);

			int branchId = Integer.parseInt(request.getParameter("branchName"));
			System.out.println(branchId);

			int standardId = Integer.parseInt(request.getParameter("standardName"));
			System.out.println(standardId);

			String AttendanceMessage = request.getParameter("AttendanceMessage");
			System.out.println(AttendanceMessage);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentAttendanceNoticeModel studentAttendanceNoticeModel = new StudentAttendanceNoticeModel();
			studentAttendanceNoticeModel.setNoticeDate(CurrrentDate);
			studentAttendanceNoticeModel.setAttendanceNotice(AttendanceMessage);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentAttendanceNoticeModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentAttendanceNoticeModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentAttendanceNoticeModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentAttendanceNoticeModel.setStandardMasterModel(standardMasterModel);

			studentAttendanceNoticeModel.setTeacherName(username);
			
			studentControllerYearDepartmentServiceInterface
					.saveStudentAttendanceNoticeModel(studentAttendanceNoticeModel);

			int StudentAttendenceNoticeMaxID = 0;
			StudentAttendenceNoticeMaxID = studentControllerYearDepartmentServiceInterface
					.getStudentAttendanceNoticeMaxID();
			System.out.println(StudentAttendenceNoticeMaxID);

			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int StudentID = Integer.parseInt(selectedStudent);
				System.out.println(StudentID);

				StudentAttendanceNoticeStudentEnteryModel studentAttendanceNoticeStudentEnteryModel = new StudentAttendanceNoticeStudentEnteryModel();

				StudentAttendanceNoticeModel studentAttendanceNoticeModel2 = new StudentAttendanceNoticeModel();
				studentAttendanceNoticeModel2.setStudentAttendenceNoticeID(StudentAttendenceNoticeMaxID);
				studentAttendanceNoticeStudentEnteryModel
						.setStudentAttendanceNoticeModel(studentAttendanceNoticeModel2);

				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(StudentID);
				studentAttendanceNoticeStudentEnteryModel.setStudentAdmissionModel(studentAdmissionModel);

				studentControllerYearDepartmentServiceInterface
						.saveStudentAttendenceNoticeEnteryModel(studentAttendanceNoticeStudentEnteryModel);

				List<StudentAdmissionModel> StudentCOntactNo;
				StudentCOntactNo=studentControllerYearDepartmentServiceInterface.getStudentContactN(StudentID);
				System.out.println(StudentCOntactNo);
				
				String ContactNo=StudentCOntactNo.get(0).getStudentContactNumber();
				
				try {
					fixKareSMS.sendSMS(ContactNo,AttendanceMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			model.addAttribute("MessageOfAttendenceStudent", "Student Get Attendance Related Message Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}
}
