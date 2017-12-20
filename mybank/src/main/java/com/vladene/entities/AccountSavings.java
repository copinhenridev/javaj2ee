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
@DiscriminatorValue("AS") //discriminator value sue by JPA
@XmlType(name="AS") //discriminator value use par Jaxb
public class AccountSavings extends Account {

	private double rate;

	public AccountSavings() {
		super();
	}

	public AccountSavings(String accountCode, Date dateCreation, double balance, double rate) {
		super(accountCode, dateCreation, balance);
		this.rate = rate;
	}
	
	

	
	
}
