package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_quantity_sold database table.
 * 
 */
@Entity
@Table(name="view_quantity_sold")
@NamedQuery(name="ViewQuantitySold.findAll", query="SELECT v FROM ViewQuantitySold v")
public class ViewQuantitySold implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cust_wo", length=255)
	private String custWo;

	@Column(name="wo_qty")
	private double woQty;
	
	@Lob
	private String invoices;

	@Column(name="qty_sold")
	private double qtySold;

	@Id
	@Column(nullable=false)
	private BigInteger id;


	public ViewQuantitySold() {
	}

	public double getWoQty() {
		return woQty;
	}

	public void setWoQty(double woQty) {
		this.woQty = woQty;
	}

	public String getCustWo() {
		return this.custWo;
	}

	public void setCustWo(String custWo) {
		this.custWo = custWo;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getInvoices() {
		return this.invoices;
	}

	public void setInvoices(String invoices) {
		this.invoices = invoices;
	}

	public double getQtySold() {
		return this.qtySold;
	}

	public void setQtySold(double qtySold) {
		this.qtySold = qtySold;
	}

}