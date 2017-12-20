package com.vladene.business;

import java.io.Serializable;
import java.util.List;

import com.vladene.entities.Operation;

/**
 * @author henri.tala
 *
 */
public class PageOperation implements Serializable{
	
	private List<Operation> operations;
	private int page;
	private int numberOfOperations;
	private int totalPages;
	private int totalOperations;
	

	
	
	
	public int getTotalOperations() {
		return totalOperations;
	}
	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNumberOfOperations() {
		return numberOfOperations;
	}
	public void setNumberOfOperations(int numberOfOperations) {
		this.numberOfOperations = numberOfOperations;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	

}
