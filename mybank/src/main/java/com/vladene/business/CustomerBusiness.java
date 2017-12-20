package com.vladene.business;

import java.util.List;

import com.vladene.entities.Customer;

/**
 * Use for manage business method on Customer
 * @author henri.tala
 *
 */
public interface CustomerBusiness {
	
	/**
	 * 
	 * @param c
	 * 			Customer to save
	 * @return  The saved customer
	 */
	public Customer saveCustomer(Customer c);

	/**
	 * 
	 * @return The list of customers
	 */
	public List<Customer> listCutomer();
}
