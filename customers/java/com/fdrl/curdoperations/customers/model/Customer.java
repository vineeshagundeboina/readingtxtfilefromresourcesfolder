package com.fdrl.curdoperations.customers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@JsonProperty("Id")
	private int id;
	@JsonProperty("customerName")
	private String customerName;
	@JsonProperty("customerSalary")
	private double customerSalary;
	@JsonProperty("customerAge")
	private int customerAge;
	

	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
