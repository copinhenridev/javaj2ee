package com.vladene.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author henri.tala
 *
 */
@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerCode;
	private String customerName;
	
	
	@OneToMany(mappedBy="customer" , fetch=FetchType.LAZY)
	private Collection<Account> accounts;
	
	public Customer() {
		super();
	}
	public Long getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(Long customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
	@JsonIgnore
	@XmlTransient
	public Collection<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	

	
	
}
