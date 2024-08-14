package com.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.LibraryBooksRecordServiceInterface;

@Controller
public class LibraryBooksRecordController {

	@Autowired
	private LibraryBooksRecordServiceInterface libraryBooksRecordServiceInterface;

	@RequestMapping("subjectWiseBooksRecords")
	public ModelAndView subjectWise(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("subjectwise record page");
		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = libraryBooksRecordServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);


			List<StudentAdmissionModel> studAdmission;
			studAdmission=libraryBooksRecordServiceInterface.getStudAdmissionInfo(studCon,StudEmail);

			System.out.println("studAdmission size : "+studAdmission.size());


			if(studAdmission.size()==0)
			{
				model.addAttribute("StudMessageForLibrary",
						"You have not requested for Admission yet Or Your Admission has been Cancelled");

				session=request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = libraryBooksRecordServiceInterface.getStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			}
			else
			{
				HashMap<String, String> BookSubList;
				BookSubList = libraryBooksRecordServiceInterface.getBookSubList();
				model.addAttribute("BookSubList", BookSubList);
				System.out.println("BookLIst in controller : " + BookSubList);
				return new ModelAndView("SubjectWiseBookRecordView");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}

	}

	@RequestMapping("titleWiseBooksRecords")
	public ModelAndView titleWise(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("TitleWise record page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = libraryBooksRecordServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);

			List<StudentAdmissionModel> studAdmission;
			studAdmission=libraryBooksRecordServiceInterface.getStudAdmissionInfo(studCon,StudEmail);

			if(studAdmission.size()==0)
			{
				model.addAttribute("StudMessageForLibrary",
						"You have not requested for Admission yet Or Your Admission has been Cancelled");

				session=request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = libraryBooksRecordServiceInterface.getStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			}

			else{
				HashMap<String, String> BookTitleList;
				BookTitleList = libraryBooksRecordServiceInterface.getBookTitleList();
				model.addAttribute("BookTitleList", BookTitleList);
				System.out.println("BookTitleList in controller : " + BookTitleList);

				return new ModelAndView("TitleWiseBookRecordView");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("authorWiseBooksRecords")
	public ModelAndView authorWise(Model model, HttpSession session, HttpServletRequest request,
			@ModelAttribute("RegisterStudent") StudentRegistrationModel studentRegistrationModel) {
		System.out.println("AuthorWise record page");

		session = request.getSession();
		String username = (String) session.getAttribute("Username");

		List<StudentRegistrationModel> StudList = new ArrayList<>();
		StudList = libraryBooksRecordServiceInterface.getStudInfo(username);

		try {
			String studName = StudList.get(0).getStudentName();
			String studCon = StudList.get(0).getStudentContactNumber();
			String StudEmail = StudList.get(0).getStudentEmail();
			System.out.println("studName" + studName);
			System.out.println("studCon" + studCon);
			System.out.println("StudEmail" + StudEmail);

			List<StudentAdmissionModel> studAdmission;
			studAdmission=libraryBooksRecordServiceInterface.getStudAdmissionInfo(studCon,StudEmail);

			if(studAdmission.size()==0)
			{
				model.addAttribute("StudMessageForLibrary",
						"You have not requested for Admission yet Or Your Admission has been Cancelled");

				session=request.getSession();
				String username1 = (String) session.getAttribute("Username");

				List<String> GetStudList = new ArrayList<>();
				GetStudList = libraryBooksRecordServiceInterface.getStudDetails(username1);

				model.addAttribute("GetStudInfo", GetStudList);
				return new ModelAndView("StudentHome");
			}

			else
			{
				HashMap<String, String> BookAuthorList;
				BookAuthorList = libraryBooksRecordServiceInterface.getBookAuthorList();
				model.addAttribute("BookAuthorList", BookAuthorList);
				System.out.println("BookTitleList in controller : " + BookAuthorList);
				return new ModelAndView("AuthorWiseBookRecordView");
			}

		} catch (Exception e) {
			model.addAttribute("MessageToStudent", "Session Expired Please Login Again.");
			return new ModelAndView("LoginPage");
		}
	}

	@RequestMapping("getBookDetailStudent")
	@ResponseBody
	public List<String> bookInfoList(String bookName) {
		List<String> bookData = new ArrayList<>();
		System.out.println("sbl");
		bookData = libraryBooksRecordServiceInterface.getBookInfo(bookName);
		System.out.println("bookName in controller : " + bookData);
		return bookData;
	}

	@RequestMapping("getBookSubDetailStudent")
	@ResponseBody
	public List<String> bookSubInfoList(String bookName,String bookfor) {
		List<String> bookData1 = new ArrayList<>();
		System.out.println("sbl");
		bookData1 = libraryBooksRecordServiceInterface.getBookSubInfo(bookName,bookfor);
		System.out.println("bookName in controller : " + bookData1);
		return bookData1;
	}

	@RequestMapping("getBookAuthorDetailStudent")
	@ResponseBody
	public List<String> bookAuthorInfoList(String authorName) {
		List<String> bookData2 = new ArrayList<>();
		System.out.println("sbl");
		bookData2 = libraryBooksRecordServiceInterface.getBookAuthorInfo(authorName);
		System.out.println("bookName in controller : " + bookData2);
		return bookData2;
	}

	@RequestMapping("getBookPublicationDetailStudent")
	@ResponseBody
	public List<String> bookPublisherList(String bookName) {
		List<String> bookData = new ArrayList<>();
		System.out.println("sb2");
		bookData = libraryBooksRecordServiceInterface.getBookPublisherInfo(bookName);
		System.out.println("bookName in controller : " + bookData);
		return bookData;
	}

}
