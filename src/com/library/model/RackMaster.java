package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RackMaster")
public class RackMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int RackMasterId;
	@Column
	private String RackNumber;
	public int getRackMasterId() {
		return RackMasterId;
	}
	public void setRackMasterId(int rackMasterId) {
		RackMasterId = rackMasterId;
	}
	public String getRackNumber() {
		return RackNumber;
	}
	public void setRackNumber(String rackNumber) {
		RackNumber = rackNumber;
	}
	
	
	
}
