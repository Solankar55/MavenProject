package com.staff.controller;

import java.text.SimpleDateFormat;
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

import com.HOD.model.HODSubjectMasterModel;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.staff.model.StudentAssignmentEnteryReportModel;
import com.staff.model.StudentAssignmentModel;
import com.staff.serviceInterface.AssignmentToStudentServiceInterface;
import com.student.model.StudentAdmissionModel;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentToStudentServiceInterface assignmentToStudentServiceInterface;
	
	public AssignmentToStudentServiceInterface getAssignmentToStudentServiceInterface() {
		return assignmentToStudentServiceInterface;
	}

	public void setAssignmentToStudentServiceInterface(
			AssignmentToStudentServiceInterface assignmentToStudentServiceInterface) {
		this.assignmentToStudentServiceInterface = assignmentToStudentServiceInterface;
	}

	@RequestMapping("GiveAssignmentToStudent")
	public ModelAndView GiveAssignmentToStudent(Model model,HttpSession httpSession,HttpServletRequest request)
	{
		System.out.println("Give Assignment To Student");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = assignmentToStudentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<String> CheckSubjectAssignOrNot;
			CheckSubjectAssignOrNot = assignmentToStudentServiceInterface.GetCheckAvability(StaffID);
			System.out.println(CheckSubjectAssignOrNot);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);

			HashMap<String, String> YearList;
			YearList = assignmentToStudentServiceInterface.GetYearList(StaffID);
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = assignmentToStudentServiceInterface.GetStreamList(StaffID);
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			HashMap<String, String> BranchList;
			BranchList = assignmentToStudentServiceInterface.GetBranchlist(StaffID);
			System.out.println(BranchList);
			model.addAttribute("BranchList", BranchList);

			HashMap<String, String> StandardList;
			StandardList = assignmentToStudentServiceInterface.GetStandardList(StaffID);
			System.out.println(StandardList);
			model.addAttribute("StandardList", StandardList);

			HashMap<String, String> SubjectList;
			SubjectList = assignmentToStudentServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);
			model.addAttribute("SubjectList", SubjectList);

			if (CheckSubjectAssignOrNot.size() == 0) {
				System.out.println("Staff Has No Subject Assgin ");

				return new ModelAndView("StaffNotAssignSubjectPage");
			} else {
				System.out.println("Staff has Assign Subject");

				return new ModelAndView("GiveAssignmentPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}

		
		//return new ModelAndView("GiveAssignmentPage");
	}
	
	@RequestMapping(value="getStudentListJSONSubjectAssignStaffToSendMessage")
	@ResponseBody
	public List<String> getStudentListJSONSubjectAssignStaffToSendMessage(int YearID, int StreamID, int branchID, int standardID,
			int SubjectID) {
		List<String> GetStudentList;
		GetStudentList = assignmentToStudentServiceInterface.GetStudentList(YearID, StreamID, branchID, standardID, SubjectID);
		System.out.println(GetStudentList);
		return GetStudentList;
	}

	@RequestMapping(value="GiveAssignmentToStudentSubjectVis",params="SendMessage")
	public ModelAndView GiveAssignmentToStudentSubjectVis(HttpServletRequest request,Model model)
	{
		System.out.println("Give Assignment To Student Subject Vis");
		
		String CurrrentDate = request.getParameter("DateCurrent");
		System.out.println(CurrrentDate);
		
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
		
		String StudentAssignment=request.getParameter("StudentAssignment");
		System.out.println(StudentAssignment);
		
		int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println(studentCount);
		studentCount=studentCount+1;
		
		StudentAssignmentModel studentAssignmentModel=new StudentAssignmentModel();
		studentAssignmentModel.setAssignmentDate(CurrrentDate);
		studentAssignmentModel.setAssignmentMessage(StudentAssignment);
		
		acadamicYearModel acadamicYearModel=new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearId);
		studentAssignmentModel.setAcadamicYearModel(acadamicYearModel);
		
		StreamMasterModel streamMasterModel=new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		studentAssignmentModel.setStreamMasterModel(streamMasterModel);
		
		BranchMasterModel branchMasterModel=new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		studentAssignmentModel.setBranchMasterModel(branchMasterModel);
		
		StandardMasterModel standardMasterModel=new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		studentAssignmentModel.setStandardMasterModel(standardMasterModel);
		
		HODSubjectMasterModel hodSubjectMasterModel=new HODSubjectMasterModel();
		hodSubjectMasterModel.setSubjectID(subjectId);
		studentAssignmentModel.setHodSubjectMasterModel(hodSubjectMasterModel);
		
		assignmentToStudentServiceInterface.saveStudentAssignment(studentAssignmentModel);
		
		int AssignmentID=0;
		AssignmentID=assignmentToStudentServiceInterface.getMaxAssignmentID();
		System.out.println(AssignmentID);
		
		StudentAssignmentEnteryReportModel studentAssignmentEnteryReportModel=new StudentAssignmentEnteryReportModel();
				
		String selectedStudent;
		for (int i = 0; i <= studentCount; i++) {
			selectedStudent = request.getParameter("StudID" + i);
			if (selectedStudent == null) {
				continue;
			}
			System.out.println(selectedStudent);
			int StudentID=Integer.parseInt(selectedStudent);
			StudentAdmissionModel studentAdmissionModel=new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(StudentID);
			studentAssignmentEnteryReportModel.setStudentAdmissionModel(studentAdmissionModel);
			
			StudentAssignmentModel studentAssignmentModel2=new StudentAssignmentModel();
			studentAssignmentModel2.setAssignmentID(AssignmentID);
			studentAssignmentEnteryReportModel.setStudentAssignmentModel(studentAssignmentModel2);
			
			assignmentToStudentServiceInterface.saveStudentRecordWithAssignment(studentAssignmentEnteryReportModel);
		}
		model.addAttribute("MessageOfAssignment","Student Get Assignment Successfully ...");
		
		return new ModelAndView("StaffHomePage");
	}
}
