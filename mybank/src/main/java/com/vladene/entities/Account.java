package com.vladene.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author henri.tala
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //use to implement inheritance base on single table
@DiscriminatorColumn(name="TYP_ACC" , discriminatorType= DiscriminatorType.STRING, length=2)
//use for discriminator column on a single table


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type" )//use for json
//to put dynamically field "type" on request
@JsonSubTypes({//use to specifiy discrimaator column value  and construct subclass 
  @Type(name="AC", value=AccountCurrent.class),
  @Type(name="AS", value=AccountSavings.class)
})



@XmlSeeAlso({Withdrawal.class , Deposit.class})//use for jaxb to  construct subclass  

public abstract class Account implements Serializable{

	@Id
	private String accountCode;
	private Date dateCreation;
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_CODE")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE")
	private Employee employee;
	
	@OneToMany(mappedBy="account")
	private Collection<Operation> operations; 
	
	public Account(String accountCode, Date dateCreation, double balance) {
		super();
		this.accountCode = accountCode;
		this.dateCreation = dateCreation;
	}
	public Account() {
		super();
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	@JsonIgnore  //ignore collection of operations in account json property
	@XmlTransient  //ignore collection of operation in xml account property
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
}
