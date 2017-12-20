package com.vladene.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladene.dao.CustomerRepository;
import com.vladene.entities.Customer;

/**
 * @author henri.tala
 *
 */
@Service
public class CustomerImpl implements CustomerBusiness{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer c) {
		return customerRepository.save(c);
	}

	@Override
	public List<Customer> listCutomer() {

		return customerRepository.findAll();
	}

	
}
