package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PurchaceBooKModel {
	@Id
	@GeneratedValue
	private int purId;
	String Book;
	@OneToMany(mappedBy="purchaceBooKModel")
	List<QuantityDataMaster> quality=new ArrayList<>();
	
	
	public int getPurId() {
		return purId;
	}
	public void setPurId(int purId) {
		this.purId = purId;
	}
	public List<QuantityDataMaster> getQuality() {
		return quality;
	}
	public void setQuality(List<QuantityDataMaster> quality) {
		this.quality = quality;
	}
	public String getBook() {
		return Book;
	}
	public void setBook(String book) {
		Book = book;
	} 
	

}
