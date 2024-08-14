package com.Alumini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Alumini.daoInterface.StudentManagmentDaoInterface;
import com.Alumini.serviceInterface.StudentManagmentServiceInterface;

@Service
public class StudentManagmentServiceClass implements StudentManagmentServiceInterface{

	@Autowired
	private StudentManagmentDaoInterface studentManagmentDaoInterface;

	public StudentManagmentDaoInterface getStudentManagmentDaoInterface() {
		return studentManagmentDaoInterface;
	}

	public void setStudentManagmentDaoInterface(StudentManagmentDaoInterface studentManagmentDaoInterface) {
		this.studentManagmentDaoInterface = studentManagmentDaoInterface;
	}

	@Transactional
	@Override
	public List<String> getStudentList() {
		// TODO Auto-generated method stub
		return studentManagmentDaoInterface.getStudentList();
	}
	
	
}
