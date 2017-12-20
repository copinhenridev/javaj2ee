package com.vladene.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vladene.business.CustomerBusiness;
import com.vladene.entities.Customer;

/**
 * Implementation of rest service on customer object
 * This class project service on business method define on business layer.
 * @author henri.tala
 *
 */
@RestController
public class CustomerRestService {

	@Autowired
	private CustomerBusiness customerBusiness;


	/**
	 * 
	 * @param c
	 * @return
	 */
	@RequestMapping(value="/customers" , method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer c) {
		return customerBusiness.saveCustomer(c);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/customers" , method=RequestMethod.GET)
	public List<Customer> listCutomer() {
		return customerBusiness.listCutomer();
	}


}
