package com.srl.srlbi.model;

import java.io.Serializable;
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
 * The persistent class for the banking database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@XmlRootElement
@Table(name = "t_banking")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Banking implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FILENAME = "Banking.csv";

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
	

	@Lob
	@CsvBindByName(column ="Debit / Credit")
	private String debit_Credit;

	@Lob
	@CsvBindByName(column ="Reference No.")
	private String reference_No;

	@CsvBindByName(column ="Runnig Balance")
	private double runnig_Balance;

	@CsvBindByName(column ="Transaction Amount")
	private double transaction_Amount;

	@Lob
	@CsvBindByName(column ="Transaction Date")
	private String transaction_Date;

	@Lob
	@CsvBindByName(column ="Transaction Description")
	private String transaction_Description;

	@Lob
	@CsvBindByName(column ="Value Date")
	private String value_Date;

}