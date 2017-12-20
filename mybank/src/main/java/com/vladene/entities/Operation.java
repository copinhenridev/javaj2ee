package com.vladene.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author henri.tala
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="P", value=Withdrawal.class),
	@Type(name="W", value=Deposit.class),
})
public class Operation implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long operationNum;
	private Date dateOperation;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_CODE")
	private Account account;

	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE")
	private Employee employee;

	
	
	public Operation() {
		super();
	}
	
	
	
	
	public Operation(Date dateOperation, double amount) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
	}




	public Long getOperationNum() {
		return operationNum;
	}
	public void setOperationNum(Long operationNum) {
		this.operationNum = operationNum;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}
	
	@JsonSetter
	@XmlTransient
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@JsonIgnore
	@XmlTransient
	public Account getAccount() {
		return account;
	}
	
	@JsonSetter
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
