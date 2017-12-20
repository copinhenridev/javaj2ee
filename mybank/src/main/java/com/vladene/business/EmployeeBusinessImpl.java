package com.vladene.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladene.dao.EmployeeRepository;
import com.vladene.entities.Employee;

/**
 * @author henri.tala
 *
 */
@Service
public class EmployeeBusinessImpl implements EmployeeBusiness{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}

}
