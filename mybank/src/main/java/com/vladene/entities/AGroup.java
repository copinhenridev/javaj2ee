package com.vladene.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author henri.tala
 *
 */
@Entity
@Table(name="GROUPS")
public class AGroup implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupCode;
	private String groupName;
	
	@ManyToMany(mappedBy="groups")
	private Collection<Employee> employees;
	
	
	
	
	public Long getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(Long groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	
}
