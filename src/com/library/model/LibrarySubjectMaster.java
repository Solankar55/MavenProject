package com.library.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="LibrarySubjectMaster")
public class LibrarySubjectMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int LibrarySubjectMasterId;
	@Column
	private String LibrarySubject;
	@Column
	private String status="Active";
	
	@JsonIgnore
	@OneToOne(mappedBy = "LSMaster")
	private QuantityDataMaster quantityDataMaster;
	
	public int getLibrarySubjectMasterId() {
		return LibrarySubjectMasterId;
	}

	public void setLibrarySubjectMasterId(int librarySubjectMasterId) {
		LibrarySubjectMasterId = librarySubjectMasterId;
	}

	public String getLibrarySubject() {
		return LibrarySubject;
	}

	public void setLibrarySubject(String librarySubject) {
		LibrarySubject = librarySubject;
	}

	public QuantityDataMaster getQuantityDataMaster() {
		return quantityDataMaster;
	}

	public void setQuantityDataMaster(QuantityDataMaster quantityDataMaster) {
		this.quantityDataMaster = quantityDataMaster;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
