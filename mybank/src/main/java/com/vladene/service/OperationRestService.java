package com.vladene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vladene.business.OperationBusiness;
import com.vladene.business.PageOperation;

/**
 * Implementation of rest service on operation object
 * This class project service on business method define on business layer.
 * @author henri.tala
 *
 */
@RestController
public class OperationRestService {

	@Autowired
	private OperationBusiness operationBusiness;

	/**
	 * 
	 * @param codeAccount
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/operations" , method=RequestMethod.GET)
	public PageOperation getOperations(
			@RequestParam String codeAccount, 
			@RequestParam int page, 
			@RequestParam int size) {
		return operationBusiness.getOperations(codeAccount, page, size);
	}

	/**
	 * 
	 * @param code
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/pay", method=RequestMethod.PUT)
	public boolean pay(
			@RequestParam String code, 
			@RequestParam double amount, 
			@RequestParam Long codeEmp) {
		return operationBusiness.pay(code, amount, codeEmp);
	}

	/**
	 * 
	 * @param code
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/withdraw", method=RequestMethod.PUT)
	public boolean withdraw(
			@RequestParam String code, 
			@RequestParam double amount, 
			@RequestParam Long codeEmp) {
		return operationBusiness.withdraw(code, amount, codeEmp);
	}

	/**
	 * 
	 * @param ac1
	 * @param ac2
	 * @param amount
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/transfer", method=RequestMethod.PUT)
	public boolean transfer(
			@RequestParam String ac1, 
			@RequestParam String ac2, 
			@RequestParam double amount, 
			@RequestParam Long codeEmp) {
		return operationBusiness.transfer(ac1, ac2, amount, codeEmp);
	}
	
	
}
