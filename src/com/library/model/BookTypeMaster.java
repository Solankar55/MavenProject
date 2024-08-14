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
@Table(name="BookTypeMaster")
public class BookTypeMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int BooktypeId;
	@Column
	private String Booktype;
	@Column
	private String status="Active";

	@JsonIgnore
	@OneToOne(mappedBy = "BTMaster")
	private QuantityDataMaster quantityDataMaster;
	
	public int getBooktypeId() {
		return BooktypeId;
	}

	public void setBooktypeId(int booktypeId) {
		BooktypeId = booktypeId;
	}

	public String getBooktype() {
		return Booktype;
	}

	public void setBooktype(String booktype) {
		Booktype = booktype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public QuantityDataMaster getQuantityDataMaster() {
		return quantityDataMaster;
	}

	public void setQuantityDataMaster(QuantityDataMaster quantityDataMaster) {
		this.quantityDataMaster = quantityDataMaster;
	}
	

	/*public AccessionLibraryRegister getAccessionlibraryregister() {
		return accessionlibraryregister;
	}

	public void setAccessionlibraryregister(AccessionLibraryRegister accessionlibraryregister) {
		this.accessionlibraryregister = accessionlibraryregister;
	}
*/
			
	


}
