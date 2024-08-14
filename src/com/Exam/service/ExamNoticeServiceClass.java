package com.Exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exam.daoInterface.ExamNoticeDaoInterface;
import com.Exam.model.ParentExamNoticeEnteryModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeEnteryModel;
import com.Exam.model.StudentExamNoticeModel;
import com.Exam.serviceInterface.ExamNoticeServiceInterface;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

@Service
public class ExamNoticeServiceClass implements ExamNoticeServiceInterface{

	@Autowired
	private ExamNoticeDaoInterface examNoticeDaoInterface;

	public ExamNoticeDaoInterface getExamNoticeDaoInterface() {
		return examNoticeDaoInterface;
	}

	public void setExamNoticeDaoInterface(ExamNoticeDaoInterface examNoticeDaoInterface) {
		this.examNoticeDaoInterface = examNoticeDaoInterface;
	}

	@Transactional
	@Override
	public List<StaffRegistrationModel> getStaffList(String username) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStaffList(username);
	}

	@Transactional
	@Override
	public HashMap<String, String> getYearList() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getYearList();
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamList() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStreamList();
	}

	@Transactional
	@Override
	public List<String> getBranch(int id) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getBranchlist(id);
	}

	@Transactional
	@Override
	public List<String> GetStamdardList(int branchid) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStandardList(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStandardWiseList( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public HashMap<String, String> getYearListP() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getYearListP();
	}

	@Transactional
	@Override
	public List<String> getBranchP(int id) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getBranchP(id);
	}

	@Transactional
	@Override
	public HashMap<String, String> getStreamListP() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStreamListP();
	}

	@Transactional
	@Override
	public List<String> GetStamdardListP(int branchid) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStandardListP(branchid);
	}

	@Transactional
	@Override
	public List<String> getStandardWiseListP(int yearId, int streamid, int branchid, int standardID) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStandardWiseListP( yearId,  streamid,  branchid,  standardID);
	}

	@Transactional
	@Override
	public void saveStudentExamNoticeModel(StudentExamNoticeModel studentExamNoticeModel) {
		// TODO Auto-generated method stub
		examNoticeDaoInterface.saveStudentExamNoticeModel(studentExamNoticeModel);
	}

	@Transactional
	@Override
	public int noticeStudentExamMaxID() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.noticeStudentExamMaxID();
	}

	@Transactional
	@Override
	public void saveStudentExamNoticeStudentEntryModel(StudentExamNoticeEnteryModel studentExamNoticeEnteryModel) {
		// TODO Auto-generated method stub
		examNoticeDaoInterface.saveStudentExamNoticeStudentEntryModel( studentExamNoticeEnteryModel);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getStudentContactN(int studID) {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.getStudentContactN(studID);
	}

	@Transactional
	@Override
	public void saveParentExamNoticeModel(ParentExamNoticeModel parentExamNoticeModel) {
		// TODO Auto-generated method stub
		examNoticeDaoInterface.saveParentExamNoticeModel(parentExamNoticeModel) ;
	}

	@Transactional
	@Override
	public int noticeParentExamMaxID() {
		// TODO Auto-generated method stub
		return examNoticeDaoInterface.noticeParentExamMaxID();
	}

	@Transactional
	@Override
	public void saveParentExamNoticeStudentEntryModel(ParentExamNoticeEnteryModel parentExamNoticeEnteryModel) {
		// TODO Auto-generated method stub
		examNoticeDaoInterface.saveParentExamNoticeStudentEntryModel(parentExamNoticeEnteryModel);
	}
	
	
}
