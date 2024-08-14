package com.cultural.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.StaffRegistrationModel;
import com.cultural.serviceInterface.StudentMasterCulturalDepartmentServiceInterface;
import com.student.model.StudentAdmissionModel;
import com.util.STCOPSMS;

@Controller
public class StudentMasterCulturalDepartmentController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private StudentMasterCulturalDepartmentServiceInterface studentMasterCulturalDepartmentServiceInterface;
	
	public StudentMasterCulturalDepartmentServiceInterface getStudentMasterCulturalDepartmentServiceInterface() {
		return studentMasterCulturalDepartmentServiceInterface;
	}

	public void setStudentMasterCulturalDepartmentServiceInterface(
			StudentMasterCulturalDepartmentServiceInterface studentMasterCulturalDepartmentServiceInterface) {
		this.studentMasterCulturalDepartmentServiceInterface = studentMasterCulturalDepartmentServiceInterface;
	}

	@RequestMapping("CultruralHomePage")
	public ModelAndView CultruralHomePage( HttpServletRequest request, HttpSession session,Model model)
	{
		System.out.println("Cultrural Home Page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentMasterCulturalDepartmentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);
		return new ModelAndView("CultruralHomePage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}
	
	@RequestMapping("MessageToStudent")
	public ModelAndView MessageToStudent(Model model, HttpServletRequest request, HttpSession session)
	{
		System.out.println("Send Cultural activity message To Student");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = studentMasterCulturalDepartmentServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);
			HashMap<String, String> YearList;
			YearList = studentMasterCulturalDepartmentServiceInterface.GetYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> StreamList;
			StreamList = studentMasterCulturalDepartmentServiceInterface.getStreamList();
			System.out.println(StreamList);
			model.addAttribute("StreamList", StreamList);

			return new ModelAndView("MessageToStudentPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}
	
	@RequestMapping(value="GetBranchListJsonCultural")
	@ResponseBody
	public List<String> GetBranchListJsonCultural(int id)
	{
		List<String> GetBranchList = new ArrayList<>();
		GetBranchList = studentMasterCulturalDepartmentServiceInterface.getBranchList(id);
		return GetBranchList;
	}
	
	@RequestMapping(value="GetStandardListJSONCultural")
	@ResponseBody
	public List<String> GetStandardListJSONCultural(int branchid)
	{
		List<String> getStandardList = new ArrayList<>();
		getStandardList = studentMasterCulturalDepartmentServiceInterface.getStandardList(branchid);
		return getStandardList;
	}
	
	@RequestMapping(value="StudentListCultural")
	@ResponseBody
	public List<String> StudentListCultural(int yearId, int streamid, int branchid, int standardID) {
		List<String> getStudentDetails = new ArrayList<>();
		getStudentDetails = studentMasterCulturalDepartmentServiceInterface.getStudentDetailsForAdmission(yearId,
				streamid, branchid, standardID);
		return getStudentDetails;
	}
	
	@RequestMapping(value="InviteStudentCultural",params="SendCulturalMessage")
	public ModelAndView InviteStudentCultural(HttpServletRequest request)
	{
		System.out.println("Way To Send Mail To Student For Cultural Event");
		
		int CheckBoxNumbers=Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers=CheckBoxNumbers+1;
		//System.out.println(CheckBoxNumbers);
		List<StudentAdmissionModel> studentEmailIDs;	
		String messageToStudent=request.getParameter("MessageForStudent");
		System.out.println(messageToStudent);
		String BoxValue1;
		for(int i=0;i<=CheckBoxNumbers;i++)
		{
			BoxValue1=request.getParameter("StudID"+i);
			if(BoxValue1==null){
				continue;
			}
			System.out.println(BoxValue1);
			
			int BoxValue=Integer.parseInt(BoxValue1);
			
			studentEmailIDs=studentMasterCulturalDepartmentServiceInterface.getStudentMail(BoxValue);
			final String EmailID=studentEmailIDs.get(0).getStudentEmail();
			String Name=studentEmailIDs.get(0).getStudentFirstName();
			String LName=studentEmailIDs.get(0).getStudentLastName();
			
			final String Subject = "Cultural Activity Information ";
			System.out.println("Subject" + Subject);
			final String Message = "Hi " + Name + " " + LName + " " + messageToStudent;
			System.out.println("Message " + Message);
			System.out.println("Sender Mail " + EmailID);

			mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					messageHelper.setTo(EmailID);
					messageHelper.setSubject(Subject);
					messageHelper.setText(Message);
				}
			});
		}
		
		
		return new ModelAndView("CultruralHomePage");
	}
	
	@RequestMapping(value="InviteStudentCultural",params="SendSMS")
	public ModelAndView InviteStudentCulturalSMS(HttpServletRequest request,Model model)
	{
		System.out.println("Way To Send Mail To Student For Cultural Event");
		
		int CheckBoxNumbers=Integer.parseInt(request.getParameter("CheckCount"));
		CheckBoxNumbers=CheckBoxNumbers+1;
		//System.out.println(CheckBoxNumbers);
		List<StudentAdmissionModel> studentEmailIDs;	
		String messageToStudent=request.getParameter("MessageForStudent");
		System.out.println(messageToStudent);
		String BoxValue1;
		for(int i=0;i<=CheckBoxNumbers;i++)
		{
			BoxValue1=request.getParameter("StudID"+i);
			if(BoxValue1==null){
				continue;
			}
			System.out.println(BoxValue1);
			
			int BoxValue=Integer.parseInt(BoxValue1);
			
			studentEmailIDs=studentMasterCulturalDepartmentServiceInterface.getStudentMail(BoxValue);
			String Name=studentEmailIDs.get(0).getStudentFirstName();
			String LName=studentEmailIDs.get(0).getStudentLastName();
			String ContactNumber=studentEmailIDs.get(0).getStudentContactNumber();
			
			String Subject = "Cultural Activity Information ";
			System.out.println("Subject" + Subject);
			String Message = "Hi " + Name + " " + LName + " " + messageToStudent;
			System.out.println("Message " + Message);
			
			STCOPSMS stcopsms=new STCOPSMS();
			
			try {
				stcopsms.sendSMS(ContactNumber, Message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("StudentMsg","Message Send Successfully...");
		return new ModelAndView("CultruralHomePage");
	}
}
