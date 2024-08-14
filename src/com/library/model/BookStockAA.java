package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BookStockAA")
public class BookStockAA {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int BookStockAAId;
	@Column
	private int IssueQuantity;
	@Column
	private int AvailableQuantity;
	@Column
	private int ReturnQuantity;
	@Column
	private int RenewalQuantity;
	
	
	
}
