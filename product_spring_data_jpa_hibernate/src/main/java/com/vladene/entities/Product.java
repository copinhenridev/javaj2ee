/**
 * 
 */
package com.vladene.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author henri.tala
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=70)
	private String designation;
	private double price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORY")
	private Category category;
	
	
	
	public Product() {
		super();
	}



	
	
	public Product(String designation, double price, int quantity) {
		super(); 
		this.designation = designation;
		this.price = price;
		this.quantity = quantity;
	}


	
	

	
	
	public Product(String designation, double price, int quantity, Category category) {
		super();
		this.designation = designation;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}





	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
