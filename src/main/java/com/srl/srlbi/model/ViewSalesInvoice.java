package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_sales_invoice database table.
 * 
 */
@Entity
@Table(name="view_sales_invoice")
@NamedQuery(name="ViewSalesInvoice.findAll", query="SELECT v FROM ViewSalesInvoice v")
public class ViewSalesInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private double adjustments;

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

	private double quantity;

	@Column(nullable=false)
	private double total;

	public ViewSalesInvoice() {
	}

	public double getAdjustments() {
		return this.adjustments;
	}

	public void setAdjustments(double adjustments) {
		this.adjustments = adjustments;
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