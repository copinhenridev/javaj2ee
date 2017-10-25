package com.vladene.student.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1270838161261428912L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(length=50)
	private String name;
    private Date birthDate;
	@Column(length=50)
    private String email;
	@Column(length=50)
    private String picture;
	
    /**
     * constructor uses by framework
     */
    public Student() {
		super();
	}

	public Student(String name, Date birthDate, String email, String picture) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
    
    
    
    
    
	
}
