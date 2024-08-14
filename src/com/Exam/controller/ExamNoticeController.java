package com.Exam.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.ParentMessageModel;
import com.AcademicMaster.model.StudentNoticeModel;
import com.AcademicMaster.model.StudentNoticeStudentEnteryModel;
import com.Exam.model.ParentExamNoticeEnteryModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeEnteryModel;
import com.Exam.model.StudentExamNoticeModel;
import com.Exam.serviceInterface.ExamNoticeServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.util.FixKareSMS;
import com.util.STCOPSMS;

@Controller
public class ExamNoticeController {

	@Autowired
	private ExamNoticeServiceInterface examNoticeServiceInterface;
	
	public ExamNoticeServiceInterface getExamNoticeServiceInterface() {
		return examNoticeServiceInterface;
	}

	public void setExamNoticeServiceInterface(ExamNoticeServiceInterface examNoticeServiceInterface) {
		this.examNoticeServiceInterface = examNoticeServiceInterface;
	}

	@RequestMapping("StudentExamNotice")
	public ModelAndView StudentExamNotice(Model model,HttpServletRequest request,HttpSession session,HttpServletResponse response)
	{
		System.out.println("StudentExamNotice");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = examNoticeServiceInterface.getStaffList(username);
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
			YearList = examNoticeServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = examNoticeServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("StudentExamNoticePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}
	
	@RequestMapping(value = "GetBranchListJsonStandardForExam", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = examNoticeServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandardForExam", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = examNoticeServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "StudentStandardWiseRecordExam", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardWiseRecord(int yearId, int streamid, int branchid, int standardID) {
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList = new ArrayList<>();
		StudentStandardList = examNoticeServiceInterface.getStandardWiseList(yearId, streamid,
				branchid, standardID);
		System.out.println(StudentStandardList);

		return StudentStandardList;
	}

	@RequestMapping(value = "SendNoticeToStudentExam", params = "SendNotice")
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

			String StudentExamNotice = request.getParameter("StudentExamNotice");
			System.out.println(StudentExamNotice);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentExamNoticeModel studentExamNoticeModel=new StudentExamNoticeModel();
			
			studentExamNoticeModel.setExamnotice(StudentExamNotice);
			studentExamNoticeModel.setExamnoticedate(CurrrentDate);
			studentExamNoticeModel.setUsername(username);
			
			acadamicYearModel acadamicYearModel=new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentExamNoticeModel.setAcadamicYearModel(acadamicYearModel);
			
			StreamMasterModel streamMasterModel=new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentExamNoticeModel.setStreamMasterModel(streamMasterModel);
			
			BranchMasterModel branchMasterModel=new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentExamNoticeModel.setBranchMasterModel(branchMasterModel);
			
			StandardMasterModel standardMasterModel=new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentExamNoticeModel.setStandardMasterModel(standardMasterModel);
			
			
			examNoticeServiceInterface.saveStudentExamNoticeModel(studentExamNoticeModel);
			
			
			int noticeStudentExamMaxID = 0;
			noticeStudentExamMaxID = examNoticeServiceInterface.noticeStudentExamMaxID();
			System.out.println("noticeStudentExamMaxID : " + noticeStudentExamMaxID);
			
			
			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				StudentExamNoticeEnteryModel studentExamNoticeEnteryModel=new StudentExamNoticeEnteryModel();
				
				StudentExamNoticeModel studentExamNoticeModel2=new StudentExamNoticeModel();
				studentExamNoticeModel2.setExamniticeid(noticeStudentExamMaxID);
				studentExamNoticeEnteryModel.setStudentExamNoticeModel(studentExamNoticeModel2);
				
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				studentExamNoticeEnteryModel.setStudentAdmissionModel(studentAdmissionModel);
			
				examNoticeServiceInterface
						.saveStudentExamNoticeStudentEntryModel(studentExamNoticeEnteryModel);
			}
	
			
			
			model.addAttribute("MessageOfNoticeStudent", "Student Get Notice Successfully ...");

			return new ModelAndView("ExamHome");
		}

	}

	@RequestMapping(value = "SendNoticeToStudentExam", params = "SendSMS")
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

			String StudentExamNotice = request.getParameter("StudentExamNotice");
			System.out.println(StudentExamNotice);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount=studentCount+100000;

			StudentExamNoticeModel studentExamNoticeModel=new StudentExamNoticeModel();
			
			studentExamNoticeModel.setExamnotice(StudentExamNotice);
			studentExamNoticeModel.setExamnoticedate(CurrrentDate);
			studentExamNoticeModel.setUsername(username);
			
			acadamicYearModel acadamicYearModel=new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			studentExamNoticeModel.setAcadamicYearModel(acadamicYearModel);
			
			StreamMasterModel streamMasterModel=new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			studentExamNoticeModel.setStreamMasterModel(streamMasterModel);
			
			BranchMasterModel branchMasterModel=new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			studentExamNoticeModel.setBranchMasterModel(branchMasterModel);
			
			StandardMasterModel standardMasterModel=new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			studentExamNoticeModel.setStandardMasterModel(standardMasterModel);
			
			
			examNoticeServiceInterface.saveStudentExamNoticeModel(studentExamNoticeModel);
			
			
			int noticeStudentExamMaxID = 0;
			noticeStudentExamMaxID = examNoticeServiceInterface.noticeStudentExamMaxID();
			System.out.println("noticeStudentExamMaxID : " + noticeStudentExamMaxID);
			
			STCOPSMS stcopsms=new STCOPSMS();
			
			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				StudentExamNoticeEnteryModel studentExamNoticeEnteryModel=new StudentExamNoticeEnteryModel();
				
				StudentExamNoticeModel studentExamNoticeModel2=new StudentExamNoticeModel();
				studentExamNoticeModel2.setExamniticeid(noticeStudentExamMaxID);
				studentExamNoticeEnteryModel.setStudentExamNoticeModel(studentExamNoticeModel2);
				
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				studentExamNoticeEnteryModel.setStudentAdmissionModel(studentAdmissionModel);
				
				
			
				examNoticeServiceInterface
						.saveStudentExamNoticeStudentEntryModel(studentExamNoticeEnteryModel);
				
				List<StudentAdmissionModel> StudentCOntactNo;
				StudentCOntactNo=examNoticeServiceInterface.getStudentContactN(studID);
				System.out.println(StudentCOntactNo);
				
				String ContactNo=StudentCOntactNo.get(0).getStudentContactNumber();
			
				try {
					stcopsms.sendSMS(ContactNo,StudentExamNotice);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			model.addAttribute("MessageOfNoticeStudent", "Student Get Notice Successfully ...");

			return new ModelAndView("ExamHome");
		}

	}
	
	@RequestMapping("ParentExamNotice")
	public ModelAndView ParentExamNotice(Model model,HttpServletRequest request,HttpSession httpSession)
	{
		System.out.println("ParentExamNotice");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = examNoticeServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(d);
			System.out.println(currentDate);
			model.addAttribute("currentDate", currentDate);
			
			HashMap<String,String> YearList;
			YearList=examNoticeServiceInterface.getYearListP();
			System.out.println(YearList);
			model.addAttribute("YearList",YearList);
			
			HashMap<String, String> StreamList;
			StreamList=examNoticeServiceInterface.getStreamListP();
			System.out.println(StreamList);
			model.addAttribute("StreamList",StreamList);
			
			return new ModelAndView("ParentExamNoticePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}
	@RequestMapping(value="GetBranchListJsonStandardForYearParentExam",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlistExamP(int id)
	{
		System.out.println("Way to Get Branch List");
	    List<String> getBranchList;
	    getBranchList=examNoticeServiceInterface.getBranchP(id);
	    /*model.addAttribute("getidList",getidList);*/
		System.out.println("list"+getBranchList);
		
		return getBranchList;
	}
	
	@RequestMapping(value="GetStandardListJSONStandardForYearParentExam",method=RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardListExam(int branchid)
	{
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList=examNoticeServiceInterface.GetStamdardListP(branchid);
		System.out.println("List"+StandardList);
		
		return StandardList;
	}
	
	@RequestMapping(value="StudentAndParentRecordExam",method=RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardWiseRecordExam(int yearId,int streamid,int branchid,int standardID)
	{
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList=new ArrayList<>();
		StudentStandardList=examNoticeServiceInterface.getStandardWiseListP(yearId,streamid,branchid,standardID);
		System.out.println(StudentStandardList);
		
		return StudentStandardList;
	}

	@RequestMapping(value="sendMessageToParentExam",params="MessageParent")
	public ModelAndView sendMessageToParent(HttpServletRequest request,HttpSession session,Model model)
	{
		System.out.println("sendMessageToParent");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
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
		
		String ParentMessage=request.getParameter("ParentMessage");
		System.out.println(ParentMessage);
		
		int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println(studentCount);
		studentCount=studentCount+100000;
		
		ParentExamNoticeModel parentExamNoticeModel=new ParentExamNoticeModel();
		
		parentExamNoticeModel.setParentexamnotice(ParentMessage);
		parentExamNoticeModel.setParentexamnoticedate(CurrrentDate);
		parentExamNoticeModel.setUsername(username);
		
		acadamicYearModel acadamicYearModel=new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearId);
		parentExamNoticeModel.setAcadamicYearModel(acadamicYearModel);
		
		StreamMasterModel streamMasterModel=new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		parentExamNoticeModel.setStreamMasterModel(streamMasterModel);
		
		BranchMasterModel branchMasterModel=new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		parentExamNoticeModel.setBranchMasterModel(branchMasterModel);
		
		StandardMasterModel standardMasterModel=new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		parentExamNoticeModel.setStandardMasterModel(standardMasterModel);
		
		 
		examNoticeServiceInterface.saveParentExamNoticeModel(parentExamNoticeModel);
		
		
		int noticeParentExamMaxID = 0;
		noticeParentExamMaxID = examNoticeServiceInterface.noticeParentExamMaxID();
		System.out.println("noticeParentExamMaxID : " + noticeParentExamMaxID);
		
		
		String selectedStudent;
		for (int i = 0; i <= studentCount; i++) {
			selectedStudent = request.getParameter("StudID" + i);
			if (selectedStudent == null) {
				continue;
			}
			System.out.println(selectedStudent);

			int studID = Integer.parseInt(selectedStudent);

			ParentExamNoticeEnteryModel parentExamNoticeEnteryModel=new ParentExamNoticeEnteryModel();
			
			ParentExamNoticeModel parentExamNoticeModel2=new ParentExamNoticeModel();
			parentExamNoticeModel2.setParentexamnoticeid(noticeParentExamMaxID);
			parentExamNoticeEnteryModel.setParentExamNoticeModel(parentExamNoticeModel2);
			
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studID);
			parentExamNoticeEnteryModel.setStudentAdmissionModel(studentAdmissionModel);
		
			examNoticeServiceInterface
					.saveParentExamNoticeStudentEntryModel(parentExamNoticeEnteryModel);
		}

		model.addAttribute("MessageToParent","Parent Get Message Successfully ...");
		
		return new ModelAndView("ExamHome");
	}
	}
	
	@RequestMapping(value="sendMessageToParentExam",params="SendSMS")
	public ModelAndView sendMessageToParentSMS(HttpServletRequest request,HttpSession session,Model model)
	{
		System.out.println("sendMessageToParent");
		
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
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
		
		String ParentMessage=request.getParameter("ParentMessage");
		System.out.println(ParentMessage);
		
		int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
		System.out.println(studentCount);
		studentCount=studentCount+100000;
		 
		ParentExamNoticeModel parentExamNoticeModel=new ParentExamNoticeModel();
		
		parentExamNoticeModel.setParentexamnotice(ParentMessage);
		parentExamNoticeModel.setParentexamnoticedate(CurrrentDate);
		parentExamNoticeModel.setUsername(username);
		
		acadamicYearModel acadamicYearModel=new acadamicYearModel();
		acadamicYearModel.setAcadamicYearId(yearId);
		parentExamNoticeModel.setAcadamicYearModel(acadamicYearModel);
		
		StreamMasterModel streamMasterModel=new StreamMasterModel();
		streamMasterModel.setStreamId(streamId);
		parentExamNoticeModel.setStreamMasterModel(streamMasterModel);
		
		BranchMasterModel branchMasterModel=new BranchMasterModel();
		branchMasterModel.setBranchId(branchId);
		parentExamNoticeModel.setBranchMasterModel(branchMasterModel);
		
		StandardMasterModel standardMasterModel=new StandardMasterModel();
		standardMasterModel.setStandardId(standardId);
		parentExamNoticeModel.setStandardMasterModel(standardMasterModel);
		
		 
		examNoticeServiceInterface.saveParentExamNoticeModel(parentExamNoticeModel);
		
		int noticeParentExamMaxID = 0;
		noticeParentExamMaxID = examNoticeServiceInterface.noticeParentExamMaxID();
		System.out.println("noticeParentExamMaxID : " + noticeParentExamMaxID);
		
		STCOPSMS stcopsms=new STCOPSMS();
		
		String selectedStudent;
		for (int i = 0; i <= studentCount; i++) {
			selectedStudent = request.getParameter("StudID" + i);
			if (selectedStudent == null) {
				continue;
			}
			System.out.println(selectedStudent);

			int studID = Integer.parseInt(selectedStudent);

			ParentExamNoticeEnteryModel parentExamNoticeEnteryModel=new ParentExamNoticeEnteryModel();
			
			ParentExamNoticeModel parentExamNoticeModel2=new ParentExamNoticeModel();
			parentExamNoticeModel2.setParentexamnoticeid(noticeParentExamMaxID);
			parentExamNoticeEnteryModel.setParentExamNoticeModel(parentExamNoticeModel2);
			
			StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
			studentAdmissionModel.setAdmissionRegId(studID);
			parentExamNoticeEnteryModel.setStudentAdmissionModel(studentAdmissionModel);
		
			examNoticeServiceInterface
					.saveParentExamNoticeStudentEntryModel(parentExamNoticeEnteryModel);
			
			List<StudentAdmissionModel> ParentCOntactNo;
			ParentCOntactNo=examNoticeServiceInterface.getStudentContactN(studID);
			System.out.println(ParentCOntactNo);
			
			String ContactNo=ParentCOntactNo.get(0).getFatherContactNumber();
			
			try {
				stcopsms.sendSMS(ContactNo,ParentMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("MessageToParent","Parent Get Message Successfully ...");
		
		return new ModelAndView("ExamHome");
	}
	}
}
