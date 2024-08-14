package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.account.model.acadamicYearModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="AccessibilityMaster")
public class AccessibilityMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AccessibilityId;
	@Column
	private String Category;
	@Column
	private int CanIssue;
	@Column
	private int ReturnInDays;
	@Column
	private int Fine;
	
	/*@OneToMany(mappedBy = "IARBStudent")
	private List<IssueAndReturnBookStudent> issueandreturnbookstudent = new ArrayList<>();
*/	
	@OneToMany(mappedBy = "IARBLecturer")
	private List<IssueAndReturnBookLecturer> issueandreturnbooklecturer = new ArrayList<>();

	@OneToOne
	@JoinColumn(name="labacademicyearid")
	private LibraryAcademicYearModel libraryAcademicYearModel;
	
	public int getAccessibilityId() {
		return AccessibilityId;
	}

	public void setAccessibilityId(int accessibilityId) {
		AccessibilityId = accessibilityId;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getCanIssue() {
		return CanIssue;
	}

	public void setCanIssue(int canIssue) {
		CanIssue = canIssue;
	}

	public int getReturnInDays() {
		return ReturnInDays;
	}

	public void setReturnInDays(int returnInDays) {
		ReturnInDays = returnInDays;
	}

	public int getFine() {
		return Fine;
	}

	public void setFine(int fine) {
		Fine = fine;
	}

/*	public List<IssueAndReturnBookStudent> getIssueandreturnbookstudent() {
		return issueandreturnbookstudent;
	}

	public void setIssueandreturnbookstudent(List<IssueAndReturnBookStudent> issueandreturnbookstudent) {
		this.issueandreturnbookstudent = issueandreturnbookstudent;
	}*/

	public List<IssueAndReturnBookLecturer> getIssueandreturnbooklecturer() {
		return issueandreturnbooklecturer;
	}

	public void setIssueandreturnbooklecturer(List<IssueAndReturnBookLecturer> issueandreturnbooklecturer) {
		this.issueandreturnbooklecturer = issueandreturnbooklecturer;
	}

	public LibraryAcademicYearModel getLibraryAcademicYearModel() {
		return libraryAcademicYearModel;
	}

	public void setLibraryAcademicYearModel(LibraryAcademicYearModel libraryAcademicYearModel) {
		this.libraryAcademicYearModel = libraryAcademicYearModel;
	}
	
}
