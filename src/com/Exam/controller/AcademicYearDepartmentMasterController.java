package com.Exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Exam.serviceInterface.AcademicYearDepartmentMasterserviceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.account.model.acadamicYearModel;

@Controller
public class AcademicYearDepartmentMasterController {

	@Autowired
	private AcademicYearDepartmentMasterserviceInterface academicYearDepartmentMasterServiceInterface;

	@RequestMapping("AcademicYear")
	public ModelAndView AcademicYear(Model model, @ModelAttribute("YearMasterD") acadamicYearModel acadamicYearModel,
			HttpServletRequest request, HttpSession httpSession) {
		System.out.println("Academic Year Master Page");

		httpSession = request.getSession();
		String username = (String) httpSession.getAttribute("Username");
		System.out.println(username);

		List<StaffRegistrationModel> getStaffList;
		getStaffList = academicYearDepartmentMasterServiceInterface.getStaffList(username);
		System.out.println(getStaffList);

		try {
			int StaffID = getStaffList.get(0).getStaffRegistrationId();
			System.out.println(StaffID);

			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String curentdate = sdf.format(d);
			String[] str = curentdate.split("-");
			int m = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			StringBuilder builder = new StringBuilder();
			if (m > 6) {
				y += 1;
				builder.append(str[2]);
				builder.append("-");
				builder.append(String.valueOf(y));

			} else {
				y -= 1;
				builder.append(String.valueOf(y));
				builder.append("-");
				builder.append(str[2]);

			}
			String str1 = new String(builder);
			model.addAttribute("curentdate", curentdate);
			model.addAttribute("academic", str1);

			List<String> AcademicYearList;
			AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
			System.out.println(AcademicYearList);

			model.addAttribute("AcademicYearList", AcademicYearList);

			return new ModelAndView("AcdemicDepartmentYearMasterPage");
		} catch (Exception e) {
			System.out.println("Exception" + e);
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		}
	}

	@RequestMapping(value = "SaveAcademicYearDepartMaster", params = "AddAcademicYear")
	public ModelAndView SaveAcademicYearDepartMaster(Model model,
			@ModelAttribute("YearMasterD") acadamicYearModel acadamicYearModel, HttpServletRequest request,
			HttpSession session) {
		System.out.println("Academic Department ADd Master");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println(username);

		if (username.equals("null")) {
			model.addAttribute("MessageForYearMaster",
					"Your Session Is Expired.You Must Login Again To Do Your Work...");
			return new ModelAndView("DepartmentLoginPage");
		} else {
			acadamicYearModel.setUserName(username);
			String year=acadamicYearModel.getAcadamicYear();
			System.out.println("year"+year);
			if(year.equals(""))
			{
				List<String> AcademicYearList;
				AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
				System.out.println(AcademicYearList);

				model.addAttribute("AcademicYearList", AcademicYearList);
				return new ModelAndView("AcdemicDepartmentYearMasterPage");
			}
			else
			{
				academicYearDepartmentMasterServiceInterface.SaveYear(acadamicYearModel);

				List<String> AcademicYearList;
				AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
				System.out.println(AcademicYearList);

				model.addAttribute("AcademicYearList", AcademicYearList);
				return new ModelAndView("AcdemicDepartmentYearMasterPage");	
			}
			
		}
	}

	@RequestMapping(value = "SaveAcademicYearDepartMaster", params = "SetActiveYear")
	public ModelAndView SetActiveYear(Model model) {
		System.out.println("Set Active Year");

		HashMap<String, String> AcademicYearList;
		AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearListKeyValue();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		List<String> ActiveYearList;
		ActiveYearList = academicYearDepartmentMasterServiceInterface.ActiveYearList();
		System.out.println(ActiveYearList);

		model.addAttribute("ActiveYearList", ActiveYearList);

		return new ModelAndView("SetActiveYearPageDepartment");
	}

	@RequestMapping(value = "SaveActiveYearD", method = RequestMethod.GET)
	public ModelAndView SaveActiveYear(HttpServletRequest request, Model model,
			@ModelAttribute("YearMasterD") acadamicYearModel acadamicYearModel) {
		System.out.println("In Activete Year");

		int yearID = Integer.parseInt(request.getParameter("ActiveYearID"));
		System.out.println(yearID);

		academicYearDepartmentMasterServiceInterface.setActiveYear(yearID);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcdemicDepartmentYearMasterPage");
	}

	@RequestMapping(value = "YearOprationD", params = "Update", method = RequestMethod.POST)
	public ModelAndView YearOpration(Model model, HttpServletRequest request,
			@ModelAttribute("YearMasterD") acadamicYearModel acadamicYearModel) {
		System.out.println("Way to Upadate Year");

		int YearId = Integer.parseInt(request.getParameter("AcYearID"));
		System.out.println(YearId);

		String Year = (String) request.getParameter("AcYear");
		System.out.println(Year);

		academicYearDepartmentMasterServiceInterface.UpadteYear(YearId, Year);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcdemicDepartmentYearMasterPage");
	}

	@RequestMapping(value = "YearOprationD", params = "Delete", method = RequestMethod.POST)
	public ModelAndView YearOprationDelete(Model model, HttpServletRequest request,
			@ModelAttribute("YearMasterD") acadamicYearModel acadamicYearModel) {
		System.out.println("Way to Upadate Year");

		int YearId = Integer.parseInt(request.getParameter("AcYearID"));
		System.out.println(YearId);

		String Year = (String) request.getParameter("AcYear");
		System.out.println(Year);

		academicYearDepartmentMasterServiceInterface.DeleteYear(YearId);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String curentdate = sdf.format(d);
		String[] str = curentdate.split("-");
		int m = Integer.parseInt(str[1]);
		int y = Integer.parseInt(str[2]);
		StringBuilder builder = new StringBuilder();
		if (m > 6) {
			y += 1;
			builder.append(str[2]);
			builder.append("-");
			builder.append(String.valueOf(y));

		} else {
			y -= 1;
			builder.append(String.valueOf(y));
			builder.append("-");
			builder.append(str[2]);

		}
		String str1 = new String(builder);
		model.addAttribute("curentdate", curentdate);
		model.addAttribute("academic", str1);

		List<String> AcademicYearList;
		AcademicYearList = academicYearDepartmentMasterServiceInterface.GetAcademicYearList();
		System.out.println(AcademicYearList);

		model.addAttribute("AcademicYearList", AcademicYearList);

		return new ModelAndView("AcdemicDepartmentYearMasterPage");
	}
	public AcademicYearDepartmentMasterserviceInterface getAcademicYearDepartmentMasterServiceInterface() {
		return academicYearDepartmentMasterServiceInterface;
	}

	public void setAcademicYearDepartmentMasterServiceInterface(
			AcademicYearDepartmentMasterserviceInterface academicYearDepartmentMasterServiceInterface) {
		this.academicYearDepartmentMasterServiceInterface = academicYearDepartmentMasterServiceInterface;
	}

}
