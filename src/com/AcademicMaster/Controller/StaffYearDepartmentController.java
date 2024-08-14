package com.AcademicMaster.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.AcademicMaster.model.StaffMeetingNoticeModel;
import com.AcademicMaster.model.StaffMeetingNoticeStaffEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeEnteryModel;
import com.AcademicMaster.model.StaffProgramNoticeModel;
import com.AcademicMaster.serviceInterface.StaffYearDepartmentServiceInterface;
import com.AcademicMaster.serviceInterface.StudentControllerYearDepartmentServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;
import com.util.STCOPSMS;

@Controller
public class StaffYearDepartmentController {

	@Autowired
	private StaffYearDepartmentServiceInterface staffYearDepartmentServiceInterface;

	@Autowired
	private StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface;

	public StudentControllerYearDepartmentServiceInterface getStudentControllerYearDepartmentServiceInterface() {
		return studentControllerYearDepartmentServiceInterface;
	}

	public void setStudentControllerYearDepartmentServiceInterface(
			StudentControllerYearDepartmentServiceInterface studentControllerYearDepartmentServiceInterface) {
		this.studentControllerYearDepartmentServiceInterface = studentControllerYearDepartmentServiceInterface;
	}

	public StaffYearDepartmentServiceInterface getStaffYearDepartmentServiceInterface() {
		return staffYearDepartmentServiceInterface;
	}

	public void setStaffYearDepartmentServiceInterface(
			StaffYearDepartmentServiceInterface staffYearDepartmentServiceInterface) {
		this.staffYearDepartmentServiceInterface = staffYearDepartmentServiceInterface;
	}

	@RequestMapping("MeetingNoticeToStaff")
	public ModelAndView MeetingNoticeToStaff(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("MeetingNoticeToStaff");
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

			return new ModelAndView("MeetingNoticeToStaffPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "getStaffList")
	@ResponseBody
	public List<String> getStaffList(String Stafftype) {
		System.out.println("getStaffList");
		List<String> GetStaffList;
		GetStaffList = staffYearDepartmentServiceInterface.getStaffListUsingStaffType(Stafftype);
		System.out.println(GetStaffList);
		return GetStaffList;
	}

	@RequestMapping(value = "sendMeetingNoticeToStaff", params = "SendNoticeToStaff")
	public ModelAndView sendMeetingNoticeToStaff(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("send Meeting Notice To Staff");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			String StaffType = request.getParameter("StaffType");
			System.out.println(StaffType);

			String MeetingNotice = request.getParameter("MeetingNotice");
			System.out.println(MeetingNotice);

			int staffCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(staffCount);
			staffCount=staffCount+100000;

			StaffMeetingNoticeModel staffMeetingNoticeModel = new StaffMeetingNoticeModel();
			staffMeetingNoticeModel.setStaffNoticeDate(CurrrentDate);
			staffMeetingNoticeModel.setStaffNotice(MeetingNotice);
			staffMeetingNoticeModel.setStaffType(StaffType);

			staffMeetingNoticeModel.setTeacherName(username);

			staffYearDepartmentServiceInterface.saveStaffMeetingNoticeModel(staffMeetingNoticeModel);

			int staffMeetingNoticeID = 0;
			staffMeetingNoticeID = staffYearDepartmentServiceInterface.getMaxStaffMeetingNoticeID();
			System.out.println(staffMeetingNoticeID);

			String selectedStaff;
			for (int i = 0; i <= staffCount; i++) {
				selectedStaff = request.getParameter("Staff" + i);
				if (selectedStaff == null) {
					continue;
				}
				System.out.println(selectedStaff);
				int staffID = Integer.parseInt(selectedStaff);
				System.out.println(staffID);

				StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel = new StaffMeetingNoticeStaffEnteryModel();

				StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
				staffRegistrationModel.setStaffRegistrationId(staffID);
				staffMeetingNoticeStaffEnteryModel.setStaffRegistrationModel(staffRegistrationModel);

				StaffMeetingNoticeModel staffMeetingNoticeModel2 = new StaffMeetingNoticeModel();
				staffMeetingNoticeModel2.setStaffMeetingNoticeID(staffMeetingNoticeID);
				staffMeetingNoticeStaffEnteryModel.setStaffMeetingNoticeModel(staffMeetingNoticeModel2);

				staffYearDepartmentServiceInterface
						.saveStaffMeetingNoticeEnteryModel(staffMeetingNoticeStaffEnteryModel);

			}
			model.addAttribute("MeetingNoticeOfStaff", "Staff Get Meeting Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}

	@RequestMapping(value = "sendMeetingNoticeToStaff", params = "SendSMS")
	public ModelAndView sendMeetingNoticeToStaffSMS(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("send Meeting Notice To Staff SMS");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			String StaffType = request.getParameter("StaffType");
			System.out.println(StaffType);

			String MeetingNotice = request.getParameter("MeetingNotice");
			System.out.println(MeetingNotice);

			int staffCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(staffCount);
			staffCount=staffCount+100000;

			StaffMeetingNoticeModel staffMeetingNoticeModel = new StaffMeetingNoticeModel();
			staffMeetingNoticeModel.setStaffNoticeDate(CurrrentDate);
			staffMeetingNoticeModel.setStaffNotice(MeetingNotice);
			staffMeetingNoticeModel.setStaffType(StaffType);

			staffMeetingNoticeModel.setTeacherName(username);

			staffYearDepartmentServiceInterface.saveStaffMeetingNoticeModel(staffMeetingNoticeModel);

			int staffMeetingNoticeID = 0;
			staffMeetingNoticeID = staffYearDepartmentServiceInterface.getMaxStaffMeetingNoticeID();
			System.out.println(staffMeetingNoticeID);

			STCOPSMS stcopsms=new STCOPSMS();
			
			String selectedStaff;
			for (int i = 0; i <= staffCount; i++) {
				selectedStaff = request.getParameter("Staff" + i);
				if (selectedStaff == null) {
					continue;
				}
				System.out.println(selectedStaff);
				int staffID = Integer.parseInt(selectedStaff);
				System.out.println(staffID);

				StaffMeetingNoticeStaffEnteryModel staffMeetingNoticeStaffEnteryModel = new StaffMeetingNoticeStaffEnteryModel();

				StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
				staffRegistrationModel.setStaffRegistrationId(staffID);
				staffMeetingNoticeStaffEnteryModel.setStaffRegistrationModel(staffRegistrationModel);

				StaffMeetingNoticeModel staffMeetingNoticeModel2 = new StaffMeetingNoticeModel();
				staffMeetingNoticeModel2.setStaffMeetingNoticeID(staffMeetingNoticeID);
				staffMeetingNoticeStaffEnteryModel.setStaffMeetingNoticeModel(staffMeetingNoticeModel2);

				staffYearDepartmentServiceInterface
						.saveStaffMeetingNoticeEnteryModel(staffMeetingNoticeStaffEnteryModel);

				List<StaffRegistrationModel> StaffCOntactNo;
				StaffCOntactNo=staffYearDepartmentServiceInterface.getStaffContactN(staffID);
				System.out.println(StaffCOntactNo);
				
				String ContactNo=StaffCOntactNo.get(0).getMobileNumber();
				
				try {
					stcopsms.sendSMS(ContactNo,MeetingNotice);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			model.addAttribute("MeetingNoticeOfStaff", "Staff Get Meeting Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}
	@RequestMapping("ProgramRelatedmessageToStaff")
	public ModelAndView ProgramRelatedmessageToStaff(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("ProgramRelatedmessageToStaff");
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

			return new ModelAndView("ProgramRelatedmessageToStaffPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "sendProgramRelatedToStaff", params = "ProgramRelatedessageToStaff")
	public ModelAndView sendProgramRelatedToStaff(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("send Program Related To Staff");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			String StaffType = request.getParameter("StaffType");
			System.out.println(StaffType);

			String ProgramRelatedMessage = request.getParameter("ProgramRelatedMessage");
			System.out.println(ProgramRelatedMessage);

			int staffCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(staffCount);
			staffCount=staffCount+100000;

			StaffProgramNoticeModel staffProgramNoticeModel = new StaffProgramNoticeModel();
			staffProgramNoticeModel.setStaffProgramNoticeDate(CurrrentDate);
			staffProgramNoticeModel.setStaffProgramNotice(ProgramRelatedMessage);
			staffProgramNoticeModel.setStaffType(StaffType);

			staffProgramNoticeModel.setTeacherName(username);

			staffYearDepartmentServiceInterface.saveStaffProgramNoticeModel(staffProgramNoticeModel);

			int staffProgramNoticeMaxID = 0;
			staffProgramNoticeMaxID = staffYearDepartmentServiceInterface.getMaxStaffProgramNoticeModelID();
			System.out.println(staffProgramNoticeMaxID);

			String selectedStaff;
			for (int i = 0; i <= staffCount; i++) {
				selectedStaff = request.getParameter("Staff" + i);
				if (selectedStaff == null) {
					continue;
				}
				System.out.println(selectedStaff);
				int staffID = Integer.parseInt(selectedStaff);
				System.out.println(staffID);

				StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel = new StaffProgramNoticeEnteryModel();

				StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
				staffRegistrationModel.setStaffRegistrationId(staffID);
				staffProgramNoticeEnteryModel.setStaffRegistrationModel(staffRegistrationModel);

				StaffProgramNoticeModel staffProgramNoticeModel2 = new StaffProgramNoticeModel();
				staffProgramNoticeModel2.setStaffProgramNoticeID(staffProgramNoticeMaxID);
				staffProgramNoticeEnteryModel.setStaffProgramNoticeModel(staffProgramNoticeModel2);

				staffYearDepartmentServiceInterface.saveStaffProgramNoticeEnteryModel(staffProgramNoticeEnteryModel);

			}
			model.addAttribute("ProgramRelatedOfStaff", "Staff Get Meeting Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}
	
	@RequestMapping(value = "sendProgramRelatedToStaff", params = "SendSMS")
	public ModelAndView sendProgramRelatedToStaffSMS(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("send Program Related To Staff");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {

			String CurrrentDate = request.getParameter("DateCurrent");
			System.out.println(CurrrentDate);

			String StaffType = request.getParameter("StaffType");
			System.out.println(StaffType);

			String ProgramRelatedMessage = request.getParameter("ProgramRelatedMessage");
			System.out.println(ProgramRelatedMessage);

			int staffCount = Integer.parseInt(request.getParameter("CheckCount"));
			System.out.println(staffCount);
			staffCount=staffCount+100000;

			StaffProgramNoticeModel staffProgramNoticeModel = new StaffProgramNoticeModel();
			staffProgramNoticeModel.setStaffProgramNoticeDate(CurrrentDate);
			staffProgramNoticeModel.setStaffProgramNotice(ProgramRelatedMessage);
			staffProgramNoticeModel.setStaffType(StaffType);

			staffProgramNoticeModel.setTeacherName(username);

			staffYearDepartmentServiceInterface.saveStaffProgramNoticeModel(staffProgramNoticeModel);

			int staffProgramNoticeMaxID = 0;
			staffProgramNoticeMaxID = staffYearDepartmentServiceInterface.getMaxStaffProgramNoticeModelID();
			System.out.println(staffProgramNoticeMaxID);

			STCOPSMS stcopsms =new STCOPSMS();
			
			String selectedStaff;
			for (int i = 0; i <= staffCount; i++) {
				selectedStaff = request.getParameter("Staff" + i);
				if (selectedStaff == null) {
					continue;
				}
				System.out.println(selectedStaff);
				int staffID = Integer.parseInt(selectedStaff);
				System.out.println(staffID);

				StaffProgramNoticeEnteryModel staffProgramNoticeEnteryModel = new StaffProgramNoticeEnteryModel();

				StaffRegistrationModel staffRegistrationModel = new StaffRegistrationModel();
				staffRegistrationModel.setStaffRegistrationId(staffID);
				staffProgramNoticeEnteryModel.setStaffRegistrationModel(staffRegistrationModel);

				StaffProgramNoticeModel staffProgramNoticeModel2 = new StaffProgramNoticeModel();
				staffProgramNoticeModel2.setStaffProgramNoticeID(staffProgramNoticeMaxID);
				staffProgramNoticeEnteryModel.setStaffProgramNoticeModel(staffProgramNoticeModel2);

				staffYearDepartmentServiceInterface.saveStaffProgramNoticeEnteryModel(staffProgramNoticeEnteryModel);

				List<StaffRegistrationModel> StaffCOntactNo;
				StaffCOntactNo=staffYearDepartmentServiceInterface.getStaffContactN(staffID);
				System.out.println(StaffCOntactNo);
				
				String ContactNo=StaffCOntactNo.get(0).getMobileNumber();
				
				try {
					stcopsms.sendSMS(ContactNo,ProgramRelatedMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			model.addAttribute("ProgramRelatedOfStaff", "Staff Get Meeting Notice Successfully ...");

			return new ModelAndView("YearHomePage");
		}
	}

}
