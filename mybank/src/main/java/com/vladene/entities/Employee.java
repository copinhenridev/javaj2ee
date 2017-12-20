package com.vladene.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author henri.tala
 *
 */
@Entity
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long employeeCode;
	private String employeeName;
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_SUP_COD")
	private Employee employeeSup;
	
	@ManyToMany
	@JoinTable(name = "EMPLOYEE_GROUP")
	private Collection<AGroup> groups;
	
	
	
	
	public Employee(String employeeName) {
		super();
		this.employeeName = employeeName;
	}
	
	public Employee() {
		super();
	
	}
	
	
	
	public Long getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@JsonIgnore
	public Employee getEmployeeSup() {
		return employeeSup;
	}
	
	@JsonSetter
	public void setEmployeeSup(Employee employeeSup) {
		this.employeeSup = employeeSup;
	}
	
	@JsonIgnore
	public Collection<AGroup> getGroups() {
		return groups;
	}
	public void setGroups(Collection<AGroup> groups) {
		this.groups = groups;
	}
	

}
