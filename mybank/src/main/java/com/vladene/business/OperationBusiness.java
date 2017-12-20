package com.vladene.business;

/**
 * Define contract for business method to manage Operations on account
 * @author henri.tala
 *
 */
public interface OperationBusiness {
	
	/**
	 * 
	 * @param code 
	 * 				Code for account to pay money
	 * @param amount
	 * 				Amount to pay to account represent by code
	 * @param codeEmp
	 * 				Code of employee who execute operation
	 * @return The result of operation (true/false)
	 */
	public boolean pay(String code, double amount, Long codeEmp);
	
	/**
	 * 
	 * @param code 
	 * 				Code for account to withdraw money
	 * @param amount
	 * 				Amount to withdraw to account represent by code
	 * @param codeEmp
	 * 				Code of employee who execute operation
	 * @return The result of operation (true/false)
	 */
	public boolean withdraw(String code, double amount, Long codeEmp);
	
	
	/**
	 * 
	 * @param cpte1
	 * 				Code of account to withdraw money
	 * @param cpte2
	 * 				Code of account to transfer money
	 * @param amount
	 * 				Amount of money to transfer from account represent by code cpte1 to account represent by cpte2
	 * @param codeEmp
	 * @return
	 */
	public boolean transfer(String cpte1, String cpte2, double amount, Long codeEmp);
	
	/**
	 * This method is use to build the page operation to unuse the Page<Operation> given by spring. In fact it's not a good
	 * way to use a technical object in business layer
	 * 
	 * @param codeAccount
	 * 						Code of account to get operations 
	 * @param page
	 * 				Page of operation
	 * @param size
	 * 				Number of page
	 * @return
	 */
	public PageOperation getOperations(String codeAccount, int page, int size);
	

}
