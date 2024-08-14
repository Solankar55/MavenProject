package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Barcodemodel")
public class Barcodemodel {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BarCodeid;
	
	@Column
	private String Barcode;
	
	@OneToOne
	@JoinColumn(name="AccessionLibraryRegisterId")
	private AccessionLibraryRegister accessionLibraryRegister;

	
	
	public int getBarCodeid() {
		return BarCodeid;
	}

	public void setBarCodeid(int barCodeid) {
		BarCodeid = barCodeid;
	}

	public String getBarcode() {
		return Barcode;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public AccessionLibraryRegister getAccessionLibraryRegister() {
		return accessionLibraryRegister;
	}

	public void setAccessionLibraryRegister(
			AccessionLibraryRegister accessionLibraryRegister) {
		this.accessionLibraryRegister = accessionLibraryRegister;
	}
	
}
