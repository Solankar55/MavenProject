package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClearanceLecturer")
public class ClearanceLecturer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int ClearenceLecturerId;
	@Column
	private int TotalFine;
	@Column
	private int PaidFine;
	@Column
	private String Date;
	
	public int getClearenceLecturerId() {
		return ClearenceLecturerId;
	}

	public void setClearenceLecturerId(int clearenceLecturerId) {
		ClearenceLecturerId = clearenceLecturerId;
	}

	public int getTotalFine() {
		return TotalFine;
	}

	public void setTotalFine(int totalFine) {
		TotalFine = totalFine;
	}

	public int getPaidFine() {
		return PaidFine;
	}

	public void setPaidFine(int paidFine) {
		PaidFine = paidFine;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getLecturerBookCode() {
		return LecturerBookCode;
	}

	public void setLecturerBookCode(int lecturerBookCode) {
		LecturerBookCode = lecturerBookCode;
	}

	private int LecturerBookCode;
	
}
