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
 * The persistent class for the bill database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_bill")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Bill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String FILENAME = "Bill.csv";

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
	
    //Bill Date,Bill ID,Bill Number,PurchaseOrder,Bill Status,Source of Supply,Destination of Supply,GST Treatment,
    //GST Identification Number (GSTIN),Is Inclusive Tax,TDS Percent,TDS Account,Vendor Name,Due Date,Currency Code,
    //Exchange Rate,Item Name,Product ID,Account,Description,Quantity,Usage unit,Rate,HSN/SAC,Tax ID,Tax Name,Tax Percentage,
    //Tax Amount,Tax Type,Item Exemption Code,Item Type,Reverse Charge Tax Name,Reverse Charge Tax Rate,Reverse Charge Tax Type,
    //Item Total,ITC Eligibility,SubTotal,Is Discount Before Tax,Entity Discount Percent,Entity Discount Amount,Discount Account,
    //Total,Balance,Adjustment,Adjustment Description,Vendor Notes,Terms & Conditions,Payment Terms,Payment Terms Label,Is Billable,
    //Is Landed Cost,Customer Name,Project Name,TDSAmount,TDS Section,TDS Account Name,CF.Vehicle No,CF.Cust WO#,CF.Cust Invoice#,
    //CF.Received Date,CF.Serial#
    
    @CsvBindByName(column ="CF.osl")
	private double osl;
	@Lob
	@CsvBindByName(column ="PurchaseOrder")
	private String purchaseOrder;
	@CsvBindByName(column ="Quantity")
	private double quantity;
	@CsvBindByName(column ="Rate")
	private double rate;
	@CsvBindByName(column ="SubTotal")
	private double subTotal;
	@CsvBindByName(column ="TDSAmount")
	private double TDSAmount;
	@CsvBindByName(column ="Total")
	private double total;
	
	@CsvBindByName(column ="Bill ID")
	private BigInteger bill_ID;
	
	@Lob
	@CsvBindByName(column ="Account")
	private String account;

	@CsvBindByName(column ="Adjustment")
	private double adjustment;

	@Lob
	@CsvBindByName(column ="Adjustment Description")
	private String adjustment_Description;

	@CsvBindByName(column ="Balance")
	private double balance;

	@Lob
	@CsvBindByName(column ="Bill Date")
	private String bill_Date;

	@CsvBindByName(column ="Bill Number")
	private int bill_Number;

	@Lob
	@CsvBindByName(column ="Bill Status")
	private String bill_Status;

	@Lob
	@CsvBindByName(column ="CF.Cust Invoice#")
	private String CF_Cust_Invoice;

	@CsvBindByName(column ="CF.Cust WO#")
	private int CF_Cust_WO;

	@Lob
	@CsvBindByName(column ="CF.Received Date")
	private String CF_Received_Date;

	@Lob
	@CsvBindByName(column ="CF.Serial#")
	private String CF_Serial;

	@Lob
	@CsvBindByName(column ="CF.Vehicle No")
	private String CF_Vehicle_No;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Customer Name")
	private String customer_Name;

	@Lob
	@CsvBindByName(column ="Description")
	private String description;

	@Lob
	@CsvBindByName(column ="Destination of Supply")
	private String destination_of_Supply;

	@Lob
	@CsvBindByName(column ="Discount Account")
	private String discount_Account;

	@Lob
	@CsvBindByName(column ="Due Date")
	private String due_Date;

	@CsvBindByName(column ="Entity Discount Amount")
	private double entity_Discount_Amount;

	@CsvBindByName(column ="Entity Discount Percent")
	private double entity_Discount_Percent;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number_GSTIN;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@CsvBindByName(column ="HSN/SAC")
	private int hsn_sac;

	@Lob
	@CsvBindByName(column ="Is Billable")
	private String is_Billable;

	@Lob
	@CsvBindByName(column ="Is Discount Before Tax")
	private String is_Discount_Before_Tax;

	@Lob
	@CsvBindByName(column ="Is Inclusive Tax")
	private String is_Inclusive_Tax;

	@Lob
	@CsvBindByName(column ="Is Landed Cost")
	private String is_Landed_Cost;

	@Lob
	@CsvBindByName(column ="ITC Eligibility")
	private String ITC_Eligibility;

	@Lob
	@CsvBindByName(column ="Item Exemption Code")
	private String item_Exemption_Code;

	@Lob
	@CsvBindByName(column ="Item Name")
	private String item_Name;

	@CsvBindByName(column ="Item Total")
	private double item_Total;

	@Lob
	@CsvBindByName(column ="Item Type")
	private String item_Type;

	@CsvBindByName(column ="Payment Terms")
	private int payment_Terms;

	@Lob
	@CsvBindByName(column ="Payment Terms Label")
	private String payment_Terms_Label;

	@CsvBindByName(column ="Product ID")
	private BigInteger product_ID;

	@Lob
	@CsvBindByName(column ="Project Name")
	private String project_Name;


	@Lob
	@CsvBindByName(column ="Reverse Charge Tax Name")
	private String reverse_Charge_Tax_Name;

	@Lob
	@CsvBindByName(column ="Reverse Charge Tax Rate")
	private String reverse_Charge_Tax_Rate;

	@Lob
	@CsvBindByName(column ="Reverse Charge Tax Type")
	private String reverse_Charge_Tax_Type;

	@Lob
	@CsvBindByName(column ="Source of Supply")
	private String source_of_Supply;

	@Lob
	@CsvBindByName(column ="Tax Amount")
	private String tax_Amount;

	@Lob
	@CsvBindByName(column ="Tax ID")
	private String tax_ID;

	@Lob
	@CsvBindByName(column ="Tax Name")
	private String tax_Name;

	@Lob
	@CsvBindByName(column ="Tax Percentage")
	private String tax_Percentage;

	@Lob
	@CsvBindByName(column ="Tax Type")
	private String tax_Type;

	@Lob
	@CsvBindByName(column ="TDS Account")
	private String TDS_Account;

	@Lob
	@CsvBindByName(column ="TDS Account Name")
	private String TDS_Account_Name;

	@CsvBindByName(column ="TDS Percent")
	private double TDS_Percent;

	@Lob
	@CsvBindByName(column ="TDS Section")
	private String TDS_Section;

	@Lob
	@CsvBindByName(column ="Terms & Conditions")
	private String terms_Conditions;

	@Lob
	@CsvBindByName(column ="Usage unit")
	private String usage_unit;

	@Lob
	@CsvBindByName(column ="Vendor Name")
	private String vendor_Name;

	@Lob
	@CsvBindByName(column ="Vendor Notes")
	private String vendor_Notes;

	

}