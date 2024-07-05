package com.fdrl.curdoperations.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication            // Enables spring boot features
@EnableJpaRepositories

public class CustomerApplication {                  // Main class 

	public static void main(String[] args) {        // Main method            
	    SpringApplication.run(CustomerApplication.class, args);    // Used to starts the spring boot application
	    }
	}