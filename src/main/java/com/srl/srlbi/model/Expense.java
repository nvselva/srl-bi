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
 * The persistent class for the expense database table.
 * 
 */

@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_expense") 
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILENAME = "Expense.csv";

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
    
	@Lob
	@CsvBindByName(column ="Claimant Email")
	private String claimant_Email;

	@Lob
	@CsvBindByName(column ="Currency Code")
	private String currency_Code;

	@Lob
	@CsvBindByName(column ="Customer Name")
	private String customer_Name;

	@Lob
	@CsvBindByName(column ="Destination of Supply")
	private String destination_of_Supply;

	@Lob
	@CsvBindByName(column ="Distance")
	private String distance;

	@Lob
	@CsvBindByName(column ="End Odometer Reading")
	private String end_Odometer_Reading;

	@CsvBindByName(column ="Entry Number")
	private int entry_Number;

	@CsvBindByName(column ="Exchange Rate")
	private double exchange_Rate;

	@Lob
	@CsvBindByName(column ="Expense Account")
	private String expense_Account;

	@CsvBindByName(column ="Expense Amount")
	private double expense_Amount;

	@Lob
	@CsvBindByName(column ="Expense Date")
	private String expense_Date;

	@Lob
	@CsvBindByName(column ="Expense Description")
	private String expense_Description;

	@CsvBindByName(column ="Expense Reference ID")
	private BigInteger expense_Reference_ID;

	@Lob
	@CsvBindByName(column ="Expense Type")
	private String expense_Type;

	@Lob
	@CsvBindByName(column ="ExpenseReport Name")
	private String expenseReport_Name;

	@Lob
	@CsvBindByName(column ="GST Identification Number (GSTIN)")
	private String GST_Identification_Number_GSTIN;

	@Lob
	@CsvBindByName(column ="GST Treatment")
	private String GST_Treatment;

	@Lob
	@CsvBindByName(column ="HSN/SAC")
	private String hsn_sac;

	@Lob
	@CsvBindByName(column ="Is Billable")
	private String is_Billable;

	@Lob
	@CsvBindByName(column ="Is Inclusive Tax")
	private String is_Inclusive_Tax;

	@Lob
	@CsvBindByName(column ="Is Reimbursable")
	private String is_Reimbursable;

	@Lob
	@CsvBindByName(column ="ITC Eligibility")
	private String ITC_Eligibility;

	@Lob
	@CsvBindByName(column ="Item Exemption Code")
	private String item_Exemption_Code;

	@CsvBindByName(column ="Mileage Rate")
	private double mileage_Rate;

	@Lob
	@CsvBindByName(column ="Mileage Type")
	private String mileage_Type;

	@Lob
	@CsvBindByName(column ="Mileage Unit")
	private String mileage_Unit;

	@Lob
	@CsvBindByName(column ="Paid Through")
	private String paid_Through;

	@Lob
	@CsvBindByName(column ="Project Name")
	private String project_Name;

	@Lob
	@CsvBindByName(column ="Recurrence Name")
	private String recurrence_Name;

	@Lob
	@CsvBindByName(column ="Reference#")
	private String reference;

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
	@CsvBindByName(column ="Start Odometer Reading")
	private String start_Odometer_Reading;

	@CsvBindByName(column ="Tax Amount")
	private double tax_Amount;

	@Lob
	@CsvBindByName(column ="Tax Name")
	private String tax_Name;

	@Lob
	@CsvBindByName(column ="Tax Percentage")
	private String tax_Percentage;

	@Lob
	@CsvBindByName(column ="Tax Type")
	private String tax_Type;

	@CsvBindByName(column ="Total")
	private double total;

	@Lob
	@CsvBindByName(column ="Vendor")
	private String vendor;

	

}