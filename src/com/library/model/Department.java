package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LibraryDepartmentMaster")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int DepartmentId;
	
	@Column
	private String Department;
	
	@Column
	private String status="Active";

	@OneToMany(mappedBy="department")
	private List<BookInDepartment> bookInDepartment= new ArrayList<BookInDepartment>();
	
	public int getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookInDepartment> getBookInDepartment() {
		return bookInDepartment;
	}

	public void setBookInDepartment(List<BookInDepartment> bookInDepartment) {
		this.bookInDepartment = bookInDepartment;
	}
}
