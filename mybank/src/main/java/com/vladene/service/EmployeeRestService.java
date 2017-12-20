package com.vladene.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vladene.business.EmployeeBusiness;
import com.vladene.entities.Employee;

/**
 * Implementation of rest service on employee object
 * This class project service on business method define on business layer.
 * @author henri.tala
 *
 */
@RestController
public class EmployeeRestService {
	
	@Autowired
	private EmployeeBusiness employeeBusiness;

	/**
	 * 
	 * @param e
	 * @return
	 */
	@RequestMapping(value="/employees",  method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee e) {
		return employeeBusiness.saveEmployee(e);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/employees" , method=RequestMethod.GET)
	public List<Employee> listEmployee() {
		return employeeBusiness.listEmployee();
	}

}
