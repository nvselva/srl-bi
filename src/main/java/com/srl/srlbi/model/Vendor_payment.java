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
 * The persistent class for the vendor payment database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_vendor_payment") 
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Vendor_payment implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILENAME = "Vendor Payment.csv";

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
	
//Payment Number,VendorPayment ID,Date,Vendor Name,Source of Supply,Destination of Supply,GST Treatment,GST Identification Number (GSTIN),EmailID,Mode,Description,Description of Supply,Exchange Rate,Amount,Paid Through,Tax Account,Reference Number,PIPayment ID,Bill Number,Bill Amount,ReverseCharge Tax Percentage,ReverseCharge Tax Type,Reverse Charge Tax Amount,ReverseCharge Tax Name,Payment Type,Withholding Tax Amount,TDSAmount,TDS Section,TDS Account Name,Unused Amount

	@CsvBindByName(column ="Amount")
	private double Amount;

	@CsvBindByName(column ="Bill Amount")
	private double bill_Amount;

	@CsvBindByName(column ="Bill Number")
	private int bill_Number;

	@Lob
	@CsvBindByName(column ="Date")
	private String Date;

	@Lob
	@CsvBindByName(column ="Description")
	private String Description;

	@Lob
	@CsvBindByName(column ="Description of Supply")
	private String description_of_Supply;

	@Lob
	@CsvBindByName(column ="Destination of Supply")
	private String destination_of_Supply;

	@Lob
	@CsvBindByName(column ="EmailID")
	private String EmailID;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number__GSTIN_;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@Lob
	@CsvBindByName(column ="Mode")
	private String Mode;

	@Lob
	@CsvBindByName(column ="Paid Through")
	private String paid_Through;

	@CsvBindByName(column ="Payment Number")
	private int payment_Number;

	@Lob
	@CsvBindByName(column ="Payment Type")
	private String payment_Type;

	@CsvBindByName(column ="PIPayment ID")
	private BigInteger PIPayment_ID;

	@Lob
	@CsvBindByName(column ="Reference Number")
	private String reference_Number;

	@CsvBindByName(column ="Reverse Charge Tax Amount")
	private double reverse_Charge_Tax_Amount;

	@Lob
	@CsvBindByName(column ="ReverseCharge Tax Name")
	private String reverseCharge_Tax_Name;

	@Lob
	@CsvBindByName(column ="ReverseCharge Tax Percentage")
	private String reverseCharge_Tax_Percentage;

	@Lob
	@CsvBindByName(column ="ReverseCharge Tax Type")
	private String reverseCharge_Tax_Type;

	@Lob
	@CsvBindByName(column ="Source of Supply")
	private String source_of_Supply;

	@Lob
	@CsvBindByName(column ="Tax Account")
	private String tax_Account;

	@Lob
	@CsvBindByName(column ="TDS Account Name")
	private String TDS_Account_Name;

	@Lob
	@CsvBindByName(column ="TDS Section")
	private String TDS_Section;

	@CsvBindByName(column ="TDSAmount")
	private double TDSAmount;

	@CsvBindByName(column ="Unused Amount")
	private double unused_Amount;

	@Lob
	@CsvBindByName(column ="Vendor Name")
	private String vendor_Name;

	@CsvBindByName(column ="VendorPayment ID")
	private BigInteger vendorPayment_ID;

	@CsvBindByName(column ="Withholding Tax Amount")
	private double withholding_Tax_Amount;


}