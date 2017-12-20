package com.vladene.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vladene.business.AccountBusiness;
import com.vladene.business.OperationBusiness;
import com.vladene.business.PageOperation;
import com.vladene.entities.Account;

/**
 * @author henri.tala
 *
 */
@Component  //use to allow spring to manage this bean
@WebService //use to define saop webservice
public class BankSoapService {

	@Autowired
	private OperationBusiness operationBusiness;
	
	@Autowired
	private AccountBusiness accountBusiness;
	
	

	/**
	 * 
	 * @param code
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@WebMethod
	public boolean pay(
			@WebParam(name="code") String code, 
			@WebParam(name="amount") double amount, 
			@WebParam(name="codeEmp")Long codeEmp) {
		return operationBusiness.pay(code, amount, codeEmp);
	}

	/**
	 * 
	 * @param code
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@WebMethod
	public boolean withdraw(
			@WebParam(name="code") String code, 
			@WebParam(name="amount") double amount, 
			@WebParam(name="codeEmp")Long codeEmp) {
		return operationBusiness.withdraw(code, amount, codeEmp);
	}

	/**
	 * 
	 * @param cpte1
	 * @param cpte2
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@WebMethod
	public boolean transfer(
			@WebParam(name="cpte1") String cpte1, 
			@WebParam(name="cpte2") String cpte2, 
			@WebParam(name="amount")double amount, 
			@WebParam(name="codeEmp") Long codeEmp) {
		return operationBusiness.transfer(cpte1, cpte2, amount, codeEmp);
	}

	
	@WebMethod
	public PageOperation getOperations(
			@WebParam(name="code") String codeAccount, 
			@WebParam(name="page") int page, 
			@WebParam(name="size") int size) {
		return operationBusiness.getOperations(codeAccount, page, size);
	}

	
	@WebMethod
	public Account getAccount(@WebParam(name="code") String code) {
		return accountBusiness.getAccount(code);
	}

}
