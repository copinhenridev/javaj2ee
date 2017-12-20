package com.vladene.business;

import com.vladene.entities.Account;

/**
 * Use to define contract for business method to manage account
 * @author henri.tala
 *
 */
public interface AccountBusiness {
	
	/**
	 * 
	 * @param a
	 * 			Account to save	
	 * @return The saved account
	 */
	public Account saveAccount(Account a);

	/**
	 * 
	 * @param code  
	 * 			   The account code to save
	 * 			 
	 * @return The found account
	 */
	public Account getAccount(String code);
}
