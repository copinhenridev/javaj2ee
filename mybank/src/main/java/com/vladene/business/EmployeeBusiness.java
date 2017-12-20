package com.vladene.business;

import java.util.List;

import com.vladene.entities.Employee;

/**
 * Define contract for managing business method on employee
 * @author henri.tala
 *
 */
public interface EmployeeBusiness {
	
	/**
	 * 
	 * @param e
	 * 			The employee to save
	 * @return The saved employee
	 */
	public Employee saveEmployee(Employee e);

	/**
	 * 
	 * @return The list employee
	 */
	public List<Employee> listEmployee();
}
