package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="DuplicateLeavingCertificate")
public class DuplicateLeavingCertificateModel {

	@Id
	@GeneratedValue
	
	private int duplicatelcid;
	private String lcstatus="DuplicateIssue";
	private String lcdate;
	private int studentid;
	
	public int getDuplicatelcid() {
		return duplicatelcid;
	}
	public String getLcstatus() {
		return lcstatus;
	}
	public String getLcdate() {
		return lcdate;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setDuplicatelcid(int duplicatelcid) {
		this.duplicatelcid = duplicatelcid;
	}
	public void setLcstatus(String lcstatus) {
		this.lcstatus = lcstatus;
	}
	public void setLcdate(String lcdate) {
		this.lcdate = lcdate;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	
}
