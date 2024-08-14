package com.AcademicMaster.Controller;

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

import com.AcademicMaster.serviceInterface.AcademicYearReportServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class AcademicYearReportController {

	@Autowired
	private AcademicYearReportServiceInterface academicYearReportServiceInterface;

	public AcademicYearReportServiceInterface getAcademicYearReportServiceInterface() {
		return academicYearReportServiceInterface;
	}

	public void setAcademicYearReportServiceInterface(
			AcademicYearReportServiceInterface academicYearReportServiceInterface) {
		this.academicYearReportServiceInterface = academicYearReportServiceInterface;
	}
	
	@RequestMapping("StudentNoticeReport")
	public ModelAndView StudentNoticeReport(Model model)
	{
		System.out.println("StudentNoticeReport");
		
		List<String> NoticeList;
		NoticeList=academicYearReportServiceInterface.getStudentNoticeList();
		System.out.println("NoTice"+NoticeList);
		
		model.addAttribute("StudentNotice",NoticeList);
		
		return new ModelAndView("StudentNoticeReportPage");
	}
	
	@RequestMapping(value="PrintStudentNoticeList",params="PrintList")
	public ModelAndView PrintStudentNoticeList(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		System.out.println("PrintStudentNoticeList");
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "StudentNoticReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	
	@RequestMapping("StudentAttendenceNoticeReport")
	public ModelAndView StudentAttendenceNoticeReport(Model model)
	{
		System.out.println("StudentAttendenceNoticeReport");
		
		List<String> NoticeList;
		NoticeList=academicYearReportServiceInterface.getAttendenceNoticeList();
		System.out.println("NoTice"+NoticeList);
		
		model.addAttribute("StudentAttendenceNotice",NoticeList);
		
		return new ModelAndView("StudentAttendenceNoticeReportPage");
	}
	
	@RequestMapping(value="StudentAttendenceNoticePrint",params="PrintList")
	public ModelAndView StudentAttendenceNoticePrint(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		System.out.println("StudentAttendenceNoticePrint");
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "StudentAttendenceNoticeReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	
	@RequestMapping("StaffMeetingnoticeReport")
	public ModelAndView StaffMeetingnoticeReport(Model model)
	{
		System.out.println("StaffMeetingnoticeReport");
		
		List<String> NoticeList;
		NoticeList=academicYearReportServiceInterface.getStaffNoticeList();
		System.out.println("NoTice"+NoticeList);
		
		model.addAttribute("StaffMeetingNotice",NoticeList);
		
		return new ModelAndView("StaffMeetingnoticeReportPage");
	}
	
	@RequestMapping(value="MeetingReportNoticePrint",params="PrintList")
	public ModelAndView StaffMeetingNoticeReportPrint(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		System.out.println("MeetingReportNoticePrint");
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "StaffMeetingNoticeReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	
	@RequestMapping("StaffProgramNoticeReport")
	public ModelAndView StaffProgramNoticeReport(Model model)
	{
		System.out.println("StaffProgramNoticeReport");
		
		List<String> NoticeList;
		NoticeList=academicYearReportServiceInterface.getStaffProgramNoticeList();
		System.out.println("NoTice"+NoticeList);
		
		model.addAttribute("StaffProgramNotice",NoticeList);
		
		return new ModelAndView("StaffProgramNoticeReportPage");
	}
	
	@RequestMapping(value="ProgramReportNoticePrint",params="PrintList")
	public ModelAndView ProgramReportNoticePrint(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		System.out.println("ProgramReportNoticePrint");
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "ProgramRelatedMessageForStaff";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	
	@RequestMapping("ParentNoticeReport")
	public ModelAndView ParentNoticeReport(Model model)
	{
		System.out.println("ParentNoticeReport");
		
		List<String> NoticeList;
		NoticeList=academicYearReportServiceInterface.getParentNoticeList();
		System.out.println("NoTice"+NoticeList);
		
		model.addAttribute("ParentNotices",NoticeList);
		
		return new ModelAndView("ParentNoticeReportPage");
	}
	
	@RequestMapping(value="PrentNoticePrint",params="PrintList")
	public ModelAndView PrentNoticePrint(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		System.out.println("PrentNoticePrint");
		
		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");
		
		String filename = "MessageToParentsReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner", banner);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
	
	/*
	@RequestMapping()
	public ModelAndView 
	{
		System.out.println();
		
		return new ModelAndView();
	}
	
	@RequestMapping()
	public ModelAndView 
	{
		System.out.println();
		
		return new ModelAndView();
	}*/
}
