package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LibraryBookInDepartment")
public class BookInDepartment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int BookInDepartmentID;
	private String status="Active";
	
	
	@OneToOne
	@JoinColumn(name="AccessionLibraryRegisterId")
	private AccessionLibraryRegister accessionLibraryRegister;

	@ManyToOne
	@JoinColumn(name="DepartmentId")
	private Department department;
	
	
	

	public int getBookInDepartmentID() {
		return BookInDepartmentID;
	}

	public void setBookInDepartmentID(int bookInDepartmentID) {
		BookInDepartmentID = bookInDepartmentID;
	}

	public AccessionLibraryRegister getAccessionLibraryRegister() {
		return accessionLibraryRegister;
	}

	public void setAccessionLibraryRegister(AccessionLibraryRegister accessionLibraryRegister) {
		this.accessionLibraryRegister = accessionLibraryRegister;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
