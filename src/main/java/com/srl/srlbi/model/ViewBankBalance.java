package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

import static com.srl.srlbi.service.Utilities.format;

/**
 * The persistent class for the view_bank_balance database table.
 * 
 */
@Entity
@Table(name="view_bank_balance")
@NamedQuery(name="ViewBankBalance.findAll", query="SELECT v FROM ViewBankBalance v")
public class ViewBankBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="till_date")
	private Date tillDate;

	@Column(name="debit_amt")
	private double debitAmt;
	
	@Column(name="credit_amt")
	private double creditAmt;

	@Column(name="bank_balance")
	private double bankBalance;
	
	@Column(name="cash_balance")
	private double cashBalance;
	
	
	public String getCashBalance() {
		return format(cashBalance);
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	@Id
	@Column(nullable=false)
	private BigInteger id;

	public ViewBankBalance() {
	}

	public String getDebitAmt() {
		return format(debitAmt);
	}

	public void setDebitAmt(double debitAmt) {
		this.debitAmt = debitAmt;
	}

	public String getCreditAmt() {
		return format(creditAmt);
	}

	public void setCreditAmt(double creditAmt) {
		this.creditAmt = creditAmt;
	}

	public String getBankBalance() {
		return format(this.bankBalance);
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getTillDate() {
		return this.tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

}