package com.srl.srlbi.model;

import static com.srl.srlbi.service.Utilities.format;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the view_profits database table.
 * 
 */
@Entity
@Table(name="view_profits")
@NamedQuery(name="ViewProfit.findAll", query="SELECT v FROM ViewProfit v")
public class ViewProfit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="sales_month", length=9)
	private String salesMonth;
	
	@Lob
	@Column(name="inv_dates")
	private String invDates;

	@Lob
	private String rmrs;
	
	@Lob
	private String invoices;

	@Column(name="purchase_quantity")
	private double purchaseQuantity;

	@Column(name="purchase_rate")
	private double purchaseRate;

	@Column(name="purchase_osl_amount")
	private double purchaseOslAmount;

	@Column(name="purchase_adjustment")
	private double purchaseAdjustment;

	@Column(name="purchase_amount_paid")
	private double purchaseAmountPaid;

	@Column(name="sales_quantity")
	private double salesQuantity;

	@Column(name="sales_amount_total")
	private double salesAmountTotal;
	
	@Column(name="sales_gst")
	private double salesGst;

	@Column(name="withheld_amount")
	private double withheldAmount;

	@Column(name="amount_to_be_received")
	private double amountToBeReceived;

	@Column(name="net_sales_adjustment")
	private double netSalesAdjustment;
	
	@Column(name="actual_amount_received")
	private double actualAmountReceived;

	@Column(name="overdue_amount")
	private double overdueAmount;

	@Column(name="sales_profit")
	private double salesProfit;
	
	@Column(name="net_profit")
	private double netProfit;
	
	@Column(name="expenses")
	private double expenses;

	@Column(name="income_tax_pct")
	@Lob
	private String incomeTaxPct;

	@Column(name="income_tax")
	private double incomeTax;
	
	@Column(name="final_profit")
	private double finalProfit;
	
	@Column(name="partner_1_share")
	private double partner_1_share;
	
	@Column(name="partner_2_share")
	private double partner_2_share;
	
	public String getPurchaseOslAmount() {
		return format(purchaseOslAmount);
	}


	public void setPurchaseOslAmount(double purchaseOslAmount) {
		this.purchaseOslAmount = purchaseOslAmount;
	}


	public String getPurchaseAdjustment() {
		return format(purchaseAdjustment);
	}


	public void setPurchaseAdjustment(double purchaseAdjustment) {
		this.purchaseAdjustment = purchaseAdjustment;
	}


	public String getWithheldAmount() {
		return format(withheldAmount);
	}


	public void setWithheldAmount(double withheldAmount) {
		this.withheldAmount = withheldAmount;
	}


	public String getNetSalesAdjustment() {
		return format(netSalesAdjustment);
	}


	public void setNetSalesAdjustment(double netSalesAdjustment) {
		this.netSalesAdjustment = netSalesAdjustment;
	}


	public String getPartner_1_share() {
		return format(partner_1_share);
	}


	public void setPartner_1_share(double partner_1_share) {
		this.partner_1_share = partner_1_share;
	}


	public String getPartner_2_share() {
		return format(partner_2_share);
	}


	public void setPartner_2_share(double partner_2_share) {
		this.partner_2_share = partner_2_share;
	}

	@Id
	@Column(nullable=false)
	private BigInteger id;

	public ViewProfit() {
	}

	
	public String getExpenses() {
		return format(expenses);
	}


	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}


	public String getIncomeTaxPct() {
		return incomeTaxPct;
	}


	public void setIncomeTaxPct(String incomeTaxPct) {
		this.incomeTaxPct = incomeTaxPct;
	}


	public String getIncomeTax() {
		return format(incomeTax);
	}


	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}


	public String getFinalProfit() {
		return format(finalProfit);
	}


	public void setFinalProfit(double finalProfit) {
		this.finalProfit = finalProfit;
	}


	public String getRmrs() {
		return rmrs;
	}


	public void setRmrs(String rmrs) {
		this.rmrs = rmrs;
	}


	public String getActualAmountReceived() {
		return format(this.actualAmountReceived);
	}

	public void setActualAmountReceived(double actualAmountReceived) {
		this.actualAmountReceived = actualAmountReceived;
	}

	public String getAmountToBeReceived() {
		return format(this.amountToBeReceived);
	}

	public void setAmountToBeReceived(double amountToBeReceived) {
		this.amountToBeReceived = amountToBeReceived;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getInvDates() {
		return this.invDates;
	}

	public void setInvDates(String invDates) {
		this.invDates = invDates;
	}

	public String getInvoices() {
		return this.invoices;
	}

	public void setInvoices(String invoices) {
		this.invoices = invoices;
	}

	public String getNetProfit() {
		return format(this.netProfit);
	}

	public void setNetProfit(double netProfit) {
		this.netProfit = netProfit;
	}

	public String getOverdueAmount() {
		return format(this.overdueAmount);
	}

	public void setOverdueAmount(double overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	public String getPurchaseAmountPaid() {
		return format(this.purchaseAmountPaid);
	}

	public void setPurchaseAmountPaid(double purchaseAmountPaid) {
		this.purchaseAmountPaid = purchaseAmountPaid;
	}

	public double getPurchaseQuantity() {
		return this.purchaseQuantity;
	}

	public void setPurchaseQuantity(double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getPurchaseRate() {
		return format(this.purchaseRate);
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getSalesAmountTotal() {
		return format(this.salesAmountTotal);		
	}
	
	


	public void setSalesAmountTotal(double salesAmountTotal) {
		this.salesAmountTotal = salesAmountTotal;
	}
	
//	
//	
//	public static String priceWithDecimal (Double price) {
//	    DecimalFormat formatter = new DecimalFormat("##,##,##,##,###.00");
//	    return formatter.format(price);
//	}
//
//	public static String priceWithoutDecimal (Double price) {
//	    DecimalFormat formatter = new DecimalFormat("##,##,##,##,###.##");
//	    return formatter.format(price);
//	}
//
//	public static String priceToString(Double price) {
//	    String toShow = priceWithoutDecimal(price);
//	    if (toShow.indexOf(".") > 0) {
//	        return priceWithDecimal(price);
//	    } else {
//	        return priceWithoutDecimal(price);
//	    }
//	}
//	

	public String getSalesGst() {
		return format(this.salesGst);
	}

	public void setSalesGst(double salesGst) {
		this.salesGst = salesGst;
	}

	public String getSalesMonth() {
		return this.salesMonth;
	}

	public void setSalesMonth(String salesMonth) {
		this.salesMonth = salesMonth;
	}

	public String getSalesProfit() {
		return format(this.salesProfit);
	}

	public void setSalesProfit(double salesProfit) {
		this.salesProfit = salesProfit;
	}

	public double getSalesQuantity() {
		return this.salesQuantity;
	}

	public void setSalesQuantity(double salesQuantity) {
		this.salesQuantity = salesQuantity;
	}


}