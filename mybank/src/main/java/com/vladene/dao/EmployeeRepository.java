package com.vladene.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladene.entities.Employee;

/**
 * @author henri.tala
 *
 */
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
