package com.Exam.serviceInterface;

import java.util.HashMap;
import java.util.List;

import com.Exam.model.ParentExamNoticeEnteryModel;
import com.Exam.model.ParentExamNoticeModel;
import com.Exam.model.StudentExamNoticeEnteryModel;
import com.Exam.model.StudentExamNoticeModel;
import com.HOD.model.StaffRegistrationModel;
import com.student.model.StudentAdmissionModel;

public interface ExamNoticeServiceInterface {

	List<StaffRegistrationModel> getStaffList(String username);

	HashMap<String, String> getYearList();

	HashMap<String, String> getStreamList();

	List<String> getBranch(int id);

	List<String> GetStamdardList(int branchid);

	List<String> getStandardWiseList(int yearId, int streamid, int branchid, int standardID);

	HashMap<String, String> getYearListP();

	List<String> getBranchP(int id);

	HashMap<String, String> getStreamListP();

	List<String> GetStamdardListP(int branchid);

	List<String> getStandardWiseListP(int yearId, int streamid, int branchid, int standardID);

	void saveStudentExamNoticeModel(StudentExamNoticeModel studentExamNoticeModel);

	int noticeStudentExamMaxID();

	void saveStudentExamNoticeStudentEntryModel(StudentExamNoticeEnteryModel studentExamNoticeEnteryModel);

	List<StudentAdmissionModel> getStudentContactN(int studID);

	void saveParentExamNoticeModel(ParentExamNoticeModel parentExamNoticeModel);

	int noticeParentExamMaxID();

	void saveParentExamNoticeStudentEntryModel(ParentExamNoticeEnteryModel parentExamNoticeEnteryModel);

}
