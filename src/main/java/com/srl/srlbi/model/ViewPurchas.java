package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_purchases database table.
 * 
 */
@Entity
@Table(name="view_purchases")
@NamedQuery(name="ViewPurchas.findAll", query="SELECT v FROM ViewPurchas v")
public class ViewPurchas implements Serializable {
	private static final long serialVersionUID = 1L;

	private double adjustment;

	@Column(name="cust_wo", nullable=false)
	private int custWo;

	@Id
	@Column(nullable=false)
	private BigInteger id;

	@Lob
	private String invoice;

	@Column(name="paid_amount")
	private double paidAmount;

	private double quantity;

	private double rate;

	@Column(length=26)
	private String RMRs;

	public ViewPurchas() {
	}

	public double getAdjustment() {
		return this.adjustment;
	}

	public void setAdjustment(double adjustment) {
		this.adjustment = adjustment;
	}

	public int getCustWo() {
		return this.custWo;
	}

	public void setCustWo(int custWo) {
		this.custWo = custWo;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getRMRs() {
		return this.RMRs;
	}

	public void setRMRs(String RMRs) {
		this.RMRs = RMRs;
	}

}