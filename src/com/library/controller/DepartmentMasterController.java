package com.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admin.model.AdminRegistrationModel;
import com.library.model.Department;
import com.library.serviceInterface.DepartmentMasterServiceInterface;

@Controller
public class DepartmentMasterController {

	@Autowired
	private DepartmentMasterServiceInterface departmentMasterServiceInterface;

	public DepartmentMasterServiceInterface getDepartmentMasterServiceInterface() {
		return departmentMasterServiceInterface;
	}

	public void setDepartmentMasterServiceInterface(DepartmentMasterServiceInterface departmentMasterServiceInterface) {
		this.departmentMasterServiceInterface = departmentMasterServiceInterface;
	}
	
	@RequestMapping("DepartmentPageDisplay")
	public ModelAndView DepartmentPage(HttpServletRequest request, HttpSession session, Model model) {

		session = request.getSession();
		String username = (String) session.getAttribute("Username");
		System.out.println("userName" + username);

		List<AdminRegistrationModel> checkAdminDetails;

		checkAdminDetails = departmentMasterServiceInterface.checkAdmin(username);

		try {
			String Name = checkAdminDetails.get(0).getName();
			System.out.println(Name);
			/*
			 * List<DepartmentMaster> DepartmentList =
			 * departmentServiceInterface.DepartmentList(); return new
			 * ModelAndView("DepartmentMasterTP","DList",DepartmentList);
			 */
			List<Department> DepartmentList = departmentMasterServiceInterface.getListOfDepartment();
			return new ModelAndView("DepartmentMasterTP", "DList", DepartmentList);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			model.addAttribute("MessageToAccount", "Session Expaire Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("SaveDepartmentData")
	public ModelAndView DepartmentSave(@ModelAttribute("department") Department department)
	{
		departmentMasterServiceInterface.saveDepartment(department);
		List<Department> DepartmentList = departmentMasterServiceInterface.getListOfDepartment();
		return new ModelAndView("DepartmentMasterTP","DList",DepartmentList);
	}
	
	@RequestMapping(value="UpdateDepartmentData",params="Update")
	public ModelAndView UpdateDepartmentData(@RequestParam("DepartmentId") int id, @RequestParam("Department") String Department)
	{
		departmentMasterServiceInterface.updateDepartmentData(id, Department);
		List<Department> DepartmentList = departmentMasterServiceInterface.getListOfDepartment();
		return new ModelAndView("DepartmentMasterTP","DList",DepartmentList);
	}
	
	@RequestMapping(value="UpdateDepartmentData",params="Delete")
	public ModelAndView DeletDepartmentData( HttpServletRequest request)
	{
		int id=Integer.parseInt(request.getParameter("DepartmentId"));
		departmentMasterServiceInterface.deleteDepartmentData(id);
		List<Department> DepartmentList = departmentMasterServiceInterface.getListOfDepartment();
		return new ModelAndView("DepartmentMasterTP","DList",DepartmentList);
	}
}
