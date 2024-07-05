package com.fdrl.curdoperations.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdrl.curdoperations.customers.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
