package com.srl.srlbi.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the customer payment database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_customer_payment") 
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Customer_payment implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILENAME = "Customer Payment.csv";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column( name ="audit_createdAt",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column( name ="audit_updatedAt",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @CsvBindByName(column ="Amount")
	private double Amount;

	@CsvBindByName(column ="Bank Charges")
	private double bank_Charges;

	@Lob
	@CsvBindByName(column ="Created Time")
	private String created_Time;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Customer Name")
	private String customer_Name;

	@CsvBindByName(column ="CustomerID")
	private BigInteger CustomerID;

	@CsvBindByName(column ="CustomerPayment ID")
	private BigInteger customerPayment_ID;

	@Lob
	@CsvBindByName(column ="Date")
	private String Date;

	@Lob
	@CsvBindByName(column ="Deposit To")
	private String deposit_To;

	@Lob
	@CsvBindByName(column ="Description")
	private String Description;

	@Lob
	@CsvBindByName(column ="Description of Supply")
	private String description_of_Supply;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number__GSTIN_;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@CsvBindByName(column ="Invoice Amount")
	private double invoice_Amount;

	@Lob
	@CsvBindByName(column ="Invoice Number")
	private String invoice_Number;

	@CsvBindByName(column ="InvoicePayment ID")
	private BigInteger invoicePayment_ID;

	@Lob
	@CsvBindByName(column ="Mode")
	private String Mode;

	@CsvBindByName(column ="Payment Number")
	private int payment_Number;

	@Lob
	@CsvBindByName(column ="Payment Number Prefix")
	private String payment_Number_Prefix;

	@CsvBindByName(column ="Payment Number Suffix")
	private int payment_Number_Suffix;

	@Lob
	@CsvBindByName(column ="Payment Type")
	private String payment_Type;

	@Lob
	@CsvBindByName(column ="Place of Supply")
	private String place_of_Supply;

	@Lob
	@CsvBindByName(column ="Place of Supply(With State Code)")
	private String place_of_Supply_With_State_Code_;

	@CsvBindByName(column ="Reference Number")
	private int reference_Number;

	@Lob
	@CsvBindByName(column ="Tax Account")
	private String tax_Account;

	@Lob
	@CsvBindByName(column ="Tax Name")
	private String tax_Name;

	@Lob
	@CsvBindByName(column ="Tax Percentage")
	private String tax_Percentage;

	@Lob
	@CsvBindByName(column ="Tax Type")
	private String tax_Type;

	@CsvBindByName(column ="Unused Amount")
	private double unused_Amount;

	@CsvBindByName(column ="Withholding Tax Amount")
	private double withholding_Tax_Amount;


}