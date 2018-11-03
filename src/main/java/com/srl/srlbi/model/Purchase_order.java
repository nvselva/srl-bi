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
 * The persistent class for the purchase order database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_purchase_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Purchase_order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FILENAME = "Purchase Order.csv";

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
	
    //Purchase Order Date,Delivery Date,Purchase Order Number,Reference#,Purchase Order Status,Vendor Name,HSN/SAC,Source of Supply,
    //Destination of Supply,GST Treatment,GST Identification Number (GSTIN),Is Inclusive Tax,Currency Code,Exchange Rate,
    //Template Name,Reference No,Delivery Instructions,Terms & Conditions,Shipment preference,Expected Arrival Date,Account,
    //Item Price,Item Name,Product ID,Item Desc,QuantityOrdered,QuantityCancelled,Usage unit,Tax ID,Item Tax,Item Tax %,
    //Item Tax Amount,Item Tax Type,Item Exemption Code,Item Type,Reverse Charge Tax Name,Reverse Charge Tax Rate,
    //Reverse Charge Tax Type,Item Total,Total,Adjustment,Adjustment Description,Is Discount Before Tax,Entity Discount Percent,
    //Entity Discount Amount,Discount Account,Attention,Address,City,State,Country,Code,Phone,Deliver To Customer,
    //Recipient Address,Recipient City,Recipient State,Recipient Country,Recipient Postal Code,Recipient Phone

	@Lob
	@CsvBindByName(column ="Account")
	private String account;

	@Lob
	@CsvBindByName(column ="Address")
	private String address;

	@CsvBindByName(column ="Adjustment")
	private double adjustment;

	@Lob
	@CsvBindByName(column ="Adjustment Description")
	private String adjustment_Description;

	@Lob
	@CsvBindByName(column ="Attention")
	private String attention;

	@Lob
	@CsvBindByName(column ="City")
	private String city;

	@Lob
	@CsvBindByName(column ="Code")
	private String code;

	@Lob
	@CsvBindByName(column ="Country")
	private String country;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Deliver To Customer")
	private String deliver_To_Customer;

	@Lob
	@CsvBindByName(column ="Delivery Date")
	private String delivery_Date;

	@Lob
	@CsvBindByName(column ="Delivery Instructions")
	private String delivery_Instructions;

	@Lob
	@CsvBindByName(column ="Destination of Supply")
	private String destination_of_Supply;

	@Lob
	@CsvBindByName(column ="Discount Account")
	private String discount_Account;

	@CsvBindByName(column ="Entity Discount Amount")
	private double entity_Discount_Amount;

	@CsvBindByName(column ="Entity Discount Percent")
	private double entity_Discount_Percent;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="Expected Arrival Date")
	private String expected_Arrival_Date;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number_GSTIN;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@CsvBindByName(column ="HSN/SAC")
	private int hsn_sac;

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
	@CsvBindByName(column ="Item Exemption Code")
	private String item_Exemption_Code;

	@Lob
	@CsvBindByName(column ="Item Name")
	private String item_Name;

	@CsvBindByName(column ="Item Price")
	private double item_Price;

	@Lob
	@CsvBindByName(column ="Item Tax")
	private String item_Tax;

	@Lob
	@CsvBindByName(column ="Item Tax %")
	private String item_Tax_pct;

	@Lob
	@CsvBindByName(column ="Item Tax Amount")
	private String item_Tax_Amount;

	@Lob
	@CsvBindByName(column ="Item Tax Type")
	private String item_Tax_Type;

	@CsvBindByName(column ="Item Total")
	private double item_Total;

	@Lob
	@CsvBindByName(column ="Item Type")
	private String item_Type;

	@Lob
	@CsvBindByName(column ="Phone")
	private String phone;

	@CsvBindByName(column ="Product ID")
	private BigInteger product_ID;

	@Lob
	@CsvBindByName(column ="Purchase Order Date")
	private String purchase_Order_Date;

	@Lob
	@CsvBindByName(column ="Purchase Order Number")
	private String purchase_Order_Number;

	@Lob
	@CsvBindByName(column ="Purchase Order Status")
	private String purchase_Order_Status;

	@CsvBindByName(column ="QuantityCancelled")
	private double quantityCancelled;

	@CsvBindByName(column ="QuantityOrdered")
	private double quantityOrdered;

	@Lob
	@CsvBindByName(column ="Recipient Address")
	private String recipient_Address;

	@Lob
	@CsvBindByName(column ="Recipient City")
	private String recipient_City;

	@Lob
	@CsvBindByName(column ="Recipient Country")
	private String recipient_Country;

	@Lob
	@CsvBindByName(column ="Recipient Phone")
	private String recipient_Phone;

	@CsvBindByName(column ="Recipient Postal Code")
	private int recipient_Postal_Code;

	@Lob
	@CsvBindByName(column ="Recipient State")
	private String recipient_State;

	@CsvBindByName(column ="Reference No")
	private int reference_No;

	@CsvBindByName(column ="Reference#")
	private int reference;

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
	@CsvBindByName(column ="Shipment preference")
	private String shipment_preference;

	@Lob
	@CsvBindByName(column ="Source of Supply")
	private String source_of_Supply;

	@Lob
	@CsvBindByName(column ="State")
	private String state;

	@Lob
	@CsvBindByName(column ="Tax ID")
	private String tax_ID;

	@Lob
	@CsvBindByName(column ="Template Name")
	private String template_Name;

	@Lob
	@CsvBindByName(column ="Terms & Conditions")
	private String terms_Conditions;

	@CsvBindByName(column ="Total")
	private double total;

	@Lob
	@CsvBindByName(column ="Usage unit")
	private String usage_unit;

	@Lob
	@CsvBindByName(column ="Vendor Name")
	private String vendor_Name;

	

}