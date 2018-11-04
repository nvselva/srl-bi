package com.srl.srlbi.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import static com.srl.srlbi.service.Utilities.format;


/**
 * The persistent class for the view_expense_detail database table.
 * 
 */
@Entity
@Table(name="view_expense_detail")
@NamedQuery(name="ViewExpenseDetail.findAll", query="SELECT v FROM ViewExpenseDetail v")
public class ViewExpenseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name="expense_month")
	private String expenseMonth;

	@Lob
	@Column(name="expense_account")
	private String expenseAccount;

	@Column(name="expense_amount")
	private double expenseAmount;

	public ViewExpenseDetail() {
	}

	@Id
	@Column(nullable=false)
	private BigInteger id;


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getExpenseAccount() {
		return this.expenseAccount;
	}

	public void setExpenseAccount(String expenseAccount) {
		this.expenseAccount = expenseAccount;
	}

	public String getExpenseAmount() {
		return format(this.expenseAmount);
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseMonth() {
		return this.expenseMonth;
	}

	public void setExpenseMonth(String expenseMonth) {
		this.expenseMonth = expenseMonth;
	}

}