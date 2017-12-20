package com.vladene.entities;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 * @author henri.tala
 *
 */
@Entity
@DiscriminatorValue("AC") //discriminatorvalue use for JPA
@XmlType(name="AC") //discriminator value use par Jaxb
public class AccountCurrent extends Account{

	//découvert bancaire
	private double overdraft;

	public AccountCurrent() {
		super();
	}

	public AccountCurrent(String accountCode, Date dateCreation, double balance, double overdraft) {
		super(accountCode, dateCreation, balance);
	this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	
	
	
	
	
	
	
}
