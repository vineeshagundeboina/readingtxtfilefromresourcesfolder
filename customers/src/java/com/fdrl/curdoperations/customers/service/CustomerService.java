package com.fdrl.curdoperations.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdrl.curdoperations.customers.model.Customer;
import com.fdrl.curdoperations.customers.repository.CustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service                                         // Used for define the service class
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;         // Class declared
	private List<Customer> customer;                       // Declares a private field named 'customers' which is list of customer objects
	
	public CustomerService() throws IOException {         // It can throws an IOException has occurred
        ObjectMapper objectMapper = new ObjectMapper();   // Converts the java objects into JSON
        Path path = new ClassPathResource("Userslist.txt").getFile().toPath();  // Reading the file
        String content = new String(Files.readAllBytes(path));     // Reads all bytes from the file and convert into string
        customer = objectMapper.readValue(content, new TypeReference<List<Customer>>(){}); // Read the JSON string and convert into list
        }
        public List<Customer> getAllCustomers() {         // Method to get all customers
        	return customer;                              // Returns the customer list
        }
    	public Optional<Customer> getCustomerById(int id) {   // Method to get CustomerById
    		return customer.stream().filter(customer -> customer.getId() == id).findAny();  // Uses Java 8 Stream API to filter the customer list to find the customer with matching id. 
	    }
   	    @Transactional                                                           // Transaction will be created for execution
	    public void saveCustomersFromFileInResources() throws IOException {      // Load file from resources folder
   	    	ClassPathResource resource = new ClassPathResource("Userslist.txt"); // Accessing the file
   	    	InputStream inputStream = resource.getInputStream();                 // Allows reading content from the file
   	    	ObjectMapper mapper = new ObjectMapper();
   	    	Customer[] customersArray = mapper.readValue(inputStream, Customer[].class); // Uses the ObjectMapper to read JSON data and convert it into an array of customer objects
   	    	List<Customer> customers = new ArrayList<>();  // Initializes an ArrayList to store customer objects 
	        for (Customer customer : customersArray) {     // Iterates through the customersArray and adds each customer object to the customers list
	        	customers.add(customer);
	        	}
	        customerRepository.saveAll(customer);          // Saves all customer objects in the customers list to the database using the saveAll
	        }
   	    }
    	
    	
    	
    	
    	










	

  





























































































//#server.port=8999
//#spring.datasource.url=jdbc:postgresql://localhost:5433/customer
//#spring.datasource.username=postgres
//#spring.datasource.password=root                    
//#spring.datasource.driver-class-name=org.postgresql.Driver
//#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
//#spring.jpa.hibernate.ddl-auto=update