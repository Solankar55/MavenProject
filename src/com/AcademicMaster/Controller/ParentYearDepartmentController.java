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

import com.AcademicMaster.model.ParentMessageEntryModel;
import com.AcademicMaster.model.ParentMessageModel;
import com.AcademicMaster.serviceInterface.ParentYearDepartmentServiceInterface;
import com.AcademicMaster.serviceInterface.StudentControllerYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.BranchMasterModel;
import com.account.model.StandardMasterModel;
import com.account.model.StreamMasterModel;
import com.account.model.acadamicYearModel;
import com.student.model.StudentAdmissionModel;
import com.util.FixKareSMS;
import com.util.STCOPSMS;

@Controller
public class ParentYearDepartmentController {

	@Autowired
	private ParentYearDepartmentServiceInterface parentYearDepartmentServiceInterface;

	public ParentYearDepartmentServiceInterface getParentYearDepartmentServiceInterface() {
		return parentYearDepartmentServiceInterface;
	}

	public void setParentYearDepartmentServiceInterface(
			ParentYearDepartmentServiceInterface parentYearDepartmentServiceInterface) {
		this.parentYearDepartmentServiceInterface = parentYearDepartmentServiceInterface;
	}

	@RequestMapping("MessageToParent")
	public ModelAndView MessageToParent(HttpServletRequest request, HttpSession httpSession, Model model) {
		System.out.println("MessageToParent");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = parentYearDepartmentServiceInterface.getStaffList(username);
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
			YearList = parentYearDepartmentServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = parentYearDepartmentServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("MessageToParentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "GetBranchListJsonStandardForYearParent", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBranchlist(int id) {
		System.out.println("Way to Get Branch List");
		List<String> getBranchList;
		getBranchList = parentYearDepartmentServiceInterface.getBranch(id);
		/* model.addAttribute("getidList",getidList); */
		System.out.println("list" + getBranchList);

		return getBranchList;
	}

	@RequestMapping(value = "GetStandardListJSONStandardForYearParent", method = RequestMethod.GET)
	@ResponseBody
	public List<String> GetStandardList(int branchid) {
		System.out.println("Way to get Standard list");
		System.out.println(branchid);
		List<String> StandardList;
		StandardList = parentYearDepartmentServiceInterface.GetStamdardList(branchid);
		System.out.println("List" + StandardList);

		return StandardList;
	}

	@RequestMapping(value = "StudentAndParentRecord", method = RequestMethod.GET)
	@ResponseBody
	public List<String> StudentStandardWiseRecord(int yearId, int streamid, int branchid, int standardID) {
		System.out.println("Get Standard list");
		System.out.println(yearId);
		System.out.println(streamid);
		System.out.println(branchid);
		System.out.println(standardID);
		List<String> StudentStandardList = new ArrayList<>();
		StudentStandardList = parentYearDepartmentServiceInterface.getStandardWiseList(yearId, streamid, branchid,
				standardID);
		System.out.println(StudentStandardList);

		return StudentStandardList;
	}

	@RequestMapping(value = "sendMessageToParent", params = "MessageParent")
	public ModelAndView sendMessageToParent(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("sendMessageToParent");

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

			String ParentMessage = request.getParameter("ParentMessage");
			System.out.println(ParentMessage);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount = studentCount + 100000;

			ParentMessageModel parentMessageModel = new ParentMessageModel();
			parentMessageModel.setParentMessageDate(CurrrentDate);
			parentMessageModel.setParentMessage(ParentMessage);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			parentMessageModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			parentMessageModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			parentMessageModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			parentMessageModel.setStandardMasterModel(standardMasterModel);

			parentMessageModel.setTeacherName(username);

			parentYearDepartmentServiceInterface.saveParentMessageModel(parentMessageModel);

			int parentMessageId = 0;
			parentMessageId = parentYearDepartmentServiceInterface.getMaxParentID();

			System.out.println("parentMessageId" + parentMessageId);

			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				ParentMessageEntryModel parentMessageEntryModel = new ParentMessageEntryModel();
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				parentMessageEntryModel.setStudentAdmissionModel(studentAdmissionModel);

				ParentMessageModel parentMessageModel2 = new ParentMessageModel();
				parentMessageModel2.setParentMessageID(parentMessageId);
				parentMessageEntryModel.setParentMessageModel(parentMessageModel2);

				parentYearDepartmentServiceInterface.saveParentMessageEntryModel(parentMessageEntryModel);

			}
			model.addAttribute("MessageToParent", "Parent Get Message Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}

	@RequestMapping(value = "sendMessageToParent", params = "SendSMS")
	public ModelAndView sendMessageToParentSMS(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("sendMessageToParent");

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

			String ParentMessage = request.getParameter("ParentMessage");
			System.out.println(ParentMessage);

			int studentCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(studentCount);
			studentCount = studentCount + 100000;

			ParentMessageModel parentMessageModel = new ParentMessageModel();
			parentMessageModel.setParentMessageDate(CurrrentDate);
			parentMessageModel.setParentMessage(ParentMessage);

			acadamicYearModel acadamicYearModel = new acadamicYearModel();
			acadamicYearModel.setAcadamicYearId(yearId);
			parentMessageModel.setAcadamicYearModel(acadamicYearModel);

			StreamMasterModel streamMasterModel = new StreamMasterModel();
			streamMasterModel.setStreamId(streamId);
			parentMessageModel.setStreamMasterModel(streamMasterModel);

			BranchMasterModel branchMasterModel = new BranchMasterModel();
			branchMasterModel.setBranchId(branchId);
			parentMessageModel.setBranchMasterModel(branchMasterModel);

			StandardMasterModel standardMasterModel = new StandardMasterModel();
			standardMasterModel.setStandardId(standardId);
			parentMessageModel.setStandardMasterModel(standardMasterModel);

			parentMessageModel.setTeacherName(username);

			parentYearDepartmentServiceInterface.saveParentMessageModel(parentMessageModel);

			int parentMessageId = 0;
			parentMessageId = parentYearDepartmentServiceInterface.getMaxParentID();

			System.out.println("parentMessageId" + parentMessageId);

			STCOPSMS fixKareSMS = new STCOPSMS();

			String selectedStudent;
			for (int i = 0; i <= studentCount; i++) {
				selectedStudent = request.getParameter("StudID" + i);
				if (selectedStudent == null) {
					continue;
				}
				System.out.println(selectedStudent);

				int studID = Integer.parseInt(selectedStudent);

				ParentMessageEntryModel parentMessageEntryModel = new ParentMessageEntryModel();
				StudentAdmissionModel studentAdmissionModel = new StudentAdmissionModel();
				studentAdmissionModel.setAdmissionRegId(studID);
				parentMessageEntryModel.setStudentAdmissionModel(studentAdmissionModel);

				ParentMessageModel parentMessageModel2 = new ParentMessageModel();
				parentMessageModel2.setParentMessageID(parentMessageId);
				parentMessageEntryModel.setParentMessageModel(parentMessageModel2);

				parentYearDepartmentServiceInterface.saveParentMessageEntryModel(parentMessageEntryModel);

				List<StudentAdmissionModel> StudentCOntactNo;
				StudentCOntactNo = parentYearDepartmentServiceInterface.getStudentContactN(studID);
				System.out.println(StudentCOntactNo);

				String ContactNo = StudentCOntactNo.get(0).getFatherContactNumber();

				try {
					fixKareSMS.sendSMS(ContactNo, ParentMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			model.addAttribute("MessageToParent", "Parent Get Message Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}
}
