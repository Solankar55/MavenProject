package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.student.daoInteerface.DownloadDaoInterface;
import com.student.model.StudentAdmissionModel;
import com.student.model.StudentRegistrationModel;
import com.student.serviceInterface.DownloadServiceInterface;

@Repository
public class DownloadServiceC implements DownloadServiceInterface{

	@Autowired
	private DownloadDaoInterface downloadDaoInterface;

	public DownloadDaoInterface getDownloadDaoInterface() {
		return downloadDaoInterface;
	}

	public void setDownloadDaoInterface(DownloadDaoInterface downloadDaoInterface) {
		this.downloadDaoInterface = downloadDaoInterface;
	}

	@Transactional
	@Override
	public List<StudentRegistrationModel> getStudInfo(String username) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudInfo(username);
	}

	@Transactional
	@Override
	public List<String> GetDetailInfo(String studName, String studCon) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.GetDetailInfo(studName,studCon);
	}

	@Transactional
	@Override
	public List<String> GetStudDetails(String username) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.GetStudDetails(username);
	}

	@Transactional
	@Override
	public List<StudentAdmissionModel> getRequestStudInfo(String studName, String studCon, String studEmail) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getRequestStudInfo(studName,studCon,studEmail);
	}

	@Transactional
	@Override
	public int getStudFlag(int studID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getFlagStud(studID);
	}

	@Transactional
	@Override
	public void UpdateBonafideFlag(int studID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateBonafideFlag(studID);
	}

	@Transactional
	@Override
	public int getDownLoadValue(int studID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getDownloadValue(studID);
	}

	@Transactional
	@Override
	public List<String> getStudDetails(String studName, String studCon) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.getStudDetails(studName,studCon);
	}

	@Transactional
	@Override
	public int checkIDFlag(int studID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.checkIDFlag(studID);
	}

	@Transactional
	@Override
	public void updateIDCardFlag(int studentID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateIDCardFlag(studentID);
	}

	@Transactional
	@Override
	public int checkLeavingCertificateFlag(int studID) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.checkLeavingCertificateFlag(studID);
	}

	@Transactional
	@Override
	public List<String> GetStudentDetails(String studName, String studCon) {
		// TODO Auto-generated method stub
		return downloadDaoInterface.GetStudentDetails(studName,studCon);
	}

	@Transactional
	@Override
	public void updateLeavingCertificateFlag(int studentID) {
		// TODO Auto-generated method stub
		downloadDaoInterface.updateLeavingCertificateFlag(studentID);
	}
	
	
	
}
