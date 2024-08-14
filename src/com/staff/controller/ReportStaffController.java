package com.staff.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.HOD.model.AssignSubjectTeacherModel;
import com.HOD.model.HODSubjectMasterModel;
import com.HOD.model.StaffRegistrationModel;
import com.staff.serviceInterface.ReportStaffServiceInterface;
import com.staff.serviceInterface.StaffMenuServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportStaffController {

	@Autowired
	private ReportStaffServiceInterface reportStaffServiceInterface;

	@Autowired
	private StaffMenuServiceInterface staffMenuServiceInterface;

	public StaffMenuServiceInterface getStaffMenuServiceInterface() {
		return staffMenuServiceInterface;
	}

	public void setStaffMenuServiceInterface(StaffMenuServiceInterface staffMenuServiceInterface) {
		this.staffMenuServiceInterface = staffMenuServiceInterface;
	}

	public ReportStaffServiceInterface getReportStaffServiceInterface() {
		return reportStaffServiceInterface;
	}

	public void setReportStaffServiceInterface(ReportStaffServiceInterface reportStaffServiceInterface) {
		this.reportStaffServiceInterface = reportStaffServiceInterface;
	}

	@RequestMapping("AbsentStudentList")
	public ModelAndView AbsentStudentList(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("Absent Student List");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<HODSubjectMasterModel> SubjectList;
			SubjectList = reportStaffServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);

			try {

				int SubjectID = SubjectList.get(0).getSubjectID();
				System.out.println(SubjectID);
				
				List<String> StudentList;
				StudentList = reportStaffServiceInterface.getStudentList(SubjectID);
				System.out.println(StudentList);
				model.addAttribute("StudentList", StudentList);

				return new ModelAndView("AbsentStudentListPage");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return new ModelAndView("StaffNotAssignSubjectPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}

	}
	
	@RequestMapping(value="PrintAbsentStudentList",params="PrintAbsentStudent")
	public ModelAndView PrintAbsentStudentList(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("PrintAbsentStudentList");
		
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);
		
		int StaffID = getStaffList.get(0).getStaffRegistrationId();
		System.out.println(StaffID);

		List<HODSubjectMasterModel> SubjectList;
		SubjectList = reportStaffServiceInterface.GetSubjectList(StaffID);
		System.out.println(SubjectList);
		
		int SubjectID = SubjectList.get(0).getSubjectID();
		
		ServletContext context = httpSession.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		
		String filename = "AbsentStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("SubjectID", SubjectID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	

	@RequestMapping("PresentStudentList")
	public ModelAndView PresentStudentList(Model model, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("PresentStudentList");
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			List<HODSubjectMasterModel> SubjectList;
			SubjectList = reportStaffServiceInterface.GetSubjectList(StaffID);
			System.out.println(SubjectList);

			try {

				int SubjectID = SubjectList.get(0).getSubjectID();

				List<Object[]> getStudentD;
				getStudentD = reportStaffServiceInterface.getPresentStudentList(SubjectID);
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
				
				model.addAttribute("StudentList",getStudentPresentList);
				return new ModelAndView("PresentStudentListPage");
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return new ModelAndView("StaffNotAssignSubjectPage");
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForStaff", "Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("StaffLoginPage");
		}

	}
	
	@RequestMapping(value="PrintPresentStudentList",params="PresentStudentList")
	public ModelAndView PrintPresentStudentList(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession)
	{
		System.out.println("PrintPresentStudentList");
		
		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = staffMenuServiceInterface.getStaffList(username);
		System.out.println(getStaffList);
		
		int StaffID = getStaffList.get(0).getStaffRegistrationId();
		System.out.println(StaffID);

		List<HODSubjectMasterModel> SubjectList;
		SubjectList = reportStaffServiceInterface.GetSubjectList(StaffID);
		System.out.println(SubjectList);
		
		int SubjectID = SubjectList.get(0).getSubjectID();

		List<Object[]> getStudentD;
		getStudentD = reportStaffServiceInterface.getPresentStudentList(SubjectID);
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
		
		ServletContext context = httpSession.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		
		String filename = "PresentStudentList";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("AttendenceID", AttendenceID);
		hm.put("YearID",YearID );
		hm.put("StreamID", StreamID);
		hm.put("BranchID",BranchID );
		hm.put("StandardID", StandardID);
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
}
