package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.serviceInterface.LibraryReportServiceInterface;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class LibraryReportController {

	@Autowired
	private LibraryReportServiceInterface libraryReportServiceInterface;

	public LibraryReportServiceInterface getLibraryReportServiceInterface() {
		return libraryReportServiceInterface;
	}

	public void setLibraryReportServiceInterface(LibraryReportServiceInterface libraryReportServiceInterface) {
		this.libraryReportServiceInterface = libraryReportServiceInterface;
	}

	@RequestMapping("StudentBookIssueReturnReport")
	public ModelAndView StudentBookIssueReturn(Model model, HttpServletRequest request, HttpSession session) {

		System.out.println("On StudentBookIssueReturnReport page ");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> StudentIssueReturnDataList = new ArrayList<>();
			StudentIssueReturnDataList = libraryReportServiceInterface.getStudentIssueReturnData();
			System.out.println("StudentIssueReturnDataList" +StudentIssueReturnDataList);
			model.addAttribute("StudentIssueReturnData", StudentIssueReturnDataList);

			return new ModelAndView("StudentBookIssueReturnReportPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}

	}

	@RequestMapping(value = "StudentBookIssueReturnRrt", params = "StudentBookIssueReturnReport")
	public ModelAndView StudentBookIssueReturnRrt(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {

		System.out.println("On Click of Generate Report ");

		String filename = "StudentIssueReturnReport";

		String indate1 = request.getParameter("InDate");
		String[] ch = indate1.split("-");
		String inDate = ch[2] + "-" + ch[1] + "-" + ch[0];
		System.out.println("inDate" + inDate);

		String toDate1 = request.getParameter("ToDate");
		String[] che = toDate1.split("-");
		String toDate = che[2] + "-" + che[1] + "-" + che[0];
		System.out.println("toDate" + toDate);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("FromDate", inDate);
		hm.put("ToDate", toDate);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");

	}

	@RequestMapping("StaffBookIssueandReturnRpt")
	public ModelAndView StaffREport(Model model, HttpServletRequest request, HttpSession session) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> StaffIssueReturnList = new ArrayList<>();
			StaffIssueReturnList = libraryReportServiceInterface.getStaffIssueReturnData();
			model.addAttribute("StaffIssueReturnDataList", StaffIssueReturnList);

			return new ModelAndView("StaffIssueReturnReportPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}

	}

	@RequestMapping("printStaffIssueReturnR")
	public ModelAndView Staffpage(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("on click of Print");

		String filename = "StaffBookIssueReturnReport";
		String FromDate1 = request.getParameter("InDate");
		String ch[] = FromDate1.split("-");
		String FromDate = ch[2] + "-" + ch[1] + "-" + ch[0];
		System.out.println("FromDate  " + FromDate);

		String ToDate1 = request.getParameter("ToDate");
		System.out.println("ToDate1    " + ToDate1);

		String che[] = ToDate1.split("-");
		String ToDate = che[2] + "-" + che[1] + "-" + che[0];
		System.out.println("ToDate  " + ToDate);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("fromDate", FromDate);
		hm.put("toDate", ToDate);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("StaffIssueReturnReportPage");
	}

	@RequestMapping("StudentIssueReturnDataPrint")
	public ModelAndView StudentPage(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("on click of Print of student issue-returned");

		String filename = "StudentAllIssued-ReturnedDataPrint";


		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner",banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("StaffIssueReturnDataPrint")
	public ModelAndView Staffpage1(HttpSession session, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("on click of Print of staff issue-returned");

		String filename = "StaffIssueReturnDataPrint";


		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("banner",banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("InvoicePrintRpt")
	public ModelAndView invoice(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("Invoice Invoice Invoice");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		/*
		 * HashMap vendorNameL=new HashMap<>();
		 * vendorNameL=librarySubjectServiceInterface.getvendorName();
		 * model.addAttribute("vendorNameL", vendorNameL);
		 */

		List<AdminRegistrationModel> checkAdminDetails;
		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {

			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap vendorNameL = new HashMap<>();
			vendorNameL = libraryReportServiceInterface.getvendorName();
			model.addAttribute("vendorNameL", vendorNameL);

			return new ModelAndView("InvoicePrintReportPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");

		}
	}

	@RequestMapping("getInvoiceDetail")
	@ResponseBody
	public List<String> getInvoiceData(int invoiceno)

	{
		System.out.println("getInvoiceJSON called");

		List<String> getInvoiceData1;
		getInvoiceData1 = libraryReportServiceInterface.getInvoice(invoiceno);
		System.out.println("getInvoiceData" + getInvoiceData1);
		return getInvoiceData1;

	}

	@RequestMapping(value = "PrintInvoiceDetail", params = "printInvoice")
	public ModelAndView printInvoiceData(Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {


		String bookFor = request.getParameter("BookFor");
		System.out.println("bookFor" + bookFor);

		String vendorName = request.getParameter("vendorName");
		System.out.println(vendorName);

		String FromDate1 = request.getParameter("fromDate");
		/*
		 * String ch[] = FromDate1.split("-"); String FromDate = ch[2] + "-" +
		 * ch[1] + "-" + ch[0]; System.out.println("FromDate  " + FromDate);
		 */

		String ToDate1 = request.getParameter("toDate");
		/*
		 * String che[] = ToDate1.split("-"); String ToDate = che[2] + "-" +
		 * che[1] + "-" + che[0]; System.out.println("ToDate  " + ToDate);
		 */

		String filename = "InvoiceReport";

		HashMap<String, Object> hm = new HashMap<>();
		if (bookFor.equals("All")) {
			hm.put("BookFor", "%");
		} else {
			hm.put("BookFor", bookFor);
		}
		if (vendorName.equals("All")) {
			hm.put("vendorName", "%");
		} else {
			hm.put("vendorName", vendorName);
		}
		/*
		 * String InvoiceNo = request.getParameter("invoiceNo");
		 * System.out.println("invoiceNo" + InvoiceNo);
		 */

		/*
		 * String vendorName=request.getParameter("vendorName"); String
		 * fromDate=request.getParameter("fromDate"); String
		 * toDate=request.getParameter("toDate");
		 */

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		//	HashMap<String, Object> hm = new HashMap<>();
		hm.put("fromDate", FromDate1);
		hm.put("toDate", ToDate1);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("InvoicePrintRptView");
	}

	@RequestMapping("CatalogSubjectPageDisplay")
	public ModelAndView CatalogLibrarySubjectPage(Model model, HttpServletRequest request, HttpSession session) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();

			HashMap<String, String> LibrarySubjectList = libraryReportServiceInterface.librarySubjectList();
			model.addAttribute("LibrarySubjectList", LibrarySubjectList);
			return new ModelAndView("CatalogLibrarySubjectPage");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "SubjectWiseReportPrintLab", params = "SubjectWiseReportPrint")
	public ModelAndView SubjectWiseReportPrintLab(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {

		System.out.println("print catalog subjectwise");

		String bookFor = request.getParameter("BookFor");
		System.out.println("bookFor" + bookFor);

		int Subject = Integer.parseInt(request.getParameter("Subject"));
		System.out.println("Subject" + Subject);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Catalogue(SubjectWise)";
		HashMap<String, Object> hm = new HashMap<>();

		if (bookFor.equals("All")) {
			hm.put("BookFor", "%");
		} else {
			hm.put("BookFor", bookFor);
		}

		hm.put("subjectId", Subject);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("CatalogLibrarySubjectPage");
	}

	@RequestMapping("CatalogAuthorPageDisplay")
	public ModelAndView CatalogAuthorPageDisplay(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			List LibraryAuthorList = libraryReportServiceInterface.getAuthorList();
			return new ModelAndView("CatalogLibraryAuthorTP", "LibraryAuthorList", LibraryAuthorList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "AutherPageReportLab", params = "AutherPageReport")
	public ModelAndView AutherPageReportLab(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String Author = request.getParameter("Author");
		System.out.println("Author" + Author);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Catalogue(AuthorWise)";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("authorName", Author);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("CatalogTitlePageDisplay")
	public ModelAndView CatalogTitlePageDisplay(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			List LibraryTitleList = libraryReportServiceInterface.getTitleList();
			return new ModelAndView("CatalogLibraryTitleTP", "LibraryTitleList", LibraryTitleList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}



	@RequestMapping(value = "TitleReportDisplayLab", params = "TitleReportPage")
	public ModelAndView TitleReportDisplayLab(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String Title = request.getParameter("Title");
		System.out.println("Title" + Title);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Catalogue(TitleWise)";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("titleName", Title);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("CatalogPublisherPageDisplay")
	public ModelAndView CatalogPublicationPageDisplay(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			List LibraryPublisherList = libraryReportServiceInterface.getPublicationList();
			model.addAttribute("LibraryPublisherList", LibraryPublisherList);
			System.out.println("The publisher list in controller" +LibraryPublisherList);
			//return new ModelAndView("CatalogLibraryTitleTP", "LibraryTitleList", LibraryTitleList);
			return new ModelAndView("CatalogLibraryPublicationTP");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "PublicationWiseReportPrintLab", params = "publicationWiseReportPrint")
	public ModelAndView publicationReportDisplayLab(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String Publication = request.getParameter("publication");
		System.out.println("publication" + Publication);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Catalogue( PublisherWise)";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("Publisher", Publication);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("");
	}

	@RequestMapping("PrintAccessionLibraryRegister")
	public ModelAndView printAccessionRegister(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("Acession REgister");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			HashMap vendorNameL = new HashMap<>();
			vendorNameL = libraryReportServiceInterface.getvendorName();
			model.addAttribute("vendorNameL", vendorNameL);

			HashMap bookTypeList = new HashMap<>();
			bookTypeList = libraryReportServiceInterface.getBookType();
			model.addAttribute("bookTypeList", bookTypeList);

			HashMap academicYearList = new HashMap<>();
			academicYearList = libraryReportServiceInterface.getacademicYearList();
			model.addAttribute("academicYearList", academicYearList);

			return new ModelAndView("PrintAccessionLibraryRegisterView");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}


	@RequestMapping(value = "printforReport", params = "AccessionPrint")
	public ModelAndView printAccessionRegisterRpt(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		String bookFor = request.getParameter("BookFor");
		System.out.println("bookFor" + bookFor);
		String vendorName = request.getParameter("vendorName");
		String AcademicYear = request.getParameter("AcademicYear");
		String bookType = request.getParameter("bookType");
		System.out.println("bookFor" +bookFor + "vendorName" + vendorName +  "AcademicYear" + AcademicYear + "bookType"
				+ bookType);
		HashMap<String, Object> hm = new HashMap<>();
		if (bookFor.equals("All")) {
			hm.put("BookFor", "%");
		} else {
			hm.put("BookFor", bookFor);
		}
		if (vendorName.equals("All")) {
			hm.put("vendorName", "%");
		} else {
			hm.put("vendorName", vendorName);
		}
		if (AcademicYear.equals("All")) {
			hm.put("AcademicYear", "%");
		} else {
			hm.put("AcademicYear", AcademicYear);
		}
		if (bookType.equals("All")) {
			hm.put("bookType", "%");
		} else {
			hm.put("bookType", bookType);
		}

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "AccessionLibRegister";
		hm.put("banner", banner);
		// hm.put("", null);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("PrintAccessionLibraryRegisterView");
	}

	/* Edited By Rahul */

	@RequestMapping("SubjectWiseClassBook")
	public ModelAndView SubjectWiseClassBook(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("SubjectWiseClassBook");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("SubjectWiseClassBookPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	/* Edited By Rahul */

	@RequestMapping("subjectClassificationBookReport")
	public ModelAndView subclassification(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("Print book classifivation");

		String bookFor = request.getParameter("BookFor");
		System.out.println("bookFor" + bookFor);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "DegreeBookSubjectWiseClassification";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("BookFor", bookFor);
		hm.put("banner", banner);

		// hm.put("", null);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("LibraryBookInvoiceRecord")
	public ModelAndView LibraryBookInvoiceRecord(Model model, HttpSession session, HttpServletRequest request) {
		System.out.println("LibraryBookInvoiceRecord");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = libraryReportServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			return new ModelAndView("LibraryBookInvoiceRecordPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("PrintYearDetail")
	public ModelAndView PrintYearDetail(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Print Year invoice report");

		int Academicyear = Integer.parseInt(request.getParameter("YearID"));
		System.out.println("Academicyear" + Academicyear);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "Year-Wise Library Report";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("yearId", Academicyear);
		hm.put("banner", banner);

		// hm.put("", null);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("LibraryTotalBook")
	public ModelAndView PrinttotalBook(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Print Year invoice report");

		String Academicyear = request.getParameter("academicYear");
		System.out.println("Academicyear" + Academicyear);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "TotalBooksReport";
		HashMap<String, Object> hm = new HashMap<>();
		/*
		 * hm.put("yearId", Academicyear); hm.put("banner", banner);
		 */
		hm.put("", null);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("reportVendorBookForYear")
	public ModelAndView reportVendorBookForYear(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("reportVendorBookForYear");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap vendorNameL = new HashMap<>();
			vendorNameL = libraryReportServiceInterface.getvendorName();
			model.addAttribute("vendorNameL", vendorNameL);

			HashMap<String, String> YearList;
			YearList = libraryReportServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			HashMap<String, String> BTMList = libraryReportServiceInterface.bookTypeList();
			model.addAttribute("BTMList", BTMList);

			return new ModelAndView("reportVendorBookForYearPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("vendorBookForandYearwiseBookReport")
	public ModelAndView vendorBookForandYearwiseBookReport(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("Print vendorBookForandYearwiseBook Report ");

		String bookFor = request.getParameter("BookFor");
		System.out.println("bookFor" + bookFor);
		String Academicyear = request.getParameter("academicYear");
		System.out.println("Academicyear" + Academicyear);
		String vendor = request.getParameter("vendorName");
		System.out.println("vendor" + vendor);
		String bookType = request.getParameter("BookType");
		System.out.println("bookType" + bookType);

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "BookForYearVendorBookTypeReport";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("AcademicYear", Academicyear);
		hm.put("BookFor", bookFor);
		hm.put("VendorName", vendor);
		hm.put("bookType", bookType);
		hm.put("banner", banner);

		hm.put("", null);
		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("BookBankReport")
	public ModelAndView BookBankReport(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("View page BookBankReport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			List<String> BookBankDataList = new ArrayList<>();
			BookBankDataList = libraryReportServiceInterface.getBookBankData();
			model.addAttribute("BookBankDataList", BookBankDataList);

			return new ModelAndView("bookBankListViewPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping(value = "StudentBookBankData", params = "PrintBookBankList")
	public ModelAndView BookBank(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BookBank report");

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String filename = "BookBankReport";
		HashMap<String, Object> hm = new HashMap<>();
		// hm.put("", null);
		// hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

	@RequestMapping("BookBankperticularReport")
	public ModelAndView BookBankperticularReport(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("View page BookBankReport");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			return new ModelAndView("bookBankStudentRptPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("BookInvoiceRecord")
	public ModelAndView BookInvoiceRecord(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("BookInvoiceRecord");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = libraryReportServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);

			HashMap<String, String> YearList;
			YearList = libraryReportServiceInterface.getYearList();
			System.out.println(YearList);
			model.addAttribute("YearList", YearList);

			return new ModelAndView("BookInvoiceRecordPage");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping(value="PrintLibraryBookInvoiceRecord")
	public ModelAndView PrintLibraryBookInvoiceRecord(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Print Library Book Invoice Record");

		ServletContext context = session.getServletContext();
		String banner = context.getRealPath("/images/report/Capturenew.jpg");

		String Year = request.getParameter("YearID");
		System.out.println("YearID" + Year);

		String filename = "LibraryBooksInvoiceRecord";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("labacademicyear", Year);
		hm.put("banner", banner);

		try {
			PrintJasperReport.printreport(filename, request, response, hm);
		} catch (JRException | NamingException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("");
	}

}
