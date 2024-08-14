package com.Exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CreateTimeTable")
public class CreateTimeTableModel {

	@Id
	@GeneratedValue
	
	private int TimeTbaleID;
	private String TimeTableDate;
	private String FromDate;
	private String TODate;
	private String EventName;
	private String TeacherName;
	
	
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public int getTimeTbaleID() {
		return TimeTbaleID;
	}
	public void setTimeTbaleID(int timeTbaleID) {
		TimeTbaleID = timeTbaleID;
	}
	public String getTimeTableDate() {
		return TimeTableDate;
	}
	public void setTimeTableDate(String timeTableDate) {
		TimeTableDate = timeTableDate;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getTODate() {
		return TODate;
	}
	public void setTODate(String tODate) {
		TODate = tODate;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	
	
}
