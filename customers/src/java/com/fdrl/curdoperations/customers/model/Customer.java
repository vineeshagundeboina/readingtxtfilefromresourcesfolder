package com.fdrl.curdoperations.customers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonPropertyOrder({"Id", "customerName", "customerSalary", "customerAge"})
@Table(name="customers")
public class Customer {

	@Id
	private int Id;
	private String customerName;
	private double customerSalary;
	private int customerAge;
	
	

	@JsonProperty("Id") 
	public int getId() {
		return Id;
	}

	 
	@JsonProperty("Id") 
	public void setId(int id) {
		this.Id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCustomerSalary() {
		return customerSalary;
	}

	public void setCustomerSalary(double customerSalary) {
		this.customerSalary = customerSalary;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

}
