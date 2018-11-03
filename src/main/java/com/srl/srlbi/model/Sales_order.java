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
 * The persistent class for the sales order database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_sales_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Sales_order implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILENAME = "Sales Order.csv";

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
	
    //Order Date,Shipment Date,SalesOrder Number,Status,Customer Name,Place of Supply,Place of Supply(With State Code),
    //GST Treatment,GST Identification Number (GSTIN),Is Inclusive Tax,PurchaseOrder,Template Name,Currency Code,
    //Exchange Rate,Discount Type,Is Discount Before Tax,Entity Discount Amount,Entity Discount Percent,Item Name,
    //Product ID,Account,Item Desc,QuantityOrdered,QuantityInvoiced,QuantityCancelled,Usage unit,Item Price,Discount,
    //Discount Amount,HSN/SAC,Supply Type,Tax ID,Item Tax,Item Tax %,Item Tax Amount,Item Tax Type,CGST Rate %,SGST Rate %,
    //IGST Rate %,CESS Rate %,CGST(FCY),SGST(FCY),IGST(FCY),CESS(FCY),CGST,SGST,IGST,CESS,Item Tax Exemption Reason,
    //Item Type,Item Total,SubTotal,Total,Shipping Charge,Adjustment,Adjustment Description,Sales person,Notes,
    //Terms & Conditions,Delivery Method,Source,Billing Address,Billing City,Billing State,Billing Country,Billing Code,
    //Billing Fax,Billing Phone,Shipping Address,Shipping City,Shipping State,Shipping Country,Shipping Code,
    //Shipping Fax,Shipping Phone,Item.CF.Date,Item.CF.Lorry No,Item.CF.Receipt no

	@Lob
	@CsvBindByName(column ="Account")
	private String account;

	@CsvBindByName(column ="Adjustment")
	private double adjustment;

	@Lob
	@CsvBindByName(column ="Adjustment Description")
	private String adjustment_Description;

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

	@CsvBindByName(column ="CESS")
	private double cess;

	@CsvBindByName(column ="CESS Rate %")
	private double CESS_Rate_pct;

	@CsvBindByName(column ="CESS(FCY)")
	private double cess_fcy;

	@CsvBindByName(column ="CGST")
	private double cgst;

	@CsvBindByName(column ="CGST Rate %")
	private double CGST_Rate_pct;

	@CsvBindByName(column ="CGST(FCY)")
	private double cgst_fcy;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Customer Name")
	private String customer_Name;

	@Lob
	@CsvBindByName(column ="Delivery Method")
	private String delivery_Method;

	@CsvBindByName(column ="Discount")
	private double discount;

	@CsvBindByName(column ="Discount Amount")
	private double discount_Amount;

	@Lob
	@CsvBindByName(column ="Discount Type")
	private String discount_Type;

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

	@CsvBindByName(column ="IGST")
	private double igst;

	@CsvBindByName(column ="IGST Rate %")
	private double IGST_Rate_pct;

	@CsvBindByName(column ="IGST(FCY)")
	private double igst_fcy;

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

	@Lob
	@CsvBindByName(column ="Item.CF.Receipt no")
	private String item_CF_Receipt_no;

	@Lob
	@CsvBindByName(column ="Notes")
	private String notes;

	@Lob
	@CsvBindByName(column ="Order Date")
	private String order_Date;

	@Lob
	@CsvBindByName(column ="Place of Supply")
	private String place_of_Supply;

	@Lob
	@CsvBindByName(column ="Place of Supply(With State Code)")
	private String place_of_Supply_With_State_Code;

	@CsvBindByName(column ="Product ID")
	private BigInteger product_ID;

	@CsvBindByName(column ="PurchaseOrder")
	private int purchaseOrder;

	@CsvBindByName(column ="QuantityCancelled")
	private double quantityCancelled;

	@CsvBindByName(column ="QuantityInvoiced")
	private double quantityInvoiced;

	@CsvBindByName(column ="QuantityOrdered")
	private double quantityOrdered;

	@Lob
	@CsvBindByName(column ="Sales person")
	private String sales_person;

	@Lob
	@CsvBindByName(column ="SalesOrder Number")
	private String salesOrder_Number;

	@CsvBindByName(column ="SGST")
	private double sgst;

	@CsvBindByName(column ="SGST Rate %")
	private double SGST_Rate;

	@CsvBindByName(column ="SGST(FCY)")
	private double sgst_fcy;

	@Lob
	@CsvBindByName(column ="Shipment Date")
	private String shipment_Date;

	@Lob
	@CsvBindByName(column ="Shipping Address")
	private String shipping_Address;

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
	@CsvBindByName(column ="Shipping Phone")
	private String shipping_Phone;

	@Lob
	@CsvBindByName(column ="Shipping State")
	private String shipping_State;

	@CsvBindByName(column ="Source")
	private int source;

	@Lob
	@CsvBindByName(column ="Status")
	private String status;

	@CsvBindByName(column ="SubTotal")
	private double subTotal;

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
	private double total;

	@Lob
	@CsvBindByName(column ="Usage unit")
	private String usage_unit;

}