package com.vladene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vladene.business.AccountBusiness;
import com.vladene.entities.Account;

/**
 * Implementation of rest service on account object
 * This class project service on business method define on business layer.
 * @author henri.tala
 *
 */
@RestController
public class AccountRestService {

	
	@Autowired
	private AccountBusiness accountBusiness;

	/**
	 * 
	 * @param a
	 * @return
	 */
	@RequestMapping(value="/accounts" , method=RequestMethod.POST)
	public Account saveAccount(@RequestBody Account a) {
		return accountBusiness.saveAccount(a);
	}

	
	/**
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/accounts/{code}" , method=RequestMethod.GET)
	public Account getAccount(@PathVariable String code) {
		return accountBusiness.getAccount(code);
	}
}
