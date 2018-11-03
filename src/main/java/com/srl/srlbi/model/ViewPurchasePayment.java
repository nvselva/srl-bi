package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_purchase_payments database table.
 * 
 */
@Entity
@Table(name="view_purchase_payments")
@NamedQuery(name="ViewPurchasePayment.findAll", query="SELECT v FROM ViewPurchasePayment v")
public class ViewPurchasePayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="bill_number", nullable=false)
	private int billNumber;

	@Id
	@Column(nullable=false)
	private BigInteger id;

	@Column(name="paid_amount")
	private double paidAmount;

	public ViewPurchasePayment() {
	}

	public int getBillNumber() {
		return this.billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

}