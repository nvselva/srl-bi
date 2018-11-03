package com.srl.srlbi.model;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_invoice", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"invoice_ID", "item_CF_Date", "item_CF_Lorry_No", "item_CF_Receipt_no"})
	}) 
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FILENAME = "Invoice.csv";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name ="audit_createdAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name ="audit_updatedAt",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
	

    //Invoice Date,Invoice ID,Invoice Number,Estimate Number,Invoice Status,Customer Name,Customer ID,Place of Supply,
    //Place of Supply(With State Code),GST Treatment,GST Identification Number (GSTIN),Is Inclusive Tax,Due Date,Expected Payment Date,
    //PurchaseOrder,Template Name,Currency Code,Exchange Rate,Discount Type,Is Discount Before Tax,Entity Discount Percent,
    //Entity Discount Amount,Account,Item Name,Product ID,Item Desc,Quantity,Usage unit,Item Price,Discount,Discount Amount,
    //Expense Reference ID,HSN/SAC,Supply Type,Tax ID,Item Tax,Item Tax %,Item Tax Amount,Item Tax Type,CGST Rate %,SGST Rate %,
    //IGST Rate %,CESS Rate %,CGST(FCY),SGST(FCY),IGST(FCY),CESS(FCY),CGST,SGST,IGST,CESS,Item Type,Item Tax Exemption Reason,
    //Item Total,Custom Charges,Shipping Bill#,Shipping Bill Date,Shipping Bill Total,PortCode,Reference Invoice#,
    //Reference Invoice Date,GST Registration Number(Reference Invoice),Reason for issuing Debit Note,SubTotal,Total,Balance,
    //Shipping Charge,Adjustment,Adjustment Description,Sales person,Payment Terms,Payment Terms Label,Last Payment Date,Notes,
    //Terms & Conditions,Recurrence Name,PayPal,Authorize.Net,Google Checkout,Payflow Pro,Stripe,2Checkout,Braintree,Forte,WorldPay,
    //Payments Pro,Square,WePay,Razorpay,GoCardless,Partial Payments,Billing Address,Billing City,Billing State,Billing Country,
    //Billing Code,Billing Phone,Billing Fax,Shipping Address,Shipping City,Shipping State,Shipping Country,Shipping Code,
    //Shipping Fax,Shipping Phone Number,E-Commerce Operator Name,E-Commerce Operator GSTIN,Item.CF.Date,Item.CF.Lorry No,Item.CF.Receipt no,CF.Withheld Amount
    @CsvBindByName(column ="CF.Withheld Amount")
	private double CF_Withheld_Amount;
	@Lob
	@CsvBindByName(column ="2Checkout")
	private String Checkout;

	@Lob
	@CsvBindByName(column ="Account")
	private String account;

	@CsvBindByName(column ="Adjustment")
	private double adjustment;

	@Lob
	@CsvBindByName(column ="Adjustment Description")
	private String adjustment_Description;

	@Lob
	@CsvBindByName(column ="Authorize.Net")
	private String authorize_Net;

	@CsvBindByName(column ="Balance")
	private double balance;

	@Lob
	@CsvBindByName(column ="Billing Address")
	private String billing_Address;

	@Lob
	@CsvBindByName(column ="Billing City")
	private String billing_City;

	@CsvBindByName(column ="Billing Code")
	private int billing_Code;

	@Lob
	@CsvBindByName(column ="Billing Country")
	private String billing_Country;

	@Lob
	@CsvBindByName(column ="Billing Fax")
	private String billing_Fax;

	@Lob
	@CsvBindByName(column ="Billing Phone")
	private String billing_Phone;

	@Lob
	@CsvBindByName(column ="Billing State")
	private String billing_State;

	@Lob
	@CsvBindByName(column ="Braintree")
	private String braintree;

	@CsvBindByName(column ="CESS")
	private double cess;

	@CsvBindByName(column ="CESS Rate %")
	private double CESS_Rate;

	@CsvBindByName(column ="CESS(FCY)")
	private double cess_fcy;

	@CsvBindByName(column ="CGST")
	private double cgst;

	@CsvBindByName(column ="CGST Rate %")
	private double CGST_Rate;

	@CsvBindByName(column ="CGST(FCY)")
	private double cgst_fcy;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Custom Charges")
	private String custom_Charges;

	@CsvBindByName(column ="Customer ID")
	private BigInteger customer_ID;

	@Lob
	@CsvBindByName(column ="Customer Name")
	private String customer_Name;

	@CsvBindByName(column ="Discount")
	private double discount;

	@CsvBindByName(column ="Discount Amount")
	private double discount_Amount;

	@Lob
	@CsvBindByName(column ="Discount Type")
	private String discount_Type;

	@Lob
	@CsvBindByName(column ="Due Date")
	private String due_Date;

	@Lob
	@CsvBindByName(column ="E-Commerce Operator GSTIN")
	private String e_Commerce_Operator_GSTIN;

	@Lob
	@CsvBindByName(column ="E-Commerce Operator Name")
	private String e_Commerce_Operator_Name;

	@CsvBindByName(column ="Entity Discount Amount")
	private double entity_Discount_Amount;

	@CsvBindByName(column ="Entity Discount Percent")
	private double entity_Discount_Percent;

	@Lob
	@CsvBindByName(column ="Estimate Number")
	private String estimate_Number;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="Expected Payment Date")
	private String expected_Payment_Date;

	@Lob
	@CsvBindByName(column ="Expense Reference ID")
	private String expense_Reference_ID;

	@Lob
	@CsvBindByName(column ="Forte")
	private String Forte;

	@Lob
	@CsvBindByName(column ="GoCardless")
	private String GoCardless;

	@Lob
	@CsvBindByName(column ="Google Checkout")
	private String google_Checkout;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number_GSTIN;

	@Lob
	@CsvBindByName(column ="GST Registration Number(Reference Invoice)")
	private String GST_Registration_Number_Reference_Invoice;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@CsvBindByName(column ="HSN/SAC")
	private int hsn_sac;
	
	@CsvBindByName(column ="IGST")
	private double IGST;

	@CsvBindByName(column ="IGST Rate %")
	private double IGST_Rate;

	@CsvBindByName(column ="IGST(FCY)")
	private double igst_fcy;

	@Lob
	@CsvBindByName(column ="Invoice Date")
	private String invoice_Date;

	@CsvBindByName(column ="Invoice ID")
	private BigInteger invoice_ID;

	@Lob
	@CsvBindByName(column ="Invoice Number")
	private String invoice_Number;

	@Lob
	@CsvBindByName(column ="Invoice Status")
	private String invoice_Status;

	@Lob
	@CsvBindByName(column ="Is Discount Before Tax")
	private String is_Discount_Before_Tax;

	@Lob
	@CsvBindByName(column ="Is Inclusive Tax")
	private String is_Inclusive_Tax;

	@Lob
	@CsvBindByName(column ="Item Desc")
	private String item_Desc;

	@Lob
	@CsvBindByName(column ="Item Name")
	private String item_Name;

	@CsvBindByName(column ="Item Price")
	private double item_Price;

	@Lob
	@CsvBindByName(column ="Item Tax")
	private String item_Tax;

	@CsvBindByName(column ="Item Tax %")
	private double item_Tax_pct;

	@CsvBindByName(column ="Item Tax Amount")
	private double item_Tax_Amount;

	@Lob
	@CsvBindByName(column ="Item Tax Exemption Reason")
	private String item_Tax_Exemption_Reason;

	@Lob
	@CsvBindByName(column ="Item Tax Type")
	private String item_Tax_Type;

	@CsvBindByName(column ="Item Total")
	private double item_Total;

	@Lob
	@CsvBindByName(column ="Item Type")
	private String item_Type;

	@Lob
	@CsvBindByName(column ="Item.CF.Date")
	private String item_CF_Date;

	@Lob
	@CsvBindByName(column ="Item.CF.Lorry No")
	private String item_CF_Lorry_No;

	@CsvBindByName(column ="Item.CF.Receipt no")
	private int item_CF_Receipt_no;

	@Lob
	@CsvBindByName(column ="Last Payment Date")
	private String last_Payment_Date;

	@Lob
	@CsvBindByName(column ="Notes")
	private String notes;

	@Lob
	@CsvBindByName(column ="Partial Payments")
	private String partial_Payments;

	@Lob
	@CsvBindByName(column ="Payflow Pro")
	private String payflow_Pro;

	@CsvBindByName(column ="Payment Terms")
	private int payment_Terms;

	@Lob
	@CsvBindByName(column ="Payment Terms Label")
	private String payment_Terms_Label;

	@Lob
	@CsvBindByName(column ="Payments Pro")
	private String payments_Pro;

	@Lob
	@CsvBindByName(column ="PayPal")
	private String payPal;

	@Lob
	@CsvBindByName(column ="Place of Supply")
	private String place_of_Supply;

	@Lob
	@CsvBindByName(column ="Place of Supply(With State Code)")
	private String place_of_Supply_With_State_Code;

	@Lob
	@CsvBindByName(column ="PortCode")
	private String portCode;

	@CsvBindByName(column ="Product ID")
	private BigInteger product_ID;

	@CsvBindByName(column ="PurchaseOrder")
	private String purchaseOrder;

	@CsvBindByName(column ="Quantity")
	private double quantity;

	@Lob
	@CsvBindByName(column ="Razorpay")
	private String razorpay;

	@Lob
	@CsvBindByName(column ="Reason for issuing Debit Note")
	private String reason_for_issuing_Debit_Note;

	@Lob
	@CsvBindByName(column ="Recurrence Name")
	private String recurrence_Name;

	@Lob
	@CsvBindByName(column ="Reference Invoice Date")
	private String reference_Invoice_Date;

	@Lob
	@CsvBindByName(column ="Reference Invoice#")
	private String reference_Invoice;

	@Lob
	@CsvBindByName(column ="Sales person")
	private String sales_person;

	@CsvBindByName(column ="SGST")
	private double sgst;

	@CsvBindByName(column ="SGST Rate %")
	private double SGST_Rate;

	@CsvBindByName(column ="SGST(FCY)")
	private double sgst_fcy;

	@Lob
	@CsvBindByName(column ="Shipping Address")
	private String shipping_Address;

	@Lob
	@CsvBindByName(column ="Shipping Bill Date")
	private String shipping_Bill_Date;

	@Lob
	@CsvBindByName(column ="Shipping Bill Total")
	private String shipping_Bill_Total;

	@Lob
	@CsvBindByName(column ="Shipping Bill#")
	private String shipping_Bill;

	@CsvBindByName(column ="Shipping Charge")
	private double shipping_Charge;

	@Lob
	@CsvBindByName(column ="Shipping City")
	private String shipping_City;

	@CsvBindByName(column ="Shipping Code")
	private int shipping_Code;

	@Lob
	@CsvBindByName(column ="Shipping Country")
	private String shipping_Country;

	@Lob
	@CsvBindByName(column ="Shipping Fax")
	private String shipping_Fax;

	@Lob
	@CsvBindByName(column ="Shipping Phone Number")
	private String shipping_Phone_Number;

	@Lob
	@CsvBindByName(column ="Shipping State")
	private String shipping_State;

	@Lob
	@CsvBindByName(column ="Square")
	private String Square;

	@Lob
	@CsvBindByName(column ="Stripe")
	private String Stripe;

	@CsvBindByName(column ="Subtotal")
	private double SubTotal;

	@Lob
	@CsvBindByName(column ="Supply Type")
	private String supply_Type;

	@CsvBindByName(column ="Tax ID")
	private BigInteger tax_ID;

	@Lob
	@CsvBindByName(column ="Template Name")
	private String template_Name;

	@Lob
	@CsvBindByName(column ="Terms & Conditions")
	private String terms_Conditions;

	@CsvBindByName(column ="Total")
	private double Total;

	@Lob
	@CsvBindByName(column ="Usage unit")
	private String usage_unit;

	@Lob
	@CsvBindByName(column ="WePay")
	private String WePay;

	@Lob
	@CsvBindByName(column ="WorldPay")
	private String WorldPay;

}