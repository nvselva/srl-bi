package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_sales database table.
 * 
 */
@Entity
@Table(name="view_sales")
@NamedQuery(name="ViewSale.findAll", query="SELECT v FROM ViewSale v")
public class ViewSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private double adjustments;

	@Column(name="check_amount")
	private double checkAmount;

	@Column(name="cust_wo", length=255)
	private String custWo;

	private double gst;

	@Id
	@Column(nullable=false)
	private BigInteger id;

	@Lob
	private String invoice;

	@Lob
	@Column(name="invoice_date")
	private String invoiceDate;

	@Column(name="item_total")
	private double itemTotal;

	@Column(name="over_due_amount")
	private double overDueAmount;

	@Column(name="paid_amount")
	private double paidAmount;

	private double quantity;

	@Column(nullable=false)
	private double total;

	public ViewSale() {
	}

	public double getAdjustments() {
		return this.adjustments;
	}

	public void setAdjustments(double adjustments) {
		this.adjustments = adjustments;
	}

	public double getCheckAmount() {
		return this.checkAmount;
	}

	public void setCheckAmount(double checkAmount) {
		this.checkAmount = checkAmount;
	}

	public String getCustWo() {
		return this.custWo;
	}

	public void setCustWo(String custWo) {
		this.custWo = custWo;
	}

	public double getGst() {
		return this.gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
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

	public String getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getItemTotal() {
		return this.itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public double getOverDueAmount() {
		return this.overDueAmount;
	}

	public void setOverDueAmount(double overDueAmount) {
		this.overDueAmount = overDueAmount;
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

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}